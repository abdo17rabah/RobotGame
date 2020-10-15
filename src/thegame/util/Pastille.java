/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.util;
import java.io.File;


/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour representer une Pastille
public class Pastille extends Elements {

    private int nbr = 3; //Nombre max de pastille possible à afficher sur la grille
    private int time=3; //compte à rebours
    private final static int LIFE_GAIN = 156; //gain à ajouter au niveau de vie d'un robot
    private final File file = new File("src/thegame/Icons/Pastille.png");

    //Constructeur
    public Pastille() {
        super("Pastille"); //Initialiser le type
        this.SetImageIcon(file); //Initialiser l'icon
    }

    public Boolean canPopUp() { //Verifier si une pastille peut etre ajouter à la grille
        return nbr > 0 && time==0;
    }

    public void outTime(){ //compte à rebours
        this.time --;
    }
    
    public void popUp(){  //Test pour indiquer qu'on peut ajouter une pastille sur la grille
        this.time=3;
        this.nbr--;
    }

    
    public int pickUp() { //Appliquer le gain au robot
        this.nbr++;
        return LIFE_GAIN;
    }


}
