package org.uphf.projetsae201.View;

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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.uphf.projetsae201.Controller.EventGUI;
import org.uphf.projetsae201.Controller.VConsole;
import org.uphf.projetsae201.Model.*;

public class GUI extends Stage{


    /* Création de la fenêtre d'acceuil */
    public GUI(){

        Group root = new Group();

        // bouton pour commencer une partie
        Button commencer = new Button("Commencer une partie");
        commencer.setFont(new Font(15));

        // bouton pour fermer la fenêtre
        Button quitter = new Button("Quitter");
        quitter.setFont(new Font(15));

        // Titre du jeu
        Text text = new Text("Jeu de la mine");
        text.setStrokeWidth(2);
        text.setStroke(Color.WHITE);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        VBox box = new VBox(text, commencer, quitter);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        // Image de fond
        Image fond = new Image(getClass().getResourceAsStream("/Images/FondAccueil.png"));
        BackgroundImage backgroundImage = new BackgroundImage(fond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,  100,true,true,true,false));
        Background bg = new Background(backgroundImage);

        Scene scene = new Scene(box, 570,   320);
        box.setBackground(bg);
        box.getChildren().addAll(root);

        // changer l'icone du jeu
        this.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icone.png")));

        this.setTitle("Accueil");
        this.setScene(scene);
        this.setResizable(false);
        this.show();

        // Event des boutons
        commencer.setOnMouseClicked(new EventGUI(this));
        quitter.setOnMouseClicked(new EventGUI(this));

    }


    /* Création de la fenêtre du choix de mode d'affichage */
    public void gui(){
        Group gui = new Group();

        // bouton pour lancer le jeu en mode console
        Button console = new Button("Console");
        console.setFont(new Font(15));

        //  pour lancer le jeu en mode graphique
        Button graphique = new Button("Graphique");
        graphique.setFont(new Font(15));

        // bouton pour fermer la fenêtre
        Button quitter2 = new Button("Quitter");
        quitter2.setFont(new Font(15));

        Text text = new Text("Choisissez le mode d'affichage :");
        text.setStrokeWidth(2);
        text.setStroke(Color.WHITE);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        VBox box = new VBox(text, console, graphique, quitter2);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);

        // Image de fond
        Image fond = new Image(getClass().getResourceAsStream("/Images/FondAccueil.png"));
        BackgroundImage backgroundImage = new BackgroundImage(fond, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,  100,true,true,true,false));
        Background bg = new Background(backgroundImage);

        Scene scene = new Scene(box, 570,   320);
        box.setBackground(bg);
        box.getChildren().addAll(gui);

        // changer l'icone du jeu
        this.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icone.png")));

        this.setTitle("Choix du mode");
        this.setScene(scene);
        this.setResizable(false);
        this.show();

        // Event des boutons
        graphique.setOnMouseClicked(new EventGUI(this));
        console.setOnMouseClicked(new EventGUI(this));
        quitter2.setOnMouseClicked(new EventGUI(this));
    }


    /* Création de la fenêtre de jeu en mode graphique */
    public void monde(Monde m){
        Group g = new Group();
        Scene scene = new Scene(g, 1440, 811);

        // bouton pour fermer la fenêtre
        Button quit = new Button("Quitter le jeu");
        quit.setFont(new Font(15));

        //bouton pour redémarrer une nouvelle partie
        Button redemarrer = new Button("Redémarrer une partie");
        redemarrer.setFont(new Font(15));

        Label tour = new Label("Tour ");
        tour.setLayoutY(10);
        tour.layoutXProperty().bind(scene.widthProperty().subtract(tour.prefWidth(-1)).divide(2.1));
        tour.setFont(new Font(30));

        HBox top = new HBox(quit, redemarrer);
        top.setLayoutY(10);
        top.setLayoutX(10);
        top.setSpacing(15);

        GridPane grille = new GridPane(m.getLongueurMonde(),m.getLargeurMonde());
        grille.setStyle("-fx-background-image: url('" + getClass().getResource("/Images/Terre.png").toExternalForm() + "');");
        grille.setHgap(0);
        grille.setVgap(0);


        Secteur[][] secteurs = m.getLstSecteur();
        for (int i = 0; i < secteurs.length; i++) {
            for (int j = 0; j < secteurs[i].length; j++) {
                StackPane cell = new StackPane();
                cell.setStyle("-fx-border-color: black; -fx-border-width: 1;"); // Bordures pour chaque cellule
                ImageView imageView = new ImageView();
                imageView.setFitHeight(60);
                imageView.setFitWidth(60);
                if (secteurs[i][j] instanceof PlanDeau) {
                    imageView.setImage(new Image(getClass().getResourceAsStream("/Images/PlanDeau.png")));
                }
                else if (((Terrain) secteurs[i][j]).getDistrict() instanceof Mine) {
                    imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Mine.png")));
                    addInfo(secteurs[i][j], i, j);
                }
                else if (((Terrain) secteurs[i][j]).getDistrict() instanceof Entrepot) {
                    imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Entrepot.png")));
                    addInfo(secteurs[i][j], i, j);
                }
                else if (((Terrain) secteurs[i][j]).getRobot() instanceof Robot) {
                    imageView.setImage(new Image(getClass().getResourceAsStream("/Images/Robot.png")));
                    addInfo(secteurs[i][j], i, j);
                }
                cell.getChildren().add(imageView);
                grille.add(cell, j, i);


            }
        }
        grille.setMaxHeight(GridPane.USE_PREF_SIZE);

        HBox jeu = new HBox(grille);
        jeu.setLayoutY(100);
        jeu.setLayoutX(50);

        TableView<Monde> tableInfo = new TableView();

        VBox commande = new VBox();
        TableColumn<Monde, String> element = new TableColumn<>("Elément");
        element.setCellValueFactory(new PropertyValueFactory<>("element"));
        TableColumn<Monde, Integer> ligne = new TableColumn<>("Ligne");
        ligne.setCellValueFactory(new PropertyValueFactory<>("ligne"));
        TableColumn<Monde, String> colonne = new TableColumn<>("Colonne");
        colonne.setCellValueFactory(new PropertyValueFactory<>("colonne"));
        TableColumn<Monde, String> type = new TableColumn<>("Type minerai");
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<Monde, String> info = new TableColumn<>("Information");
        info.setCellValueFactory(new PropertyValueFactory<>("info"));
        tableInfo.getColumns().addAll(element, ligne, colonne, type, info);
        tableInfo.setMinWidth(600);
        commande.getChildren().add(tableInfo);


        Label action = new Label("Actions");
        action.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        ComboBox<String> robotComboBox = new ComboBox<>();
        robotComboBox.getItems().addAll("Robot 1", "Robot 2", "Robot 3");
        robotComboBox.setPromptText("Choisir un robot");

        Button moveButton = new Button("Se déplacer");
        Button extractButton = new Button("Extraire des minerais");
        Button unloadButton = new Button("Décharger des minerais");

        VBox buttonBox = new VBox(10, moveButton, extractButton, unloadButton);
        buttonBox.setStyle("-fx-border-color: black; -fx-padding: 10; -fx-alignment: center; -fx-background-color: white;");

        VBox choix = new VBox(10, robotComboBox, buttonBox);
        choix.setStyle("-fx-padding: 0; -fx-alignment: center;");

        VBox actions = new VBox(10, action, choix);
        actions.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(actions);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        TableView<Monde> tableStatus = new TableView();

        TableColumn<Monde, String> nameCol = new TableColumn<>("N° robot");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Monde, String> statusCol = new TableColumn<>("Status de l'action");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableStatus.getColumns().addAll(nameCol, statusCol);

        tableStatus.setPrefHeight(200);

        Label statuslabel = new Label("Status des robots");
        statuslabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        // bouton pour fermer la fenêtre
        Button valider = new Button("Valider le tour");
        valider.setFont(new Font(15));

        VBox statusBox = new VBox(statuslabel, tableStatus, valider);

        statusBox.setAlignment(Pos.CENTER);
        statusBox.setSpacing(10);

        HBox act = new HBox(root, statusBox);
        act.setSpacing(30);
        act.setAlignment(Pos.CENTER);

        commande.getChildren().add(act);

        jeu.getChildren().addAll(commande);
        jeu.setSpacing(100);

        g.getChildren().addAll(top, tour, jeu);

        //changer l'icone du jeu
        this.getIcons().add(new Image(getClass().getResourceAsStream("/Images/Icone.png")));

        this.setTitle("Jeu de la mine");
        scene.setFill(Color.PEACHPUFF);
        this.setScene(scene);
        this.setResizable(false);
        this.show();

        // Event des boutons
        quit.setOnMouseClicked(new EventGUI(this));
        redemarrer.setOnMouseClicked(new EventGUI(this));

    }


    /* Création de la fenêtre de jeu en mode console */
    public void mondeconsole(Monde m){
        new VConsole();
    }


    private void addInfo(Secteur secteur, int posX, int posY) {
        if (secteur instanceof Terrain) {
            Terrain terrain = (Terrain) secteur;
            String type = "";
            String mineraiType = "";
            String info = "";

            if (terrain.getDistrict() instanceof Mine) {
                Mine mine = (Mine) terrain.getDistrict();
                type = "Mine";
                mineraiType = mine.getTypeMinerai().toString();
                info = "Minerai restant: " + mine.getNbMinerais();
            } else if (terrain.getDistrict() instanceof Entrepot) {
                Entrepot entrepot = (Entrepot) terrain.getDistrict();
                type = "Entrepôt";
                mineraiType = "-";
                info = "Capacité: " + entrepot.getnbMineraisStockees();
            } else if (terrain.getRobot() instanceof Robot) {
                Robot robot = terrain.getRobot();
                type = "Robot";
                mineraiType = "-";
                info = "Position: " + robot.getCoordonneesX() + ", " + robot.getCoordonneesY();
            }
        }
    }

}
