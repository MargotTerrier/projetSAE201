package org.uphf.projetsae201;

public class AffichageConsole {

    public AffichageConsole(Monde map) {

        Secteur[][] m = map.getLstSecteur();
        String[][][][] Affiche = new String[map.getLongueurMonde()][map.getLargeurMonde()][2][2];
        for (int i = 0; i < map.getLongueurMonde(); i++) {
            for (int j = 0; j < map.getLargeurMonde(); j++) {
                // Initialisation du tableau 2x2 pour chaque élément du tableau principal
                Affiche[i][j] = new String[2][2];
            }
        }

    }
}

