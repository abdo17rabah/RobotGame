/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.grid;

import java.util.ArrayList;
import java.util.Random;

import thegame.modelgame.robot.*;
import thegame.modelgame.weaponry.*;
import thegame.util.*;

/**
 *
 * @author  Abderrafii RABAH
 */

// Classe qui représente la grille principal du jeu

public class MainGrid implements Grid {

    private int numRow; // représenter le nombre de lignes de la grille
    private int numCol; // représenter le nombre de colonnes de la grille
    private int next = 0; // représenter le robot qui va jouer le tour suivant
    private int currentPlayer; // représenter le robot qui joue actuellement
    private RobotsGroup robots; // La liste des robots
    private RobotsGroup destroyRobots; // la liste des robots qui sont morts
    private Pastille pastille; // Objet pastille qui sera générée au cours du jeu
    private Elements[][] grid; // Grille du jeu

    //Constructeur
    public MainGrid(RobotsGroup robots, Pastille pastille) {

        this.robots = robots; // Initialisation de la liste des robots
        this.pastille = pastille; // Initialisation de la pastille
        this.destroyRobots = new RobotsGroupList(); // Création d'une liste qui va contenir les robots morts
    }

    @Override
    public void afficher() { // Afficher la grille du jeu dans le terminal

        System.out.println();

        for (int i = 0; i < numRow; i++) {

            for (int j = 0; j < numCol; j++) {

                if (grid[i][j] instanceof Robot) {

                    System.out.print(" " + grid[i][j].getType().substring(0,4) + " ");

                } else if (grid[i][j] instanceof Wall) {

                    System.out.print("  ##  ");

                } else if (grid[i][j] instanceof Field) {

                    System.out.print("  ..  ");

                } else if (grid[i][j] instanceof Bombe) {

                    System.out.print("  ++  ");

                } else if (grid[i][j] instanceof Mine) {

                    System.out.print("  @@  ");

                } else if (grid[i][j] instanceof Pastille) {

                    System.out.print(" PAST ");
                }
            }
            System.out.println();
            System.out.println();
        }

        System.out.println();

    }

    @Override
    public Elements elementAt(Emplacement em) { // Methode pour recuppérer un élèment à un certain emplacement

        if (this.inBounds(em)) {
            return grid[em.getRow()][em.getCol()];
        }
        return null;
    }

    @Override
    public void setElementAt(Emplacement em, Elements e) { // Placer un element sur la grille du jeu principal

        if (this.inBounds(em)) {

            grid[em.getRow()][em.getCol()] = e;
        }
    }

    @Override
    public boolean inBounds(Emplacement em) { // Verifier si un emplacement est valide

        return (em.getRow() >= 0 && em.getRow() < this.numRow && em.getCol() >= 0 && em.getCol() < this.numCol);
    }

    public int numRow() {
        return numRow;
    } // Recupperer le nombre de lignes

    public int numCol() {
        return numCol;
    } // Recupperer le nombre de colonnes

    public RobotsGroup getRobots() {
        return robots;
    } // Recupperer la liste des robots

    public void setColRow(int nbrRow, int nbrColm) { // Initialiser les dimensions de la grille du jeu

        this.numRow = nbrRow; // Initialiser le nombre de lignes
        this.numCol = nbrColm; // Initialiser le nombre de colonnes
        this.grid = new Elements[this.numRow][this.numCol]; // Création de la grille
    }

    public void isDestroyed() { //Methode pour vérifier si un Robot est mort

        for (int i = 0; i < this.robots.getSize(); i++) { // on parcours la liste des robots

            if (this.robots.get(i).getNiveauVie() <= 0) { // on vérifier le niveau de vie

                this.setElementAt(this.robots.get(i).getEmplacement(), new Field()); //on remplace l'emplacement du robot mort par une zone de jeu
                this.destroyRobots.add(this.robots.get(i)); // on ajoute le robot dans la liste des robots morts
                this.robots.remove(i); // on retire le robot de la liste des robots entrain de jouer
            }
        }
    }

    public boolean allDestroyed() { // Verifier si on a un gagnant

        return this.robots.getSize() == 1;
    }

    public boolean verifyArming() { // Verifier les munitions d'un robots

        for (int i = 0; i < this.robots.getSize(); i++) {

            if (this.robots.get(i).canPlay()) {

                return true;
                
            }

        }
        return false;
    }

    public Boolean endGame() { // Verifier si une partie est terminée

        return this.allDestroyed() || !this.verifyArming();
    }

    /*
       Method qui va faire les verifications sur les bombes à chaque debut de tour
       et faire apparaitre des pastille au cour du jeu
    */
    public void checkTurn() {

        ArrayList<Emplacement> emplacements = new ArrayList<>(); //Une liste pour récupperer que les zones de jeu

        Random r = new Random(); // Création d'une objet Random qui va servir à placer une pastille aléatoirement sur la grille du jeu

        for (int i = 0; i < numRow; i++) {

            for (int j = 0; j < numCol; j++) {

                if (grid[i][j] instanceof Field ) { //Wall

                    emplacements.add(new Emplacement(i, j));

                } else if (grid[i][j] instanceof Bombe) { // permet de verifie s'il une bombe sur la grille qui va s'explose

                    ((Bombe) grid[i][j]).timeOut();

                }

            }
        }

        if (this.pastille.canPopUp()){ // verification si le nombre max des pastilles qui sont sur la grille n'est pas atteint

            this.pastille.popUp(); //On crée une pastille

            this.setElementAt(emplacements.get(r.nextInt(emplacements.size())), pastille); // on ajoute la pastille sur la grille
            
        }else{
        
            this.pastille.outTime(); //On decrémente le timer d'affichage des pastilles
        }

    }

    public int next() { //Permet de reccupperer le robot qui va jouer le tour suivant

        if (next > this.robots.getSize() - 1) { // Verifier si on arrive au dernier joueur sur la liste des robots qui jouent

            next = 0; // on commence de nouveau avec le premier joueur sur la liste
        }
        currentPlayer=next; // recupperer le joueur actuel
        return next++; // on retourne le robot qui va jouer le tour suivant
    }

    public void nextTurn() { //Permet d'initialiser l'état du tour suivant
        this.checkTurn(); //Verifier s'il y a des bombes à faire exploser ou des pastilles à ajouter sur la grille
        this.isDestroyed(); //Verifier si un robot doit mourir
        this.robots.get(next()).useStrategy(); // initialiser la strategie du jeu du robot qui va jouer le tour suivant
    }

    /**
     * @return the destroyRobots
     */
    public RobotsGroup getDestroyedRobots() {
        return destroyRobots;
    } // Récupperer la liste des robots morts

    public Elements[][] getGrid() {
        return grid;
    } // Recupperer la grille du jeu

    public int getCurrentPlayer() {
        return currentPlayer;
    } // Récupperer le joueur actuel
}
