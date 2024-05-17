package org.uphf.projetsae201;

import java.util.Random;

public class Mine extends District{
    private int id;
    private int nbMinerais;
    private Minerai typeMinerai;
    private int capacite;
    private boolean vide;

    public Mine(int id){
        this.id = id;
        this.nbMinerais = 50 + new Random().nextInt(50);
        this.capacite = nbMinerais;
        this.vide = false;
    }

    public int getId(){
        return this.id;
    }
    public int getNbMinerais(){
        return this.nbMinerais;
    }
    public int getCapacite(){
        return this.capacite;
    }

    public void extraction(Robot r){
        this.nbMinerais -= r.getCapaciteExtraction();
    }

    public void setVide(boolean v) {
        this.vide=v;
    }

    public boolean getVide(){
        return this.vide;
    }

}