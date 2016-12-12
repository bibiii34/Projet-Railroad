
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
    
    public Train(int x, int y, ImageIcon t, int[][] trajet){
        super(x,y,t);
        this.trajet=trajet;
        this.stock=new ArrayList();
        
    }

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
