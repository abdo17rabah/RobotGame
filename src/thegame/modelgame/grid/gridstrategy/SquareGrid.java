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

// Classe qui permet de créer une grille de jeu sous forme carrée et de placer les murs et les robots d'une façon spécifique
public class SquareGrid extends GridStrategy {

    public SquareGrid(MainGrid g) {
        super(12, 12, g);
    } //Initialisation des dimensions de la grille

    @Override
    public void placeRobot() { // Methode qui permet de placer les robots dans les coins de la grille


        this.grid.getRobots().get(0).setEmplacement(new Emplacement(1, 1)); // choix d'emplacement pour le 1e robot
        this.grid.setElementAt(new Emplacement(1, 1), this.grid.getRobots().get(0)); // Ajout du robot dans la grille de jeu

        this.grid.getRobots().get(1).setEmplacement(new Emplacement(1, 10)); // choix d'emplacement pour le 2e robot
        this.grid.setElementAt(new Emplacement(1, 10), this.grid.getRobots().get(1)); // Ajout du robot dans la grille de jeu

        this.grid.getRobots().get(2).setEmplacement(new Emplacement(10, 1)); // choix d'emplacement pour le 3e robot
        this.grid.setElementAt(new Emplacement(10, 1), this.grid.getRobots().get(2)); // Ajout du robot dans la grille de jeu

        this.grid.getRobots().get(3).setEmplacement(new Emplacement(10, 10)); // choix d'emplacement pour 4e  robot
        this.grid.setElementAt(new Emplacement(10, 10), this.grid.getRobots().get(3)); // Ajout du robot dans la grille de jeu

    }

    @Override
    public void placeWall() { // Methode qui permet de placer les murs dans le contour de la grille

        Wall W = new Wall();

        Emplacement em1 = new Emplacement(0, 0);
        Emplacement em2 = new Emplacement(1, 0);
        Emplacement em3 = new Emplacement(11, 1);
        Emplacement em4 = new Emplacement(11, 11);
        Emplacement em5 = new Emplacement(6, 3);
        Emplacement em6 = new Emplacement(4, 6);
        Emplacement em7 = new Emplacement(4, 8);

        this.grid.setElementAt(new Emplacement(3, 3), W);
        this.grid.setElementAt(new Emplacement(9, 3), W);

        for (int i = 1; i <= 12; i++) {

            this.grid.setElementAt(em1, W);
            em1 = Param.changeEmplacement(em1, Param.HUT_RIGHT());

            if (i <= 11) {

                this.grid.setElementAt(em2, W);
                em2 = Param.changeEmplacement(em2, Param.HUT_DOWN());

                this.grid.setElementAt(em4, W);
                em4 = Param.changeEmplacement(em4, Param.HUT_UP());

            }

            if (i <= 10) {

                this.grid.setElementAt(em3, W);
                em3 = Param.changeEmplacement(em3, Param.HUT_RIGHT());
            }

            if (i <= 2) {

                this.grid.setElementAt(em7, W);
                em7 = Param.changeEmplacement(em7, Param.HUT_LEFT());
            }

            if (i <= 6) {

                this.grid.setElementAt(em6, W);
                em6 = Param.changeEmplacement(em6, Param.HUT_DOWN());
            }

            if (i <= 3) {

                this.grid.setElementAt(em5, W);
                em5 = Param.changeEmplacement(em5, Param.HUT_RIGHT());
            }

        }
    }

}
