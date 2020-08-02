package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PauseGameAction extends AbstractAction {

    GameGenerationWorker gameGenerationWorker;

    public PauseGameAction(GameGenerationWorker gameGenerationWorker) {
        this.gameGenerationWorker = gameGenerationWorker;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gameGenerationWorker.pause();
    }

    public void setGameGenerationWorker(GameGenerationWorker gameGenerationWorker) {
        this.gameGenerationWorker = gameGenerationWorker;
    }
}
