/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.weaponry;

import java.io.File;
import thegame.modelgame.grid.MainGrid;
import thegame.util.Field;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour représenter une bombe
public class Bombe extends Explosif {

    private int timer; //Compte à rebours
    private static final File file = new File("src/thegame/Icons/Bombe.png"); //emplacement de l'icon

    //Construvteur
    public Bombe(MainGrid grid) {
        super("Bombe", grid, 108,4); //Initialisation des caractéristiques de la bombe
        this.timer = 3; //initalisation du timer
        this.SetImageIcon(file); //initialisation de l'icon

    }

    //Methode qui permet de verifier si le compte à rebours est atteint
    public void timeOut() {

        if (this.timer == 0) { //on verifie si le compte à rebours est atteint

            this.exploser(); //On fait exploser la bombe
            
            this.getGrid().setElementAt(localisation, new Field()); //on remplace son emplacement par une zone de jeu

            this.timer = 4; // on initialise le compte à rebours

        } else {// sinon on décremente le compte à rebours

            timer--;
        }
    }

}
