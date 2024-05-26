package org.uphf.projetsae201.Model;

public class Entrepot extends District{

    private static int id=1;
    private int idEntrepot;
    private int nbMineraisStockes;
    private  Minerai typeMinerai;

    public Entrepot(Minerai minerai){
        super();
        this.typeMinerai=minerai;
        this.idEntrepot = id;
        id++;
        this.nbMineraisStockes = 0;
    }
    public Entrepot(){
        super();

        this.idEntrepot = id;
        id++;
        this.nbMineraisStockes = 0;
        this.typeMinerai=Minerai.RandomMinerai();
    }


    @Override
    public int getId() {
        return idEntrepot;
    }

    public int getnbMineraisStockees(){
        return this.nbMineraisStockes;
    }

    public void remplissage(Robot rob){
        this.nbMineraisStockes += rob.getNbMineraisExtraits();
    }


    public Minerai getTypeMinerai() {
        return typeMinerai;
    }

    public String getNbMinerais() {
        return String.valueOf(nbMineraisStockes);
    }
}