package view;

import controller.*;
import model.Universe;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {

    LeftPanel leftPanel;
    GamePanel gamePanel;

    public GameOfLife(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Universe universe = new Universe();
        gamePanel = new GamePanel(universe.getField());
        GameGenerationWorker gameGenerationWorker = new GameGenerationWorker(universe, gamePanel);

        leftPanel = new LeftPanel(gameGenerationWorker);

        add(leftPanel, BorderLayout.LINE_START);

        add(gamePanel, BorderLayout.CENTER);

        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        JMenu fileMenu = new JMenu("File");
        jMenuBar.add(fileMenu);

        JMenu settingMenu = new JMenu("Setting");
        jMenuBar.add(settingMenu);

        LoadGameAction loadGameAction = new LoadGameAction();
        fileMenu.add(loadGameAction);

        SaveGameAction saveGameAction = new SaveGameAction();
        fileMenu.add(saveGameAction);

        GameFieldSizeChooserAction gameFieldSizeChooserAction = new GameFieldSizeChooserAction();
        settingMenu.add(gameFieldSizeChooserAction);

        GameFieldColorChooserAction gameFieldColorChooserAction = new GameFieldColorChooserAction(new JFileChooser());
        settingMenu.add(gameFieldColorChooserAction);

        setVisible(true);
    }
}
