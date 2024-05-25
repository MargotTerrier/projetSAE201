package org.uphf.projetsae201.Model;

import java.util.Random;

public class Mine extends District{
    private static int id=1;
    private int idMine;
    private int nbMinerais; // Nombre de minerais restants
    private Minerai typeMinerai;
    private int capacite; // Nombre total de minerais à la création

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

    public int extraction(Robot r){ // retourne le nombre de minerais qui sera extrait
        if (this.nbMinerais == 0) {
            System.out.println("VIDE");
            return -1; // Si la mine est vide, retourne  -1
        }
        else if (this.nbMinerais - r.getCapaciteExtraction() < 0) {

            System.out.println("aled");// S'il y moins de minerais dans la mine que la capacité d'extraction du robot
            int tmp = this.nbMinerais;
            this.nbMinerais = 0;
            return tmp; // retourne le nombre de minerais restant dans la mine
        }
        else {
            System.out.println(r.getCapaciteExtraction());
            this.nbMinerais -= r.getCapaciteExtraction();
            return r.getCapaciteExtraction(); // retourne le nombre de minerais max que le robot peut extraire
        }
    }
}