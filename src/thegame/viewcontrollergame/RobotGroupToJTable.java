package thegame.viewcontrollergame;

import thegame.modelgame.robot.Robot;
import thegame.modelgame.robot.RobotsGroup;
import thegameobserver.ModelListener;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour adapter un groupe de robots en JTable
public class RobotGroupToJTable extends AbstractTableModel implements ModelListener {

        private final static int NB_CHAMPS = 8; //nombre de champs de la JTable

        private final static int JOUEUR = 0; //champs pour representer le nom du robot
        private final static int TYPE = 1; //champs pour representer le type du robot
        private final static int NIVEAUVIE = 2; //champs pour representer le niveau de vie du robot
        private final static int FusMu = 3; //champs pour representer le magasine de fusil du robot
        private final static int MetMu = 4; //champs pour representer le magasine de la metraillette du robot
        private final static int PisMu = 5; //champs pour representer le magasine du fusil du robot
        private final static int BombeNb = 6; //champs pour representer le nombre de bombes restante du robot
        private final static int MineNb = 7; //champs pour representer le nombre de mines restantes du robot

        private final static String[] COL_NAME; //Nom de la collonne

        static {
            COL_NAME = new String[NB_CHAMPS];
            COL_NAME[JOUEUR] = "Joueur";
            COL_NAME[TYPE] = "Type";
            COL_NAME[NIVEAUVIE] = "Vie ";
            COL_NAME[FusMu] = "Fusil -> ";
            COL_NAME[MetMu] = "Metraillette -> ";
            COL_NAME[PisMu] = "Pistolet -> ";
            COL_NAME[BombeNb] = "N° Bombe ";
            COL_NAME[MineNb] = "N° Mine ";

        }

        private RobotsGroup robots;//liste des robots

        //Constructeur
        public RobotGroupToJTable(RobotsGroup robots) {
            this.robots = robots;//Initialiser la liste des robots
            robots.addModelListener(this); //on ajoute un ecouteur sur la liste du robots
        }

        @Override
        public int getRowCount() {
            return robots.getSize(); //Recupperer le nombre de ligne de la table
        }

        @Override
        public int getColumnCount() {
            return NB_CHAMPS; //Recupperer le nombre de champs de la table
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) { //Recupperer la valeur d'une colonne de la table
            Robot robot = robots.get(rowIndex);
            switch (columnIndex) {
                case JOUEUR:
                    return robot.getType();
                case TYPE:
                    return robot.getType().substring(0,robot.getType().length()-1);
                case NIVEAUVIE:
                    return robot.getNiveauVie();
                case FusMu :
                    return robot.getShootGun(2).getMunition();
                case MetMu :
                    return robot.getShootGun(1).getMunition();
                case PisMu :
                    return robot.getShootGun(0).getMunition();
                case BombeNb :
                    return robot.getExplosif(0).getOwns();
                case MineNb :
                    return robot.getExplosif(1).getOwns();


            }
            return "**";
        }

        public String getColumnName(int col) {
            return COL_NAME[col]; //Recupperer le nom d'un champs de la table
        }

        @Override
        public void somethingHasChanged(Object source) {
            fireTableDataChanged(); //on redessine la table lors d'une modification d'un état du robot
        }


}
