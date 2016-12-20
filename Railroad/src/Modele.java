
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
    
    private ArrayList<Ville> villes = new ArrayList();
    private ArrayList<Rail> rails = new ArrayList();
    private ArrayList<Train> trains = new ArrayList();

    public Modele(){
 
        map=new Case[8][8];
        this.observateur=new ArrayList<>();
    }
    
    //GET SET

    public Case[][] getMap() {
        return map;
    }

    public void setMap(Case[][] map) {
        this.map = map;
    }
    
    public void setCaseTrain(int i, int j){
        ((Rail)map[i][j]).setTrain(true);
        
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
                
            for (Ville v : villes){
                System.out.println("ville :"+v.getX()+"/"+v.getY());
            }
            
            //Generer obstacle
            Obstacle o = new Obstacle(villes);
            System.out.println("obstacle :"+o.getX()+"/"+o.getY());
            Obstacle o1 = new Obstacle(villes);
            System.out.println("obstacle :"+o1.getX()+"/"+o.getY());
            Obstacle o2 = new Obstacle(villes);
            System.out.println("obstacle :"+o2.getX()+"/"+o.getY());
            Obstacle o3 = new Obstacle(villes);
            System.out.println("obstacle :"+o3.getX()+"/"+o.getY());
  
            
 
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
           /*BackgroundTask1 genererRessource = new BackgroundTask1(villes,trains, this);
            genererRessource.start();*/
            
            System.out.println("le programme fonctionne comme sur des roulettes");
            
           /*LigneItem I1halteretest = new LigneItem(fer,20);
           carcassonne.getStock().add(I1halteretest);*/
  
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
  
        public void avertirAllTrainTrue(int i, int j, Case c){
         for (Observateur o : this.observateur){
            o.avertirTrainTrue(i, j, c);
        }   
        }
        
        /* PLACER RAILS */
        public void placerRails(ArrayList<int[]> trajet){
            int c = 0;
            /*on parcoure l'arraylist trajet en ignorant 1er coordonées (ville)*/
            for (int i=1; i<=trajet.size()-1; i++){
 
                /*On rempli une liste de Rails avec les coordonnées des case selectionnées*/ 
                if (i!=trajet.size()-1){
                rails.add(c,new Rail(trajet.get(i)[0],trajet.get(i)[1])); 
                }
                
        //RAIL HORIZONTAL        
                //Si la case n'est pas une ville et si le X de la case selectionnée est le meme que la case precedente alors placement rail horizontal              
                if(this.getCase(trajet.get(i)[0],trajet.get(i)[1]) instanceof Ville == false && rails.get(c).getX()==trajet.get(i-1)[0]){
                    rails.get(c).setTexture(rails.get(c).getRailH());
                    rails.get(c).setTextureSelection(rails.get(c).getRailHSelection());
                
                    //placement de la case rail sur le modele map[][]
                    map[rails.get(c).getX()][rails.get(c).getY()]=rails.get(c);    
                
                    //changement du logo sur la frame
                    this.avertirAllChangementCase(rails.get(c).getX(),rails.get(c).getY(), rails.get(c));
                
                }
        //RAIL VERTICAL        
                //Si la case n'est pas une ville et si le Y de la case selectionnée est le meme que la case precedente alors placement rail vertical
                if(this.getCase(trajet.get(i)[0],trajet.get(i)[1]) instanceof Ville == false && rails.get(c).getY()==trajet.get(i-1)[1])
                {
                    rails.get(c).setTexture(rails.get(c).getRailV());
                    rails.get(c).setTextureSelection(rails.get(c).getRailVSelection());
                    map[rails.get(c).getX()][rails.get(c).getY()]=rails.get(c);
                    this.avertirAllChangementCase(rails.get(c).getX(),rails.get(c).getY(), rails.get(c));
  
                }
                
        //RAIL VIRAGE1 
                //Si la case n'est pas une ville et que nous somme a partir de la 3eme case
                if( (i>=2)
                        //X est plus petit que X de case-2 et Y est plus grand
                        && ((trajet.get(i)[0]<trajet.get(i-2)[0] && trajet.get(i)[1]>trajet.get(i-2)[1])|| 
                        //X est plus grand et Y plus petit
                        (trajet.get(i)[0]>trajet.get(i-2)[0] && trajet.get(i)[1]<trajet.get(i-2)[1]) ))                       
                {
                    rails.get(c-1).setTexture(rails.get(c-1).getRailVirage1());
                    rails.get(c-1).setTextureSelection(rails.get(c-1).getRailVirage1Selection());
                    map[rails.get(c-1).getX()][rails.get(c-1).getY()]=rails.get(c-1);
                    this.avertirAllChangementCase(rails.get(c-1).getX(),rails.get(c-1).getY(), rails.get(c-1));
                }
                
                
        //RAIL VIRAGE 2
                //Si la case n'est pas une ville et que nous somme a partir de la 3eme case
                if(  (i>=2) 
                        
                        //X et Y sont plus grand que X de case -2 
                        && (trajet.get(i)[0]>trajet.get(i-2)[0] && trajet.get(i)[1]>trajet.get(i-2)[1] ||
                        //X et Y sont plus petit que X de case -2 
                        (trajet.get(i)[0]<trajet.get(i-2)[0] && trajet.get(i)[1]<trajet.get(i-2)[1]) ))                                
                {
                rails.get(c-1).setTexture(rails.get(c-1).getRailVirage2());
                rails.get(c-1).setTextureSelection(rails.get(c-1).getRailVirage2Selection());
                map[rails.get(c-1).getX()][rails.get(c-1).getY()]=rails.get(c-1);
                this.avertirAllChangementCase(rails.get(c-1).getX(),rails.get(c-1).getY(), rails.get(c-1));
                }
  
        
        //RAIL VIRAGE 3
                //Si la case n'est pas une ville et que nous somme a partir de la 3eme case
                if(  (i>=2) 
                        
                        //X et Y sont plus grand que X de case -2 + verif case-1 pr separer de virage1
                        && ( (trajet.get(i)[0]>trajet.get(i-2)[0] && trajet.get(i)[1]>trajet.get(i-2)[1]&&  trajet.get(i)[1]==trajet.get(i-1)[1]) ||
                        //X et Y sont plus petit que X de case -2 
                        (trajet.get(i)[0]<trajet.get(i-2)[0] && trajet.get(i)[1]<trajet.get(i-2)[1] && trajet.get(i)[0]==trajet.get(i-1)[0]) )
                        )                                
                {
                rails.get(c-1).setTexture(rails.get(c-1).getRailVirage3());
                rails.get(c-1).setTextureSelection(rails.get(c-1).getRailVirage3Selection());
                map[rails.get(c-1).getX()][rails.get(c-1).getY()]=rails.get(c-1);
                this.avertirAllChangementCase(rails.get(c-1).getX(),rails.get(c-1).getY(), rails.get(c-1));
                }
                 
        //RAIL VIRAGE4 
                //Si la case n'est pas une ville et que nous somme a partir de la 3eme case
                if( ((this.getCase(trajet.get(i)[0],trajet.get(i)[1]) instanceof Ville == false && i>=2)) 
                        
                        //X est plus petit que X de case-2 et Y est plus grand + verif case-1 pr separer de virage1
                        && ((trajet.get(i)[0]<trajet.get(i-2)[0] && trajet.get(i)[1]>trajet.get(i-2)[1] && trajet.get(i)[0]==trajet.get(i-1)[0] )|| 
                        //X est plus grand et Y plus petit
                        (trajet.get(i)[0]>trajet.get(i-2)[0] && trajet.get(i)[1]<trajet.get(i-2)[1])&& trajet.get(i)[1]==trajet.get(i-1)[1]  ))
                        
                {
                rails.get(c-1).setTexture(rails.get(c-1).getRailVirage4());
                rails.get(c-1).setTextureSelection(rails.get(c-1).getRailVirage4Selection());
                map[rails.get(c-1).getX()][rails.get(c-1).getY()]=rails.get(c-1);
                this.avertirAllChangementCase(rails.get(c-1).getX(),rails.get(c-1).getY(), rails.get(c-1));
         
                } 
  
             //compteur pour l'arrayList rails
             c++;
            }
            
            //On deselectionne les villes
            for(Ville v : villes){
                v.setSelection(false);
                this.avertirAllObservateursSelectionVille(v.getX(), v.getY(), v);
            }
          
            
            //creation d'un train en fonction du trajet
            trains.add(new Train(trajet.get(1)[0],trajet.get(1)[1],trajet,((Ville)this.getCase(trajet.get(0)[0],trajet.get(0)[1])), ((Ville)this.getCase(trajet.get(0)[0],trajet.get(0)[1]))));
            
            //On nettoye le trajet apres cration du chemin de rails 
            trajet.clear();
            
            for(Rail r : rails){
                System.out.println("rail : "+r.getX()+"/"+r.getY());
            }
        }
           
        /*SUPPRIMER RAILS*/
        public void supprimerRails(ArrayList<int[]> trajet){
            
        }
}



