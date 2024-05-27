package org.uphf.projetsae201.View;

import javafx.collections.ObservableList;
import org.uphf.projetsae201.Model.*;

public class Informations {
    private String element;
    private int ligne;
    private int colonne;
    private String type;
    private String info;

    public Informations(String element, int ligne, int colonne, String type, String info) {
        this.element = element;
        this.ligne = ligne;
        this.colonne = colonne;
        this.type = type;
        this.info = info;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    static void addInfo(ObservableList<Informations> data, Secteur secteur, int posX, int posY) {
        if (secteur instanceof Terrain) {
            Terrain terrain = (Terrain) secteur;
            String type = "";
            String mineraiType = "";
            String info = "";

            if (terrain.getDistrict() instanceof Mine) {
                Mine mine = (Mine) terrain.getDistrict();
                type = "Mine";
                mineraiType = mine.getTypeMinerai().toString();
                info = "Minerai restant: " + mine.getNbMinerais();
            } else if (terrain.getDistrict() instanceof Entrepot) {
                Entrepot entrepot = (Entrepot) terrain.getDistrict();
                type = "Entrepôt";
                mineraiType = entrepot.getTypeMinerai().toString();
                info = "Minerais collectés: " + entrepot.getnbMineraisStockees();
            } else if (terrain.getRobot() instanceof Robot) {
                Robot robot = terrain.getRobot();
                type = "Robot " + robot.getIdRobot();
                mineraiType = robot.getTypeMinerai().toString();
                info = "Stockage: " + robot.getNbMineraisExtraits() +" / " + robot.getCapaciteStockage() + "\nCapacité exctraction " + robot.getCapaciteExtraction();
            }

            data.add(new Informations(type, posX+1, posY+1, mineraiType, info));
        }
    }
}
