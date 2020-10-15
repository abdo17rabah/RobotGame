package thegame.viewcontrollergame;

import thegame.modelgame.robot.RobotsGroup;

import javax.swing.*;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour adapter la Jtable en JScrollPane
public class VueGroupeRobots extends JScrollPane {

    //Constructeur
    public VueGroupeRobots(RobotsGroup robotsGroup)
    {
        super(new JTable(new RobotGroupToJTable(robotsGroup)));
    }
}
