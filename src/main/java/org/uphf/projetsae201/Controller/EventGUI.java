package org.uphf.projetsae201.Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Robot;
import org.uphf.projetsae201.Model.Terrain;
import org.uphf.projetsae201.View.GUI;
import org.uphf.projetsae201.View.GUIAcceuil;
import org.uphf.projetsae201.View.GUIChoix;

import java.util.ArrayList;

public class EventGUI implements EventHandler {
    private VGraphique v;
    private GUI gui;
    private GUIChoix cgui;
    private GUIAcceuil agui;
    private int i;
    private ArrayList<Robot> robots;

    public EventGUI(GUIAcceuil agui) {
        this.agui = agui;
    }
    public EventGUI(GUIChoix cgui) {
        this.cgui = cgui;
    }

    public EventGUI(VGraphique v) {
        this.v = v;
        this.gui = v.getGUI();
        i=0;
        this.robots=v.getMonde().getRobots();
        gui.Affiche(this);

    }

    public int getI(){
        return i;
    }
    public void verif(){
        if(this.i==this.robots.size()) {
            this.v.actualise();
            this.i=0;
            this.v.getMonde().increment();
            gui.setMonde(v.getMonde());
            gui.Affiche(this);

        }
        else {
            gui.Affiche(this);
        }
    }

    @Override
    public void handle(Event event) {
        Stage s = ((Stage) ((Node) event.getSource()).getScene().getWindow());


        // Boutons pour la fenêtre d'acceuil
        if (s.getTitle().equals("Accueil")) {
            if (((Button) event.getSource()).getText().equals("Commencer une partie")) {

                agui.close();
                new GUIChoix();
            } else if (((Button) event.getSource()).getText().equals("Quitter")) {
                agui.close();
            }
        }


        // Boutons pour la fenêtre du mode de jeu
        else if (s.getTitle().equals("Choix du mode")) {
            if (((Button) event.getSource()).getText().equals("Graphique")) {
                cgui.close();
                new VGraphique();
            } else if (((Button) event.getSource()).getText().equals("Quitter")) {
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
            } else if (((Button) event.getSource()).getText().equals("Redémarrer une partie")) {
                new VGraphique();
                gui.close();
            } else if (((Button) event.getSource()).getText().equals("Extraire des minerais")) {
                if (robots.get(i).verifDeplacement(this.v.getMonde(),"Extraire")){
                    this.v.getMonde().deplacerRobot("Extraire",((Terrain)v.getMonde().getLstSecteur()[this.robots.get(i).getCoordonneesX()][this.robots.get(i).getCoordonneesY()]));
                    i+=1;
                    verif();
                }

            } else if (((Button) event.getSource()).getText().equals("Décharger des minerais")) {
                if (robots.get(i).verifDeplacement(this.v.getMonde(),"Vider")){
                    this.v.getMonde().deplacerRobot("Vider",((Terrain)v.getMonde().getLstSecteur()[this.robots.get(i).getCoordonneesX()][this.robots.get(i).getCoordonneesY()]));
                    i+=1;
                    verif();
                }
            }
            else if (((Button) event.getSource()).getText().equals("Haut")) {
                if (robots.get(i).verifDeplacement(this.v.getMonde(),"Haut")){
                    this.v.getMonde().deplacerRobot("Haut",((Terrain)v.getMonde().getLstSecteur()[this.robots.get(i).getCoordonneesX()][this.robots.get(i).getCoordonneesY()]));
                    i+=1;
                    verif();
                }

            }
            else if (((Button) event.getSource()).getText().equals("Bas")) {
                if (robots.get(i).verifDeplacement(this.v.getMonde(),"Bas")){
                    this.v.getMonde().deplacerRobot("Bas",((Terrain)v.getMonde().getLstSecteur()[this.robots.get(i).getCoordonneesX()][this.robots.get(i).getCoordonneesY()]));
                    i+=1;
                    verif();
                }
            }
            else if (((Button) event.getSource()).getText().equals("Gauche")) {
                if (robots.get(i).verifDeplacement(this.v.getMonde(),"Gauche")){
                    this.v.getMonde().deplacerRobot("Gauche",((Terrain)v.getMonde().getLstSecteur()[this.robots.get(i).getCoordonneesX()][this.robots.get(i).getCoordonneesY()]));
                    i+=1;
                    verif();
                }
            }
            else if (((Button) event.getSource()).getText().equals("Droit")) {
                if (robots.get(i).verifDeplacement(this.v.getMonde(),"Droit")){
                    this.v.getMonde().deplacerRobot("Droit",((Terrain)v.getMonde().getLstSecteur()[this.robots.get(i).getCoordonneesX()][this.robots.get(i).getCoordonneesY()]));
                    i+=1;
                    verif();
                }
            }


        }

        // Boutons pour la fenêtre de fin de jeu
        else if (s.getTitle().equals("Fin")) {
            if (((Button) event.getSource()).getText().equals("Ok")) {
                gui.close();
            }
        }

    }
}
