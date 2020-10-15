/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame.util;
import thegameobserver.AbstractListenableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author  Abderrafii RABAH
 */

//Classe abstraite qui represente les élèments de jeu
public abstract class Elements extends AbstractListenableModel{
    
    private String type; //Type de l'element
    protected Emplacement localisation; //emplacment de l'element
    private Image imageIcon=null; //Icon de l'element

    //Constructeur
    public Elements(String type){
        this.type=type; //initialiser le type de l'element
    }
    
    public String getType(){
        
        return type;//recupperer le type de l'element
    }

    public Emplacement getEmplacement(){
        
        return this.localisation; //recupperer l'emplacment de l'element
    }

    public void setEmplacement(Emplacement em){
        
        this.localisation = em; //initialiser l'emplacment de l'element
    }

    public void SetImageIcon(File ImagePath){ //initialiser l'Icon de l'element
        try {
            imageIcon = ImageIO.read(ImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public Image getImageIcon(){
        return imageIcon;//recupperer l'Icon de l'element
    }


    
}
