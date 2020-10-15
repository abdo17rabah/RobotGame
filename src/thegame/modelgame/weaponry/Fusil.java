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

//Classe pour représenter un fusil selon le type de robot
public class Fusil extends ShootGun{

    //Constructeur
    public Fusil(int range, int damage, int mint){
    
        this.setTypeArme("Fusil"); //Initialisation du type d'arme
        this.setRange(range); //initialisier de l'intervalle de tire
        this.setImpact(damage); //initialiser l'impact du fusil
        this.setMunition(mint); //initialiser le magasine du fusil
    }
    
}
