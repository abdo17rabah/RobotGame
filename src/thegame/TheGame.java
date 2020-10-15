package thegame;

import java.util.Scanner;
import thegame.modelgame.robot.FinalRobotFactory;
import thegame.modelgame.grid.*;
import thegame.modelgame.grid.gridstrategy.*;
import thegame.modelgame.robot.*;

import thegame.util.Pastille;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe pour representer le jeu
public class TheGame {

    private MainGrid grid; // GRille du jeu
    private RobotsGroup group; // groupe de robots

    //Constructeur
    public TheGame(int choix){
        FinalRobotFactory fac = new FinalRobotFactory(); // Creation d'une factory
        this.group = new RobotsGroupList(); // Creation d'une groupe de robot
        group.add(fac.makeRobot("PEPS")); // creation d'un robot de type "Peps"
        group.add(fac.makeRobot("OPTIMUS")); // creation d'un robot de type "Optimus"
        group.add(fac.makeRobot("PUNISHER")); // creation d'un robot de type "Punisher"
        group.add(fac.makeRobot("TERMINATOR")); // creation d'un robot de type "Terminator"
        this.grid = new MainGrid(group, new Pastille()); // creation d'une grille
        this.play(grid,choix); // Creation de la grille du jeu
    }

    //Permet de choisir le type de la grille et d'initaliser les élèments de la grille
    public void play(MainGrid grid,int choix){

        GridStrategy init;

        for(int i=0; i<grid.getRobots().getSize();i++){

            grid.getRobots().get(i).inteStratExplosif(grid);
            grid.getRobots().get(i).setProxy(new GridProxy(grid,grid.getRobots().get(i)));
        }

        switch(choix){ //Choix du type de la grille

            case 2:
                init = new SquareGrid(grid);
                break;
            case 3:
                init = new OblongGrid(grid);
                break;
            default:
                init = new InitRandom(grid);

        }

        grid.afficher(); // Affichage de la grille du jeu sur le terminal
    }

    public void nextStage(){ //le tour suivant du jeu
        if(!grid.endGame())
        grid.nextTurn();
    }
    
    public void play(MainGrid grid){
    
        Scanner sc = new Scanner(System.in);
        GridStrategy init;
        int choix;
        boolean end;
        for(int i=0; i<grid.getRobots().getSize();i++){
            
            grid.getRobots().get(i).inteStratExplosif(grid);
            grid.getRobots().get(i).setProxy(new GridProxy(grid,grid.getRobots().get(i)));
        }
        
        
        System.out.println("--> GRILLE DE JEU <--");
        System.out.println("--> Carree robot et mur place aleatoirement: 1");
        System.out.println("--> Carree bassique: 2");
        System.out.println("--> Rectangle de bassique: 3");
        
        System.out.print("CHOISISSEZ UNE GRILLE: ");
        
        choix = sc.nextInt();
        
        switch(choix){
            
            case 2:
                init = new SquareGrid(grid);
                break;
            case 3:
                init = new OblongGrid(grid);
                break;
            default:
                init = new InitRandom(grid);
                
        }
        
        
        grid.afficher();
        
        do{
            
            grid.nextTurn();
            
            end=grid.endGame();
            
        }while(!end);
        
         System.out.println("FIN DU COMBAT: ");
        
        System.out.println("GAGNANT 1 " + grid.getRobots().get(0).getType());
        System.out.println("GAGNANT 2 " + grid.getDestroyedRobots().get(0).getType());
        System.out.println("GAGNANT 3 " + grid.getDestroyedRobots().get(1).getType());
        System.out.println("GAGNANT 4 " + grid.getDestroyedRobots().get(2).getType());
    }

    public MainGrid getGrid() {
        return grid;
    } // Récupperer la grille du jeu

    public RobotsGroup getGroup() { //Récuppperer le groupe de robot
        return group;
    }
}
