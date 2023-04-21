//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class dialogbox extends JFrame {
//    JLabel label;
//    JLabel lb;
//    JButton sign;
//    JButton log;
//    ActionClass actionEvent;
//    dialogbox() {
//        actionEvent = new ActionClass();
//        label = new JLabel("Hey! Do You have account?");
//        lb = new JLabel("if No Click on SignUp for Create Account");
//        sign = new JButton("SignUp");
//        log = new JButton("Login");
//        setLayout(null);
//        label.setBounds(55, 80, 200, 100);
//        lb.setBounds(25, 100, 250, 100);
//        sign.setBounds(17, 180, 100, 50);
//        log.setBounds(150, 180, 100, 50);
//        sign.addActionListener(actionEvent);
//        log.addActionListener(actionEvent);
//        sign.setActionCommand("1");
//        log.setActionCommand("2");
//        add(lb);
//        add(label);
//        add(sign);
//        add(log);
//        setTitle("Dialog Box");
//        setVisible(true);
//        setBounds(400, 100, 300, 300);
//        setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
//        setResizable(false);
//    }
//}
//class ActionClass implements ActionListener {
//    public void actionPerformed(ActionEvent e) {
//        int action = Integer.parseInt(e.getActionCommand());
//        if (action == 1) {
//            try {
//                new signup();
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//        } else if (action == 2) {
//            try {
//                new Login();
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//        } else {
//            System.exit(0);
//        }
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class dialogbox extends JDialog {
    private JButton loginButton, signupButton;

    public dialogbox() {
        super();
        setTitle("Dialog Box");
        setModal(true);
        setLayout(new GridLayout(2, 1));

        loginButton = new JButton("Login");
        signupButton = new JButton("Signup");

        // add login and signup buttons to JPanel
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(loginButton);
        panel.add(signupButton);

        add(new JLabel("Welcome to Brick Breaker Game!"));
        add(panel);

        // add event listeners for login and signup buttons
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                dispose();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    signup signup = new signup();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

        setSize(300, 150);
        setLocationRelativeTo(null); // center the dialog box on the screen
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // set default close operation
        setVisible(true); // make the dialog box visible
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new dialogbox();
            }
        });
    }
}