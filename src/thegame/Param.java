package thegame;

import thegame.util.Emplacement;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour representer tous les paramétres du jeu
public abstract class Param {
    
    private static final int PISTOLET = 0;
    private static final int MITRAILLETTE = 1;
    private static final int FUSIL = 2;
    
    private static final int BOMBE = 1;
    private static final int MINE= 0;
    
    private static final int SHOOT = 0;
    private static final int MOVE = 1;
    private static final int PUT = 2;
    private static final int SHILD = 3;
    
    private static final int HUT_UP = 1;
    private static final int HUT_RIGHT = 2;
    private static final int HUT_DOWN = 3;
    private static final int HUT_LEFT = 4;

    private static final int HUT_UP_LEFT = 5;
    private static final int HUT_UP_RIGHT = 6;
    private static final int HUT_DOWN_RIGHT = 7;
    private static final int HUT_DOWN_LEFT = 8;

    /**
     * @return the PISTOLET
     */
    public static int PISTOLET() {
        return PISTOLET;
    }

    /**
     * @return the MITRAILLETTE
     */
    public static int MITRAILLETTE() {
        return MITRAILLETTE;
    }

    /**
     * @return the FUSIL
     */
    public static int FUSIL() {
        return FUSIL;
    }

    /**
     * @return the BOMBE
     */
    public static int BOMBE() {
        return BOMBE;
    }

    /**
     * @return the MINE
     */
    public static int MINE() {
        return MINE;
    }

    /**
     * @return the HUT_UP
     */
    public static int HUT_UP() {
        return HUT_UP;
    }

    /**
     * @return the HUT_RIGHT
     */
    public static int HUT_RIGHT() {
        return HUT_RIGHT;
    }

    /**
     * @return the HUT_DOWN
     */
    public static int HUT_DOWN() {
        return HUT_DOWN;
    }

    /**
     * @return the HUT_LEFT
     */
    public static int HUT_LEFT() {
        return HUT_LEFT;
    }

    /**
     * @return the HUT_UP_LEFT
     */
    public static int HUT_UP_LEFT() {
        return HUT_UP_LEFT;
    }

    /**
     * @return the HUT_UP_RIGHT
     */
    public static int HUT_UP_RIGHT() {
        return HUT_UP_RIGHT;
    }

    /**
     * @return the HUT_DOWN_RIGHT
     */
    public static int HUT_DOWN_RIGHT() {
        return HUT_DOWN_RIGHT;
    }

    /**
     * @return the HUT_DOWN_LEFT
     */
    public static int HUT_DOWN_LEFT() {
        return HUT_DOWN_LEFT;
    }

    //Permet de recupperer un emplacement selon une direction
    public static Emplacement changeEmplacement(Emplacement em, int direction) {
        

        Emplacement newEm = new Emplacement(em.getRow(), em.getCol());

        if (direction == HUT_DOWN || direction == HUT_DOWN_RIGHT || direction == HUT_DOWN_LEFT) { // incrementation sur les lignes

            newEm.setRow(em.getRow() + 1);

        } else if (direction == HUT_UP || direction == HUT_UP_LEFT || direction == HUT_UP_RIGHT) { // decrementation sur les lignes

            newEm.setRow(em.getRow() - 1);
        }

        if (direction == HUT_RIGHT || direction == HUT_UP_RIGHT || direction == HUT_DOWN_RIGHT) { // incrementation sur les colonnes

            newEm.setCol(em.getCol() + 1);

        } else if (direction == HUT_LEFT || direction == HUT_UP_LEFT || direction == HUT_DOWN_LEFT) { // decrementation sur les colonnes

            newEm.setCol(em.getCol() - 1);
        }

        return newEm;
    }

    /**
     * @return the SHOOT
     */
    public static int SHOOT() {
        return SHOOT;
    }

    /**
     * @return the MOVE
     */
    public static int MOVE() {
        return MOVE;
    }

    /**
     * @return the PUT
     */
    public static int PUT() {
        return PUT;
    }

    /**
     * @return the SHIELD
     */
    public static int SHIELD() {
        return SHILD;
    }
}
