
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
public class Modele implements Serializable{
    private String nom;
    private Case[][] map;
    private  ArrayList<Observateur> observateur;
    transient ArrayList<Observateur> temp;
    private long point;
    private ArrayList<Ville> villes = new ArrayList();
    private ArrayList<Rail> rails = new ArrayList();
    private ArrayList<Train> trains = new ArrayList();    
    private transient BackgroundTask1 background = new BackgroundTask1(villes, this);
    private int nbTrain=0;
    private int nbVilles=0;
    private Ressource bois;
    private Ressource fer;
    private Ressource cereales;
    private Produit pistolet;
    private Produit whisky;
    
    ImageIcon beziersCity = new ImageIcon("./src/imgs/Texture 100x100/villeBeziersCity.png");
    ImageIcon beziersCitySelection = new ImageIcon("./src/imgs/Texture 100x100/villeBeziersCitySelection.png");
    ImageIcon agenCity = new ImageIcon("./src/imgs/Texture 100x100/villeAgenCity.png");
    ImageIcon agenCitySelection = new ImageIcon("./src/imgs/Texture 100x100/villeAgenCitySelection.png");
    ImageIcon carsonCity = new ImageIcon("./src/imgs/Texture 100x100/villeCarsonCity.png");
    ImageIcon carsonCitySelection = new ImageIcon("./src/imgs/Texture 100x100/villeCarsonCitySelection.png");
    ImageIcon tombstoneIcn = new ImageIcon("./src/imgs/Texture 100x100/villeTombstone.png");
    ImageIcon tombstoneSelection = new ImageIcon("./src/imgs/Texture 100x100/villeTombstoneSelection.png");
    ImageIcon hillValleyIcn = new ImageIcon("./src/imgs/Texture 100x100/villeHillValley.png");
    ImageIcon hillValleySelection = new ImageIcon("./src/imgs/Texture 100x100/villeHillValleySelection.png");
    ImageIcon santaFeIcn = new ImageIcon("./src/imgs/Texture 100x100/villeSantaFe.png");
    ImageIcon santaFeSelection = new ImageIcon("./src/imgs/Texture 100x100/villeSantaFeSelection.png");
    ImageIcon sanAntonioIcn = new ImageIcon("./src/imgs/Texture 100x100/villeSanAntonio.png");
    ImageIcon sanAntonioSelection = new ImageIcon("./src/imgs/Texture 100x100/villeSanAntonioSelection.png");


    
    public Modele(String s){
        
        map=new Case[7][7];
                for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                // init case
                Case c = new Case(i,j);
                map[i][j]=c;
            }
        }
        this.observateur=new ArrayList<>();
        this.nom=s;
        this.point=0;
        
        villes.add(new Ville(10,10,"villeFactice1",bois));
        villes.add(new Ville(10,10,"villeFactice2",bois));
        villes.add(new Ville(10,10,"villeFactice3",bois));
        villes.add(new Ville(10,10,"villeFactice4",bois));
        villes.add(new Ville(10,10,"villeFactice5",bois));

        
             //Creation des ressource          
            this.bois = new Ressource("bois",1);
            this.fer = new Ressource("fer",1);
            this.cereales = new Ressource("cereales",1);
        
            //ligneItem des differents produits       
            LigneItem I1pistolet = new LigneItem(fer,20);
            LigneItem I2pistolet = new LigneItem(bois,5);
            LigneItem I1whisky = new LigneItem(cereales,20);
            LigneItem I2whisky = new LigneItem(bois,5);
          
            //ArrayList de ligne item pour créer des produits
            ArrayList<LigneItem> fabricationPistolet =new ArrayList();
            ArrayList<LigneItem> fabricationWhisky =new ArrayList();        
            fabricationPistolet.add(I1pistolet);
            fabricationPistolet.add(I2pistolet);
            fabricationWhisky.add(I1whisky);
            fabricationWhisky.add(I2whisky);

            //Creation des produit          
            this.pistolet = new Produit("pistolet",100,fabricationPistolet);
            this.whisky = new Produit("whisky",100,fabricationWhisky);
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

    public ArrayList<Ville> getVilles() {
        return villes;
    }

    public void setVilles(ArrayList<Ville> villes) {
        this.villes = villes;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Rail> getRails() {
        return rails;
    }

    public void setRails(ArrayList<Rail> rails) {
        this.rails = rails;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public int getNbVilles() {
        return nbVilles;
    }

    public void setNbVilles(int nbVilles) {
        this.nbVilles = nbVilles;
    }
    
        //generer monde pour nouvelle partie
        public void  genererMonde() throws InterruptedException{
            
            //Creation des villes
        
            Ville beziers = new Ville("Beziers City",pistolet, villes);
            beziers.setTexture(beziersCity);
            beziers.setTextureSelection(beziersCitySelection);
            villes.set(0,beziers);
            
            Ville agen=new Ville("Agen City",whisky, villes);
            agen.setTexture(agenCity);
            agen.setTextureSelection(agenCitySelection);
            villes.set(1,agen);

            Ville tombstone = new Ville("Tombstone",bois, villes);
            tombstone.setTexture(tombstoneIcn);
            tombstone.setTextureSelection(tombstoneSelection);
            villes.set(2,tombstone);

            Ville hillValley = new Ville("Hill Valley",cereales, villes);
            hillValley.setTexture(hillValleyIcn);
            hillValley.setTextureSelection(hillValleySelection);
            villes.set(3,hillValley);
            
            Ville santaFe = new Ville("Sant Fe",fer,villes );
            santaFe.setTexture(santaFeIcn);
            santaFe.setTextureSelection(santaFeSelection);
            villes.set(4,santaFe);

    
            //placement des villes sur le modele et sur la vue
            map[beziers.getX()][beziers.getY()]=beziers;
            avertirAllChangementCase(beziers.getX(), beziers.getY(), beziers);
 
            map[agen.getX()][agen.getY()]=agen;
            avertirAllChangementCase(agen.getX(), agen.getY(), agen);
            
            map[tombstone.getX()][tombstone.getY()]=tombstone;
            avertirAllChangementCase(tombstone.getX(), tombstone.getY(), tombstone);
            
            map[hillValley.getX()][hillValley.getY()]=hillValley;
            avertirAllChangementCase(hillValley.getX(), hillValley.getY(), hillValley);
                        
            map[santaFe.getX()][santaFe.getY()]=santaFe;
            avertirAllChangementCase(santaFe.getX(), santaFe.getY(), santaFe);

            //Generer obstacles
            Obstacle o = new Obstacle(villes);
            System.out.println("obstacle :"+o.getX()+"/"+o.getY());
            Obstacle o1 = new Obstacle(villes);
            System.out.println("obstacle :"+o1.getX()+"/"+o.getY());
            Obstacle o2 = new Obstacle(villes);
            System.out.println("obstacle :"+o2.getX()+"/"+o.getY());
            Obstacle o3 = new Obstacle(villes);
            System.out.println("obstacle :"+o3.getX()+"/"+o.getY());
      
            //placement des obstacles sur le modele et la vue
            map[o.getX()][o.getY()]=o;
            avertirAllChangementCase(o.getX(), o.getY(), o);
            
            map[o1.getX()][o1.getY()]=o1;
            avertirAllChangementCase(o1.getX(), o1.getY(), o1);
            
            map[o2.getX()][o2.getY()]=o2;
            avertirAllChangementCase(o2.getX(), o2.getY(), o2);
            
            map[o3.getX()][o3.getY()]=o3;
            avertirAllChangementCase(o3.getX(), o3.getY(), o3);
            
            
            //LigneItem pour initialiser le stock des villes
            LigneItem boisItemTombstone = new LigneItem(bois,10);
            LigneItem ferItemTombstone = new LigneItem(fer,0);
            LigneItem cerealeItemTombstone = new LigneItem(cereales,0);
            
            
            LigneItem boisItemSantaFe = new LigneItem(bois,0);
            LigneItem ferItemSantaFe = new LigneItem(fer,10);
            LigneItem cerealeItemSantaFe = new LigneItem(cereales,0);
            
            
            LigneItem boisItemHillValley = new LigneItem(bois,0);
            LigneItem ferItemHillValley = new LigneItem(fer,0);
            LigneItem cerealesItemHillValley = new LigneItem(cereales,10);
            
            
            LigneItem boisItemBeziers = new LigneItem(bois,0);
            LigneItem ferItemBeziers= new LigneItem(fer,0);
            LigneItem cerealeItemBeziers = new LigneItem(cereales,0);
            LigneItem pistoletItem = new LigneItem(pistolet,0);
            
            LigneItem boisItemAgen = new LigneItem(bois, 0);
            LigneItem ferItemAgen = new LigneItem(fer, 0);
            LigneItem cerealeItemAgen = new LigneItem(cereales, 0);
            LigneItem whiskyItem=new LigneItem(whisky,0);
            
            tombstone.setStock(boisItemTombstone);
            tombstone.setStock(ferItemTombstone);
            tombstone.setStock(cerealeItemTombstone);
            
            santaFe.setStock(boisItemSantaFe);
            santaFe.setStock(ferItemSantaFe);
            santaFe.setStock(cerealeItemSantaFe);
            

            hillValley.setStock(boisItemHillValley);
            hillValley.setStock(ferItemHillValley);
            hillValley.setStock(cerealesItemHillValley);

            beziers.setStock(boisItemBeziers);
            beziers.setStock(ferItemBeziers);
            beziers.setStock(cerealeItemBeziers);
            beziers.setStock(pistoletItem);

            agen.setStock(boisItemAgen);
            agen.setStock(ferItemAgen);
            agen.setStock(cerealeItemAgen);
            agen.setStock(whiskyItem);
           
          
            avertirAllCreationRessource();
            //Lancement script de generation de ressources
            background.start();

  
        }
        //Methode pour jouer à partir de l'éditeur
        public void jouer(){
            
             //initialisation des stock des villes 
            LigneItem boisItemTombstone = new LigneItem(bois,10);
            LigneItem ferItemTombstone = new LigneItem(fer,0);
            LigneItem cerealeItemTombstone = new LigneItem(cereales,0);
            
            
            LigneItem boisItemSantaFe = new LigneItem(bois,0);
            LigneItem ferItemSantaFe = new LigneItem(fer,10);
            LigneItem cerealeItemSantaFe = new LigneItem(cereales,0);
            
            
            LigneItem boisItemHillValley = new LigneItem(bois,0);
            LigneItem ferItemHillValley = new LigneItem(fer,0);
            LigneItem cerealesItemHillValley = new LigneItem(cereales,10);
            
            
            LigneItem boisItemBeziers = new LigneItem(bois,0);
            LigneItem ferItemBeziers= new LigneItem(fer,0);
            LigneItem cerealeItemBeziers = new LigneItem(cereales,0);
            LigneItem pistoletItem = new LigneItem(pistolet,0);
            
            LigneItem boisItemAgen = new LigneItem(bois, 0);
            LigneItem ferItemAgen = new LigneItem(fer, 0);
            LigneItem cerealeItemAgen = new LigneItem(cereales, 0);
            LigneItem whiskyItem=new LigneItem(whisky,0);
            
            villes.get(2).setStock(boisItemTombstone);
            villes.get(2).setStock(ferItemTombstone);
            villes.get(2).setStock(cerealeItemTombstone);
            
            villes.get(4).setStock(boisItemSantaFe);
            villes.get(4).setStock(ferItemSantaFe);
            villes.get(4).setStock(cerealeItemSantaFe);
            

            villes.get(3).setStock(boisItemHillValley);
            villes.get(3).setStock(ferItemHillValley);
            villes.get(3).setStock(cerealesItemHillValley);
            
            villes.get(0).setStock(boisItemBeziers);
            villes.get(0).setStock(ferItemBeziers);
            villes.get(0).setStock(cerealeItemBeziers);
            villes.get(0).setStock(pistoletItem);
           
            villes.get(1).setStock(boisItemAgen);
            villes.get(1).setStock(ferItemAgen);
            villes.get(1).setStock(cerealeItemAgen);
            villes.get(1).setStock(whiskyItem);
           
          
            avertirAllCreationRessource();
            background.start();

  
        }
        //ajouter un observateur
        public void register(Observateur o){
        observateur.add(o);
    }
        //supprimer un observateur
        public void unregister(Observateur o){
        observateur.remove(o);
    }
        //changement d'une case    
        public void avertirAllChangementCase(int i, int j, Case c){
            for (Observateur o : this.observateur){
            o.avertirChangementCase(i, j,c);            
        }
        }
        //Selection d'une case
        public void avertirAllSelection(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirSelection(i, j, c);
        }
        }
        //Deselection d'une case
        public void avertirAllDeselection(int i, int j, Case c){
        for (Observateur o : this.observateur){
            o.avertirDeselection(i, j, c);
        }
        }
        //train sur une case
        public void avertirAllTrainTrue(int i, int j, Case c){
         for (Observateur o : this.observateur){
            o.avertirTrainTrue(i, j, c);
        }   
        }
        //train n'est plus sur une case
        public void avertirAllTrainFalse(int i, int j, Case c){
            for (Observateur o : this.observateur){
            o.avertirTrainFalse(i, j, c);
        }   
        }
        //creation d'une ressource
        public void avertirAllCreationRessource(){
            for (Observateur o : this.observateur){
                o.avertirCreationRessource();
        }  
        }
        //rafraichir la map pour remettre les bonnes textures apres chargement d'une partie
        public void avertirAllRafraichir(){
                        for (Observateur o : this.observateur){
                o.rafraichir();
        }  
        }
        //afficher une info
        public void avertirAllInformations(String s){
                        for (Observateur o : this.observateur){
                o.avertirInformation(s);
        }  
        }
        
        /* PLACER RAILS */
        public synchronized void placerRails(ArrayList<int[]> trajet) throws InterruptedException{
        //Si trajet n'est pas vide 
        if (trajet.isEmpty()==false){
        //si la premiere et derniere case du trajet sont des villes    
        if(this.getCase(trajet.get(0)[0],trajet.get(0)[1]) instanceof Ville && this.getCase(trajet.get(trajet.size()-1)[0],trajet.get(trajet.size()-1)[1]) instanceof Ville){
            
             int c = 0;
            /*on parcoure l'arraylist trajet en ignorant 1er coordonées (ville)*/
            for (int i=1; i<=trajet.size()-1; i++){
 
                /*On rempli une liste de Rails avec les coordonnées des cases selectionnées*/ 
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
                //Si  nous somme a partir de la 3eme case
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
                //Si nous somme a partir de la 3eme case
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
                //Si nous somme a partir de la 3eme case
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
                //Si nous somme a partir de la 3eme case
                if( ((i>=2)) 
                        
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
               this.avertirAllDeselection(v.getX(), v.getY(), v);
            }

            
            //creation d'un train en fonction du trajet.
            synchronized(trains) {
            trains.add(new Train(nbTrain, trajet.get(1)[0],trajet.get(1)[1],trajet,((Ville)this.getCase(trajet.get(0)[0],trajet.get(0)[1])), ((Ville)this.getCase(trajet.get(trajet.size()-1)[0],trajet.get(trajet.size()-1)[1])),trains));
            
            BackgroundTaskTrain bg = new BackgroundTaskTrain(trains.get((int)nbTrain),this);
            
            trains.get(nbTrain).setThd(bg);
            nbTrain++;
            bg.start();
            }
            //On nettoye le trajet apres cration du chemin de rails 
            trajet.clear();
            
        }  
            else {
                System.out.println("Attention le depart et l'arrivée doivent etre une ville");
                avertirAllInformations("Attention le depart et l'arrivée doivent etre une ville");
                
                for(int[] i : trajet){
                    map[i[0]][i[1]].setSelection(false);
                    avertirAllDeselection(i[0], i[1], this.getCase(i[0],i[1]));
                }
                trajet.clear();
   
            }
        }
        
        }
           
        /*SUPPRIMER RAILS*/
        public void supprimerRails(ArrayList<int[]> trajet){
           
            for(int[] t : trajet){
                if(map[t[0]][t[1]] instanceof Rail){
                Case c = new Case(t[0],t[1]);
                map[t[0]][t[1]]=c;
                this.avertirAllChangementCase(c.getX(), c.getY(), c);   
                }

                
            }
            trajet.clear();
        }
        
        /*SAUVEGARDER*/
        public void sauvegarder(String s) throws IOException, InterruptedException{
            temp=new ArrayList(observateur);
            FileOutputStream f = new FileOutputStream(new File("./src/save/"+this.nom+s));
            observateur.clear();
       
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(this);
            oos.close();
            for (Observateur o : temp){
                observateur.add(o);
            }

            avertirAllInformations("Monde Sauvegardé !");
        }
        /*CHARGER*/
        public void charger(String s) throws FileNotFoundException, IOException, ClassNotFoundException{
            //on charge le modele en fonction du nom et de l'emplacement
            temp.clear();

            Modele m = new Modele(this.nom);
            FileInputStream f = new FileInputStream(new File("./src/save/"+this.nom+s));
        try (ObjectInputStream oos = new ObjectInputStream(f)) {
            m = (Modele)oos.readObject();
        }
            
            //m.register(o);
            avertirAllRafraichir();
            this.textuel();
            System.out.println("monde chargé");
        }
        /*AFFICHER LA MAP DANS LA CONSOLE*/
        public void textuel(){
           System.out.println("textuel :");
   
               System.out.println(this.map[0][0].toString()+this.map[0][1].toString()+this.map[0][2].toString()+this.map[0][3].toString()
               +this.map[0][4].toString()+this.map[0][5].toString()+this.map[0][6].toString());
               
               System.out.println(this.map[1][0].toString()+this.map[1][1].toString()+this.map[1][2].toString()+this.map[1][3].toString()                      
               +this.map[1][4].toString()+this.map[1][5].toString()+this.map[1][6].toString());
               
               System.out.println(this.map[2][0].toString()+this.map[2][1].toString()+this.map[2][2].toString()+this.map[2][3].toString()                     
               +this.map[2][4].toString()+this.map[2][5].toString()+this.map[2][6].toString());
               
               
               System.out.println(this.map[3][0].toString()+this.map[3][1].toString()+this.map[3][2].toString()+this.map[3][3].toString()
               +this.map[3][4].toString()+this.map[3][5].toString()+this.map[3][6].toString());
               
               System.out.println(this.map[4][0].toString()+this.map[4][1].toString()+this.map[4][2].toString()+this.map[4][3].toString()
               +this.map[4][4].toString()+this.map[4][5].toString()+this.map[4][6].toString());
               
               System.out.println(this.map[5][0].toString()+this.map[5][1].toString()+this.map[5][2].toString()+this.map[5][3].toString()
               +this.map[5][4].toString()+this.map[5][5].toString()+this.map[5][6].toString());
               
                System.out.println(this.map[6][0].toString()+this.map[6][1].toString()+this.map[6][2].toString()+this.map[6][3].toString()
               +this.map[6][4].toString()+this.map[6][5].toString()+this.map[6][6].toString());
               

               
              System.out.println("case 01 coordonnées: " + map[0][1].getX()+map[0][1].getY());
              System.out.println("case 02 coordonnées: " + map[0][2].getX()+map[0][2].getY());
              System.out.println("case 03 coordonnées: " + map[0][3].getX()+map[0][3].getY());
              System.out.println("case 04 coordonnées: " + map[0][4].getX()+map[0][4].getY());
              System.out.println("case 23 coordonnées: " + map[2][3].getX()+map[2][3].getY());
           

        }
        /*PLACER VILLE*/
        public void PlacerVille(ArrayList<int[]> t, int ville){
            boolean resultat=false;
            //Si la case selectionnée n'est pas deja une ville ou un obstacle
            if (this.getCase(t.get(0)[0], t.get(0)[1]) instanceof Ville == false && this.getCase(t.get(0)[0], t.get(0)[1]) instanceof Obstacle == false){
                //Switch en fonction du numero de ville
                switch (ville)
                {
                case 0:
                    Ville beziers = new Ville(t.get(0)[0],t.get(0)[1],"Beziers City",pistolet);
                    beziers.setTexture(beziersCity);
                    beziers.setTextureSelection(beziersCitySelection);
                    villes.set(ville,beziers);              
                    map[beziers.getX()][beziers.getY()]=beziers;
                    avertirAllChangementCase(beziers.getX(), beziers.getY(), beziers);
                    nbVilles++;

                break;

                case 1:
                    Ville agen = new Ville(t.get(0)[0],t.get(0)[1],"Agen City",whisky);
                    agen.setTexture(agenCity);
                    agen.setTextureSelection(agenCitySelection);
                    villes.set(ville, agen);
                    map[agen.getX()][agen.getY()]=agen;
                    avertirAllChangementCase(agen.getX(), agen.getY(), agen);
                    nbVilles++;
                break;

                case 2:
                    Ville tombstone = new Ville(t.get(0)[0],t.get(0)[1],"Tombstone",bois);
                    tombstone.setTexture(tombstoneIcn);
                    tombstone.setTextureSelection(tombstoneSelection);
                    villes.set(ville, tombstone);
                    map[tombstone.getX()][tombstone.getY()]=tombstone;
                    avertirAllChangementCase(tombstone.getX(), tombstone.getY(), tombstone);
                    nbVilles++;
                break;

                case 3:
                    Ville hillvalley = new Ville(t.get(0)[0],t.get(0)[1],"hillvalley",cereales);
                    hillvalley.setTexture(hillValleyIcn);
                    hillvalley.setTextureSelection(hillValleySelection);
                    villes.set(ville, hillvalley);
                    map[hillvalley.getX()][hillvalley.getY()]=hillvalley;
                    avertirAllChangementCase(hillvalley.getX(), hillvalley.getY(), hillvalley);
                    nbVilles++;
                break;

                case 4:
                    Ville santafe = new Ville(t.get(0)[0],t.get(0)[1],"santafe",fer);
                    santafe.setTexture(santaFeIcn);
                    santafe.setTextureSelection(santaFeSelection);
                    villes.set(ville, santafe);
                    map[santafe.getX()][santafe.getY()]=santafe;
                    avertirAllChangementCase(santafe.getX(), santafe.getY(), santafe);
                    nbVilles++;
                break;

                } 
               }
           else {
               
               avertirAllInformations("Attention vous ne pouvez placer des elements que sur des cases libres");
           }
          
       }
        /*PLACER OBSTACLE*/
        public void PlacerObstacle(ArrayList<int[]> t){
            if (this.getCase(t.get(0)[0], t.get(0)[1]) instanceof Ville == false && this.getCase(t.get(0)[0], t.get(0)[1]) instanceof Obstacle == false){
                Obstacle o = new Obstacle(t.get(0)[0], t.get(0)[1]);
                map[t.get(0)[0]][t.get(0)[1]]=o;
                avertirAllChangementCase(t.get(0)[0], t.get(0)[1], o);
            }
            else avertirAllInformations("Attention vous ne pouvez placer des elements que sur des cases libres");
        }
}
    



