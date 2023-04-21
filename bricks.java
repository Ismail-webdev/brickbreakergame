import java.awt.*;

public class bricks {
    public int map[][];
    public int bw;
    public int bh;

    public bricks(int row, int col) {
        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = 1;
            }
        }
        bw = 530 / col;
        bh = 150 / row;
    }

    public void setBricks(int value, int r, int c) {
        map[r][c] = value;
    }

    public void draw(Graphics2D graphics) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    if (map[i][j] > 0) {
                        if (i == 0 && map[i][j] > 0) { // check if in second row and not destroyed
                            graphics.setColor(Color.green); // Change the color to green
                            graphics.fillRect(j*bw+80, i*bh+50, bw, bh);
                            graphics.setColor(Color.DARK_GRAY);
                            graphics.setStroke(new BasicStroke(3));
                            graphics.drawRect(j*bw+80, i*bh+50, bw, bh);
                        }
                        else if (map[i][j] > 0) {
                            graphics.setColor(Color.white);
                            graphics.fillRect(j*bw+80, i*bh+50, bw, bh);
                            graphics.setColor(Color.DARK_GRAY);
                            graphics.setStroke(new BasicStroke(3));
                            graphics.drawRect(j*bw+80, i*bh+50, bw, bh);
                        }
                    }
                }
            }
        }
    }
}