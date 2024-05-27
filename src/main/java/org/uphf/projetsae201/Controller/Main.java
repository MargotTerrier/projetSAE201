package org.uphf.projetsae201.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.View.GUI;
import org.uphf.projetsae201.View.GUIChoix;


public class Main extends Application {

    @Override public void start(Stage stage){
        new GUIChoix();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
