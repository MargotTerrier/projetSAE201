package org.uphf.projetsae201;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class Main extends Application {
    @Override public void start(Stage stage){

        Text text = new Text(10,40,"ALED");
        text.setFont(new Font("Arial",20));

    }

}
