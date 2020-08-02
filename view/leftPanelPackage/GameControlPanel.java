package view.leftPanelPackage;

import controller.GameGenerationWorker;
import controller.PauseGameAction;
import controller.PlayGameAction;
import controller.RestartGameAction;

import javax.swing.*;
import java.awt.*;

public class GameControlPanel extends JPanel {
    JButton playButton;
    JButton pauseButton;
    JButton restartButton;

    public GameControlPanel(GameGenerationWorker gameGenerationWorker) {
        //setBackground(Color.GREEN);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,0));

        playButton = new JButton(new ImageIcon("D:\\Project\\Game of Life\\Game of Life\\task\\src\\life\\src\\play.png"));
        pauseButton = new JButton(new ImageIcon("D:\\Project\\Game of Life\\Game of Life\\task\\src\\life\\src\\pause.png"));
        restartButton = new JButton(new ImageIcon("D:\\Project\\Game of Life\\Game of Life\\task\\src\\life\\src\\restart.png"));

        playButton.setName("PlayToggleButton");
        restartButton.setName("ResetButton");

        playButton.addActionListener(new PlayGameAction(gameGenerationWorker));
        pauseButton.addActionListener(new PauseGameAction(gameGenerationWorker));
        restartButton.addActionListener(new RestartGameAction(gameGenerationWorker));
/*
        playButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        pauseButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        restartButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
*/
        add(playButton);
        add(pauseButton);
        add(restartButton);
    }
}
