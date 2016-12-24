
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private  ArrayList<LigneItem> stock;
  

        //constructeur
    
    public Ville(){
        this.nom=" ";
        this.item=null;
        this.stock = new ArrayList<>();
        
    }
    public Ville(int x, int y, String n, Item i){
        super(x,y);
        ImageIcon VILLE = new ImageIcon("./src/imgs/Texture 100x100/ville.png");
        this.texture=VILLE;
        ImageIcon VILLESELECTION = new ImageIcon("./src/imgs/Texture 100x100/villeSelection.png");
        this.textureSelection=VILLESELECTION;
        this.nom=n;
        this.item=i;
        this.stock = new ArrayList<>();
        this.selection=false;
        
                
        
    }
    
    public Ville(String n,Item i, ArrayList<Ville> v){
        boolean coordonnees = false;
        
        while (coordonnees == false){
            this.x=0 + (int)(Math.random() * ((7 - 0) + 1));
            this.y=0 + (int)(Math.random() * ((7 - 0) + 1));   
            
            if (v.isEmpty()){
                coordonnees = true;
            }    
            else{
                coordonnees=true;
                for (Ville maville : v){
                    if (this.x==maville.getX() && this.y==maville.getY()){
                    coordonnees = false;
                    }
                }
            }
        }
        ImageIcon VILLE = new ImageIcon("./src/imgs/Texture 100x100/ville.png");
        this.texture=VILLE;
        ImageIcon VILLESELECTION = new ImageIcon("./src/imgs/Texture 100x100/villeSelection.png");
        this.textureSelection=VILLESELECTION;
        this.nom=n;
        this.item=i;
        this.stock = new ArrayList<>();
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

    public ArrayList<LigneItem> getStock() {
        return stock;
    }

    public void setStock(LigneItem stock) {
        this.stock.add(stock);
    }
    
    
    public void getStockString(){
        //retourne le contenu du stock
        for (LigneItem l : this.stock){
            System.out.println(l.getItem().getNom()+": "+l.getQuantite());
            
        }
    }
   
    
    
    public void genererPremiereRessource(Item item) throws InterruptedException{
        LigneItem li = new LigneItem(item,1);
        this.stock.add(li);

    }
    
    public void genererItem(){
  
        //si l'item de la ville est une ressource
        if (this.item instanceof Ressource){
            
            //on parcoure le stock de la ville 
            for (LigneItem l : this.stock){
                //est on increment seulement la ressource de la ville pas les autres
                if (this.item==l.getItem()){
                l.setQuantite(l.getQuantite()+1);
                }
            }
        }

        //si l'item est un produit
        if (this.item instanceof Produit){
            boolean ressource = false;
            
            
            //on parcoure les ressource necessaire pour realiser ce produit
            for (LigneItem ligneItemProduit : ((Produit) this.item).getRessource()){
                
                //on les compares avec les ressources presentent dans le stock
                for (LigneItem ligneItemStock : this.stock){
                    
                    //si la ressource du produit est presente dans le stock de la ville
                    if (ligneItemProduit.getItem()==ligneItemStock.getItem()){
                        
                        //on verifie si il y a suffisemment de quantité de ressource pour produire le produit
                        if (ligneItemStock.getQuantite()>= ligneItemProduit.getQuantite()){
                            
                            ressource=true;
                            
                        }
                        
                        else ressource=false;   
                    }
                }
            }
            
            //Si il y a suffisemment de toutes les ressources:
            if (ressource==true){
                //on parcoure les ressource necessaire pour realiser ce produit
                for (LigneItem ligneItemProduit : ((Produit) this.item).getRessource()){
                    //on les compares avec les ressources presentent dans le stock
                     for (LigneItem ligneItemStock : this.stock){
                         //on decremente les ressource necessaire
                         if (ligneItemProduit.getItem()==ligneItemStock.getItem()){
                             ligneItemStock.setQuantite(ligneItemStock.getQuantite()-ligneItemProduit.getQuantite());
                         }
                     }
                }
                
                //Enfin, on parcoure le stock pour verifier si le produit créé est deja present
                boolean produit=false;
                for (LigneItem ligneItemStock2 : this.stock){
   
                                //si oui, on augmente la quantité du produit +1
                                if (ligneItemStock2.getItem()==this.getItem()){
                                    ligneItemStock2.setQuantite(ligneItemStock2.getQuantite()+1);
                                    produit=true;
                                }
                                //si non, on crée une ligneitem du produit et on l'ajoute au stock

                } 
                if (produit==false){
                LigneItem ligneItem = new LigneItem(((Produit) this.item),1);
                this.stock.add(ligneItem);
                }
                                
            }
                        
        }

        
    }
            
        @Override
    public String toString(){
    String chaine = " V ";
    return chaine;
    }          
        
}  
            
  