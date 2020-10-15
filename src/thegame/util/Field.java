package thegame.util;
import java.io.File;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour representer une zone de jeu

public class Field extends Elements {

    private final File file = new File("src/thegame/Icons/Empty.gif"); //Path de l'image icon

    //Constructeur
    public Field() {
        super("Pave"); //Initialiser le type
        this.SetImageIcon(file); //Initialiser l'icon
    }


}
