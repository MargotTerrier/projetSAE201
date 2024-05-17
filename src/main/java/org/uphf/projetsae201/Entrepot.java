package org.uphf.projetsae201;

public class Entrepot extends District{

    private int nbMineraisStockes;
    private  Minerai tyoeMinerai;

    public Entrepot(){
        super();
        this.nbMineraisStockes = 0;
    }

    public int getId(){
        return Secteur.id;
    }

    public int getnbMineraisStockees(){
        return this.nbMineraisStockes;
    }

    public void remplissage(Robot rob){
        this.nbMineraisStockes += rob.getNbMineraisExtraits();
    }


}