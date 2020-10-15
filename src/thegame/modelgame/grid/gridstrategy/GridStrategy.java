/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.grid.gridstrategy;

import thegame.modelgame.grid.MainGrid;
import thegame.util.Emplacement;
import thegame.util.Field;

/**
 *
 * @author  Abderrafii RABAH
 */
public abstract class GridStrategy {

    // Une classe abstraite pour initialiser la grille de jeu avec la strategie qui corresponde

    private int numRow; // Nombre de ligne de la grille
    private int numCol; // nombre de Colone de la grille
    protected MainGrid grid; // la grille de jeu à initialiser


    // Constructeur d'initalisation
    public GridStrategy(int row, int col, MainGrid g) {

        this.numCol = col;
        this.numRow = row;
        this.grid = g;
        this.initialiseGrid();
    }

    public abstract void placeRobot(); //Methode de placement des robots dans la grille

    public abstract void placeWall(); // Methode pour placer les murs dans la grille


    // Methode d'initialisation de la grille de jeu donnée et placement de ses elements

    public void initialiseGrid() {

        grid.setColRow(this.numRow, this.numCol); // Initialisation de dimensions de la grille

        Field p = new Field(); // Création d'une surface de jeu

        Emplacement em = new Emplacement(0,0);

        // On parcours la grille par ligne et par colonne et on la remplie par des surface de jeu
        for (int i =0; i <grid.numRow(); i++) {

            for (int j =0; j <grid.numCol(); j++) {

                em.setColRow(i, j);

                grid.setElementAt(em, p);
            }
        }
        this.placeWall(); // On place les murs sur la grille
        this.placeRobot(); // // On place les rebots sur la grille
    }

}
