package org.uphf.projetsae201.Model;

public class Terrain extends Secteur{
    private District district;
    private Robot robot;

    public Terrain(){
        super();
        district = null;
        robot = null;
    }

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

    public void setDistrict(District district) {
        this.district = district;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;

    }

}