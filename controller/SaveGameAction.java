package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveGameAction extends AbstractAction {

    public SaveGameAction() {
        putValue(NAME, "Save");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke('S'));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
