
package thegame.util;
import java.io.File;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe qui permet de representer un mur
public class Wall extends Elements  {

    private final File file = new File("src/thegame/Icons/Wall.gif");

    //Constructeur
    public Wall() {
        super("Wall"); //Initialiser le type
        this.SetImageIcon(file); // initialiser l'icon
    }


}
