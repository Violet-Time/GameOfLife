package controller;

import model.Universe;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RestartGameAction extends AbstractAction {

    GameGenerationWorker gameGenerationWorker;

    public RestartGameAction(GameGenerationWorker gameGenerationWorker) {
        this.gameGenerationWorker = gameGenerationWorker;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gameGenerationWorker.restart();
    }

    public void setGameGenerationWorker(GameGenerationWorker gameGenerationWorker) {
        this.gameGenerationWorker = gameGenerationWorker;
    }
}
