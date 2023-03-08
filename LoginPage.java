import javax.swing.*;

public class LoginPage {
    public static void main() {
       JFrame frame = new JFrame();
        JLabel label;
        JLabel lb;
        JButton sign;
        JButton log;
        label = new JLabel("Hey! Do You have account?");
        lb = new JLabel("if No Click on SignUp for Create Account");
        sign = new JButton("SignUp");
        log = new JButton("Login");
        frame.setLayout(null);
        label.setBounds(55, 80, 200, 100);
        lb.setBounds(25, 100, 250, 100);
        sign.setBounds(17, 180, 100, 50);
        log.setBounds(150, 180, 100, 50);
        frame.setVisible(true);
        frame.setBounds(200,100,720, 480);
    }
}
