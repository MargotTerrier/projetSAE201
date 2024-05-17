package org.uphf.projetsae201;

public class Terrain extends Secteur{
    private District district;
    private Robot robot;

    public Terrain(){
        super();
    }

    public int getId(){
        return Secteur.id;
    }

}