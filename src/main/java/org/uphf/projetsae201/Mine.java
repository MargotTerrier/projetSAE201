package org.uphf.projetsae201;

import java.util.Random;

public class Mine extends District{
    private static int id=1;
    private int idMine;
    private int nbMinerais; // Nombre de minerais restants
    private Minerai typeMinerai;
    private int capacite; // Nombre total de minerais à la création

    public Mine(){
        this.idMine = id;
        id++;
        this.nbMinerais = 50 + new Random().nextInt(50);
        this.capacite = nbMinerais;
    }

    public int getId(){
        return this.idMine;
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