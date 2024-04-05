import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class list12 extends JFrame {
    private JTextArea outputArea;

    public list12() {
        super("Database");

        outputArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel checkboxPanel = new JPanel();
        add(checkboxPanel, BorderLayout.NORTH);

        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/swing_demo", "root", "Praveen@02");

                    // Delete selected tasks
                    Component[] components = checkboxPanel.getComponents();
                    for (Component component : components) {
                        if (component instanceof JCheckBox) {
                            JCheckBox checkBox = (JCheckBox) component;
                            if (checkBox.isSelected()) {
                                String taskName = checkBox.getText();
                                deleteTask(connection, taskName);
                            }
                        }
                    }

                  
                    checkboxPanel.removeAll();
                    addCheckboxes(checkboxPanel, connection);

                   
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(deleteButton, BorderLayout.SOUTH);
        JButton addButton=new JButton("Add items");
        add(addButton,BorderLayout.WEST);
        addButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
                new todo();
            }
        });
        
        // Add checkboxes
        try {
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/swing_demo", "root", "Praveen@02");
            addCheckboxes(checkboxPanel, connection);
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private void addCheckboxes(JPanel panel, Connection connection) throws SQLException {
        String query = "SELECT id, item FROM items";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String taskName = resultSet.getString("item");

            JCheckBox checkBox = new JCheckBox(taskName);
            panel.add(checkBox);
        }
        resultSet.close();
        statement.close();
    }

    private void deleteTask(Connection connection, String taskName) throws SQLException {
        String deleteQuery = "DELETE FROM items WHERE item = ?";
        PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
        deleteStatement.setString(1, taskName);
        deleteStatement.executeUpdate();
        deleteStatement.close();
        outputArea.append("Deleted task: " + taskName + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new list12());
    }
}
