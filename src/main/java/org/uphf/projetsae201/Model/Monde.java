package org.uphf.projetsae201.Model;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;


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

    public Monde(int longueurMonde, int largeurMonde) {
        this.longueurMonde = longueurMonde;
        this.largeurMonde = largeurMonde;
    }

    public Monde(int nbEntrepots, int nbRobot, int longueurMonde, int largeurMonde) {

        this.nbEntrepots = nbEntrepots;
        this.compteurTour = 0;
        this.nbRobot = nbRobot;
        this.longueurMonde = longueurMonde;
        this.largeurMonde = largeurMonde;


        // le nb de terrains represente au moins 90% +- 10%(nbPlanDeau) -
        int maxSize = this.longueurMonde * this.largeurMonde;

        // Mme Lepreux nous a dit au moins un plans d'eau.
        this.nbPlanEau = new Random().nextInt(1, ((int) ((maxSize + 1) * 0.1)));
        this.nbTerrains = maxSize - this.nbPlanEau;


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

    //récupère les districts dans un monde
    public ArrayList<District> getDistrict(){
        ArrayList<District> districts = new ArrayList<>();
        for (int i = 0; i < this.longueurMonde; i++) {
            for (int j = 0; j < this.largeurMonde; j++) {
                if (this.lstSecteur[i][j] instanceof Terrain) {
                    if (((((Terrain) this.lstSecteur[i][j]).getDistrict() != null))) {
                        districts.add( ((Terrain) this.lstSecteur[i][j]).getDistrict());
                    }
                }
            }
        }
        return districts;
    }
    //recupère les Mines
    public ArrayList<Mine> getMines(){
        ArrayList<Mine> mines = new ArrayList<>();
        for (int i = 0; i < this.longueurMonde; i++) {
            for (int j = 0; j < this.largeurMonde; j++) {
                if (this.lstSecteur[i][j] instanceof Terrain) {
                    if (((((Terrain) this.lstSecteur[i][j]).getDistrict() != null))&& ((((Terrain) this.lstSecteur[i][j]).getDistrict() instanceof Mine) )){
                        mines.add( (Mine) ((Terrain) this.lstSecteur[i][j]).getDistrict());
                    }
                }
            }
        }
        mines.sort(Comparator.comparingInt(Mine::getId));
        return mines;
    }
    //recupère les Entrepots
    public ArrayList<Entrepot> getEntrepots(){
        ArrayList<Entrepot> entrepots = new ArrayList<>();
        for (int i = 0; i < this.longueurMonde; i++) {
            for (int j = 0; j < this.largeurMonde; j++) {
                if (this.lstSecteur[i][j] instanceof Terrain) {
                    if (((((Terrain) this.lstSecteur[i][j]).getDistrict() != null))&& ((((Terrain) this.lstSecteur[i][j]).getDistrict() instanceof Entrepot) )){
                        entrepots.add( (Entrepot) ((Terrain) this.lstSecteur[i][j]).getDistrict());
                    }
                }
            }
        }
        entrepots.sort(Comparator.comparingInt(Entrepot::getId));//Trie
        return entrepots;
    }


    //récupère les robots dans un monde
    public ArrayList<Robot> getRobots() {
        ArrayList<Robot> robots = new ArrayList<>();
        for (int i = 0; i < this.longueurMonde; i++) {
            for (int j = 0; j < this.largeurMonde; j++) {
                if (this.lstSecteur[i][j] instanceof Terrain) {
                    if ((((Terrain) this.lstSecteur[i][j]).getRobot() != null)) {
                        robots.add( ((Terrain) this.lstSecteur[i][j]).getRobot());
                    }
                }
            }
        }
        robots.sort(Comparator.comparingInt(Robot::getIdRobot)); //permet de jouer toujours dans le même ordre
        return robots;
    }

    //création d'une grille pour jouer
    public void creationMonde() {
        int l;int L;

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
                if (x == 0) {
                    ((Terrain) map[l][L]).setRobot(new Robot(l,L,Minerai.Or));
                } else if (x == 1) {
                    ((Terrain) map[l][L]).setRobot(new Robot(l,L,Minerai.Or));
                } else {
                    ((Terrain) map[l][L]).setRobot(new Robot(l,L,Minerai.RandomMinerai()));
                }
                x += 1;
            }
        }

        for (int x = 0; x < this.nbEntrepots; ) {
            l = new Random().nextInt(this.longueurMonde);
            L = new Random().nextInt(this.largeurMonde);
            if (!(pas[l][L].equals("R")) && !(pas[l][L].equals("O")) && !(pas[l][L].equals("E"))) {
                pas[l][L] = "E";
                if (x == 0) {
                    ((Terrain) map[l][L]).setDistrict(new Entrepot(Minerai.Or));
                } else if (x == 1) {
                    ((Terrain) map[l][L]).setDistrict(new Entrepot(Minerai.Nickel));
                } else {
                    ((Terrain) map[l][L]).setDistrict(new Entrepot());
                }
                x += 1;
            }
        }

        for (int x = 0; x < this.nbMines; ) {
            l = new Random().nextInt(this.longueurMonde);
            L = new Random().nextInt(this.largeurMonde);

            if (!(pas[l][L].equals("R")) && !(pas[l][L].equals("O")) && !(pas[l][L].equals("E")) && !(pas[l][L].equals("M"))) {
                pas[l][L] = "M";
                if (x == 0) {
                    ((Terrain) map[l][L]).setDistrict(new Mine(Minerai.Or));
                } else if (x == 1) {
                    ((Terrain) map[l][L]).setDistrict(new Mine(Minerai.Nickel));
                } else {
                    ((Terrain) map[l][L]).setDistrict(new Mine());
                }
                x += 1;
            }
            this.lstSecteur = map;
        }
    }

    public void deplacerRobot(String direction, Terrain T) {
        Robot r = T.getRobot();

        if (r.verifDeplacement(this, direction)) {//vérifie si on peut se déplacer
            int tmpY = r.getCoordonneesY();
            int tmpX = r.getCoordonneesX();

            switch (direction) {
                case "Haut" -> tmpX -= 1;
                case "Bas" -> tmpX += 1;
                case "Gauche" -> tmpY -= 1;
                case "Droit" -> tmpY += 1;
                case "Extraire" -> {
                    if (((Terrain) this.lstSecteur[tmpX][tmpY]).getDistrict() instanceof Mine) {
                        this.extraire(r,(Mine) ((Terrain) this.lstSecteur[tmpX][tmpY]).getDistrict());
                        System.out.println(r.getTypeMinerai());
                        T.setRobot(r);
                    }
                }
                case "Vider" -> {
                    if (((Terrain) this.lstSecteur[tmpX][tmpY]).getDistrict() instanceof Entrepot) {
                        this.vider(r,(Entrepot) ((Terrain) this.lstSecteur[tmpX][tmpY]).getDistrict());
                    }

                }
            }
            if (((Terrain) this.lstSecteur[tmpX][tmpY]).getRobot() != null) {
                Robot r2 = ((Terrain) this.lstSecteur[tmpX][tmpY]).getRobot();
                Robot temp = new Robot(r);

                ((Terrain) this.lstSecteur[r.getCoordonneesX()][r.getCoordonneesY()]).setRobot(r2);
                ((Terrain) this.lstSecteur[tmpX][tmpY]).setRobot(temp);

                r2.setCoordonneesX(temp.getCoordonneesX());
                r2.setCoordonneesY(temp.getCoordonneesY());
            } else {
                ((Terrain) this.lstSecteur[tmpX][tmpY]).setRobot(r);
                ((Terrain) this.lstSecteur[r.getCoordonneesX()][r.getCoordonneesY()]).setRobot(null);
                r.setCoordonneesX(tmpX);
                r.setCoordonneesY(tmpY);


            }
        }
    }

    public void extraire(Robot robot, Mine mine){
        boolean MineraiSuffisant = mine.getNbMinerais() > robot.getCapaciteExtraction();
        boolean StockageSuffisant = robot.getCapaciteStockage() > (robot.getNbMineraisExtraits()+robot.getCapaciteExtraction());
        int minerai;

        if (MineraiSuffisant && StockageSuffisant) {
            minerai = robot.getCapaciteExtraction();
        }
        else if (MineraiSuffisant && !StockageSuffisant) {
            minerai = robot.getCapaciteStockage()-robot.getNbMineraisExtraits();
        }
        else if (!MineraiSuffisant && !StockageSuffisant){
            minerai = Math.min(robot.getCapaciteStockage() - robot.getNbMineraisExtraits(), mine.getNbMinerais());
        }
        else {
            minerai = mine.getNbMinerais();
        }

        robot.setnbMineraisExtraits(robot.getNbMineraisExtraits() + minerai);
        mine.setNbMinerais(mine.getNbMinerais() - minerai);
    }

    public void vider (Robot robot, Entrepot entrepot){
        entrepot.setnbMineraisStockes(entrepot.getnbMineraisStockees() + robot.getNbMineraisExtraits());
        robot.setnbMineraisExtraits(0);
    }


    public boolean verifFin(){
       ArrayList<Robot> robots = this.getRobots();
       ArrayList<District> districts = this.getDistrict();
       boolean fin = true;
       for(Robot i : robots){
           if (i.getNbMineraisExtraits() != 0) {
               fin = false;
               break;
           }
       }
       for(District d : districts){
           if(d instanceof Mine){
               if (((Mine) d).getNbMinerais()!=0){
                   fin = false;
               }
           }
       }
       return fin;
    }
}