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
        String s =new String(new char[map[0].length*4]).replace("\0", "=");


        //*2 car on a 4 case par secteur
        for(int i = 0; i < map.length; i++) {
//            System.out.println(map.length);
//            System.out.println(map[i].length);
//            System.out.println(i);

            System.out.println(s);
            temp = "|";

            for(int j = 0; j < map[0].length; j++) {

                //On sépare les cas en paire et impair afin de savoir si on est sur la ligne des mine ou des Robots.
                if (i%2 ==0) {
//                    System.out.println("terre 1 ");
                    if ((map[i][j]instanceof Terrain)) {

                        Terrain t = (Terrain) map[i][j];
                        System.out.print(t.getDistrict());
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
//                        System.out.print(map[i][j]);
//                        System.out.println("eau1");
                        temp += "X X|";
                    }
                }
                else if (i%2 != 0) {
//                    System.out.print(map[i][j]);
//                    System.out.println("terre2");
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
//                        System.out.println("eau2");
                        temp += "X X|";
                    }
                }
            }
            System.out.println(temp);
        }
        System.out.println(s);

    }




}



