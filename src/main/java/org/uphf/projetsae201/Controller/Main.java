package org.uphf.projetsae201.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.uphf.projetsae201.View.GUI;


public class Main extends Application {

    @Override public void start(Stage stage){

        new GUI();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
