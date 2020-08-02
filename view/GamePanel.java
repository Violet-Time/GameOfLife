package view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private boolean[][] field;

    public GamePanel(boolean[][] field){
        this.field = field;
    }

    public void setField(boolean[][] field) {
        this.field = field;
        update(getGraphics());
    }

    @Override
    public void paint(Graphics g) {

        int rectWidth = getWidth() / field[0].length;
        int rectHeight = getHeight() / field.length;

        int x = 0;
        int y = 0;

        for (boolean[] elements : field) {
            for (boolean element : elements) {
                if (element) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(x, y, rectWidth, rectHeight);
                x += rectWidth;
                if (getWidth() - x < rectWidth) {
                    y += rectHeight;
                    x = 0;
                }
            }
        }
        g.setColor(Color.WHITE);
        for (x = rectWidth; x < getWidth(); x += rectWidth) {
            g.drawLine(x, 0, x, getHeight());
        }

        for (y = rectHeight; y < getHeight(); y += rectHeight) {
            g.drawLine(0, y, getWidth(), y);
        }
    }

    private void generate(Graphics g) {
        Random random = new Random();
        boolean[] mass = new boolean[1000];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextBoolean();
        }

        int sqrt = (int) Math.sqrt(mass.length);

        int rectWidth = getWidth() / (sqrt);
        int rectHeight = getHeight() / (mass.length - sqrt * sqrt != 0 ? sqrt + 1 : sqrt);

        //for (int i )



        int x = 0;
        int y = 0;

        for (int i = 0; i < mass.length; i++) {

            if (mass[i]) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }

            g.fillRect(x, y, rectWidth, rectHeight);
            x += rectWidth;
            if (getWidth() - x < rectWidth) {
                y += rectHeight;
                x = 0;
            }
        }
        g.setColor(Color.WHITE);
        for (x = rectWidth; x < getWidth(); x += rectWidth) {
            g.drawLine(x, 0, x, getHeight());
        }

        for (y = rectHeight; y < getHeight(); y += rectHeight) {
            g.drawLine(0, y, getWidth(), y);
        }


    }

}
