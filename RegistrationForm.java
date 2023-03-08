//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//public class RegistrationForm {
//    public static void main() {
//       final long serialVersionUID = 1L;
//        JPanel contentPane;
//         JTextField firstname;
//        JTextField lastname;
//        JTextField email;
//        JTextField username;
//        JTextField mob;
//        JPasswordField passwordField;
//        JButton btnNewButton, btn1;
//
//        ActionClass ae;
//        RegistrationForm() {
//            ae = new ActionClass();
//            contentPane = new JPanel();
//            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//            frasetContentPane(contentPane);
//            contentPane.setLayout(null);
//
//            JLabel lblNewUserRegister = new JLabel("New User Register");
//            lblNewUserRegister.setBounds(252, 52, 325, 50);
//            lblNewUserRegister.setFont(new Font("Arial", Font.PLAIN, 30));
//            contentPane.add(lblNewUserRegister);
//
//            JLabel lblName = new JLabel("First name");
//            lblName.setBounds(58, 152, 99, 43);
//            contentPane.add(lblName);
//
//            JLabel lblNewLabel = new JLabel("Last name");
//            lblNewLabel.setBounds(58, 205, 110, 29);
//            contentPane.add(lblNewLabel);
//
//            JLabel lblEmailAddress = new JLabel("Email-address");
//            lblEmailAddress.setBounds(40, 245, 124, 36);
//            contentPane.add(lblEmailAddress);
//
//            firstname = new JTextField();
//            firstname.setBounds(125, 160, 228, 25);
//            contentPane.add(firstname);
//            firstname.setColumns(10);
//
//            lastname = new JTextField();
//            lastname.setBounds(125, 205, 228, 25);
//            contentPane.add(lastname);
//            lastname.setColumns(10);
//
//            email = new JTextField();
//            email.setBounds(125, 250, 228, 25);
//            contentPane.add(email);
//            email.setColumns(10);
//
//            username = new JTextField();
//            username.setBounds(463, 159, 228, 25);
//            contentPane.add(username);
//            username.setColumns(10);
//
//            JLabel lblUsername = new JLabel("Username");
//            lblUsername.setBounds(393, 154, 99, 29);
//            contentPane.add(lblUsername);
//
//            JLabel lblPassword = new JLabel("Password");
//            lblPassword.setBounds(393, 206, 99, 24);
//            contentPane.add(lblPassword);
//
//            JLabel lblMobileNumber = new JLabel("Mobile number");
//            lblMobileNumber.setBounds(373, 248, 139, 26);
//            contentPane.add(lblMobileNumber);
//
//            mob = new JTextField();
//            mob.setBounds(463, 248, 228, 25);
//            contentPane.add(mob);
//            mob.setColumns(10);
//
//            passwordField = new JPasswordField();
//            passwordField.setBounds(463, 206, 228, 25);
//            contentPane.add(passwordField);
//
//            btnNewButton = new JButton("Register");
//            btnNewButton.setBounds(250, 300, 228, 30);
//            contentPane.add(btnNewButton);
//            btnNewButton.addActionListener(ae);
//
//            btn1 = new JButton("Account Exist");
//            btn1.setBounds(50, 350, 190, 20);
//            contentPane.add(btn1);
//            btn1.addActionListener(ae);
//
//            btnNewButton.setActionCommand("1");
//            btn1.setActionCommand("2");
//            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            this.setBounds(200, 100, 720, 597);
//            this.setResizable(false);
//            this.setVisible(true);
//        }
//        class ActionClass implements ActionListener {
//            public void actionPerformed(ActionEvent e) {
//                int act = Integer.parseInt(e.getActionCommand());
//                if (act == 1) {
//                    String firstName = firstname.getText();
//                    String lastName = lastname.getText();
//                    String emailId = email.getText();
//                    String userName = username.getText();
//                    String mobileNumber = mob.getText();
//                    int len = mobileNumber.length();
//                    String password = passwordField.getText();
//
//                    String msg = "" + firstName;
//                    msg += " \n";
//                    if (len != 10) {
//                        JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
//                    }
//                    try {
//                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo", "root", "root");
//
//                        String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
//                                password + "','" + emailId + "','" + mobileNumber + "')";
//
//                        Statement sta = connection.createStatement();
//                        int x = sta.executeUpdate(query);
//                        if (x == 0) {
//                            JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
//                        } else {
//                            JOptionPane.showMessageDialog(btnNewButton,
//                                    "Welcome, " + msg + "Your account is sucessfully created");
//                        }
//                        connection.close();
//                    } catch (Exception exception) {
//                        exception.printStackTrace();
//                    }
//                }
//            });
////            if (act == 2) {
////                new LoginPage();
////            }
////            else {
////                System.exit(0);
////            }
//        }
//    }
//}