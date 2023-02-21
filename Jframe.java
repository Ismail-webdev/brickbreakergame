import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Jframe extends JFrame implements ActionListener {
    JButton btn = new JButton("START...");
    JLabel lb = new JLabel();
    ImageIcon icon;
    Jframe() {
        icon = new ImageIcon("logo.png");
        lb.setBounds(220, 100, 270, 160);
        lb.setIcon(icon);
        lb.setHorizontalAlignment(JLabel.CENTER);
        add(lb);
        add(btn);
        btn.addActionListener(this);
        setLayout(null);
        btn.setBounds(300, 350, 100, 60);
        setVisible(true);
       setBounds(200,100,720, 480);
        setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
        setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
 new Progress();
 dispose();
    }
}

