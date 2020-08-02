package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFieldColorChooserAction  extends AbstractAction {

    JFileChooser fileChooser;

    public GameFieldColorChooserAction(JFileChooser fileChooser) {
        putValue(NAME, "Color");
        this.fileChooser = fileChooser;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        fileChooser.showOpenDialog((Component) actionEvent.getSource());
    }
}
