package thegame.modelgame.weaponry;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour représenter une metraillette selon le type de robot
public class Mitraillette extends ShootGun {

    //Constructeur
    public Mitraillette(int range, int damage, int mint){
        
        this.setTypeArme("Mitraillette"); //Initialisation du type d'arme
        this.setRange(range); //initialisier de l'intervalle de tire
        this.setImpact(damage); //initialiser l'impact du fusil
        this.setMunition(mint); //initialiser le magasine du fusil
        
    }
    
}
