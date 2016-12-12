
import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author btorralba
 */
public class Train extends Case{
    private int[][] trajet;
    private  ArrayList<Ressource> stock;
    private Ville depart;
    private Ville arrivee;
    
    //Constructeurs  
    public Train(int x, int y, int[][] trajet, Ville d, Ville a){
        super(x,y);
        //image train
        this.trajet=trajet;
        this.stock=new ArrayList();
        this.depart=d;
        this.arrivee=a;
        
    }

     //Accesseur 
    public int[][] getTrajet() {
        return trajet;
    }

    public void setTrajet(int[][] trajet) {
        this.trajet = trajet;
    }

    public ArrayList<Ressource> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Ressource> stock) {
        this.stock = stock;
    }
    
    
}
