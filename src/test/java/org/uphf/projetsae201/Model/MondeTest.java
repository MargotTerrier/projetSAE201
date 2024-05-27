package org.uphf.projetsae201.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MondeTest {

    /*Ici il y a toutes les variables nécessaires aux tests*/
    Monde monde;
    Robot robot;
    Mine mine;
    Entrepot entrepot;
    Terrain terrain;
    Terrain terrain2;
    Robot autreRobot;
    Terrain terrain3;
    Robot robotExtraire;
    Terrain terrain4;

    @BeforeEach
    public void setUp() {
        monde = new Monde(5, 5);
        robot = new Robot(2, 2, Minerai.Or);

        terrain2 = new Terrain();
        monde.getLstSecteur()[1][2] = terrain2; //terrain en haut du robot
        monde.getLstSecteur()[3][2] = terrain2; //terrain en bas
        monde.getLstSecteur()[2][1] = terrain2; //terrain à gauche

        robotExtraire= new Robot(1,3,Minerai.Or);
        mine = new Mine(Minerai.Or);
        terrain4 = new Terrain(mine);
        terrain4.setRobot(robotExtraire);
        monde.getLstSecteur()[1][3] = terrain4; //terrain à droite du robot


        terrain = new Terrain(mine);
        monde.getLstSecteur()[2][2] = terrain;
        terrain.setRobot(robot);

        entrepot = new Entrepot(Minerai.Or);
        monde.getLstSecteur()[2][3] = new Terrain(entrepot); //terrain à droite du robot

        autreRobot = new Robot(3,2,Minerai.Or);
        terrain3 = new Terrain();
        terrain3.setRobot(autreRobot);
        monde.getLstSecteur()[3][2] = terrain3;

    }


    /*TEST METHODE extraire*/
    @Test
    public void testExctractionNormale() {
        /*Ici, le robot a assez de stockage disponible par rapport a sa capacité d'extraction et la mine a assez de minerai par rapport a la capacité d'extraction du robot*/
        robot.setCapaciteStockage(15);
        robot.setCapaciteExtraction(5);
        robot.setnbMineraisExtraits(0);
        mine.setNbMinerais(50);

        monde.extraire(robot, mine);
        Assertions.assertEquals(5, robot.getNbMineraisExtraits(), "Le robot devrait avoir extrait 5 minerais");
        Assertions.assertEquals(45, mine.getNbMinerais(), "Il devrait rester 45 minerais dans la mine");
    }

    @Test
    public void testExtractionLimiteParStockage() {
        /*Ici, le robot n'a pas assez de stockage par rapport a sa capacité d'extraction et la mine a assez de minerai par rapport a la capacité d'extraction du robot*/
        robot.setCapaciteStockage(15);
        robot.setCapaciteExtraction(3);
        robot.setnbMineraisExtraits(13);
        mine.setNbMinerais(50);

        monde.extraire(robot, mine);
        Assertions.assertEquals(15, robot.getNbMineraisExtraits(), "Le robot devrait avoir extrait 5 minerais");
        Assertions.assertEquals(48, mine.getNbMinerais(), "Il devrait rester 95 minerais dans la mine");
    }

    @Test
    public void testExtractionLimiteParMine() {
        /*Ici, le robot a assez de stockage par rapport a sa capacité d'extraction mais la mine n'a pas assez de minerai par rapport a la capacité d'extraction du robot*/

        robot.setCapaciteStockage(15);
        robot.setCapaciteExtraction(3);
        robot.setnbMineraisExtraits(0);
        mine.setNbMinerais(2);

        monde.extraire(robot, mine);
        Assertions.assertEquals(2, robot.getNbMineraisExtraits(), "Le robot devrait avoir extrait 2 minerais");
        Assertions.assertEquals(0, mine.getNbMinerais(), "La mine devrait être vide");
    }

    @Test
    public void testExtractionLimiteParTout() {
        /*Ici, le robot n'a pas assez de stockage par rapport a sa capacité d'extraction et la mine n'a assez de minerai par rapport a la capacité d'extraction du robot*/

        robot.setCapaciteStockage(15);
        robot.setCapaciteExtraction(3);
        robot.setnbMineraisExtraits(14);
        mine.setNbMinerais(2);

        monde.extraire(robot, mine);
        Assertions.assertEquals(15, robot.getNbMineraisExtraits(), "Le robot devrait avoir extrait 1 minerais");
        Assertions.assertEquals(1, mine.getNbMinerais(), "Il devrait rester 1 minerais dans la mine");
    }




    /*TEST METHODE deplacerRobot*/
    @Test
    void testDeplacementHaut() {
        monde.deplacerRobot("Haut", ((Terrain) monde.getLstSecteur()[2][2]));
        assertNull((((Terrain) monde.getLstSecteur()[2][2]).getRobot())); //vérifie que le terrain initial ne contient plus le robot
        assertNotNull((((Terrain) monde.getLstSecteur()[1][2]).getRobot())); //vérifie que le terrain du haut contient maintenant le robot
        Assertions.assertEquals(1, ((Terrain) monde.getLstSecteur()[1][2]).getRobot().getCoordonneesX()); // vérifie les coordonnées du robot
    }

    @Test
    void testDeplacementBasOccupe() {
        monde.deplacerRobot("Bas", ((Terrain) monde.getLstSecteur()[2][2]));
        assertNotNull((((Terrain) monde.getLstSecteur()[2][2]).getRobot())); //vérifie que le terrain initial contient l'autre robot robot
        assertNotNull((((Terrain) monde.getLstSecteur()[3][2]).getRobot())); //vérifie que le terrain du bas contient le robot déplacé (les robots on échangés de place)

        Assertions.assertEquals(3, robot.getCoordonneesX());
        Assertions.assertEquals(2, robot.getCoordonneesY());
        Assertions.assertEquals(2, autreRobot.getCoordonneesX());
        Assertions.assertEquals(2, autreRobot.getCoordonneesY());
    }

    @Test
    void testDeplacementGauche() {
        monde.deplacerRobot("Gauche", ((Terrain) monde.getLstSecteur()[2][2]) );
        assertNull((((Terrain) monde.getLstSecteur()[2][2]).getRobot())); //vérifie que le terrain initial ne contient plus le robot
        assertNotNull((((Terrain) monde.getLstSecteur()[2][1]).getRobot())); //vérifie que le terrain de gauche contient le robot
        Assertions.assertEquals(1, robot.getCoordonneesY()); //on vérifie les coordonnées
    }

    @Test
    void testDeplacementDroite() {
        monde.deplacerRobot("Droit", ((Terrain) monde.getLstSecteur()[2][2]) );
        assertNull((((Terrain) monde.getLstSecteur()[2][2]).getRobot())); //vérifie que le terrain initial ne contient plus le robot
        assertNotNull((((Terrain) monde.getLstSecteur()[2][3]).getRobot())); //vérifie que le terrain de droite contient le robot
        Assertions.assertEquals(3, robot.getCoordonneesY()); //on vérifie les coordonnées
    }

    @Test
    void testDeplacementVider() {
        robot.setCapaciteStockage(15); //on set les paramètres nécessaires au test
        robot.setCapaciteExtraction(3);
        robot.setnbMineraisExtraits(15);
        entrepot.setnbMineraisStockes(0);


        monde.deplacerRobot("Droit", ((Terrain) monde.getLstSecteur()[2][2]));
        monde.deplacerRobot("Vider", ((Terrain) monde.getLstSecteur()[2][3]));

        Assertions.assertEquals(15, entrepot.getnbMineraisStockees(), "L'entrepôt devrait maintenant contenir 15 minerais");
        Assertions.assertEquals(0, robot.getNbMineraisExtraits(), "Le robot devrait avoir 0 minerais après vidage");

    }

    @Test
    void testDeplacementExtraire() {
        robotExtraire.setCapaciteStockage(15); //on set les paramètres nécessaires au test
        robotExtraire.setCapaciteExtraction(3);
        robotExtraire.setnbMineraisExtraits(0);
        mine.setNbMinerais(20);

        monde.deplacerRobot("Extraire", ((Terrain) monde.getLstSecteur()[1][3]));

        Assertions.assertEquals(3, robotExtraire.getNbMineraisExtraits(), "Le robot devrait avoir extrait 3 minerais");
        Assertions.assertEquals(17, mine.getNbMinerais(), "La mine devrait contenir 17 minerais");

    }




    /*TEST METHODE vider*/
    /*Tests additionnels de la méthode vider*/
    @Test
    public void testVider() {
        robot.setnbMineraisExtraits(30);
        entrepot.setnbMineraisStockes(20);
        monde.vider(robot, entrepot);
        Assertions.assertEquals(50, entrepot.getnbMineraisStockees(), "L'entrepôt devrait maintenant contenir 50 minerais");
        Assertions.assertEquals(0, robot.getNbMineraisExtraits(), "Le robot devrait avoir 0 minerais après vidage");
    }


}
