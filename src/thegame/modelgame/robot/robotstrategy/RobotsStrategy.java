/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.robot.robotstrategy;

import thegame.modelgame.grid.MainGrid;
import thegame.modelgame.robot.*;
import thegame.modelgame.weaponry.Explosif;
import thegame.modelgame.weaponry.Mine;
import thegame.modelgame.weaponry.ShootGun;
import thegame.util.*;
import thegame.*;

/**
 *
 * @author  Abderrafii RABAH
 */

// Classe abstraite qui permet d'implémenter les differentes actions du jeu

public abstract class RobotsStrategy {

    protected Robot robot;
    protected MainGrid grid;

    //Constructeur
    public RobotsStrategy(Robot robot, MainGrid g) {

        this.robot = robot;//Initialisation du robot
        this.grid = g; //Initialisation de la grille

    }

    //Methode qui permet au robot de se déplacer dans un nouveau emplacement
    public void moves(Emplacement newEm) {

        if (this.grid.elementAt(newEm) instanceof Explosif) { //Si le robot se place sur un explosif, ce dernier s'explose

            ((Explosif) this.grid.elementAt(newEm)).exploser();

        } else if (this.grid.elementAt(newEm) instanceof Pastille) { //Si le robot se place sur une pastille, on augmente son niveau de vie

            this.robot.picked(((Pastille) this.grid.elementAt(newEm)).pickUp());

        }

        this.robot.getProxyGrid().setElementAt(this.robot.getEmplacement(), new Field()); // on met un Field a la place du robot

        this.robot.setEmplacement(newEm);

        this.robot.degat(10);
        this.robot.getProxyGrid().setElementAt(newEm, this.robot); // placement du robot sur un new emplacement

    }

    //Methode de tire
    public void shoot(ShootGun gun, int d) {

        System.out.println("LA DIRECTION DU SHOOT " + d);

        Emplacement em = new Emplacement(this.robot.getEmplacement().getRow(), this.robot.getEmplacement().getCol()); //On récuppere l'emplacement du robot

        for (int i = 0; i < gun.getRange(); i++) { //On récuppere les emplacements qui sont dans li'ntervalle du tire

            em = Param.changeEmplacement(em, d);

            if (this.robot.getProxyGrid().inBounds(em)) {

                if (this.robot.getProxyGrid().elementAt(em) instanceof Robot) { // On verifie s'il y des robots dans l'intervalle du tire

                    if (!((Robot) this.robot.getProxyGrid().elementAt(em)).getShield().beProtect()) { //Si le robot n'a un bouclier posé
                        ((Robot) this.robot.getProxyGrid().elementAt(em)).degat(gun.getImpact()); //on applique l'imacte de l'arme choisi
                    } else {

                        ((Robot) this.robot.getProxyGrid().elementAt(em)).getShield().takeof(); // si le robot à un bouclier posé on le retire
                    }

                }
            }
        }
    }


    //Méthode pour placer un explosif
    public void putExplosif(Explosif exp, Emplacement set) {

        System.out.println("A  (" + set.getRow() + "," + set.getCol() + ")");

        exp.setEmplacement(set); //On initialise l'emplacement de l'explosif

        if (exp.getGrid().elementAt(set) instanceof Mine) {

            ((Mine) exp.getGrid().elementAt(set)).exploser();//Si on place la mine sur un emplacement qui contient déja une mine on l'a fait exploser
            exp.exploser(); //on explose l'explosif

        } else {

            this.robot.getProxyGrid().setElementAt(set, exp); //Sinon on place la mine sur la grille

        }
        exp.put(); //on décremente le nombre d'explosif du robot
    }

    public abstract void Action(); //Methode abstraire qui permet d'appliquer une action

    public abstract int chooseAction(); //Methode abstraire qui permet de chosir une action

}
