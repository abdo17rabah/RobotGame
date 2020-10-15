/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.grid;

import thegame.modelgame.robot.*;
import thegame.modelgame.weaponry.*;
import thegame.util.*;
import thegame.util.Field;
import thegameobserver.AbstractListenableModel;

/**
 *
 * @author  Abderrafii RABAH
 */

// Classe qui represente la grille de jeu pour chaque robot

public class GridProxy extends AbstractListenableModel implements Grid {

    private Robot robot; // Le robot pour lequel appartient la grille
    private MainGrid grid; // la grille du Jeu
    private Emplacement em;

    //Constructeur
    public GridProxy(MainGrid gille, Robot robot) {

        this.grid = gille; // Initilaisation de la grille
        this.robot = robot; // Initilaisation du robot
        this.em = new Emplacement(0, 0); // Création d'une objet Emplacement
    }

    @Override
    public Elements elementAt(Emplacement em) { // Methode pour recuppérer un élèment à un certain emplacement

        Elements e = this.grid.elementAt(em);

        // Faire un teste pour l'objet Mine pour savoir si la mine au robot
        if (e instanceof Mine) {

            if (!((Mine) e).getPoseur().equals(this.robot)) { // si le test échou on envoi un objet Field ()

                return new Field();
            }

        }

        return e;
    }

    @Override
    public void setElementAt(Emplacement e, Elements o) { // Placer un element sur la grille du jeu principal

        grid.setElementAt(e, o);
    }

    @Override
    public void afficher() { // Afficher  la grille propre au robot sur le terminal

        for (int i = 0; i < this.grid.numRow(); i++) {

            for (int j = 0; j < this.grid.numCol(); j++) {

                em.setColRow(i, j);

                if (this.elementAt(em) instanceof Robot) {

                    System.out.print(" " + this.elementAt(em).getType().substring(0,3) + " ");

                } else if (this.elementAt(em) instanceof Wall) {

                    System.out.print("  ##  ");

                } else if (this.elementAt(em) instanceof Field) {

                    System.out.print("  ..  ");

                } else if (this.elementAt(em) instanceof Bombe) {

                    System.out.print("  ++  ");

                } else if (this.elementAt(em) instanceof Mine) {

                    System.out.print("  @@  ");

                } else if (this.elementAt(em) instanceof Pastille) {

                    System.out.print(" PAST ");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public int numRow() { // récupperer le nombre de ligne de la grille
        return grid.numRow();
    }

    @Override
    public int numCol() { // récupperer le nombre de colonne de la grille
        return grid.numRow();
    }

    @Override
    public boolean inBounds(Emplacement em) { // Vérifier si un emplacement est valide
        return this.grid.inBounds(em);
    }

    public Robot getRobot() { // Récupperer le robot correspondant à la cette grille
        return robot;
    }
}
