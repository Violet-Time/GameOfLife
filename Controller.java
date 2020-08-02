

import model.Universe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Universe universe;
    View view;
    boolean play = true;

    Controller(int n, JFrame frame) {
        this.universe = new Universe();
        this.view = new View(universe, frame);
        actionButtons();
    }

    public void generate() {
        while (play) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            universe.step();
            view.gameField(universe);
        }
    }

    void actionButtons() {
        this.view.setActionListenerPlayButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                play = true;
                generate();
            }
        });
        this.view.setActionListenerPauseButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                play = false;
            }
        });
        this.view.setActionListenerRestartButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                universe = new Universe();
            }
        });
    }
}
