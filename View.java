

import model.Universe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    JLabel generationLabel;
    JLabel aliveLabel;
    JLabel[][] gameField;
    int count = 0;
    JButton playButton;
    JButton pauseButton;
    JButton restartButton;
    JSlider speedSlider;
    JPanel gamePanel;

    public View (Universe universe, JFrame frame) {
        frame.setLayout(new BorderLayout());
        JPanel counters = control(universe);
        gamePanel = new JPanel();
        gameField(universe);
        frame.add(counters,BorderLayout.WEST);
        frame.add(gamePanel,BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void setActionListenerPauseButton(ActionListener actionListener) {
        this.pauseButton.addActionListener(actionListener);
    }

    public void setActionListenerPlayButton(ActionListener actionListener) {
        this.playButton.addActionListener(actionListener);
    }

    public void setActionListenerRestartButton(ActionListener actionListener) {
        this.restartButton.addActionListener(actionListener);
    }

    JPanel control(Universe universe) {

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        playButton = new JButton(new ImageIcon("D:\\Project\\Game of Life\\Game of Life\\task\\src\\life\\src\\play.png"));
        pauseButton = new JButton(new ImageIcon("D:\\Project\\Game of Life\\Game of Life\\task\\src\\life\\src\\pause.png"));
        restartButton = new JButton(new ImageIcon("D:\\Project\\Game of Life\\Game of Life\\task\\src\\life\\src\\restart.png"));

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        controlPanel.add(playButton);
        controlPanel.add(pauseButton);
        controlPanel.add(restartButton);

        generationLabel = new JLabel("model.game.Generation #" + ++count);
        aliveLabel = new JLabel("Alive:" + universe.countAlive());
        generationLabel.setName("GenerationLabel");
        aliveLabel.setName("AliveLabel");

        speedSlider = new JSlider();

        leftPanel.add(controlPanel);
        leftPanel.add(generationLabel);
        leftPanel.add(aliveLabel);
        leftPanel.add(speedSlider);

        return leftPanel;
    }

    void gameField(Universe universe) {
        if (this.gameField == null || this.gameField.length != universe.getField().length) {
            gamePanel.setLayout(new GridLayout(universe.getField().length,universe.getField().length));
            gameField = new JLabel[universe.getField().length][universe.getField().length];
            for (int h = 0; h < gameField.length; h++) {
                for (int w = 0; w < gameField[h].length; w++) {
                    gameField[h][w] = new JLabel();
                    if (universe.getField()[h][w]) {
                        gameField[h][w].setBackground(Color.BLACK);
                    } else {
                        gameField[h][w].setBackground(Color.WHITE);
                    }
                    gameField[h][w].setOpaque(true);
                    gameField[h][w].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    gamePanel.add(gameField[h][w]);
                }
            }
        } else {
            for (int h = 0; h < gameField.length; h++) {
                for (int w = 0; w < gameField[h].length; w++) {
                    if (universe.getField()[h][w]) {
                        gameField[h][w].setBackground(Color.BLACK);
                    } else {
                        gameField[h][w].setBackground(Color.WHITE);
                    }
                    gameField[h][w].setOpaque(true);
                    gameField[h][w].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
            }
        }
        generationLabel.setText("model.game.Generation #" + ++count);
        aliveLabel.setText("Alive:" + universe.countAlive());
    }



}
