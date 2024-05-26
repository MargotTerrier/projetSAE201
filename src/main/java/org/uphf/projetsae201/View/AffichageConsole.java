package org.uphf.projetsae201.View;

import org.uphf.projetsae201.Model.*;
import java.util.ArrayList;
import java.util.Comparator;

public class AffichageConsole {
    private Monde m ;
    public AffichageConsole(Monde m ) {
        this.m = m;
        affichage();
    }

    public void affichage() {
        Secteur [][] map = m.getLstSecteur();
        String temp ;
        String temp2;
        String s =new String(new char[map[0].length*4]).replace("\0", "=");
        ArrayList<District> lstDistrict = m.getDistrict();

        for(int i = 0; i < map.length; i++) {


            System.out.println(s);
            temp = "|";
            temp2 = "|";

            for(int j = 0; j < map[0].length; j++) {
                    if ((map[i][j]instanceof Terrain)) {
                        //ligne District
                        Terrain t = (Terrain) map[i][j];
                        if (t.getDistrict() instanceof Entrepot) {
                            temp += "E " + ((Entrepot) t.getDistrict()).getId() + "|";
                        }
                        else if (t.getDistrict() instanceof Mine) {
                            temp += "M " + ((Mine) t.getDistrict()).getId() + "|";
                        }
                        else {
                            temp += "   |";
                        }

                        //ligne Robot
                        if(t.getRobot() != null) {
                            temp2 += "R " + t.getRobot().getIdRobot() + "|";
                        }
                        else  {
                            temp2 += "   |";
                        }
                    }
                    else if ((map[i][j]instanceof PlanDeau)){
                        temp += "X X|";
                        temp2 += "X X|";
                    }

            }
            System.out.println(temp);
            System.out.println(temp2);
        }
        System.out.println(s);

        //Affiche les données de tous ce qui compose le monde
        //On trie par id

        ArrayList<Mine>lstMines = m.getMines();
        ArrayList<Entrepot>lstEntrepots = m.getEntrepots();

        for(Mine mine : lstMines){
            System.out.println("Mine " + mine.getId() + " Type de Minerai :" + mine.getTypeMinerai() + " Quantité restante : " + mine.getNbMinerais() + "/" + mine.getCapacite());
        }
        for(Entrepot entrepot : lstEntrepots){
            System.out.println("Entrepot " + entrepot.getId() + " Type de Minerai :" + entrepot.getTypeMinerai() + " Quantité stocké : " + entrepot.getNbMinerais());
        }

    }
}








