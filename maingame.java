import javax.swing.*;

public class maingame{

    maingame(){
        GamePlay gamePlay = new GamePlay();
        JFrame  f1 = new JFrame("Brick Breaker");
        f1.setSize(700,600);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setResizable(false);
        f1.add(gamePlay);
    }
}
