package thegame.modelgame.robot;

/**
 *
 * @author  Abderrafii RABAH
 */

//Interface qui implemente une fonction de création d'un robot
public interface RobotFactory {
    
    Robot makeRobot(String type);
   
}
