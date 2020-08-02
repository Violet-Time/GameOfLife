package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PlayGameAction extends AbstractAction {

    GameGenerationWorker gameGenerationWorker;

    public PlayGameAction(GameGenerationWorker gameGenerationWorker) {
        this.gameGenerationWorker = gameGenerationWorker;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gameGenerationWorker.play();
        gameGenerationWorker.execute();
    }

    public void setGameGenerationWorker(GameGenerationWorker gameGenerationWorker) {
        this.gameGenerationWorker = gameGenerationWorker;
    }
}
