/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.weaponry;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe qui represente un bouclier
public class Shield {
    
    private int numberShield; //le nombre de boucliers pour un robot
    
    private boolean put; //pour representer si un bouclier est posé

    //Constructeur
    public Shield(){
        this.numberShield=4; //initialiser le nombre de bouclier
        this.put=false;
    }
    
    
    //Verifier si un robot peut utiliser un bouclier
    public boolean canUse(){
        return (this.numberShield!=0) && !put ;
    }
    
    //Pour poser un bouclier
    public void used(){
        this.numberShield--;
        this.put=true;
    }

    //Pour retirer un bouclier
    public void takeof(){
        this.put=false;
    }

    //Verfier si un robot peut être proteger avec son bouclier
    public boolean beProtect(){
        return put;
    }
    
    
}
