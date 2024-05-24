package org.uphf.projetsae201.Controller;

import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.View.AffichageConsole;

import java.util.Scanner;

public class VConsole {
    public VConsole(){
        this.lancer();
    }
    public void lancer(){
        boolean Fin=false;
        Scanner sc = new Scanner(System.in);
        Monde m =new Monde(5,5,5,5);
        while (!Fin) {
            new AffichageConsole(m);
            System.out.println(m.getRobots());

            sc.nextLine();
            Fin=true;




        }
    }
}
