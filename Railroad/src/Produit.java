
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author btorralba
 */
public class Produit extends Item {
       private ArrayList<LigneItem> ressource;
       
    //Constructeurs   
    public Produit(String n, int p, ArrayList<LigneItem> fabrication){
        super(n,p);
        this.ressource = fabrication ;
    }

    //Accesseur 
    public ArrayList<LigneItem> getRessource() {
        return ressource;
    }

    public void setRessource(ArrayList<LigneItem> ressource) {
        this.ressource = ressource;
    }  
    
}
