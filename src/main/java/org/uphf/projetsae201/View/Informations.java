package org.uphf.projetsae201.View;

public class Informations {
    private String element;
    private int ligne;
    private int colonne;
    private String type;
    private String info;
    private String status;

    public Informations(String element, int ligne, int colonne, String type, String info) {
        this.element = element;
        this.ligne = ligne;
        this.colonne = colonne;
        this.type = type;
        this.info = info;
    }

    public Informations(String nom, String status) {
        this.element = nom;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
