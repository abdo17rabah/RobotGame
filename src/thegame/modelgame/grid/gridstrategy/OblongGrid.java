/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.grid.gridstrategy;

import thegame.Param;
import thegame.modelgame.grid.MainGrid;
import thegame.util.Emplacement;
import thegame.util.Wall;

/**
 *
 * @author  Abderrafii RABAH
 */

// Classe qui permet de créer une grille de jeu sous forme rectangulaire et de placer les murs et les robots d'une façon spécifique

public class OblongGrid extends GridStrategy {

    public OblongGrid(MainGrid g) {
        super(6, 12, g);
    } // Choix des dimensions de la grille de jeu

    @Override
    public void placeRobot() { // Methode qui permet de placer les robots dans des emplacements spécifiques
        
        this.grid.getRobots().get(0).setEmplacement(new Emplacement(1, 1)); // choix d'emplacement pour le 1er robot
        this.grid.setElementAt(new Emplacement(1, 1), this.grid.getRobots().get(0)); // Ajout du robot dans la grille de jeu

        this.grid.getRobots().get(1).setEmplacement(new Emplacement(0, 10)); // choix d'emplacement pour le 2er robot
        this.grid.setElementAt(new Emplacement(0, 10), this.grid.getRobots().get(1)); // Ajout du robot dans la grille de jeu

        this.grid.getRobots().get(2).setEmplacement(new Emplacement(5, 6)); // choix d'emplacement pour le 3er robot
        this.grid.setElementAt(new Emplacement(5, 6), this.grid.getRobots().get(2)); // Ajout du robot dans la grille de jeu

        this.grid.getRobots().get(3).setEmplacement(new Emplacement(5, 2)); // choix d'emplacement pour le 4er robot
        this.grid.setElementAt(new Emplacement(5, 2), this.grid.getRobots().get(3)); // Ajout du robot dans la grille de jeu

    }

    @Override
    public void placeWall() { // Methode qui permet de placer les murs dans des emplacements spécifiques

        Wall W = new Wall();

        Emplacement em1 = new Emplacement(1, 2);
        Emplacement em2 = new Emplacement(4, 0);
        Emplacement em3 = new Emplacement(4, 8);
        Emplacement em4 = new Emplacement(3, 5);
        Emplacement em5 = new Emplacement(2, 11);
        for (int i = 1; i <= 7; i++) {

            this.grid.setElementAt(em1, W);
            em1 = Param.changeEmplacement(em1, Param.HUT_RIGHT());

            if (i <= 3) {

                this.grid.setElementAt(em2, W);
                em2 = Param.changeEmplacement(em2, Param.HUT_RIGHT());
                
                this.grid.setElementAt(em3, W);
                em3 = Param.changeEmplacement(em3, Param.HUT_RIGHT());
                
                this.grid.setElementAt(em4, W);
                em4 = Param.changeEmplacement(em4, Param.HUT_DOWN());
                
                this.grid.setElementAt(em5, W);
                em5 = Param.changeEmplacement(em5, Param.HUT_DOWN());

            }

        }

    }

}
