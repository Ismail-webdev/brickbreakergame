import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends Jframe {
    JPanel contentPane;
    JTextField firstname;
    JTextField lastname;
    JTextField email;
    JTextField username;
    JTextField mob;
    JPasswordField passwordField;

   Integer userlen =3;
   Integer pass =3;
    JButton btnNewButton;
    Color btn;

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signup frame = new signup();
                    frame.setTitle("SignUp Page");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    String url = "signup:mysql://localhost:3306/swing_demo"; // table details
    String uname = "root"; // MySQL credentials
    String password = "mysqlroot";
    signup() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name*");
        lblName.setBounds(142, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name*");
        lblNewLabel.setBounds(142, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address*");
        lblEmailAddress.setBounds(122, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setBounds(617, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username*");
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password*");
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number*");
        lblMobileNumber.setBounds(522, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setBounds(617, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(617, 235, 228, 50);
        contentPane.add(passwordField);
        btnNewButton = new JButton("Register");
        contentPane.setBackground(Color.LIGHT_GRAY);
        btnNewButton.setForeground(Color.getHSBColor(2,1,2));
        btnNewButton.setBackground(Color.getHSBColor(112,320,222));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                String password = passwordField.getText();
                String name = firstName + lastName;
                int name1= firstName.length();
                int name2 = lastName.length();
                int user = userName.length();
                int len = mobileNumber.length();
                int pass = password.length();

                String msg = "" + firstName;
                msg += " \n";
                if (name1 != 3 && name2 != 3) {
                    JOptionPane.showMessageDialog(btnNewButton, "Name Should be 3 character");
                }
                if (user <= userlen) {
                    JOptionPane.showMessageDialog(btnNewButton, "UserName Should be more than 3 String");
                }
                if (pass < pass) {
                    JOptionPane.showMessageDialog(btnNewButton, "Password Should not be less than 3 digits");
                }
                if (valemail(emailId) != true) {
                    JOptionPane.showMessageDialog(btnNewButton, "Email Address is invalid");
                }
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Mobile Number Less than 10 Digits");
                }
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brickgame", "root",
                            "mysqlroot");

                    String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName
                            + "','" +
                            password + "','" + emailId + "','" + mobileNumber + "')";

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);
                        if (x == 1) {
                            JOptionPane.showMessageDialog(btnNewButton, "This is already exist");
                            Login login = new Login();
                            dispose();
                        }
                     else {
                            JOptionPane.showMessageDialog(btnNewButton,
                                    "Welcome, " + msg + "Your account is sucessfully created");
                            Login login = new Login();
                            dispose();
                        }
                    sta.close();
                    con.close();
                } catch (Exception exception) {
                    System.err.println(exception);
                }
            }
        });
        btnNewButton.setBounds(399, 447, 259, 74);
        contentPane.add(btnNewButton);
    }

    public static boolean valemail(String input) {
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."
                + "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}