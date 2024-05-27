package org.uphf.projetsae201.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.uphf.projetsae201.View.GUIAcceuil;

public class Main extends Application {

    @Override public void start(Stage stage){
        new GUIAcceuil();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
