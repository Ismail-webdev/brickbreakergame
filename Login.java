import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2;

    Login() {
        setTitle("Login");
        setLayout(null);
        l1 = new JLabel("Username:");
        l1.setBounds(50, 70, 200, 30);
        add(l1);
        tf1 = new JTextField();
        tf1.setBounds(150, 70, 200, 30);
        add(tf1);
        l2 = new JLabel("Password:");
        l2.setBounds(50, 110, 200, 30);
        add(l2);
        pf2 = new JPasswordField();
        pf2.setBounds(150, 110, 200, 30);
        add(pf2);
        b1 = new JButton("Login");
        b1.setBounds(50, 160, 100, 30);
        b1.addActionListener(this);
        add(b1);
        setSize(400, 250);
        setLocation(500,200);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brickgame", "root", "mysqlroot");
            Statement st = con.createStatement();
            String user = tf1.getText();
            String pwd = new String(pf2.getPassword());
            ResultSet rs = st.executeQuery("select * from account where user_name='" + user + "' and password='" + pwd + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            maingame maingame = new maingame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener {
//    JLabel userLabel, passwordLabel;
//    JTextField userField;
//    JPasswordField passwordField;
//    JButton loginButton, clearButton;
//
//    public Login() {
//        setTitle("Login Demo");
//
//        userLabel = new JLabel("Username:");
//        passwordLabel = new JLabel("Password:");
//        userField = new JTextField();
//        passwordField = new JPasswordField();
//        loginButton = new JButton("Login");
//        clearButton = new JButton("Clear");
//
//        // Set layout
//        JPanel panel = new JPanel(new GridLayout(3, 2));
//        panel.add(userLabel);
//        panel.add(userField);
//        panel.add(passwordLabel);
//        panel.add(passwordField);
//        panel.add(loginButton);
//        panel.add(clearButton);
//
//        // Add action listeners
//        loginButton.addActionListener(this);
//        clearButton.addActionListener(this);
//
//        add(panel);
//        setSize(300, 150);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == clearButton) {
//            userField.setText("");
//            passwordField.setText("");
//        } else if (e.getSource() == loginButton) {
//            String username = userField.getText();
//            String password = String.valueOf(passwordField.getPassword());
//
//            try {
//                // Connect to the database
//                String url = "jdbc:mysql://localhost:3306/brickgame";
//                String dbUsername = "root";
//                String dbPassword = "password";
//                Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
//
//                // Execute the query
//                String query = "SELECT * FROM users WHERE username = ? AND password = ?";
//                PreparedStatement ps = conn.prepareStatement(query);
//                ps.setString(1, username);
//                ps.setString(2, password);
//                ResultSet rs = ps.executeQuery();
//
//                if (rs.next()) {
//                    System.out.println("Login successful!");
//                } else {
//                    System.out.println("Invalid username or password");
//                }
//
//                // Close ResultSet, PreparedStatement, and Connection
//                rs.close();
//                ps.close();
//                conn.close();
//            } catch (SQLException exp) {
//                exp.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        new Login();
//    }
//}