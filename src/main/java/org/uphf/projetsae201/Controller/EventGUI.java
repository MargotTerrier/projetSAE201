package org.uphf.projetsae201.Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.View.GUI;
import org.uphf.projetsae201.View.GUIAcceuil;
import org.uphf.projetsae201.View.GUIChoix;

import java.util.Random;

public class EventGUI implements EventHandler {
    VGraphique v;
    private GUI gui;
    private GUIChoix cgui;
    private GUIAcceuil agui;
    private int n;

    public EventGUI(GUIAcceuil agui) {
        this.agui = agui;
    }
    public EventGUI(GUIChoix cgui) {
        this.cgui = cgui;
    }

    public EventGUI(VGraphique v) {
        this.v = v;
        this.gui = v.getGUI();
        gui.Affiche(this);

    }


    @Override
    public void handle(Event event) {
        Stage s = ((Stage) ((Node) event.getSource()).getScene().getWindow());


        // Boutons pour la fenêtre d'acceuil
        if (s.getTitle().equals("Accueil")) {
            if (((Button) event.getSource()).getText().equals("Commencer une partie")) {

                agui.close();
                new GUIChoix();
            }
            else if (((Button) event.getSource()).getText().equals("Quitter")) {
                agui.close();
            }
        }



        // Boutons pour la fenêtre du mode de jeu
        else if (s.getTitle().equals("Choix du mode")) {
            if (((Button) event.getSource()).getText().equals("Graphique")) {
                cgui.close();
                new VGraphique();
            }
            else if (((Button) event.getSource()).getText().equals("Quitter")) {
                cgui.close();
            } else if (((Button) event.getSource()).getText().equals("Console")) {
                cgui.close();
                new VConsole();
            }
        }



        // Boutons pour la fenêtre du jeu
        else if (s.getTitle().equals("Jeu de la mine")) {


            if (((Button) event.getSource()).getText().equals("Quitter le jeu")) {
                gui.close();
            }

            else if (((Button) event.getSource()).getText().equals("Redémarrer une partie")) {
                new VGraphique();
                gui.close();

            }

            else if (((Button) event.getSource()).getText().equals("Se déplacer")) {

            }

            else if (((Button) event.getSource()).getText().equals("Extraire des minerais")) {

            }
            else if (((Button) event.getSource()).getText().equals("Décharger des minerais")) {

            }
            else if (((Button) event.getSource()).getText().equals("Suivant")) {

            }
            else if (((Button) event.getSource()).getText().equals("Précédent")) {

            }

        }

    }


}
