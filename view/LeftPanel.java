package view;

import controller.GameGenerationWorker;
import view.leftPanelPackage.EvolutionSpeedPanel;
import view.leftPanelPackage.GameControlPanel;
import view.leftPanelPackage.GameStatusPanel;

import javax.swing.*;

public class LeftPanel extends JPanel {

    GameControlPanel gameControlPanel;
    GameStatusPanel gameStatusPanel = new GameStatusPanel();
    EvolutionSpeedPanel evolutionSpeedPanel = new EvolutionSpeedPanel();

    public LeftPanel(GameGenerationWorker gameGenerationWorker){
        gameControlPanel = new GameControlPanel(gameGenerationWorker);
        gameGenerationWorker.setEvolutionSpeedModel(evolutionSpeedPanel.getEvolutionSpeedModel());
        gameGenerationWorker.setAliveLabelModel(gameStatusPanel.getAliveLabelModel());
        gameGenerationWorker.setGenerationLabelModel(gameStatusPanel.getGenerationLabelModel());
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(gameControlPanel);
        add(gameStatusPanel);
        add(evolutionSpeedPanel);
    }

    public EvolutionSpeedPanel getEvolutionSpeedPanel() {
        return evolutionSpeedPanel;
    }

    public GameStatusPanel getGameStatusPanel() {
        return gameStatusPanel;
    }
}
