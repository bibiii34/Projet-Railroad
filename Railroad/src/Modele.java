
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
    
    public ArrayList<Ville> villes = new ArrayList();
    private ArrayList<Rail> rails = new ArrayList();
    private ArrayList<Train> trains = new ArrayList();
    BackgroundTask1 background = new BackgroundTask1(villes,trains, this);
    int nbTrain=0;
    public Modele(){
 
        map=new Case[7][7];
                for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                // init case
                Case c = new Case(i,j);
                map[i][j]=c;
            }
        }
        this.observateur=new ArrayList<>();
    }
    
    //GET SET

    public Case[][] getMap() {
        return map;
    }

    public void setMap(Case[][] map) {
        this.map = map;
    }
    
    public void setCaseTrainTrue(int i, int j){
        if (map[i][j] instanceof Rail==false){
            System.out.println("Attention accident de Train");
        }
        else((Rail)map[i][j]).setTrain(true);
    }
        public void setCaseTrainFalse(int i, int j){
        ((Rail)map[i][j]).setTrain(false);
    }

        public Case getCase(int x, int y){
            return map[x][y];
        }
    
        public void  genererMonde() throws InterruptedException{
            
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
            ImageIcon villeLimoge = new ImageIcon("./src/imgs/Texture 100x100/villeLimoges.png");
            Ville limoges=new Ville("Limoges",lait, villes);
            limoges.setTexture(villeLimoge);
            villes.add(limoges);
            
            Ville toulouse = new Ville("toulouse",fer, villes);
            villes.add(toulouse);
            
            Ville servian = new Ville("servian",plastique, villes);
            villes.add(servian);
            
            Ville beziers = new Ville("Bezier",proteine, villes);
            villes.add(beziers);

            Ville carcassonne = new Ville("carcassonne",haltere, villes);
            villes.add(carcassonne);
            Ville agen = new Ville("agen",shaker,villes );
            villes.add(agen);


            
            //placement des villes sur le modele et sur la vue
            map[limoges.getX()][limoges.getY()]=limoges;
            avertirAllChangementCase(limoges.getX(), limoges.getY(), limoges);
            
           //map[beziers.getX()][beziers.getY()]=beziers;
            //avertirAllChangementCase(beziers.getX(), beziers.getY(), beziers);
            
            map[toulouse.getX()][toulouse.getY()]=toulouse;
            avertirAllChangementCase(toulouse.getX(), toulouse.getY(), toulouse);
            
            map[servian.getX()][servian.getY()]=servian;
            avertirAllChangementCase(servian.getX(), servian.getY(), servian);
            
            /*map[carcassonne.getX()][carcassonne.getY()]=carcassonne;
            avertirAllChangementCase(carcassonne.getX(), carcassonne.getY(), carcassonne);
            
            map[agen.getX()][agen.getY()]=agen;
            avertirAllChangementCase(agen.getX(), agen.getY(), agen);*/
                
            
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
            
            
            //LigneItem pour initialiser le stock
            
            LigneItem laitItemToulouse = new LigneItem(lait,0);
            LigneItem laitItemServian = new LigneItem(lait,0);
            
            LigneItem ferItemLimoges = new LigneItem(fer,0);
            LigneItem ferItemServian = new LigneItem(fer,0);
            
            
            LigneItem plasitqueItemLimoges = new LigneItem(plastique,0);
             LigneItem plasitqueItemToulouse = new LigneItem(plastique,0);
            
            limoges.setStock(ferItemLimoges);
            limoges.setStock(plasitqueItemLimoges);
            
            toulouse.setStock(laitItemToulouse);
            toulouse.setStock(plasitqueItemToulouse);
            
            servian.setStock(ferItemServian);
            servian.setStock(laitItemServian);
            

            
            
            
            
            
            
             //avertieAllCreationRessource();
            
            System.out.println("Limoges: "+limoges.getStock().get(0).getItem().getNom()+limoges.getStock().get(0).getQuantite());
            System.out.println("Limoges: "+limoges.getStock().get(1).getItem().getNom()+limoges.getStock().get(1).getQuantite());
            System.out.println("Limoges: "+limoges.getStock().get(2).getItem().getNom()+limoges.getStock().get(2).getQuantite());
            
           
            System.out.println("Toulouse: "+toulouse.getStock().get(0).getItem().getNom()+toulouse.getStock().get(0).getQuantite());
            System.out.println("Toulouse: "+toulouse.getStock().get(1).getItem().getNom()+toulouse.getStock().get(1).getQuantite());
            System.out.println("Toulouse: "+toulouse.getStock().get(2).getItem().getNom()+toulouse.getStock().get(2).getQuantite());
            
            System.out.println("Servian: "+servian.getStock().get(0).getItem().getNom()+servian.getStock().get(0).getQuantite());
            System.out.println("Servian: "+servian.getStock().get(1).getItem().getNom()+servian.getStock().get(1).getQuantite());
            System.out.println("Servian: "+servian.getStock().get(2).getItem().getNom()+servian.getStock().get(2).getQuantite());
            
            avertieAllCreationRessource();

            for(Ville v:villes){
                System.out.println(v.getNom());
            }
            
            
            //Lancer tache generer ressource ville
            background.start();
            
            //this.textuel();
            
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
        
        public void avertirAllObservateursSelection(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirSelection(i, j, c);
        }
        }
        
        public void avertirAllObservateursDeselection(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirDeselection(i, j, c);
        }
        }
        
  
        public void avertirAllTrainTrue(int i, int j, Case c){
         for (Observateur o : this.observateur){
            o.avertirTrainTrue(i, j, c);
        }   
        }
        
        public void avertirAllTrainFalse(int i, int j, Case c){
            for (Observateur o : this.observateur){
            o.avertirTrainFalse(i, j, c);
        }   
        }
        
        public void avertieAllCreationRessource(){
            for (Observateur o : this.observateur){
                o.avertirCreationRessource();
        }  
        }
        
        public void avertirAllInformations(String s){
                        for (Observateur o : this.observateur){
                o.avertirInformation(s);
        }  
        }
        /* PLACER RAILS */
        public synchronized void placerRails(ArrayList<int[]> trajet) throws InterruptedException{
        if (trajet.isEmpty()==false){
        if(this.getCase(trajet.get(0)[0],trajet.get(0)[1]) instanceof Ville && this.getCase(trajet.get(trajet.size()-1)[0],trajet.get(trajet.size()-1)[1]) instanceof Ville){
            
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
                    rails.get(c).setTextureTrain(rails.get(c).getRailHTrain());
                
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
                    rails.get(c).setTextureTrain(rails.get(c).getRailVTrain());
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
                    rails.get(c-1).setTextureTrain(rails.get(c-1).getRailVirage1Train());
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
                rails.get(c-1).setTextureTrain(rails.get(c-1).getRailVirage2Train());
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
                rails.get(c-1).setTextureTrain(rails.get(c-1).getRailVirage3Train());
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
                rails.get(c-1).setTextureTrain(rails.get(c-1).getRailVirage4Train());
                map[rails.get(c-1).getX()][rails.get(c-1).getY()]=rails.get(c-1);
                this.avertirAllChangementCase(rails.get(c-1).getX(),rails.get(c-1).getY(), rails.get(c-1));
         
                } 
  
             //compteur pour l'arrayList rails
             c++;
            }
            
            //On deselectionne les villes
            for(Ville v : villes){
                v.setSelection(false);
               this.avertirAllObservateursDeselection(v.getX(), v.getY(), v);
            }
 
            
            //creation d'un train en fonction du trajet.
            synchronized(trains) {
            trains.add(new Train(trajet.get(1)[0],trajet.get(1)[1],trajet,((Ville)this.getCase(trajet.get(0)[0],trajet.get(0)[1])), ((Ville)this.getCase(trajet.get(trajet.size()-1)[0],trajet.get(trajet.size()-1)[1]))));
            
            BackgroundTaskTrain bg = new BackgroundTaskTrain(trains.get((int)nbTrain),this);
            
            trains.get(nbTrain).setThd(bg);
            nbTrain++;
            bg.start();
            }
            //On nettoye le trajet apres cration du chemin de rails 
            trajet.clear();
            
        }    
        }
        
        else {
            System.out.println("Attention le depart et l'arrivée doivent etre une ville");
            avertirAllInformations("Attention le depart et l'arrivée doivent etre une ville");
            for (int i =0 ; i<7;i++){
                for (int j=0 ; i<7;i++){
                    map[i][j].setSelection(false);
                    this.avertirAllObservateursDeselection(i, j, this.getCase(i, j));
                }
            }
        }

        }
           
        /*SUPPRIMER RAILS*/
        public void supprimerRails(ArrayList<int[]> trajet){
            for(int[] t : trajet){
                Case c = new Case(t[0],t[1]);
                map[t[0]][t[1]]=c;
                this.avertirAllChangementCase(c.getX(), c.getY(), c);
                
            }
        }
        
    
       public void textuel(){
           System.out.println("textuel :");
   
               System.out.println(this.map[0][0].toString()+this.map[0][1].toString()+this.map[0][2].toString()+this.map[0][3].toString()
               +this.map[0][4].toString()+this.map[0][5].toString()+this.map[0][6].toString()+this.map[0][7].toString());
               
               System.out.println(this.map[1][0].toString()+this.map[1][1].toString()+this.map[1][2].toString()+this.map[1][3].toString()                      
               +this.map[1][4].toString()+this.map[1][5].toString()+this.map[1][6].toString()+this.map[1][7].toString());
               
               System.out.println(this.map[2][0].toString()+this.map[2][1].toString()+this.map[2][2].toString()+this.map[2][3].toString()                     
               +this.map[2][4].toString()+this.map[2][5].toString()+this.map[2][6].toString()+this.map[2][7].toString());
               
               
               System.out.println(this.map[3][0].toString()+this.map[3][1].toString()+this.map[3][2].toString()+this.map[3][3].toString()
               +this.map[3][4].toString()+this.map[3][5].toString()+this.map[3][6].toString()+this.map[3][7].toString());
               
               System.out.println(this.map[4][0].toString()+this.map[4][1].toString()+this.map[4][2].toString()+this.map[4][3].toString()
               +this.map[4][4].toString()+this.map[4][5].toString()+this.map[4][6].toString()+this.map[4][7].toString());
               
               System.out.println(this.map[5][0].toString()+this.map[5][1].toString()+this.map[5][2].toString()+this.map[5][3].toString()
               +this.map[5][4].toString()+this.map[5][5].toString()+this.map[5][6].toString()+this.map[5][7].toString());
               
                System.out.println(this.map[6][0].toString()+this.map[6][1].toString()+this.map[6][2].toString()+this.map[6][3].toString()
               +this.map[6][4].toString()+this.map[6][5].toString()+this.map[6][6].toString()+this.map[6][7].toString());
               
               System.out.println(this.map[7][0].toString()+this.map[7][1].toString()+this.map[7][2].toString()+this.map[7][3].toString()
               +this.map[7][4].toString()+this.map[7][5].toString()+this.map[7][6].toString()+this.map[7][7].toString());
               

               
              System.out.println("case 01 coordonnées: " + map[0][1].getX()+map[0][1].getY());
              System.out.println("case 02 coordonnées: " + map[0][2].getX()+map[0][2].getY());
              System.out.println("case 03 coordonnées: " + map[0][3].getX()+map[0][3].getY());
              System.out.println("case 04 coordonnées: " + map[0][4].getX()+map[0][4].getY());
              System.out.println("case 23 coordonnées: " + map[2][3].getX()+map[2][3].getY());
           

        }
}



