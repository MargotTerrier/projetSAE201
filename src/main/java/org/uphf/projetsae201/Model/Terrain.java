package org.uphf.projetsae201.Model;

public class Terrain extends Secteur{
    private District district;
    private Robot robot;

    public Terrain(){super();}

    public Terrain(District d, Robot r){
        super();
        this.district = d;
        this.robot = r;
    }

    public District getDistrict() {
        if (district == null){
            return null;
        }
        return district;
    }

    public Robot getRobot() {
        return robot;
    }
}