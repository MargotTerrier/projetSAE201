package org.uphf.projetsae201;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.Model.PlanDeau;
import org.uphf.projetsae201.Model.Secteur;
import org.uphf.projetsae201.View.AffichageConsole;


public class Main extends Application {

    @Override public void start(Stage stage){

        Monde m = new Monde(5,5,5,5);
        System.out.println(m);
        Secteur a= new PlanDeau();
        System.out.println(a);
        new AffichageConsole(m);



        Text text = new Text(10,40,"PAS D'ERREUR");
        text.setFont(new Font("Arial",20));
        Scene scene = new Scene(new Group(text));
        stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlXw-Np3cMZ4kj518EfxS3uKmiZ6Wx6tbHvJ2CJRBVxA&s"));
        stage.setTitle("Jeu de la mine");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
