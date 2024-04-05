import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class App extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;

    private JPanel Content;

    private JTextField firstname;

    private JTextField lastname;

    private JTextField email;

    private JTextField username;

    private JTextField mob;

    private JPasswordField passwordField;

    private JButton btnNewButton;
    
    private JButton btnClear;

    private JButton btnlogin;
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    App frame = new App();

                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }
    App() {

        setIconImage(Toolkit.getDefaultToolkit().getImage("c:\\Users\\Admin\\Desktop\\logi.jpg"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(450, 190, 1014, 597);

        setResizable(false);

        Content = new JPanel();

        Content.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(Content);

        Content.setLayout(null);
        JLabel lblNewUserRegister = new JLabel("New User Register");

        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));

        lblNewUserRegister.setBounds(362, 52, 325, 50);

        Content.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");

        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblName.setBounds(58, 152, 99, 43);

        Content.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");

        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblNewLabel.setBounds(58, 243, 110, 29);

        Content.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");

        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblEmailAddress.setBounds(58, 324, 124, 36);

        Content.add(lblEmailAddress);

        firstname = new JTextField();

        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));

        firstname.setBounds(214, 151, 228, 50);

        Content.add(firstname);

        firstname.setColumns(10);

        lastname = new JTextField();

        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));

        lastname.setBounds(214, 235, 228, 50);

        Content.add(lastname);

        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 32));

        email.setBounds(214, 320, 228, 50);

        Content.add(email);

        email.setColumns(10);

        username = new JTextField();

        username.setFont(new Font("Tahoma", Font.PLAIN, 32));

        username.setBounds(707, 151, 228, 50);

        Content.add(username);

        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");

        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblUsername.setBounds(542, 159, 99, 29);

        Content.add(lblUsername);
        JLabel lblPassword = new JLabel("Password");

        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblPassword.setBounds(542, 245, 99, 24);

        Content.add(lblPassword);



        JLabel lblMobileNumber = new JLabel("Mobile number");

        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));

        lblMobileNumber.setBounds(542, 329, 139, 26);

        Content.add(lblMobileNumber);
       mob = new JTextField();

        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));

        mob.setBounds(707, 320, 228, 50);

        Content.add(mob);

        mob.setColumns(10);
        passwordField = new JPasswordField();

        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));

        passwordField.setBounds(707, 235, 228, 50);

        Content.add(passwordField);

        btnNewButton = new JButton("Register");
        btnClear =new JButton("Clear");
        btnlogin=new JButton("login");
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String firstName = firstname.getText();

                String lastName = lastname.getText();

                String emailId = email.getText();

                String userName = username.getText();

                String mobileNumber = mob.getText();

                int len = mobileNumber.length();

                @SuppressWarnings("deprecation")

                String password = passwordField.getText();

                if (len != 10) {

                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");

                }
                try {

                    Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo","root","Praveen@02");
		    Statement st=con.createStatement();
		    st.executeUpdate("insert into account(firstname,lastName,userName,password,emailId,mobileNumber) values('"+firstName+"','"+lastName+"','"+userName+"','"+password+"','"+emailId+"','"+mobileNumber+"')");

            con.close();
           new login();
           System.out.println("hai");
           
                    
                    dispose();
                    

                } catch (Exception exception) {

                    exception.printStackTrace();

                }

            }

        });

        btnClear.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                firstname.setText(null);
                lastname.setText(null);
                username.setText(null);
                mob.setText(null);
                email.setText(null);
                passwordField.setText(null);
            }
        });
        btnlogin.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
                new login();
            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));

        btnNewButton.setBounds(220, 447, 200, 74);

        Content.add(btnNewButton);
        btnClear.setFont(new Font("Tahoma",Font.PLAIN,22));
        btnClear.setBounds(450,447,200,74);
        Content.add(btnClear);
        btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnlogin.setBounds(680, 447, 200, 74);
        Content.add(btnlogin);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}