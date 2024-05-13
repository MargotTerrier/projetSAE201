package org.uphf.projetsae201;

public class Mine extends District{
    private int id;
    private int nbMinerais;
    private int capacite;
    private boolean vide;

    public Mine(int id){
        this.id = id;
        this.nbMinerais = 50 + random.nextInt(50);
        this.capacite = nbMinerais;
        this.vide = False;
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
}