package org.uphf.projetsae201;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override public void start(Stage stage){

        Monde m = new Monde(5,5,5,5);
        System.out.println(m);
        new AffichageConsole(m.getLstSecteur());

        new GUI();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
