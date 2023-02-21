import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegistrationForm extends JFrame {
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;

    RegistrationForm() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setBounds(252, 52, 325, 50);
        lblNewUserRegister.setFont(new Font("Arial", Font.PLAIN,30));
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setBounds(58, 205, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email-address");
        lblEmailAddress.setBounds(40, 245, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setBounds(125, 160, 228, 25);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setBounds(125, 205, 228, 25);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setBounds(125, 250, 228, 25);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setBounds(463, 159, 228, 25);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(393, 154, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(393, 206, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setBounds(373, 248, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setBounds(463, 248, 228, 25);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(463, 206, 228, 25);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.setBounds(250,300,228,30);
        contentPane.add(btnNewButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200,100, 720, 597);
        this.setResizable(false);
        this.setVisible(true);
    }
}