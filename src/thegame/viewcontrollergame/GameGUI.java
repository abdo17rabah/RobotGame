package thegame.viewcontrollergame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe qui represente le View du jeu
public class GameGUI extends JFrame implements ActionListener {

    private JPanel gamePanel; //Panel pour afficher le jeu
    private JRadioButton  checkSquareGrid; //un Button radio pour choisir une grille carrée
    private JRadioButton  checkRectangleSquare; //un Button radio pour choisir une grille rectangulaire
    private JRadioButton  checkRandomGrid; //un Button radio pour choisir une grille aléatoire
    private JLabel SquareGrid, RectangleSquare, RandomGrid;
    private ImageIcon iconSquareGrid, iconRectangleSquare, iconRandomGrid;
    private ButtonGroup bg;

    //Constructeur
    public GameGUI(){
        //Initialiser les composants
        this.setTitle("The last LastStander");
        this.intiComponent();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(0, 0, screenSize.width, screenSize.height);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //Initialiser les composants
    private void intiComponent() {
        gamePanel =new JPanel();
        iconSquareGrid = new ImageIcon("src/thegame/Icons/SquareGrid.png");
        iconRectangleSquare = new ImageIcon("src/thegame/Icons/RectangleGrid.png");
        iconRandomGrid = new ImageIcon("src/thegame/Icons/RandomGrid.png");

        Image img1 = iconSquareGrid.getImage();
        Image newimg = img1.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        iconSquareGrid = new ImageIcon(newimg);

        Image img2 = iconRectangleSquare.getImage();
        Image newimg2 = img2.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        iconRectangleSquare = new ImageIcon(newimg2);

        Image img3 = iconRandomGrid.getImage();
        Image newimg3 = img3.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        iconRandomGrid = new ImageIcon(newimg3);

        SquareGrid = new JLabel(iconSquareGrid);
        SquareGrid.setBorder(BorderFactory.createTitledBorder("Square"));
        RectangleSquare = new JLabel(iconRectangleSquare);
        RectangleSquare.setBorder(BorderFactory.createTitledBorder("Rectangle"));
        RandomGrid = new JLabel(iconRandomGrid);
        RandomGrid.setBorder(BorderFactory.createTitledBorder("Random"));

        JPanel iconPanel = new JPanel(new GridLayout(2, 3));
        iconPanel.add(SquareGrid);
        iconPanel.add(RectangleSquare);
        iconPanel.add(RandomGrid);


        JPanel checkBoxPanel= new JPanel();
        checkBoxPanel.setPreferredSize(new Dimension(100, 25));
        checkBoxPanel.setBorder(BorderFactory.createTitledBorder("Grids :"));
        bg= new ButtonGroup();
        checkSquareGrid= new JRadioButton ("Random Grid",false);
        checkSquareGrid.addActionListener(this);

        checkRectangleSquare= new JRadioButton ("Square Grid",false);
        checkRectangleSquare.addActionListener(this);

        checkRandomGrid = new JRadioButton ("Rectangle Grid",false);
        checkRandomGrid.addActionListener(this);

        bg.add(checkSquareGrid);
        bg.add(checkRectangleSquare);
        bg.add(checkRandomGrid);
        iconPanel.add(checkSquareGrid);
        iconPanel.add(checkRectangleSquare);
        iconPanel.add(checkRandomGrid);

        gamePanel.add(iconPanel);
        this.getContentPane().add(gamePanel);
    }

    /*private void toggle(int i) {
        this.removeAll();
        this.getContentPane().revalidate();
        this.getContentPane().add(new GUI(i).getGamePanel());
        this.repaint();
    }*/


    @Override
    public void actionPerformed(ActionEvent e) {
        this.removeAll();
        if(e.getSource() == checkRandomGrid)
        {
            new GUI(3);
        }
        else if(e.getSource() == checkRectangleSquare)
        {
            new GUI(2);
        }
        else{
            new GUI(1);
        }

    }
}


