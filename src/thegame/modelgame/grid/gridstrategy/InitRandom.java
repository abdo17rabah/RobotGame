/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.grid.gridstrategy;

import java.util.Random;
import thegame.modelgame.grid.*;
import thegame.util.*;

/**
 *
 * @author  Abderrafii RABAH
 */

// Classe qui permet d'initialiser les elèments de la grille de jeu d'une façon aléatoire

public class InitRandom extends GridStrategy {

    // Constructeur
    public InitRandom(MainGrid g) {
        super(12, 12, g);
    } // Initialisation des dimensions de la grille

    @Override
    public void placeRobot() { // Méthode pour placer les robots

        Emplacement em = new Emplacement(0, 0); // Création d'une emplacement
        Random r = new Random(); // Création d'un objet Random qui va permettre de construire un emplacement aléatoire pour un rebot

        for (int i = 0; i < this.grid.getRobots().getSize(); i++) { // on parcours la liste des robots

            int l = (int) ((Math.random() * 11)); // on tire aléatoirement le numero de la ligne où poser le robot
            int c = (int) ((Math.random() * 11)); // on tire aléatoirement le numero de la colonne où poser le robot

            em.setColRow(l, c);
            this.grid.getRobots().get(i).setEmplacement(new Emplacement(l, c)); // on initialise l'emplacement du robot

            this.grid.setElementAt(em, this.grid.getRobots().get(i)); // on place le robot sur la grille du jeu

        }
    }

    @Override
    public void placeWall() { // Méthode pour placer les murs sur la grille

        Emplacement em = new Emplacement(0, 0);
        Wall w = new Wall(); // Création d'un objet Wall (mur)

        for (int i = 1; i <= 50; i++) {

            int l = (int) ((Math.random() * 11));  // on tire aléatoirement le numero de la ligne où poser le mur
            int c = (int) ((Math.random() * 11)); // on tire aléatoirement le numero de la colonne où poser le mur
            em.setColRow(l, c); // on initialise l'emplacement du mur
            this.grid.setElementAt(em, w);// on place le mur sur la grille du jeu
        }
    }

}
