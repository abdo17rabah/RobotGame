package thegame.viewcontrollergame;

import thegame.TheGame;
import thegame.modelgame.grid.MainGrid;
import thegameobserver.ListenableModel;
import thegameobserver.ModelListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import static java.lang.System.exit;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour representer le panel du jeu principal
public class GUI extends JFrame implements ListenableModel,ModelListener,KeyListener,MouseListener,MouseMotionListener {

    private MainGrid gameGrid; // Grille du jeu
    private GridView gridView; // View de la grille
    private JPanel gamePanel; // Panel du jeu
    //private List<ModelListener> listeners;
    private TheGame game;

    //Constructeur
    public GUI(int choix) {
        game=new TheGame(choix); //Creation du jeu
        this.gameGrid = game.getGrid(); //Initialiser la grille du jeu
        this.gridView = new GridView(this.gameGrid,this.gameGrid.numCol()); //creation d'un view de la grille
        //listeners = new ArrayList<>();
        this.addKeyListener(gridView); //ajout des listeners dont on a besoin
        this.addMouseListener(gridView); //ajout des listeners dont on a besoin
        this.addMouseMotionListener(gridView); //ajout des listeners dont on a besoin
        PlayerView playerTest ;
        JPanel playersView = new JPanel(); //Creation d'un panels pour les grilles des joueurs
        for(int i=0;i<game.getGroup().getSize();i++){
            playerTest=new PlayerView(gameGrid.getRobots().get(i).getProxyGrid(),10); // Creation d'un view pour la grille privée de chaque robot
            this.addKeyListener(playerTest); //ajout des listeners dont on a besoin
            this.addMouseListener(playerTest); //ajout des listeners dont on a besoin
            this.addMouseMotionListener(playerTest); //ajout des listeners dont on a besoin
            playersView.add(playerTest); //ajout les views dans le panel
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        //bouton pour jouer le tour suivant
        JButton next = new JButton("next");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.nextStage();
                revalidate();
                repaint();
            }
        });
        //next.setSize(60, 40);

        /*JButton reset = new JButton();
        reset.setText("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });*/

        //bouton pour quitter le jeu
        JButton quit = new JButton();
        quit.setText("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit(0);
            }
        });

        buttonPanel.add(next);
        //buttonPanel.add(reset);
        buttonPanel.add(quit);

        //Placer les composants du panel
        JScrollPane table = new JScrollPane(new VueGroupeRobots(game.getGroup()), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        table.setPreferredSize(new Dimension(300, 100));

        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(table, BorderLayout.SOUTH);
        gamePanel.add(gridView, BorderLayout.CENTER);
        gamePanel.add(playersView, BorderLayout.EAST);
        gamePanel.add(buttonPanel, BorderLayout.NORTH);
        this.setTitle("The last LastStander");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width, screenSize.height);
        this.getContentPane().add(gamePanel);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    @Override
    public void somethingHasChanged(Object source) {
        this.revalidate();
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.revalidate();
        this.revalidate();
        fireChange();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.revalidate();
        this.revalidate();
        fireChange();
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

    @Override
    public void addModelListener(ModelListener l){

        //listeners.add(l);
    }

    @Override
    public void removeModelListener(ModelListener l){

        //listeners.remove(l);
    }

    protected void fireChange(){

        /*for (ModelListener l : listeners)

            l.somethingHasChanged(this);*/
    }
}
