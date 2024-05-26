package org.uphf.projetsae201.test;

import org.junit.jupiter.api.BeforeAll;
import org.uphf.projetsae201.Model.*;
import org.uphf.projetsae201.Controller.*;
import org.uphf.projetsae201.View.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


public class TestRobot {

    private Monde monde;
    private Robot robot;


    @BeforeEach
    public void setUp() {
        monde = new Monde(5,5); // Créer un monde de taille 5x5
        monde.getLstSecteur()[2][1] = new PlanDeau();
        monde.getLstSecteur()[2][4] = new Terrain(new Mine());
        monde.getLstSecteur()[0][4] = new Terrain(new Entrepot());
        robot = new Robot(2, 2, Minerai.Nickel); // Position initiale du robot au centre du monde

    }



    /*TEST METHODE verifDeplacement*/
    @Test
    public void testDeplacementHautSecteurValide() {
        assertTrue("Le robot devrait pouvoir se déplacer vers le haut", robot.verifDeplacement(monde, "Haut"));
    }

    @Test
    public void testDeplacementBasLimiteMonde() {
        robot.setCoordonneesX(4); // Déplacer le robot à la limite basse
        assertFalse("Le robot ne devrait pas pouvoir se déplacer vers le bas", robot.verifDeplacement(monde, "Bas"));
    }

    @Test
    public void testDeplacementGauchePlanEau() {
        assertFalse("Le robot ne devrait pas pouvoir se déplacer vers la gauche", robot.verifDeplacement(monde, "Gauche"));
    }

    @Test
    public void testDeplacementDroitSecteurValide() {
        assertTrue("Le robot devrait pouvoir se déplacer vers la droite", robot.verifDeplacement(monde, "Droit"));
    }

    @Test
    public void testExtraireMine() {
        robot.setCoordonneesX(2); // Placer le robot sur une mine
        robot.setCoordonneesY(4);
        assertTrue("Le robot devrait pouvoir extraire", robot.verifDeplacement(monde, "Extraire"));
    }

    @Test
    public void testExtraireNonMine() {
        assertFalse("Le robot ne devrait pas pouvoir extraire", robot.verifDeplacement(monde, "Extraire"));
    }

    @Test
    public void testViderEntrepot() {
        robot.setCoordonneesX(0); // Placer le robot sur un entrepôt
        robot.setCoordonneesY(4);
        assertTrue("Le robot devrait pouvoir vider", robot.verifDeplacement(monde, "Vider"));
    }

    @Test
    public void testViderNonEntrepot() {
        assertFalse("Le robot ne devrait pas pouvoir vider", robot.verifDeplacement(monde, "Vider"));
    }



    /*TEST METHODE estPlanEau*/
    @Test
    public void testEstPlanEauTrue() {
        assertTrue("Doit retourner true pour un PlanDeau", robot.estPlanEau(2, 1, monde));
    }

    @Test
    public void testEstPlanEauFalse() {
        assertFalse("Doit retourner false pour un secteur non-PlanDeau", robot.estPlanEau(1, 1, monde));
    }

    @Test
    public void testEstPlanEauHorsLimites() {
        assertFalse("Devrait retourner false pour des indices hors limites", robot.estPlanEau(5, 5, monde));
    }



    /*TEST METHODE EstPasDansLeMonde*/
    @Test
    public void testXNegatif() {
        assertTrue("Robot devrait être hors du monde", robot.EstPasDansLeMonde(-1, 5, monde));
    }

    @Test
    public void testXHorsLimites() {
        assertTrue("Robot devrait être hors du monde", robot.EstPasDansLeMonde(10, 5, monde));
    }

    @Test
    public void testYNegatif() {
        assertTrue("Robot devrait être hors du monde", robot.EstPasDansLeMonde(5, -1, monde));
    }

    @Test
    public void testYHorsLimites() {
        assertTrue("Robot devrait être hors du monde", robot.EstPasDansLeMonde(5, 10, monde));
    }

    @Test
    public void testDansLeMonde() {
        assertFalse("Robot devrait être dans le monde", robot.EstPasDansLeMonde(2, 2, monde));
    }



    /*TEST METHODE extraire*/

    /*TEST METHODE vider*/




}








