
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
public class Modele {
    private Case[][] map;
    private ArrayList<Produit> production;
    private ArrayList<Observateur> observateur;
    
    public Modele(){
        map=new Case[15][15];
        this.observateur=new ArrayList<>();
    }
    
    
    
        public void genererMonde(){
            
            //Creation des ressource
            Ressource lait = new Ressource("lait",5); 
            Ressource plastique = new Ressource("plastique",5);
            Ressource fer = new Ressource("fer",5);
            
            //ligneItem des different produit
            LigneItem I1altere = new LigneItem(fer,10);
            LigneItem I1proteine = new LigneItem(lait,20);
            LigneItem I2proteine = new LigneItem(plastique,5);
            
            //ArayList de ligne item pour crée des produit
            ArrayList<LigneItem> fabricationaltere =new ArrayList();
            ArrayList<LigneItem> fabricationproteine =new ArrayList(); 
            
            fabricationaltere.add(I1altere);
            fabricationproteine.add(I1proteine);
            fabricationproteine.add(I2proteine);
            
            //Creation des produit
            Produit proteine = new Produit("proteine",100,fabricationproteine);
            Produit altere = new Produit("altere",100,fabricationaltere);
            
            //Creation ville
            Ville limoges=new Ville("Limoges",lait);
            Ville beziers = new Ville("Bezier",proteine);
            Ville toulouse = new Ville("toulouse",fer);
            Ville servian = new Ville("servian",plastique);
            Ville carcassone = new Ville("carcassone",altere);
            
            
            map[limoges.getX()][limoges.getY()]=limoges;
            avertirAllChangementCase(limoges.getX(), limoges.getY(), limoges);
            
           map[beziers.getX()][beziers.getY()]=beziers;
            avertirAllChangementCase(beziers.getX(), beziers.getY(), beziers);
            
            map[toulouse.getX()][toulouse.getY()]=toulouse;
            avertirAllChangementCase(toulouse.getX(), toulouse.getY(), toulouse);
            
            map[servian.getX()][servian.getY()]=servian;
            avertirAllChangementCase(servian.getX(), servian.getY(), servian);
            
            map[carcassone.getX()][carcassone.getY()]=carcassone;
            avertirAllChangementCase(carcassone.getX(), carcassone.getY(), carcassone);
                
            //Generer obstacle
            Obstacle o = new Obstacle();
            Obstacle o1 = new Obstacle();
            Obstacle o2 = new Obstacle();
            
            map[o.getX()][o.getY()]=o;
            avertirAllChangementCase(o.getX(), o.getX(), o);
            map[o1.getX()][o1.getY()]=o1;
            avertirAllChangementCase(o1.getX(), o1.getX(), o1);
            map[o2.getX()][o2.getY()]=o2;
            avertirAllChangementCase(o2.getX(), o2.getX(), o2);
            
            
            
        }
    
        public void register(Observateur o){
        observateur.add(o);
    }
    
        public void unregister(Observateur o){
        observateur.remove(o);
    }
            
        public void avertirAllChangementCase(int i, int j, Case c){
            for (Observateur o : this.observateur){
            o.avertirChangementCase(i, j,c);            
        }
            System.out.println(i+"/"+j);
        }
        
        public void avertirAllObservateurs(int i, int j){
        for (Observateur o : this.observateur){
            o.avertir(i, j);
        }
        }
        
        public int aleatoire(){
           int aleatoire= 0 + (int)(Math.random() * ((15 - 0) + 1));
           return aleatoire;
        }
        
    
}

