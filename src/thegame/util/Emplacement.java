/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.util;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour representer un emplacement sur la grille
public class Emplacement {
    
    private int row ; //Numero de la ligne
    private int col ; //Numero de la colonne

    //Constructeur
    public Emplacement(int row, int col) {
	    this.row = row; //Initialiser le numero de la ligne
	    this.col = col; //Initialiser le numero de la colonne
    }

    public void setColRow(int row,int col) { //Initialiser le numero de la ligne et de la colonne
        this.row = row;
        this.col = col;
    }
    
    public int getRow() { //Recupperer le numero de la ligne
        return row;
    }

    public void setRow(int row) { //Initialiser le numero de la ligne
        this.row = row;
    }

    public int getCol() {  //Recupperer le numero de la colonne
        return col;
    }

    public void setCol(int col) { //Initialiser le numero de la colonne
        this.col = col;
    }
    
}
