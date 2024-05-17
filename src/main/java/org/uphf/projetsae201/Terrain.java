package org.uphf.projetsae201;

public class Terrain extends Secteur{
    private District district;
    private Robot robot;

    public Terrain(){super();}

    public Terrain(District d, Robot r){
        super();
        this.district = d;
        this.robot = r;
    }

    public int getId(){
        return Secteur.id;
    }

}