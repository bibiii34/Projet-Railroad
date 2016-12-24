/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author btorralba
 */
public class LigneItem {
    
    private Item item;
    private int quantite;

    //Constructeurs
    public LigneItem(){
        this.item=null;
        this.quantite=1;
    }
    public LigneItem(Item item, int quantite) {
        this.item = item;
        this.quantite = quantite;
    }

    
    //Accesseur 
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
}
