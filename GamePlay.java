import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.InputStream;

public class GamePlay extends JPanel implements ActionListener, KeyListener {
    private boolean play = false;
    private int score = 0;
    private int totalbrick = 50;
    private Timer timer;
    private int delay =8;
    private int ballposX= 290;
    private int ballposY = 520;
    private int ballXdir = -1;
    private int ballYdir=-2;
    private int playerX = 250;
   private bricks map;

    public GamePlay(){
addKeyListener(this);
setFocusable(true);
setFocusTraversalKeysEnabled(true);

timer = new Timer(delay,this);
timer.start();
map = new bricks(5,10);
    }

    public void paint(Graphics g){
     //bg
        g.setColor(Color.DARK_GRAY);
        g.fillRect(1,1,692,592);

        //border
        g.setColor(Color.CYAN);
        g.fillRect(0,0,692,3);
        g.fillRect(0,3,7,592);
        g.fillRect(691,3,7,592);
        g.fillRect(678,3,7,592);

        //paddle
        g.setColor(Color.red);
        g.fillRect(playerX,540,100,8);

        //bricks
        map.draw((Graphics2D) g);

        //ball
        g.setColor(Color.blue);
        g.fillOval(ballposX,ballposY,15,15);

    //score
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,17));
        g.drawString("Score: " + score, 550,30);

        //gameover
        if (ballposY>=572){
            play=false;
            ballXdir=0;
            ballYdir=0;
            g.setColor(Color.GREEN);
            g.setFont(new Font("Serif", Font.BOLD,30));
            g.drawString("GameOver!!, Score: " + score,200,300);

            g.setFont(new Font("Serif", Font.BOLD,25));
            g.drawString("Press Enter to Restart!!",230,350);
        }
        if (totalbrick<=0){
            play=false;
            ballXdir=0;
            ballYdir=0;
            g.setColor(Color.GREEN);
            g.setFont(new Font("Serif", Font.BOLD,30));
            g.drawString("You Won!!, Score: " + score,200,300);

            g.setFont(new Font("Serif", Font.BOLD,25));
            g.drawString("Press Enter to Restart!!",230,350);
        }
    }

    private void moveLeft(){
        play=true;
        playerX -= 20;
    }
    private void moveRight(){
        play=true;
      playerX += 20;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            if (playerX<=7) {
                playerX = 7;
            }
            else
            moveLeft();
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            if (playerX>=579) {
                playerX = 579;
            }
            else
            moveRight();
        }
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            if (!play){
                score=0;
                totalbrick=50;
                ballposX=290;
                ballposY=520;
                ballXdir=-1;
                ballYdir=-2;
                playerX=260;

                map= new bricks(5,10);
            }
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (play) {

            if (ballposX <= 7){
                ballXdir = -ballXdir;
                gamemusic("C:\\Users\\Zayed\\Desktop\\jswing\\music\\bounce.wav");
            }
            if (ballposX >= 658){
                ballXdir = -ballXdir;
                gamemusic("C:\\Users\\Zayed\\Desktop\\jswing\\music\\bounce.wav");

            }
            if (ballposY <= 0) {
                ballYdir = -ballYdir;
            }
            //paddle
            Rectangle rectangle = new Rectangle(ballposX, ballposY, 15, 15);
            Rectangle rect1 = new Rectangle(playerX, 540, 100, 8);
            if (rectangle.intersects(rect1)) {
                ballYdir = -ballYdir;
            }
            A:for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int width = map.bw;
                        int height = map.bh;
                        int bricksXpos = 80 + j * width;
                        int bricksYpos = 50 + i * height;
                        Rectangle brickrect = new Rectangle(bricksXpos, bricksYpos, width, height);
                        if (rectangle.intersects(brickrect)) {
                            map.setBricks(0, i, j);
                            totalbrick--;
                            if (i == 0) { // if the row is 0 (the first row), increase the score by 20
                                score += 20;
                            } else {
                                score += 5;
                            }
                            gamemusic("C:\\Users\\Zayed\\Desktop\\jswing\\music\\bounce.wav");
                            if (ballposX+19<=bricksXpos || ballposX+1>=bricksXpos+width){
                                ballXdir=-ballXdir;
                            }
                            else {
                                ballYdir=-ballYdir;
                            }

                           break A;
                        }
                    }
                }
            }
            ballposX += ballXdir;
            ballposY += ballYdir;
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    public static void gamemusic(String filepath){
        InputStream music;
        try{
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(filepath));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(0);
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
