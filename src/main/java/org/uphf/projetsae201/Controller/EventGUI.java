package org.uphf.projetsae201.Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.uphf.projetsae201.View.GUI;

public class EventGUI implements EventHandler {
    GUI gui;

    public EventGUI(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(Event event) {
        Stage s = ((Stage) ((Node) event.getSource()).getScene().getWindow());
        if (s.getTitle().equals("Acceuil")) {
            if (((Button) event.getSource()).getText().equals("Commencer une partie")) {
                gui.close();
                gui.gui();
            }
            else if (((Button) event.getSource()).getText().equals("Quitter")) {
                gui.close();
            }
        }
        else if (s.getTitle().equals("Choix du mode")) {
            if (((Button) event.getSource()).getText().equals("Graphique")) {
                gui.close();
                gui.monde();
            }
            else if (((Button) event.getSource()).getText().equals("Quitter")) {
                gui.close();
            }
        }
    }
}
