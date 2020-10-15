/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.robot;

import thegameobserver.ListenableModel;
import thegameobserver.ModelListener;

/**
 *
 * @author  Abderrafii RABAH
 */

//Interface qui implement les methodes necessaire pour construire un groupe de robots
public interface RobotsGroup extends ListenableModel {
    
     int getSize(); // Récupperer la taille de la liste des robots
     Robot get(int i); // Récupperer un robot à un indice donné de la liste des robots
     void add(Robot robot); // Ajouter un robot dans la liste des robots
     void remove(Robot robot); //Supprimer un robot de la liste des robots
     void remove(int i); //Supprimer un robot à un indice donné de la liste des robots
    
}
