package org.uphf.projetsae201.Controller;

import javafx.application.Application;
import javafx.stage.Stage;
import org.uphf.projetsae201.Model.Monde;
import org.uphf.projetsae201.Model.PlanDeau;
import org.uphf.projetsae201.Model.Robot;
import org.uphf.projetsae201.Model.Terrain;
import org.uphf.projetsae201.View.AffichageConsole;
import org.uphf.projetsae201.View.GUI;


public class Main extends Application {

    @Override public void start(Stage stage){
        Monde m = new Monde(5,0,5,5);



        Robot r=new Robot(3,3);
        ((Terrain) m.getLstSecteur()[3][3]).setRobot(r);
        (m.getLstSecteur()[4][3]) = new PlanDeau();
        new AffichageConsole(m);
//        System.out.println(m.getLstSecteur()[4][3]instanceof PlanDeau);
//        System.out.println(r.EstPasDansLeMonde(4,3,m));
//        System.out.println(r.estPlanEau(4,3,m));

//        m.deplacerRobot("Droit",(Terrain) m.getLstSecteur()[3][3]);
//        System.out.println("ok");
//        m.deplacerRobot("Haut",(Terrain) m.getLstSecteur()[3][4]);
//        System.out.println("ok");
//        m.deplacerRobot("Gauche",(Terrain) m.getLstSecteur()[2][4]);
//        System.out.println("ok");
//        m.deplacerRobot("Bas",(Terrain) m.getLstSecteur()[2][3]);
//        System.out.println("ok");
//        m.deplacerRobot("Gauche",(Terrain) m.getLstSecteur()[3][3]);
//        System.out.println("ok");

        new AffichageConsole(m);
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
