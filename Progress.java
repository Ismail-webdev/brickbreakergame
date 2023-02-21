import javax.swing.*;
import java.awt.*;

public class Progress extends JFrame {
    JProgressBar bar;
     JLabel label;
    ImageIcon logo;
    UpdateThread t;
    public  Progress(){
        setLayout(null);
       label= new JLabel();
        logo = new ImageIcon("logo.png");
       label.setBounds(230, 100, 270, 160);
       this.add(label);
       label.setIcon(logo);
       label.setHorizontalAlignment(JLabel.CENTER);
        bar = new JProgressBar(0,100);
        bar.setBackground(Color.white);
        bar.setStringPainted(true);
        bar.setBounds(100, 350, 480, 30);
        add(bar);
        setVisible(true);
        setBounds(200,100,720, 480);
        setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
        setResizable(false);
        t = new UpdateThread();
        t.start();
    }
   private class UpdateThread extends Thread
    {
        public void run(){
            for (int i = 0; i <= 100; i++) {
                try {
                    bar.setValue(i);
                    Thread.sleep(90);
                }
                catch (Exception e){
                    System.out.println(e);

                }
            }
            new dialogbox();
            dispose();
        }
    }
}