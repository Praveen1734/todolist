import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**

 * User Registration using Swing

 * @author javaguides.net

 *

 */

public class login extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;

    private JPanel Content;

    private JTextField username;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    //private Appframe appframe;

   



    /**

     * Launch the loginlication.

     */

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    login frame = new login();

                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }



    /**

     * Create the frame.

     */



    public login() {

        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\logi.jpg"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(450, 190, 1014, 597);

        setResizable(false);
        setVisible(true);

        Content = new JPanel();

        Content.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(Content);

        Content.setLayout(null);



        JLabel userlogin = new JLabel("Login");

        userlogin.setFont(new Font("Times New Roman", Font.PLAIN, 42));

        userlogin.setBounds(362, 52, 325, 50);

        Content.add(userlogin);



        username = new JTextField();

        username.setFont(new Font("Tahoma", Font.PLAIN, 32));

        username.setBounds(214, 151, 228, 50);

        Content.add(username);

        username.setColumns(10);



        JLabel lblUsername = new JLabel("Username",JLabel.CENTER);

        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblUsername.setBounds(58, 152, 99, 43);

        Content.add(lblUsername);



        JLabel lblPassword = new JLabel("Password");

        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblPassword.setBounds(58, 243, 110, 29);

        Content.add(lblPassword);






       


        passwordField = new JPasswordField();

        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));

        passwordField.setBounds(214, 235, 228, 50);

        Content.add(passwordField);



        btnNewButton = new JButton("Login");
        JButton btnClear = new JButton("Clear");
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

               

                String userName = username.getText();

                
                

                

                @SuppressWarnings("deprecation")
                String password = passwordField.getText();

                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo","root","Praveen@02");//praveen------>database name
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from account where userName='"+userName+"' and password='"+password+"'");
            if(rs.next())
            {
                
                new todo();
              
                dispose();
            }
			
                    con.close();

                } catch (Exception exception) {

                    exception.printStackTrace();

                }

            }

        });

        btnClear.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
               
                username.setText(null);
               
                passwordField.setText(null);
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));

        btnNewButton.setBounds(320, 447, 200, 74);

        Content.add(btnNewButton);
        btnClear.setFont(new Font("Tahoma",Font.PLAIN,22));
        btnClear.setBounds(550,447,200,74);
        Content.add(btnClear);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
