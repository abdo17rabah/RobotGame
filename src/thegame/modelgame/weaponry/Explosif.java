package thegame.modelgame.weaponry;

import thegame.modelgame.grid.MainGrid;
import thegame.modelgame.robot.Robot;
import thegame.util.Elements;
import thegame.util.Emplacement;
import thegame.util.Field;
import thegame.*;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe abstraite pour representer un explosif
public abstract class Explosif extends Elements {

    private int owns; //Nombre d'explosif que le robot posséde
    private int impactExplosion; //Imact de l'explosif
    private MainGrid grid; // grille du jeu

    //Constructeur
    public Explosif(String type, MainGrid grid, int impact, int nbr) {
        super(type); //Initialisation du type de l'explosif
        this.impactExplosion = impact; //initialisation de l'impact de l'explosif
        this.grid = grid; //initialisation de la grille de jeu
        this.owns = nbr; // initialisation du nombre d'explosif possédé par le robot
    }

    public MainGrid getGrid() { //Récupperer la grille du jeu
        return this.grid;
    }

    public int getOwns() { //Récupperer nombre d'explosifs possédés par le robot
        return owns;
    }

    public boolean canBePut() { //Verfifier si le robot posséde un explosif

        return owns > 0;
    }

    public void put() { //Décremente nombre d'explosifs possédés par le robot

        this.owns--;
    }

    public void exploser() { //Permet de faire exploser un explosif

        System.out.println("EXPLOSION D'UN BOMBE DE TYPE " + this.getType() + " A L'EMP: (" + this.localisation.getRow() + "," + this.localisation.getCol() + ")");

        grid.setElementAt(this.localisation, new Field()); // on remplace l'emplacement de l'explosif par une zone de jeu

        for (int i = 1; i <= 8; i++) { // on applique l'impact de l'explosif au 8 cases adjacentes à l'emplacment de l'explosif

            Emplacement em = new Emplacement(this.localisation.getRow(), this.localisation.getCol());

            em = Param.changeEmplacement(em, i);

            if (this.grid.inBounds(em)) {

                if (grid.elementAt(em) instanceof Robot) {

                    if (!((Robot) grid.elementAt(em)).getShield().beProtect()) { //on verifie si un robot n'a pas un bouclier posé

                        ((Robot) grid.elementAt(em)).degat(this.impactExplosion); //on applique le l'impact de l'explosif au robot

                    } else { //sinon on retire le bouclier du robot

                        ((Robot) grid.elementAt(em)).getShield().takeof();

                    }
                }
            }
        }
    }
}
