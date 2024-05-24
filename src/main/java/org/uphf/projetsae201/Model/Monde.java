package org.uphf.projetsae201.Model;


import java.util.Random;

import static java.lang.System.in;

public class Monde {
    private int nbTerrains;
    private int nbMines;
    private int nbEntrepots;
    private int compteurTour;
    private int nbRobot;
    private int nbPlanEau;
    private int longueurMonde;
    private int largeurMonde;


    private Secteur[][] lstSecteur;


    public Monde(int nbEntrepots, int nbRobot, int longueurMonde, int largeurMonde) {

        this.nbEntrepots = nbEntrepots;
        this.compteurTour = 0;
        this.nbRobot = nbRobot;
        this.longueurMonde = longueurMonde;
        this.largeurMonde = largeurMonde;




        // le nb de terrains represente au moins 90% +- 10%(nbPlanDeau) -
        int maxSize = this.longueurMonde*this.largeurMonde;
        // Mme Lepreux nous a dit au moins un plans d'eau.
        this.nbPlanEau = new Random().nextInt(1,((int) ((maxSize + 1) * 0.1)));
        this.nbTerrains = maxSize - this.nbPlanEau;


        System.out.println((int) (0.9*(this.largeurMonde*this.longueurMonde)+0.1*(0))-1);
        System.out.println((int) (0.9*(this.largeurMonde*this.longueurMonde)+0.1*(this.largeurMonde*this.longueurMonde)-1));
        System.out.println(this.nbTerrains);
        System.out.println(this.nbPlanEau);




        // au moins une mine d'or et une mine de nickel
        this.nbMines = 2 + new Random().nextInt(2);

        //on crée un tableau car on connait le nombre de case et c'est fixe
        this.lstSecteur = new Secteur[this.longueurMonde][this.largeurMonde];
        creationMonde();
    }

    public int getCompteurTour() {
        return this.compteurTour;
    }

    public int getNbTerrains() {
        return nbTerrains;
    }

    public int getNbMines() {
        return nbMines;
    }

    public int getNbEntrepots() {
        return nbEntrepots;
    }

    public int getNbRobot() {
        return nbRobot;
    }

    public int getNbPlantEau() {
        return nbPlanEau;
    }

    public int getLongueurMonde() {
        return longueurMonde;
    }

    public int getLargeurMonde() {
        return largeurMonde;
    }

    public Secteur[][] getLstSecteur() {
        return this.lstSecteur;
    }

    public void creationMonde() {//création d'une grille pour jouer
        int l;
        int L;
        int minerai = 0;
        Secteur[][] map = new Secteur[this.longueurMonde][this.largeurMonde];
        String[][] pas = new String[this.longueurMonde][this.largeurMonde];
        for (int i = 0; i < this.longueurMonde; i++) {
            for (int j = 0; j < this.largeurMonde; j++) {

                map[i][j] = new Terrain();
                pas[i][j] = "V";
            }
        }

        for (int x = 0; x < this.nbPlanEau; ) {
            l = new Random().nextInt(this.longueurMonde);
            L = new Random().nextInt(this.largeurMonde);
            if (!(pas[l][L].equals("O"))) {
                pas[l][L] = "O";
                map[l][L] = new PlanDeau();
                x += 1;
            }
        }

        for (int x = 0; x < this.nbRobot; ) {
            l = new Random().nextInt(this.longueurMonde);
            L = new Random().nextInt(this.largeurMonde);
            if (!(pas[l][L].equals("R")) && !(pas[l][L].equals("O"))) {
                pas[l][L] = "R";
                ((Terrain) map[l][L]).setRobot(new Robot(l, L));
                x += 1;
            }
        }

        for (int x = 0; x < this.nbEntrepots; ) {
            l = new Random().nextInt(this.longueurMonde);
            L = new Random().nextInt(this.largeurMonde);
            if (!(pas[l][L].equals("R")) && !(pas[l][L].equals("O")) && !(pas[l][L].equals("E"))) {
                pas[l][L] = "E";
                if (x==0){
                    ((Terrain) map[l][L]).setDistrict(new Entrepot(Minerai.Or));
                } else if (x==1)
                {
                    ((Terrain) map[l][L]).setDistrict(new Entrepot(Minerai.Nickel));
                }
                else {((Terrain) map[l][L]).setDistrict(new Entrepot());}
                x += 1;
            }
        }

        for (int x = 0; x < this.nbMines; ) {
            l = new Random().nextInt(this.longueurMonde);
            L = new Random().nextInt(this.largeurMonde);

            if (!(pas[l][L].equals("R")) && !(pas[l][L].equals("O")) && !(pas[l][L].equals("E")) && !(pas[l][L].equals("M"))) {
                pas[l][L] = "M";
                if (x==0){
                    ((Terrain) map[l][L]).setDistrict(new  Mine(Minerai.Or));
                } else if (x==1)
                {
                    ((Terrain) map[l][L]).setDistrict(new  Mine(Minerai.Nickel));
                }
                else {((Terrain) map[l][L]).setDistrict(new  Mine());}
                x += 1;
            }


            this.lstSecteur = map;
        }
    }
    public void inverseRobot(Robot r1,Robot r2){



    }
    public void deplacerRobot(String direction,Terrain T){
        Robot r=T.getRobot();
        if (r.verifDeplacement(this,direction)) {//vérifie si on peut se déplacer
            int tmpY = r.getCoordonneesY();
            int tmpX = r.getCoordonneesX();

            switch (direction) {
                case "Haut" -> tmpX -= 1;
                case "Bas" -> tmpX += 1;
                case "Gauche" -> tmpY -= 1;
                case "Droit" -> tmpY += 1;
            }

            Robot temp = new Robot(r);
            Robot r2 = ((Terrain) this.lstSecteur[tmpX][tmpY]).getRobot();
            ((Terrain) this.lstSecteur[r.getCoordonneesX()][r.getCoordonneesY()]).setRobot(r2);

            ((Terrain) this.lstSecteur[tmpX][tmpY]).setRobot(temp);
        }
    }
}
