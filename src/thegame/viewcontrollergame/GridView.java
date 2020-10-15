package thegame.viewcontrollergame;

import thegame.Param;
import thegame.modelgame.grid.MainGrid;
import thegame.modelgame.robot.robotstrategy.RandomStrategy;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour représenter un View de la grille de jeu
public class GridView extends JPanel implements KeyListener,MouseListener,MouseMotionListener {

        protected MainGrid mainGrid; //Grille de jeu
        protected int gridSize; //taille de la grille

        //Constructeur
        public GridView(MainGrid mainGrid, int gridSize) {
            this.mainGrid = mainGrid; //Initialiser la grille
            this.gridSize = gridSize; //Initialiser la taille
            this.setPreferredSize(new Dimension(700  ,700)); //Initiliser les dimentsions du panel
        }

        public Dimension getPreferredSize() {
            return new Dimension(700, 700);
        } //recupperer les dimentsions du panel

        public void paintComponent(Graphics g){ //Dessiner le panel
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            if(this.mainGrid.endGame()) { // Si la partie est terminée on dessine une image de fin de jeu avec le robot gagnant
            Image image = null;
            final File file = new File("src/thegame/Icons/victory.jpg");
            try {
                image = ImageIO.read(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(image, 0, 0, null);
            g.setColor(Color.RED);
            if(mainGrid.getRobots().getSize()!=0)
            g.drawString("The Last Stander" + mainGrid.getRobots().get(1).getType(), 240, 300);
             }

             else { // Sinon
                int x = 0;
                int y = 0;
                for (int i = 0; i < mainGrid.numRow(); i++) { //On parcours les lignes de la grille
                    for (int z = 0; z < mainGrid.numCol(); z++) { //On parcours les colonnes de la grille
                        g2d.setBackground(Color.GRAY);
                        g2d.drawImage(this.mainGrid.getGrid()[i][z].getImageIcon(), x , y , null); //on dessine les images de chaque element de la grille
                            x+=40; //On augmente par 40px car les images sont de 40px*40px
                            }
                            x=0;
                            y+=40;
                        }

                int currentPlayer = mainGrid.getCurrentPlayer() ; //On recuppere le robot jouant
                int choice = ((RandomStrategy)mainGrid.getRobots().get(currentPlayer).getStrategy()).getChoice(); //on recuppere le choix d'action
                int k = mainGrid.getRobots().get(currentPlayer).getEmplacement().getRow();
                int j = mainGrid.getRobots().get(currentPlayer).getEmplacement().getCol();

                if(choice== Param.SHOOT()){ //Si l'action est le tire
                    g.setColor(Color.BLACK);
                    int shootDirection = ((RandomStrategy)mainGrid.getRobots().get(currentPlayer).getStrategy()).getShootDirection(); //on recuppere la direction du tire
                    if(k != 0 || j!=0){
                        switch(shootDirection){ //On dessine une balle selon la direction
                            case 1: //Direction en Haut
                                g.fillRect(40*j+20,40*k-9,4,9);
                                break;
                            case 2 : //Direction à droite
                                g.fillRect(40*j+40,40*k+20,9,4);
                                break;
                            case 3 : //Direction en bas
                                g.fillRect(40*j+20,40*k+40,4,9);
                                break;
                            case 4 : //Direction à gauche
                                g.fillRect(40*j-9,40*k+20,9,4);
                                break;
                        }
                    }
                }

                if(choice== Param.SHIELD()){ //Si l'action est la pause d'un bouclier
                    g.setColor(Color.RED);
                    g.drawRect(40*j,40*k,40,40); //on dessine un rectangle autour du robot
                }


                 }
             }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            mainGrid.nextTurn(); //Si une touche est cliqué
            repaint(); //on redessine le panel

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mainGrid.nextTurn(); //si la souris est cliqué
        repaint(); //on redessine le panel
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


