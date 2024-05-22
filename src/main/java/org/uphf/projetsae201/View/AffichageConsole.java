package org.uphf.projetsae201.View;

public class AffichageConsole {
//    private Secteur[][] m ;
//    private String[][][][] Affiche ;
//    public AffichageConsole(Monde map) {
//
//        this.m = map.getLstSecteur();
//        this.Affiche = new String[map.getLongueurMonde()][map.getLargeurMonde()][2][2];
//        for (int i = 0; i < map.getLongueurMonde(); i++) {
//            for (int j = 0; j < map.getLargeurMonde(); j++) {
//                // Initialisation du tableau 2x2 pour chaque élément du tableau principal
//                this.Affiche[i][j] = new String[2][2];
//            }
//        }
//        affichage();
//    }
//
//    public void affichage() {
//        for(int i = 0; i < m.length; i++) {
//            for (int j = 0; j < m[i].length; j++) {
//                if (m[i][j] instanceof Terrain) {
//                    Terrain t = (Terrain) m[i][j];
//                    //Ligne du bas//
//                    if (t.getRobot() != null) {
//                        this.Affiche[i][j][1][0] = "|R";
//                        this.Affiche[i][j][1][1] = "" + (t.getRobot().getIdRobot()) + "|";
//                    }
//                    else {
//                        this.Affiche[i][j][1][0] = "| ";
//                        this.Affiche[i][j][1][1] = " |";
//                    }
//
//                    //Ligne de haut//
//                    if (t.getDistrict() != null) {
//                        if (t.getDistrict() instanceof Mine) {
//                            this.Affiche[i][j][1][0] = "|M";
//                            this.Affiche[i][j][1][1] = "" + (t.getDistrict().getId()) + "|";
//                        }
//                    }
//                    if (t.getDistrict() instanceof Entrepot) {
//                        this.Affiche[i][j][1][0] = "|E";
//                        this.Affiche[i][j][1][1] = "" + (t.getDistrict().getId()) + "|";
//                    }
//                } else {
//                    this.Affiche[i][j][1][0] = "|x";
//                    this.Affiche[i][j][1][1] = "x|";
//                }
//            }
//        }
//        for (int i = 0; i < this.Affiche.length; i++) {
//            for (int j = 0; j < this.Affiche[i].length; j++) {
//                for (int k = 0; k < this.Affiche[i][j].length; k++) {
//                    for (int l = 0; l < this.Affiche[i][j][k].length; l++) {
//                        System.out.println(this.Affiche[i][j][k][l]);
//                    }
//                }
//            }
//        }
//
//    }
}



