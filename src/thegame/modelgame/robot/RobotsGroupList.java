/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.robot;
import java.util.ArrayList;
import thegameobserver.*;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe qui represente un groupe de robots
public class RobotsGroupList extends AbstractListenableModel implements RobotsGroup, ModelListener{
    
    ArrayList<Robot> robots;
    
   //Constructeur
    public RobotsGroupList(){

        this.robots= new ArrayList<>(); // Création d'une liste de robots
    }
    
    @Override
    public int getSize(){
        
        return this.robots.size(); // Récupperer la taille de la liste des robots
    }

    @Override
    public Robot get(int i){
        
        return this.robots.get(i); // Récupperer un robot à un indice donné de la liste des robots
    }

    @Override
    public void add(Robot robot) {
        
        this.robots.add(robot); // Ajouter un robot dans la liste des robots
    }


    @Override
    public void remove(Robot robot){
    
       this.robots.remove(robot); //Supprimer un robot de la liste des robots
       fireChange(); //mettre à jour les listeners
    }

    @Override
    public void remove(int i) {
        
        this.robots.remove(i); //Supprimer un robot à un indice donné de la liste des robots
        fireChange(); //mettre à jour les listeners
    }
    
    @Override
    public void somethingHasChanged(Object source) {
        
        fireChange(); //mettre à jour les listeners
    }
}
