package thegame.modelgame.weaponry;

import thegame.modelgame.grid.MainGrid;
import thegame.modelgame.robot.*;
import thegame.util.Emplacement;

import java.io.File;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour représenter une Mine
public class Mine extends Explosif {

    protected Robot poseur; //Le robot possédant la mine
    private final File file = new File("src/thegame/Icons/Mine.gif"); //PATH de l'image icon

    //Constructeur
    public Mine(Robot robot, MainGrid grid) {
        super("Mine", grid, 144,4); //Initialisation des caracteristiques de la mine
        this.poseur = robot; // initialiser le robot possédant la mine
        this.SetImageIcon(file); // initialiser l'icone de la mine
    }

    public Robot getPoseur() {
        return this.poseur;
    } //retourner le robot possédant la mine
}
