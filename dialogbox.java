import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class dialogbox extends JFrame {
    JLabel label;
    JLabel lb;
    JButton sign;
    JButton log;
    ActionClass actionEvent;
    dialogbox() {
        actionEvent = new ActionClass();
        label = new JLabel("Hey! Do You have account?");
        lb = new JLabel("if No Click on SignUp for Create Account");
        sign = new JButton("SignUp");
        log = new JButton("Login");
        setLayout(null);
        label.setBounds(55, 80, 200, 100);
        lb.setBounds(25, 100, 250, 100);
        sign.setBounds(17, 180, 100, 50);
        log.setBounds(150, 180, 100, 50);
        sign.addActionListener(actionEvent);
        log.addActionListener(actionEvent);
        sign.setActionCommand("1");
        log.setActionCommand("2");
        add(lb);
        add(label);
        add(sign);
        add(log);
        setTitle("Dialog Box");
        setVisible(true);
        setBounds(400, 100, 300, 300);
        setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
        setResizable(false);
    }
}
class ActionClass implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        int action = Integer.parseInt(e.getActionCommand());
      if (action == 1){
          new RegistrationForm();
      } else if (action == 2) {
          new LoginPage();
      }
      else {
          System.exit(0);
      }
    }
}