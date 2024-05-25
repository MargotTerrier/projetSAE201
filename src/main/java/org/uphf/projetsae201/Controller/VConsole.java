package org.uphf.projetsae201.Controller;

import org.uphf.projetsae201.Model.*;
import org.uphf.projetsae201.View.AffichageConsole;

import java.util.ArrayList;
import java.util.Scanner;

public class VConsole {
    public VConsole(){
        this.lancer();
    }


    public void lancer(){

        boolean Fin=false;
        Scanner sc = new Scanner(System.in);
        Monde m =new Monde(2,1,5,5);
        ArrayList<Robot> lstRobots = m.getRobots();
        ArrayList<District> lstDistrict = m.getDistrict();
        int cpt = 0;


        while (!Fin) {
            cpt+=1;
            System.out.println("Tour N°"+cpt);
            new AffichageConsole(m);

            //on demande une action à tous les robots
            for(int i=0;i<lstRobots.size();i++){
                boolean Valide = false;
                while (!Valide){
                    Robot robot = lstRobots.get(i);
                    System.out.println("Prochain mouvement de Robot"+i+" Type de Minerai : "+robot.getTypeMinerai());
                    System.out.println("Action Possible : Haut,Bas,Gauche,Droit,Extraire,Vider");
                    String direction = sc.nextLine();
                    if(robot.verifDeplacement(m,direction)){
                        Valide=true;
                        m.deplacerRobot(direction,((Terrain)m.getLstSecteur()[robot.getCoordonneesX()][robot.getCoordonneesY()]));
                    }
                    else{
                        System.out.println("Impossible de faire ça ici. Choississez une autre action");
                    }

                }



            }

            Fin=m.verifFin();


        }
    }
}
