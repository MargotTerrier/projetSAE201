package org.uphf.projetsae201.Model;

import java.util.Random;

public class Mine extends District{
    private static int id=1;
    private int idMine;
    private int nbMinerais; // Nombre de minerais restants
    private Minerai typeMinerai;
    private int capacite; // Nombre total de minerais à la création
    private int x;
    private int y;
    public Mine(Minerai minerai){
        this.idMine = id;
        id++;
        this.nbMinerais = 50 + new Random().nextInt(50);
        this.capacite = nbMinerais;
        this.typeMinerai=minerai;
    }
    public Mine(){
        this.idMine = id;
        id++;
        this.nbMinerais = 50 + new Random().nextInt(50);
        this.capacite = nbMinerais;
        this.typeMinerai=Minerai.RandomMinerai();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
    public Minerai getTypeMinerai(){return this.typeMinerai;}

    public void setNbMinerais(int nbMinerais){
        this.nbMinerais = nbMinerais;
    }

    public void resetMine(){
        id=1;
    }
}

