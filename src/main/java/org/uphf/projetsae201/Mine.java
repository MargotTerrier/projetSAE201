package org.uphf.projetsae201;

import java.util.Random;

public class Mine extends District{
    private int id;
    private int nbMinerais; // nombre de minerais actuel dans la mine
    private Minerai typeMinerai;
    private int capacite; // nombre de minerais total présent dans la mine au départ

    public Mine(int id){
        this.id = id;
        this.nbMinerais = 50 + new Random().nextInt(50);
        this.capacite = nbMinerais;
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

    public int extraction(Robot r){
        if (this.nbMinerais == 0) return -1;
        else if (this.nbMinerais - r.getCapaciteExtraction() < 0) {
            int tmp = this.nbMinerais;
            this.nbMinerais = 0;
            return tmp;
        }
        else {
            this.nbMinerais -= r.getCapaciteExtraction();
            return r.getCapaciteExtraction();
        }
    }

}