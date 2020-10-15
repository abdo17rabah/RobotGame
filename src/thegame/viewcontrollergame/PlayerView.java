package thegame.viewcontrollergame;
import thegame.modelgame.grid.GridProxy;
import thegame.modelgame.weaponry.Bombe;
import thegame.modelgame.weaponry.Mine;
import thegame.util.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour representer un View pour la grille privée du robot
public class PlayerView extends JPanel implements KeyListener,MouseListener,MouseMotionListener {

    private GridProxy playersGrid ; //Grille privée du robot
    private int gridSize; //taille de la grille

    //Constructeur
    public PlayerView(GridProxy playersGrid,int gridSize) {
        this.playersGrid = playersGrid; //initialiser la grille privée
        this.gridSize=gridSize; //initialiser la taille
        this.setPreferredSize(new Dimension(100 ,100)); //initliser les dimensions
    }

    public Dimension getPreferredSize() {
        return new Dimension(gridSize * playersGrid.numRow(), gridSize
                * gridSize * playersGrid.numCol());
    }

    public void paintComponent(Graphics g) {
        //Dessiner les elements de la grille privée du robot
        super.paintComponent(g);
        int x = 0;
        int y = 0;
        Emplacement em = new Emplacement(0, 0);
        for (int i = 0; i < playersGrid.numRow(); i++) {
            for (int z = 0; z < playersGrid.numCol(); z++) {
                em.setColRow(i, z);
                if (playersGrid.elementAt(em) instanceof Mine) //Si l'élèment est une mine
                        g.setColor(Color.RED);
                    else if (playersGrid.elementAt(em) instanceof Bombe) //Si l'élèment est une bombe
                        g.setColor(Color.YELLOW);
                    else if (playersGrid.elementAt(em) instanceof Field) //Si l'élèment est une zone de jeu
                        g.setColor(Color.GRAY);
                    else if (playersGrid.elementAt(em) instanceof Wall) //Si l'élèment est un mur
                        g.setColor(Color.WHITE);
                    else if (playersGrid.elementAt(em) instanceof Pastille) //Si l'élèment est une pastille
                        g.setColor(Color.GREEN);
                    else g.setColor(Color.BLACK); //Si l'élèment est un robot

                    g.fillRect(x, y, 10, 10); //on dessine un rectangle de 10px*10px
                    x += 10;
                }
                x = 0;
                y += 10;
            }


        }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        repaint(); // si une touche cliquée on redessine le panel

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        repaint(); // si la souris cliquée on redessine le panel

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
