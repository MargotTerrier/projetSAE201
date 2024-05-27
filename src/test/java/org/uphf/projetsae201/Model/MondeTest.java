package org.uphf.projetsae201.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uphf.projetsae201.Model.*;


class MondeTest {

    private Monde monde;
    private Robot robot;
    private Mine mine;
    private Entrepot entrepot;

    @BeforeEach
    public void setUp() {
        monde = new Monde(5, 5);
        robot = new Robot(2, 2, Minerai.Or); // Coordonnées initiales et type de minerai
        mine = new Mine(Minerai.Or); // Minerai initial et quantité
        entrepot = new Entrepot();
        monde.getLstSecteur()[2][2] = new Terrain(mine);
        monde.getLstSecteur()[2][3] = new Terrain(entrepot);

    }



    /*TEST METHODE extraire*/
    @Test
    public void testExtractionMaxCapacity() {
        robot.setCapaciteStockage(15);
        robot.setCapaciteExtraction(5);
        robot.setnbMineraisExtraits(0);
        mine.setNbMinerais(50);

        monde.extraire(robot, mine);
        assertEquals("Le robot devrait avoir extrait 5 minerais", 5, robot.getNbMineraisExtraits());
        assertEquals("Il devrait rester 45 minerais dans la mine", 45, mine.getNbMinerais());
    }

    @Test
    public void testExtractionLimitedByStorage() {
        robot.setCapaciteStockage(15);
        robot.setCapaciteExtraction(3);
        robot.setnbMineraisExtraits(13);
        mine.setNbMinerais(50);

        monde.extraire(robot, mine);
        assertEquals("Le robot devrait avoir extrait 5 minerais", 15, robot.getNbMineraisExtraits());
        assertEquals("Il devrait rester 95 minerais dans la mine", 48, mine.getNbMinerais());
    }

    @Test
    public void testExtractionLimitedByMine() {
        robot.setCapaciteStockage(15);
        robot.setCapaciteExtraction(3);
        robot.setnbMineraisExtraits(0);
        mine.setNbMinerais(2);

        monde.extraire(robot, mine);
        assertEquals("Le robot devrait avoir extrait 2 minerais", 2, robot.getNbMineraisExtraits());
        assertEquals("La mine devrait être vide", 0, mine.getNbMinerais());
    }

    @Test
    public void testExtractionLimitedByBoth() {
        robot.setCapaciteStockage(15);
        robot.setCapaciteExtraction(3);
        robot.setnbMineraisExtraits(14);
        mine.setNbMinerais(2);

        monde.extraire(robot, mine);
        assertEquals("Le robot devrait avoir extrait 1 minerais", 15, robot.getNbMineraisExtraits());
        assertEquals("Il devrait rester 1 minerais dans la mine", 1, mine.getNbMinerais());
    }


    /*TEST METHODE vider*/
    @Test
    public void testVider() {
        robot.setnbMineraisExtraits(30); // Supposons que le robot a extrait 30 unités de minerai
        entrepot.setnbMineraisStockes(20); // Supposons que l'entrepôt contient déjà 20 unités de minerai
        monde.vider(robot, entrepot);
        assertEquals("L'entrepôt devrait maintenant contenir 50 minerais", 50, entrepot.getnbMineraisStockees());
        assertEquals("Le robot devrait avoir 0 minerais après vidage", 0, robot.getNbMineraisExtraits());
    }


}
