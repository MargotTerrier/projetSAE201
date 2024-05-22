package org.uphf.projetsae201.Model;

public class Entrepot extends District{

    private static int id=1;
    private int idEntrepot;
    private int nbMineraisStockes;
    private  Minerai typeMinerai;

    public Entrepot(){
        super();
        this.idEntrepot = id;
        id++;
        this.nbMineraisStockes = 0;
    }

    public int getIdEntrepot() {
        return idEntrepot;
    }

    public int getnbMineraisStockees(){
        return this.nbMineraisStockes;
    }

    public void remplissage(Robot rob){
        this.nbMineraisStockes += rob.getNbMineraisExtraits();
    }


}