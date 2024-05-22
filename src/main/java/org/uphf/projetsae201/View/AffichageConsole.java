package org.uphf.projetsae201.View;

import org.uphf.projetsae201.Model.Entrepot;
import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.Model.Secteur;
import org.uphf.projetsae201.Model.Terrain;

public class AffichageConsole {
    private Monde m ;
    public AffichageConsole(Monde m ) {
        this.m = m;
    }

    public void affichage() {
        Secteur [][] map = m.getLstSecteur();
        String temp ;

        //*2 car on a 4 case par secteur
        for(int i = 0; i < map.length*2; i++) {
            String s =new String(new char[map[i].length*2]).replace("\0", "=");
            System.out.print(s);

            for(int j = 0; j < map[i].length; j++) {

                //On sépare les cas en paire et impair afin de savoir si on est sur la ligne des mine ou des Robots.
                if (i%2 == 0) {
                    else if ((map[i][j]instanceof Terrain){
                        Terrain t = (Terrain) map[i][j];
                        if (t.getDistrict()==null){

                        }
                        else if (t.getDistrict() instanceof Entrepot){

                        }

                    }

                }
            }
        }
    }




}



