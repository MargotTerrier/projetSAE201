package org.uphf.projetsae201.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.Model.PlanDeau;
import org.uphf.projetsae201.Model.Secteur;
import org.uphf.projetsae201.View.AffichageConsole;
import org.uphf.projetsae201.View.GUI;


public class Main extends Application {

    @Override public void start(Stage stage){

        Monde m = new Monde(5,5,10,10);
//        System.out.println(m);
        Secteur a= new PlanDeau();
//        System.out.println(a);
        new AffichageConsole(m);

        new GUI();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
