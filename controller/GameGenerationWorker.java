package controller;

import model.Universe;
import view.GamePanel;

import javax.swing.*;
import javax.swing.text.Document;
import java.util.List;

public class GameGenerationWorker extends SwingWorker<Universe, Universe> {

    Universe universe;
    BoundedRangeModel evolutionSpeedModel;
    BoundedRangeModel generationLabelModel;
    BoundedRangeModel aliveLabelModel;
    GamePanel gamePanel;
    boolean run = true;
    boolean status = false;

    public GameGenerationWorker(Universe universe, GamePanel gamePanel) {
        this.universe = universe;
        this.gamePanel = gamePanel;
    }

    public void play() {
        status = true;
    }

    public void pause() {
        status = false;
    }

    public void restart() {
        universe.restart();
    }

    @Override
    protected Universe doInBackground() throws Exception {
        while (run) {
            if (status) {
                universe.step();
                publish(universe);
            }
            sleepAWhile();
        }
        return universe;
    }

    private void sleepAWhile() {
        try {
            Thread.yield();
            long timeToSleep = getTimeToSleep();
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
        }
    }

    @Override
    protected void process(List<Universe> chunks) {
        Universe universe = chunks.get(0);
        generationLabelModel.setValue(universe.getCountSteps());
        aliveLabelModel.setValue(universe.countAlive());
        gamePanel.setField(universe.getField());
    }

    private long getTimeToSleep() {
        return evolutionSpeedModel.getValue();
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public void setStatus(boolean status) {
        this.run = status;
    }

    public void setAliveLabelModel(BoundedRangeModel aliveLabelModel) {
        this.aliveLabelModel = aliveLabelModel;
    }

    public void setEvolutionSpeedModel(BoundedRangeModel evolutionSpeedModel) {
        this.evolutionSpeedModel = evolutionSpeedModel;
    }

    public void setGenerationLabelModel(BoundedRangeModel generationLabelModel) {
        this.generationLabelModel = generationLabelModel;
    }
}
