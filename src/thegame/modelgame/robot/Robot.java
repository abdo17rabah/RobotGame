/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.robot;

import java.util.ArrayList;
import thegame.Param;
import thegame.modelgame.grid.*;
import thegame.modelgame.robot.robotstrategy.*;
import thegame.modelgame.weaponry.*;
import thegame.util.*;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe qui permet de represent un robot
public class Robot extends Elements {

    private final int MITrange; // Intervalle de tire pour une mertraillette
    private final int MITdamage; // Impact d'une mertraillette
    private final int MITmunition; //Magasine d'une metraillette
    private final int FUSrange; // Intervalle de tire pour un fusil
    private final int FUSdamage; // Impact d'un fusil
    private final int FUSmunition;//Magasine d'un fusil

    private GridProxy grid; //Grille de jeu
    private Mine mine; //Mine
    private Bombe bombe; //Bombe
    private Shield shield; // Bouclier
    private int niveauVie = 600; //Niveau de vie
    private RobotsStrategy strategy; //startegie de jeu pour le robot
    private final ArrayList<ShootGun> shootGuns; //liste des armes à feu

    //Constructeur
    protected Robot(String type, int mrange, int mdamage, int mmunition,
            int frange, int fdamage, int fmunition) {

        super(type); //Type du robot
        this.MITrange = mrange; // Initialisation d'intervalle de tire pour la mertraillette
        this.MITdamage = mdamage; // Initialisation d'imapct pour la mertraillette
        this.MITmunition = mmunition; // Initialisation du magasine de  la mertraillette
        this.FUSrange = frange; // Initialisation d'intervalle de tire pour le fusil
        this.FUSdamage = fdamage; // Initialisation d'imapct pour le fusil
        this.FUSmunition = fmunition; // Initialisation du magasine de  le fusil
        this.shootGuns = new ArrayList<>(); //Création d'une liste d'armes à feu
        this.shield = new Shield(); // création d'un bouclier

    }

    //Methode pour choisir une arme à feu aléatoirement
    public ShootGun getShootGun(int Gun) {

        switch (Gun) {

            case 0:
                return this.shootGuns.get(Param.PISTOLET()); //Récupperer un pistolet

            case 1:
                return this.shootGuns.get(Param.MITRAILLETTE()); //Récupperer une mertraillette

            case 2:
                return this.shootGuns.get(Param.FUSIL()); //Récupperer un fusil
        }

        return null;
    }

    // Methode pour choisir un explosif aléatoirement
    public Explosif getExplosif(int explo) {

        switch (explo) {

            case 0:
                return this.mine; //Récupperer une mine
            case 1:
                return this.bombe; //Récupperer une bombe
        }

        return null;
    }

    // Methode pour augmenter le niveau de vie du robot lorsqu'une pastille est recupperée
    public void picked(int vie) {

        this.niveauVie += vie;
    }

    // Methode pour diminuer le niveau de vie du robot lorsqu'un robot est affecter par un tire ou explosion
    public void degat(int degat) {

        this.niveauVie -= degat;
        this.fireChange();

    }


    //Methode pour initialiser la strategie de jeu pour le robot et créer ses explosifs
    public void inteStratExplosif(MainGrid g) {

        this.strategy = new RandomStrategy(this, g); //Initialisation de la strategie
        this.bombe = new Bombe(g); // Création d'une bombe
        this.mine = new Mine(this, g); // Création d'une mine
    }

    //Methode pour appliquer la strategie choisi par le robot
    public void useStrategy() {

        System.out.println("C'EST LES TOUR DE   [ " + this.getType() + " ] LIFE : " + this.getNiveauVie());
        System.out.print("PIST: " + this.shootGuns.get(0).getMunition() + " MIT: " + this.shootGuns.get(2).getMunition() + " FUS: " + this.shootGuns.get(2).getMunition());
        
        System.out.println(" Mine: " + this.mine.getOwns() + " BOMBE: " + this.bombe.getOwns());
        this.strategy.Action();
        
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("C'EST LES TOUR DE   [ " + this.getType() + " ] LIFE : " + this.getNiveauVie());
        System.out.print("PIST: " + this.shootGuns.get(0).getMunition() + " MIT: " + this.shootGuns.get(2).getMunition() + " FUS: " + this.shootGuns.get(2).getMunition());
        System.out.println(" Mine: " + this.mine.getOwns() + " BOMBE: " + this.bombe.getOwns());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        this.getProxyGrid().afficher();

        this.fireChange();
    }

    //Methode pour ajouter un fusil à la liste des armes à feu
    private void addGun(ShootGun gun) {

        this.shootGuns.add(gun);
    }

    //Methode pour créer les armes du robot selon les caractéristiques
    public void arming() {

        this.addGun(new Pistolet()); // Création d'une fusil
        this.addGun(new Mitraillette(this.MITrange, this.MITdamage, this.MITmunition)); // création d'une metrailette
        this.addGun(new Fusil(this.FUSrange, this.FUSdamage, this.FUSmunition)); // création d'un fusil
    }

    //Initialiser la grille de jeu du robot
    public void setProxy(GridProxy game) {
        this.grid = game;

    }

    /**
     * @return the grid
     */
    public GridProxy getProxyGrid() {
        return grid;
    }

    /**
     * @return the niveauVie
     */
    public int getNiveauVie() {
        return niveauVie;
    }

    //Verifier si un robot peu jouer
    public Boolean canPlay() {

        for (int i = 0; i < this.shootGuns.size(); i++) { // Verifier s'il a des armes avec munitions valable

            if (shootGuns.get(i).getMunition() != 0) {

                return true;
            }
        }

        if (!this.mine.canBePut() && !this.bombe.canBePut()) {  // Verifier s'il a des explosif qui peut les placer

            return true;
        }
        return false;
    }

    /**
     * @return the shield
     */
    public Shield getShield() {
        return shield;
    } // Recupperer le bouclier

    public RobotsStrategy getStrategy() { // Recupperer la strategie
        return strategy;
    }
}
