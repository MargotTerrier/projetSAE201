package org.uphf.projetsae201.Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.View.GUI;

import java.util.Random;

public class EventGUI implements EventHandler {
    VGraphique v;
    private GUI gui;
    public EventGUI(VGraphique v) {
        this.v = v;
        this.gui = v.getGUI();
    }

    @Override
    public void handle(Event event) {
        Stage s = ((Stage) ((Node) event.getSource()).getScene().getWindow());

        // Boutons pour la fenêtre d'acceuil
        if (s.getTitle().equals("Accueil")) {
            if (((Button) event.getSource()).getText().equals("Commencer une partie")) {
                gui.close();
                gui.monde(v.getMonde());
            }
            else if (((Button) event.getSource()).getText().equals("Quitter")) {
                gui.close();
            }
        }

        // Boutons pour la fenêtre du mode de jeu
        else if (s.getTitle().equals("Choix du mode")) {
            if (((Button) event.getSource()).getText().equals("Graphique")) {
                gui.close();
                gui.monde(new Monde(2,new Random().nextInt(5) + 1,10,10));
            }
            else if (((Button) event.getSource()).getText().equals("Quitter")) {
                gui.close();
            } else if (((Button) event.getSource()).getText().equals("Console")) {
                gui.close();
                new VConsole();
            }
        }

        // Boutons pour la fenêtre du jeu
        else if (s.getTitle().equals("Jeu de la mine")) {
            if (((Button) event.getSource()).getText().equals("Quitter le jeu")) {
                gui.close();
            }
            else if (((Button) event.getSource()).getText().equals("Redémarrer une partie")) {
                gui.close();
                gui.monde(new Monde(2,new Random().nextInt(2,5),10,10));
            }
            else if (((Button) event.getSource()).getText().equals("Se déplacer")) {

            }
            else if (((Button) event.getSource()).getText().equals("Extraire des minerais")) {

            }
            else if (((Button) event.getSource()).getText().equals("Décharger des minerais")) {

            }
//            else if (((Button) event.getSource()).getText().equals("Valider le tour")) {
//
//            }
        }
    }

}
