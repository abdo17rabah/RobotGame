/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.modelgame.grid;
import thegame.util.*;

/**
 *
 * @author  Abderrafii RABAH
 */

// Interface qui permet d'implementer toutes les fonctions necessaires pour la grille du jeu
public interface Grid {

     Elements elementAt( Emplacement emplacement );  // Methode pour recuppérer un élement à un certain emplacement
     void setElementAt(Emplacement e , Elements o); // Methode pour placer un élement à un certain emplacement dans la grille du jeu
     boolean inBounds(Emplacement em); // Methode pour verifier qu'un emplacement est valide
     void  afficher(); // Afficher le grille du jeu sur le terminal
     int numRow(); // Methode pour recuppérer le nombre de lignes d'une grille
     int numCol(); // Methode pour recuppérer le nombre de colonnes d'une grille

    
}
