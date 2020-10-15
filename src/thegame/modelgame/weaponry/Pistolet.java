package thegame.modelgame.weaponry;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour représenter un pistolet
public class Pistolet extends ShootGun {

    //Constructeur
    public Pistolet(){
        this.setTypeArme("Pistolet"); //Initialisation du type d'arme
        this.setImpact(48); //initialisier de l'intervalle de tire
        this.setRange(3); //initialiser l'impact du fusil
        this.setMunition(12); //initialiser le magasine du fusil
 
    }
    
}
