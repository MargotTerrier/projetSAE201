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
        Monde m =new Monde(2,0,5,5);

        m.getLstSecteur()[0][0]= new Terrain(new Mine(Minerai.Or),new Robot(0,0,Minerai.Or));

        ArrayList<District> lstDistrict = m.getDistrict();
        int cpt = 0;

        new AffichageConsole(m);

        while (!Fin) {
            cpt+=1;
            System.out.println("Tour N°"+cpt);
            ArrayList<Robot> lstRobots = m.getRobots();

            //on demande une action à tous les robots
            for(Robot robot : lstRobots){
                boolean Valide = false;

                while (!Valide){

                    //affichage
                    System.out.println("Prochain mouvement de Robot "+robot.getIdRobot()+" Type de Minerai : "+robot.getTypeMinerai()+" Nombre de minerai extrait : "+robot.getNbMineraisExtraits()+"/"+robot.getCapaciteStockage()+   " Capacite d'extraction : "+robot.getCapaciteExtraction());
                    System.out.println("Action Possible : Haut,Bas,Gauche,Droit,Extraire,Vider");
                    String direction = sc.nextLine();

                    if(robot.verifDeplacement(m,direction)){
                        Valide=true;
                        m.deplacerRobot(direction,((Terrain)m.getLstSecteur()[robot.getCoordonneesX()][robot.getCoordonneesY()]));
                        new AffichageConsole(m);
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
