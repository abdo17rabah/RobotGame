package thegame.modelgame.weaponry;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe abstraite pour representer une arme à feu
public abstract class ShootGun {

    private String typeArme;//Type d'arme
    
    private int impact;//impact d'arme
    
    private int range; // intervalle de tire
    
    private int munitions; //magasine de l'arme

    public String getTypeArme(){
        
        return typeArme;//recuperer le type d'arme
    }

    public void setTypeArme(String typeArme){
        
        this.typeArme = typeArme; //initialiser le type d'arme
    }

    public void setImpact(int impact) {
        this.impact = impact; //initialiser l'imacte de l'arme
    }
    
    public int getImpact(){
        
        return this.impact; //recupperer l'impact de l'arme
    }

    
    public void setRange(int range) {
        this.range = range; //initialiser l'intervalle de tire de l'arme
    }
    
    public int getRange() {
        return range; //recupperer l'intervalle de tire de l'arme
    }
    
    public void setMunition(int munitions){
        this.munitions=munitions;//initialiser le magasine de l'arme
    }
    
    public int getMunition(){
       
        return this.munitions;//recupperer le magasine de l'arme
    }

    public boolean canShoot(){
        
        return this.munitions > 0; //Verfier si une arme est utilisable
    }
    
    public void used(){
        
        this.munitions--; //decrementer le magasine de l'arme
    }
}
