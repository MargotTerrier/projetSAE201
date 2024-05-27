package org.uphf.projetsae201.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.uphf.projetsae201.Controller.EventGUI;
import org.uphf.projetsae201.Model.*;

public class GUI extends GUIControl{
    private EventGUI eg;
    private Monde m;
    public GUI(Monde m){
        this.m = m;
    }
    public void setMonde(Monde m){
        this.m=m;
    }
    /* Création de la fenêtre de jeu en mode graphique */
    public void Affiche(EventGUI eg ){
        Group g = new Group();
        VBox r = new VBox();
        Scene scene = new Scene(r, 1440, 811);

        // bouton pour fermer la fenêtre
        Button quit = new Button("Quitter le jeu");
        quit.setFont(new Font(15));

        //bouton pour redémarrer une nouvelle partie
        Button redemarrer = new Button("Redémarrer une partie");
        redemarrer.setFont(new Font(15));

        Label tour = new Label("Tour "+m.getCompteurTour());
        tour.setLayoutY(10);
        tour.layoutXProperty().bind(scene.widthProperty().subtract(tour.prefWidth(-1)).divide(2.1));
        tour.setFont(new Font(30));

        HBox top = new HBox(quit, redemarrer);
        top.setLayoutY(10);
        top.setLayoutX(10);
        top.setSpacing(15);

        GridPane grille = afficherGrille(m);

        HBox jeu = new HBox(grille);
        jeu.setLayoutY(100);
        jeu.setLayoutX(50);


        ObservableList<Informations> dataInfo = FXCollections.observableArrayList();
        TableView<Informations> tableInfo = new TableView();

        VBox commande = new VBox();
        TableColumn<Informations, String> element = new TableColumn<>("Elément");
        element.setCellValueFactory(new PropertyValueFactory<>("element"));
        TableColumn<Informations, Integer> ligne = new TableColumn<>("Ligne");
        ligne.setCellValueFactory(new PropertyValueFactory<>("ligne"));
        TableColumn<Informations, String> colonne = new TableColumn<>("Colonne");
        colonne.setCellValueFactory(new PropertyValueFactory<>("colonne"));
        TableColumn<Informations, String> type = new TableColumn<>("Type minerai");
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<Informations, String> info = new TableColumn<>("Information");
        info.setCellValueFactory(new PropertyValueFactory<>("info"));
        tableInfo.getColumns().addAll(element, ligne, colonne, type, info);
        tableInfo.setMinWidth(600);
        tableInfo.setPrefHeight(400);
        tableInfo.setItems(dataInfo);

        double tableWidth = 600;
        element.setPrefWidth(tableWidth * 0.2);
        ligne.setPrefWidth(tableWidth * 0.15);
        colonne.setPrefWidth(tableWidth * 0.15);
        type.setPrefWidth(tableWidth * 0.2);
        info.setPrefWidth(tableWidth * 0.3);

        commande.getChildren().add(tableInfo);


        Label action = new Label(" Actions ");
        action.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        action.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 1;");

        Button haut = new Button("Haut");
        Button bas = new Button("Bas");
        Button gauche = new Button("Gauche");
        Button droit = new Button("Droit");
        Button extraire = new Button("Extraire");
        Button vider = new Button("Vider");
        haut.setOnMouseClicked(eg);
        bas.setOnMouseClicked(eg);
        gauche.setOnMouseClicked(eg);
        droit.setOnMouseClicked(eg);
        extraire.setOnMouseClicked(eg);
        vider.setOnMouseClicked(eg);

        VBox buttonBox = new VBox(10, haut, bas, gauche, droit, extraire, vider);
        buttonBox.setStyle("-fx-border-color: black; -fx-padding: 10; -fx-alignment: center; -fx-background-color: white;");

        HBox dg = new HBox(gauche, droit);
        dg.setLayoutY(10);
        dg.setSpacing(20);
        dg.setStyle("-fx-alignment: center;");

        VBox direction = new VBox(haut, dg, bas);
        direction.setAlignment(Pos.CENTER);
        direction.setSpacing(20);

        HBox choix = new HBox(10, direction ,extraire, vider);
        choix.setStyle("-fx-padding: 0; -fx-alignment: center;");
        choix.setSpacing(20);

        Text NRobot = new Text("Robot ");
        NRobot.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        NRobot.setFill(Color.WHITE);

        VBox actions = new VBox(10, action, NRobot, choix);
        actions.setAlignment(Pos.CENTER);
        actions.setSpacing(20);

        StackPane root = new StackPane(actions);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");



        // bouton pour fermer la fenêtre
        HBox act = new HBox(root);
        act.setSpacing(30);
        act.setAlignment(Pos.CENTER);

        commande.getChildren().add(act);

        jeu.getChildren().addAll(commande);
        jeu.setSpacing(100);

        g.getChildren().addAll(top, tour, jeu);

        // Image de fond
        Image fond = new Image(getClass().getResourceAsStream("/Images/FondAccueil.png"));
        BackgroundImage backgroundImage = new BackgroundImage(fond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,  100,true,true,true,false));
        Background bg = new Background(backgroundImage);

        r.setBackground(bg);
        r.getChildren().addAll(g);

        // Event des boutons
        quit.setOnMouseClicked(eg);
        redemarrer.setOnMouseClicked(eg);

        //changer l'icone du jeu
        this.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icone.png")));

        this.setTitle("Jeu de la mine");
        this.setScene(scene);
        this.setResizable(false);
        this.show();
    }

    private GridPane afficherGrille(Monde m) {
        GridPane grille = new GridPane();
        grille.setStyle("-fx-background-image: url('" + getClass().getResource("/Images/Terre.png").toExternalForm() + "');");
        grille.setHgap(0);
        grille.setVgap(0);

        Secteur[][] secteurs = m.getLstSecteur();
        ObservableList<Informations> dataInfo = FXCollections.observableArrayList();

        for (int i = 0; i < secteurs.length; i++) {
            for (int j = 0; j < secteurs[i].length; j++) {
                StackPane cell = new StackPane();
                cell.setStyle("-fx-border-color: black; -fx-border-width: 1;"); // Bordures pour chaque cellule
                ImageView imageView = new ImageView();
                imageView.setFitWidth(60);
                imageView.setFitHeight(60);
                if (secteurs[i][j] instanceof PlanDeau) {
                    imageView.setImage(new Image(getClass().getResourceAsStream("/Images/PlanDeau.png")));
                } else if (((Terrain) secteurs[i][j]).getRobot() instanceof Robot) {
                    if ((((Terrain) secteurs[i][j]).getRobot()).getIdRobot()==1) {
                        imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Robot1.png")));
                        Informations.addInfo(dataInfo, secteurs[i][j], i, j);
                    } else if ((((Terrain) secteurs[i][j]).getRobot()).getIdRobot()==2) {
                        imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Robot2.png")));
                    } else if ((((Terrain) secteurs[i][j]).getRobot()).getIdRobot()==3) {
                        imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Robot3.png")));
                        Informations.addInfo(dataInfo, secteurs[i][j], i, j);
                    } else if ((((Terrain) secteurs[i][j]).getRobot()).getIdRobot()==4) {
                        imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Robot4.png")));
                        Informations.addInfo(dataInfo, secteurs[i][j], i, j);
                    } else if ((((Terrain) secteurs[i][j]).getRobot()).getIdRobot()==5) {
                        imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Robot5.png")));
                        Informations.addInfo(dataInfo, secteurs[i][j], i, j);
                    }
                } else if (((Terrain) secteurs[i][j]).getDistrict() instanceof Mine) {
                    imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Mine.png")));
                    Informations.addInfo(dataInfo, secteurs[i][j], i, j);
                } else if (((Terrain) secteurs[i][j]).getDistrict() instanceof Entrepot) {
                    imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Entrepot.png")));
                    Informations.addInfo(dataInfo, secteurs[i][j], i, j);
                }
                cell.getChildren().add(imageView);
                grille.add(cell, j, i);
            }
        }
        return grille;
    }

}
