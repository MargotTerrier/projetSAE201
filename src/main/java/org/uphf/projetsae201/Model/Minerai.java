package org.uphf.projetsae201.Model;

import java.util.Random;

public enum Minerai {
    Or, Nickel;

    public static Minerai RandomMinerai(){
        int rand = new Random().nextInt(2);
        if (rand == 1){
            return Nickel;
        }
        else return Or;
    }

}
