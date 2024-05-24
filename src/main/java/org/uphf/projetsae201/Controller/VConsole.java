package org.uphf.projetsae201.Controller;

import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.Model.Robot;
import org.uphf.projetsae201.Model.Terrain;
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
        Monde m =new Monde(5,5,5,5);
        ArrayList<Robot> lstRobots = m.getRobots();
        int cpt = 0;


        while (!Fin) {
            cpt+=1;
            System.out.println("Tour N°"+cpt);
            new AffichageConsole(m);

            //on demande une action à tous les robots
            for(int i=0;i<lstRobots.size();i++){
                boolean Valide = false;
                while (!Valide){
                    System.out.println("nextMove Robot"+i);
                    System.out.println("Haut,Bas,Gauche,Droit,Extraire,Vider");
                    String direction = sc.nextLine();
                    Robot robot = lstRobots.get(i);
                    if(robot.verifDeplacement(m,direction)){
                        Valide=true;
                        m.deplacerRobot(direction,((Terrain)m.getLstSecteur()[robot.getCoordonneesX()][robot.getCoordonneesY()]));
                    }

                }


            }
            System.out.println();

            sc.nextLine();
            Fin=true;


        }
    }
}
