package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoadGameAction extends AbstractAction {

    public LoadGameAction() {
        putValue(NAME, "Load");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke('L'));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
