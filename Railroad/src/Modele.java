
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
    
    ArrayList<Ville> villes = new ArrayList();
    
    public Modele(){
        map=new Case[8][8];
        this.observateur=new ArrayList<>();
    }
    
    
        public Case getCase(int x, int y){
            return map[x][y];
        }
    
        public void genererMonde() throws InterruptedException{
            
            //Creation des ressource
            Ressource lait = new Ressource("lait",5); 
            Ressource plastique = new Ressource("plastique",5);
            Ressource fer = new Ressource("fer",5);
            
            //ligneItem des different produit
            LigneItem I1haltere = new LigneItem(fer,10);
            LigneItem I1proteine = new LigneItem(lait,20);
            LigneItem I2proteine = new LigneItem(plastique,5);
            LigneItem I1shaker = new LigneItem(plastique,3);
            
            //ArayList de ligne item pour crée des produit
            ArrayList<LigneItem> fabricationhaltere =new ArrayList();
            ArrayList<LigneItem> fabricationproteine =new ArrayList(); 
            ArrayList<LigneItem> fabricationshaker=new ArrayList();
            
            fabricationhaltere.add(I1haltere);
            fabricationproteine.add(I1proteine);
            fabricationproteine.add(I2proteine);
            
            //Creation des produit
            Produit proteine = new Produit("proteine",100,fabricationproteine);
            Produit haltere = new Produit("altere",100,fabricationhaltere);
            Produit shaker = new Produit("shaker",100,fabricationshaker);
            
            //Creation ville
            
            Ville limoges=new Ville("Limoges",lait, villes);
            villes.add(limoges);
            Ville beziers = new Ville("Bezier",proteine, villes);
            villes.add(beziers);
            Ville toulouse = new Ville("toulouse",fer, villes);
            villes.add(toulouse);
            Ville servian = new Ville("servian",plastique, villes);
             villes.add(servian);
            Ville carcassonne = new Ville("carcassonne",haltere, villes);
            villes.add(carcassonne);
            Ville agen = new Ville("agen",shaker,villes );
            villes.add(agen);

  
            //placement des villes sur le modele et sur la vue
            map[limoges.getX()][limoges.getY()]=limoges;
            avertirAllChangementCase(limoges.getX(), limoges.getY(), limoges);
            
           map[beziers.getX()][beziers.getY()]=beziers;
            avertirAllChangementCase(beziers.getX(), beziers.getY(), beziers);
            
            map[toulouse.getX()][toulouse.getY()]=toulouse;
            avertirAllChangementCase(toulouse.getX(), toulouse.getY(), toulouse);
            
            map[servian.getX()][servian.getY()]=servian;
            avertirAllChangementCase(servian.getX(), servian.getY(), servian);
            
            map[carcassonne.getX()][carcassonne.getY()]=carcassonne;
            avertirAllChangementCase(carcassonne.getX(), carcassonne.getY(), carcassonne);
            
            map[agen.getX()][agen.getY()]=agen;
            avertirAllChangementCase(agen.getX(), agen.getY(), agen);
                
            //Generer obstacle
            Obstacle o = new Obstacle();
            Obstacle o1 = new Obstacle();
            Obstacle o2 = new Obstacle();
            Obstacle o3 = new Obstacle();
  
            
 
            //placement des obstacles sur le modele et la vue;
            map[o.getX()][o.getY()]=o;
            avertirAllChangementCase(o.getX(), o.getY(), o);
            
            map[o1.getX()][o1.getY()]=o1;
            avertirAllChangementCase(o1.getX(), o1.getY(), o1);
            
            map[o2.getX()][o2.getY()]=o2;
            avertirAllChangementCase(o2.getX(), o2.getY(), o2);
            
            map[o3.getX()][o3.getY()]=o3;
            avertirAllChangementCase(o3.getX(), o3.getY(), o3);
            

            
            //generer premiere ressource
            limoges.genererPremiereRessource(limoges.getItem());
            toulouse.genererPremiereRessource(toulouse.getItem());
            servian.genererPremiereRessource(servian.getItem());
            
            
            //Lancer tache generer ressource ville
            BackgroundTask1 genererRessource = new BackgroundTask1(villes);
            genererRessource.start();
            
            System.out.println("le programme fonctionne comme sur des roulettes");
            
           LigneItem I1halteretest = new LigneItem(fer,20);
           carcassonne.getStock().add(I1halteretest);
  
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
        }
        
        public void avertirAllObservateursSelectionVille(int i, int j, Ville v){
        for (Observateur o : this.observateur){
            o.avertirSelectionVille(i, j, v);
        }
        }
        
        /*Placement Rail observateur*/
        public void avertirAllPlacementRailH(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirPlacementRailH(i, j, c);            
        }
        } 
        
        public void avertirAllPlacementRailV(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirPlacementRailV(i, j, c);            
        }
        } 
        
        public void avertirAllPlacementRailVirage1(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirPlacementRailVirage1(i, j, c);            
        }
        } 
        
        public void avertirAllPlacementRailVirage2(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirPlacementRailVirage2(i, j, c);            
        }
        } 
                
        public void avertirAllPlacementRailVirage3(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirPlacementRailVirage3(i, j, c);            
        }
        }         
        
        public void avertirAllPlacementRailVirage4(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirPlacementRailVirage4(i, j, c);            
        }
        } 
        
        
        /*placer rails */
        public void placerRails(ArrayList<Integer[]> trajet){
            
            /*on parcoure l'arraylist trajet en ignorant 1er et derniere coordonées (ville)*/
            for (int i =1; i<=trajet.size()-1; i++){
        
                /*on crée une nouvelle case rail avec les coordonnées de la case selectionnée*/ 
                Rail rail = new Rail(trajet.get(i)[0],trajet.get(i)[1]); 
                
        //RAIL HORIZONTAL        
                /*si le X de la case selectionnée est le meme que la case precedente alors placement rail horizontal*/ 
                if(this.getCase(trajet.get(i)[0],trajet.get(i)[1]) instanceof Ville == false && rail.getX()==trajet.get(i-1)[0]){
                this.avertirAllPlacementRailH(trajet.get(i)[0],trajet.get(i)[1], rail);
                rail.setTexture(rail.getRailH());
                rail.setTextureSelection(rail.getRailHSelection());
                map[rail.getX()][rail.getY()]=rail;
                }
        //RAIL VERTICAL        
                /*sinon si le Y de la case selectionnée est le meme que la case precedente alors placement rail vertical*/ 
                if(this.getCase(trajet.get(i)[0],trajet.get(i)[1]) instanceof Ville == false && rail.getY()==trajet.get(i-1)[1]){
                    this.avertirAllPlacementRailV(trajet.get(i)[0],trajet.get(i)[1], rail);
                    rail.setTexture(rail.getRailV());
                    rail.setTextureSelection(rail.getRailVSelection());
                    map[rail.getX()][rail.getY()]=rail;
                    }
                
        //RAIL VIRAGE1 
                /*Si la case n'est pas une ville et que nous somme a partir de la 3eme case*/  
                if( (i>=2) 
                        
                        /*X est plus petit que X de case-2 et Y est plus grand*/ 
                        && ((rail.getX()<trajet.get(i-2)[0] && rail.getY()>trajet.get(i-2)[1])|| 
                        /*X est plus grand et Y plus petit*/
                        (rail.getX()>trajet.get(i-2)[0] && rail.getY()<trajet.get(i-2)[1]) ))
                        
                {
                this.avertirAllPlacementRailVirage1(trajet.get(i-1)[0],trajet.get(i-1)[1], rail);
                rail.setTexture(rail.getRailVirage1());
                rail.setTextureSelection(rail.getRailVirage1Selection());
                map[rail.getX()][rail.getY()]=rail;
                }
                
        //RAIL VIRAGE 2
                /*Si la case n'est pas une ville et que nous somme a partir de la 3eme case*/  
                if(  (i>=2) 
                        
                        /*X et Y sont plus grand que X de case -2 */
                        && (rail.getX()>trajet.get(i-2)[0] && rail.getY()>trajet.get(i-2)[1] ||
                        /*X et Y sont plus petit que X de case -2 */
                        (rail.getX()<trajet.get(i-2)[0] && rail.getY()<trajet.get(i-2)[1]) ))                                
                {
                this.avertirAllPlacementRailVirage2(trajet.get(i-1)[0],trajet.get(i-1)[1], rail);
                rail.setTexture(rail.getRailVirage2());
                rail.setTextureSelection(rail.getRailVirage2Selection());
                map[rail.getX()][rail.getY()]=rail;
                
                }
  
        
        //RAIL VIRAGE 3
                /*Si la case n'est pas une ville et que nous somme a partir de la 3eme case*/  
                if(  (i>=2) 
                        
                        /*X et Y sont plus grand que X de case -2 */
                        && ( (rail.getX()>trajet.get(i-2)[0] && rail.getY()>trajet.get(i-2)[1]&& rail.getY()==trajet.get(i-1)[1]) ||
                        /*X et Y sont plus petit que X de case -2 */
                        (rail.getX()<trajet.get(i-2)[0] && rail.getY()<trajet.get(i-2)[1] && rail.getX()==trajet.get(i-1)[0]) )
                        )                                
                {
                this.avertirAllPlacementRailVirage3(trajet.get(i-1)[0],trajet.get(i-1)[1], rail);
                rail.setTexture(rail.getRailVirage3());
                rail.setTextureSelection(rail.getRailVirage3Selection());
                map[rail.getX()][rail.getY()]=rail;
                }
                 
        //RAIL VIRAGE4 
                /*Si la case n'est pas une ville et que nous somme a partir de la 3eme case*/  
                if( (i>=2) 
                        
                        /*X est plus petit que X de case-2 et Y est plus grand*/ 
                        && ((rail.getX()<trajet.get(i-2)[0] && rail.getY()>trajet.get(i-2)[1] && rail.getX()==trajet.get(i-1)[0] )|| 
                        /*X est plus grand et Y plus petit*/
                        (rail.getX()>trajet.get(i-2)[0] && rail.getY()<trajet.get(i-2)[1])&&  rail.getY()==trajet.get(i-1)[1]  ))
                        
                {
                this.avertirAllPlacementRailVirage4(trajet.get(i-1)[0],trajet.get(i-1)[1], rail);
                rail.setTexture(rail.getRailVirage4());
                rail.setTextureSelection(rail.getRailVirage4Selection());
                map[rail.getX()][rail.getY()]=rail;
                }     
             
            }
            
            for(Ville v : villes){
                v.setSelection(false);
                this.avertirAllObservateursSelectionVille(v.getX(), v.getY(), v);
            }
            trajet.clear();
            
        }
}
    


