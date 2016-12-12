
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
public class Ville extends Case {
    private  String nom;
    private  Item item;
    private  ArrayList<Ressource> stock;

        //constructeur
    public Ville(int x, int y, String n, Item i){
        super(x,y);
        ImageIcon VILLE = new ImageIcon("./src/imgs/ville.png");
        this.texture=VILLE;
        this.nom=n;
        this.item=i;
        this.stock = new ArrayList<>();
        
    }
    
    public Ville(String n,Item i){
        this.x=0 + (int)(Math.random() * ((14 - 0) + 1));
        this.y=0 + (int)(Math.random() * ((14 - 0) + 1));
        ImageIcon VILLE = new ImageIcon("./src/imgs/ville.png");
        this.texture=VILLE;
        this.nom=n;
        this.item=i;
    }
    
    //accesseur

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item i) {
        this.item = i;
    }

    public ArrayList<Ressource> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Ressource> stock) {
        this.stock = stock;
    }
    
    
}
