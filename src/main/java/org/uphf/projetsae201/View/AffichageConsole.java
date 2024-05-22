package org.uphf.projetsae201.View;

import org.uphf.projetsae201.Model.*;

public class AffichageConsole {
    private Monde m ;
    public AffichageConsole(Monde m ) {
        this.m = m;
        affichage();
    }

    public void affichage() {
        Secteur [][] map = m.getLstSecteur();
        String temp ;

        //*2 car on a 4 case par secteur
        for(int i = 0; i < map.length*2; i++) {
            String s =new String(new char[map.length*2]).replace("\0", "=");
            System.out.println(s);
            temp = "|";

            for(int j = 0; j < map[i].length; j++) {

                //On sépare les cas en paire et impair afin de savoir si on est sur la ligne des mine ou des Robots.
                if (i%2 == 0) {
                    if ((map[i][j]instanceof Terrain)) {
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
                    }
                    else if ((map[i][j]instanceof PlanDeau)){
                        temp += "X X|";
                    }
                }
                else {
                    if (map[i][j] instanceof Terrain) {
                        Terrain t = (Terrain) map[i][j];
                        if(t.getRobot() != null) {
                            temp += "R " + t.getRobot().getIdRobot() + "|";
                        }
                        else  {
                            temp += "   |";
                        }
                    }
                    else if ((map[i][j]instanceof PlanDeau)){
                        temp += "X X|";
                    }
                }
            }
            System.out.println(temp);
        }

    }




}



