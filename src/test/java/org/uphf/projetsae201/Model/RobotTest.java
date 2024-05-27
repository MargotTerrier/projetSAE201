package org.uphf.projetsae201.Model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RobotTest {

    private Monde monde;
    private Robot robot;
    Terrain terrain;
    Terrain terrain2;
    Terrain terrain3;
    Robot robot2;
    Robot robot3;
    Mine mine;
    Entrepot entrepot;


    @BeforeEach
    public void setUp() {
        monde = new Monde(5,5); // Créer un monde de taille 5x5

        robot = new Robot(2, 2, Minerai.Nickel); // Position initiale du robot au centre du monde
        terrain = new Terrain(new Mine());
        terrain.setRobot(robot);
        monde.getLstSecteur()[2][2] = terrain;

        mine = new Mine(Minerai.Nickel);
        entrepot = new Entrepot(Minerai.Nickel);

        robot2 = new Robot(2,4,Minerai.Nickel);
        terrain2 = new Terrain(mine);
        terrain2.setRobot(robot2);

        robot3 = new Robot(0,4,Minerai.Nickel);
        terrain3 = new Terrain(entrepot);
        terrain3.setRobot(robot3);

        monde.getLstSecteur()[2][1] = new PlanDeau();
        monde.getLstSecteur()[2][4] = terrain2;
        monde.getLstSecteur()[0][4] = terrain3;

    }



    /*TEST METHODE verifDeplacement*/
    @Test
    public void testDeplacementHautSecteurValide() {
        Assertions.assertTrue(robot.verifDeplacement(monde, "Haut"), "Le robot devrait pouvoir se déplacer vers le haut");
    }

    @Test
    public void testDeplacementBasLimiteMonde() {
        robot.setCoordonneesX(4); // Déplacer le robot à la limite basse
        Assertions.assertFalse(robot.verifDeplacement(monde, "Bas"), "Le robot ne devrait pas pouvoir se déplacer vers le bas");
    }

    @Test
    public void testDeplacementGauchePlanEau() {
        Assertions.assertFalse(robot.verifDeplacement(monde, "Gauche"), "Le robot ne devrait pas pouvoir se déplacer vers la gauche");
    }

    @Test
    public void testDeplacementDroitSecteurValide() {
        Assertions.assertTrue(robot.verifDeplacement(monde, "Droit"), "Le robot devrait pouvoir se déplacer vers la droite");
    }

    @Test
    public void testExtraireMine() {
        Assertions.assertTrue(robot2.verifDeplacement(monde, "Extraire"), "Le robot devrait pouvoir extraire");
    }

    @Test
    public void testExtraireNonMine() {
        Assertions.assertFalse(robot.verifDeplacement(monde, "Extraire"), "Le robot ne devrait pas pouvoir extraire");
    }

    @Test
    public void testViderEntrepot() {
        Assertions.assertTrue(robot3.verifDeplacement(monde, "Vider"), "Le robot devrait pouvoir vider");
    }

    @Test
    public void testViderNonEntrepot() {
        Assertions.assertFalse(robot.verifDeplacement(monde, "Vider"), "Le robot ne devrait pas pouvoir vider");
    }



    /*TEST METHODE estPlanEau*/
    @Test
    public void testEstPlanEauTrue() {
        Assertions.assertTrue(robot.estPlanEau(2, 1, monde), "Doit retourner true pour un PlanDeau");
    }

    @Test
    public void testEstPlanEauFalse() {
        Assertions.assertFalse(robot.estPlanEau(1, 1, monde), "Doit retourner false pour un secteur non-PlanDeau");
    }

    @Test
    public void testEstPlanEauHorsLimites() {
        Assertions.assertFalse(robot.estPlanEau(5, 5, monde), "Devrait retourner false pour des indices hors limites");
    }



    /*TEST METHODE EstPasDansLeMonde*/
    @Test
    public void testXNegatif() {
        Assertions.assertTrue(robot.EstPasDansLeMonde(-1, 5, monde), "Robot devrait être hors du monde");
    }

    @Test
    public void testXHorsLimites() {
        Assertions.assertTrue(robot.EstPasDansLeMonde(10, 5, monde), "Robot devrait être hors du monde");
    }

    @Test
    public void testYNegatif() {
        Assertions.assertTrue(robot.EstPasDansLeMonde(5, -1, monde), "Robot devrait être hors du monde");
    }

    @Test
    public void testYHorsLimites() {
        Assertions.assertTrue(robot.EstPasDansLeMonde(5, 10, monde), "Robot devrait être hors du monde");
    }

    @Test
    public void testDansLeMonde() {
        Assertions.assertFalse(robot.EstPasDansLeMonde(2, 2, monde), "Robot devrait être dans le monde");
    }


}








