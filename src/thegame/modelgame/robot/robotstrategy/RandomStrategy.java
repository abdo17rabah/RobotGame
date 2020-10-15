/*
 * To change this license header, choice License Headers in Project Properties.
 * To change this template file, choice Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.robot.robotstrategy;

import java.util.ArrayList;
import java.util.Random;

import thegame.modelgame.robot.Robot;
import thegame.modelgame.weaponry.*;
import thegame.util.Emplacement;
import thegame.util.*;
import thegame.*;
import thegame.modelgame.grid.*;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe qui permet de créer et de choisir aléatoirement une strategie de jeu pour un robot
public class RandomStrategy extends RobotsStrategy {

    ArrayList<Integer> action; //Liste des actions possibles
    Random r; // Réference sur un Objet Random
    private int choice,shootDirection; //Representer le choix de l'action à jouer et la direction du tire

    //Constructeur
    public RandomStrategy(Robot robot, MainGrid g) {

        super(robot, g); //Initialisation
        this.r = new Random(); //Création de l'objet Random
        this.action = new ArrayList<>(); //Création d'une liste d'actions
    }

    // Cette methode permet de récupperer une arme aléatoirement avec laquel le robot peut tirer
    private ShootGun chooseGun() {

        ArrayList<ShootGun> guns = new ArrayList<>(); // liste des armes

        for (int i = 0; i < 3; i++) { // on parcours la liste des armes du robot

            if (this.robot.getShootGun(i).canShoot()) { //on teste si l'arme est valide pour tirer

                guns.add(this.robot.getShootGun(i)); //on ajoute l'arme à la liste
            }

        }

        if (guns.size() != 0) {

            return guns.get(r.nextInt(guns.size())); // on choisit une arme aléatoirement
        }

        return null;
    }

    // Cette methode permet de récupperer un explosif aléatoirement
    public Explosif chooseExplosif() {

        this.robot.getExplosif(Param.MINE()); //Inutile??

        Explosif explosifChoice;

        int c = r.nextInt(3); // on tire aléatoirement

        if (c == 1) { // on Récuppere une mine

            explosifChoice = this.robot.getExplosif(Param.MINE());

        } else { // on Récuppere une bombe

            explosifChoice = this.robot.getExplosif(Param.BOMBE());
        }

        if (explosifChoice.canBePut()) { /* on Verifie si le robot peut poser l'explosif choisi
                                              sinon on choisi un autre et on verifie de nouveau la possibilité de pose */

            return explosifChoice;

        } else if (c == 1) {

            explosifChoice = this.robot.getExplosif(Param.BOMBE());

            if (explosifChoice.canBePut()) {

                return explosifChoice;

            }

        } else if (c != 1) {

            explosifChoice = this.robot.getExplosif(Param.MINE());

            if (explosifChoice.canBePut()) {

                return explosifChoice;

            }

        }

        return null;

    }

    //Permet de placer une mine ou un bombe dans un emplacement adjacent à l'emplacement du robot
    public Emplacement choixEmplacemntExplosif(int n, int mBm) { //Essayes de changer le nom ex choixEmplacemntExplosif

        ArrayList<Emplacement> ems = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            Emplacement em = new Emplacement(this.robot.getEmplacement().getRow(), this.robot.getEmplacement().getCol());
            em = Param.changeEmplacement(em, i);

            if (this.robot.getProxyGrid().inBounds(em)) {

                if (this.robot.getProxyGrid().elementAt(em) instanceof Field) {
                    ems.add(em);

                } else if (this.robot.getProxyGrid().elementAt(em) instanceof Pastille && mBm == Param.MOVE()) {

                    ems.add(em);

                } else if (this.robot.getProxyGrid().elementAt(em) instanceof Robot && mBm == Param.PUT()) {
                    ems.add(em);
                }
            }
        }

        if (ems.isEmpty()) {
            return null;
        }
        return ems.get(r.nextInt(ems.size()));
    }

    //Permet de choisir une action de jeu pour le robot
    @Override
    public void Action() {

        int goAction = 0;
        Emplacement em;

        do {

            choice = this.chooseAction(); // On récupperer l'action choisi

            if (choice == Param.SHOOT()) { //Si l'action choisi est l'action de tire

                ShootGun gun = this.chooseGun(); // On recuppere une arme de tire

                if (gun != null) { // on test que le robot à une arme

                    System.out.println(" # SHOOT #");
                    gun.used();
                    shootDirection=r.nextInt(4) + 1; // on choisi aléatoirement la direction du tire
                    this.shoot(gun, shootDirection);
                    goAction = 1;

                } else {

                    this.action.remove(choice);
                }

            } else if (choice == Param.MOVE()) { //Si l'action choisi est l'action de deplacement

                em = this.choixEmplacemntExplosif(4, Param.MOVE()); //On choisi un emplacement aléatoirement

                if (em != null) {

                    System.out.println(" # MOVE #");
                    this.moves(em);
                    goAction = 1;

                } else {

                    this.action.remove(choice);
                }

            } else if (choice == Param.PUT()) { //Si l'action choisi est l'action de placement d'un explosif

                Explosif exp = this.chooseExplosif(); //On choisi un explosif aléatoirement

                em = this.choixEmplacemntExplosif(8, Param.PUT()); //on le place aléatoirement dans les 8 emplacement adjacents possible

                if (em != null && exp != null) { // on verifie que l'emplacement est valide et que le robot possede un exlosif

                    System.out.println(" # PUT EXPLOSIF #");

                    this.putExplosif(exp, em);
                    goAction = 1;

                } else {

                    this.action.remove(choice);
                }

            } else if (choice == Param.SHIELD()) { //Si l'action choisi est de placer un bouclier

                if (this.robot.getShield().canUse()) { //On verifie que le robot peut poser un bouclier

                    System.out.println(" # PUT SHIELD #");

                    this.robot.getShield().used(); // On décremente le nombre de bouclier restant pour le robot
                    goAction = 1;

                } else {

                    this.action.remove(choice);
                }

            }

        } while (!this.action.isEmpty() && goAction == 0);

    }

    @Override
    public int chooseAction() { // Permet de choisir une action aléatoirement
        this.action.add(Param.SHOOT());
        this.action.add(Param.MOVE());
        this.action.add(Param.PUT());
        this.action.add(Param.SHIELD());
        return this.action.get(r.nextInt(this.action.size()));
    }

    public int getChoice() { // recupperer l'action chosie
        return choice;
    }

    public int getShootDirection() {  // recupperer la direction du tire
        return shootDirection;
    }
}
