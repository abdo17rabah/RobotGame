package thegame.modelgame.robot;

import java.io.File;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe qui sert comme factory des robots

public class FinalRobotFactory implements RobotFactory{
    
    private static int NbrTerm=0; //Nombre pour compter le nombre de robots de type "Terminator"
    private static int NbrPun=0; //Nombre pour compter le nombre de robots de type "Punisher"
    private static int NbrOP=0; //Nombre pour compter le nombre de robots de type "Optimus"
    private static int Nbrpeps=0; //Nombre pour compter le nombre de robots de type "Peps"
    private File file; //Reference sur objet File
  
    public FinalRobotFactory(){
       
       
    }

    //Methode pour créer un robot selon le type
    @Override
    public Robot makeRobot(String type){

        Robot robot = null;
        
        switch(type){
        
            case"PEPS": //Initialisation des caracteristiques du robot type "Peps"
                file = new File("src/thegame/Icons/Peps.png");
                robot = new Robot(type+Nbrpeps,3,36,12,3,66,8);
                Nbrpeps++;
                break;    
            case"OPTIMUS": //Initialisation des caracteristiques du robot type "Optimus"
                file = new File("src/thegame/Icons/Optimius.png");
                robot = new Robot(type+NbrOP,5,24,12,5,120,4);
                NbrOP++;
                break;  
            case "PUNISHER": //Initialisation des caracteristiques du robot type "Punisher"
                file = new File("src/thegame/Icons/Punisher.png");
                robot =  new Robot(type+NbrPun,4,36,12,2,72,12);
                NbrPun++;
                break;
            case"TERMINATOR": //Initialisation des caracteristiques du robot type "Terminator"
                file = new File("src/thegame/Icons/Terminator.png");
                robot = new Robot(type+NbrTerm,4,72,6,2,132,4);
                NbrTerm++;
                break;
        }
        
       if(robot!=null){
           robot.arming(); //Création des armes du robot
           robot.SetImageIcon(file); //Inialisation de l'icon du robot
       }

       return robot; // on retourne le robot créé
    }
    
}
