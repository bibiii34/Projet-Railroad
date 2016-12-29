
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
    private ArrayList<Produit> production;
    private  ArrayList<Observateur> observateur;
    transient ArrayList<Observateur> temp;
    private long point;
    
    private ArrayList<Ville> villes = new ArrayList();
    private ArrayList<Rail> rails = new ArrayList();
    private ArrayList<Train> trains = new ArrayList();
    
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
    
    BackgroundTask1 background = new BackgroundTask1(villes, this);
    int nbTrain=0;
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
    
    
    
    
    
        public void  genererMonde() throws InterruptedException{
            
            //Creation des ressource          
            Ressource bois = new Ressource("bois",1);
            Ressource fer = new Ressource("fer",1);
            Ressource cereales = new Ressource("cereales",1);
            Ressource cuir = new Ressource("cuir",1);
            
            //ligneItem des different produit       
            LigneItem I1pistolet = new LigneItem(fer,5);
            LigneItem I2pistolet = new LigneItem(bois,1);
            LigneItem I1whisky = new LigneItem(cereales,100);
            LigneItem I2whisky = new LigneItem(bois,30);
            LigneItem I1bottes = new LigneItem(cuir,20);
            LigneItem I2bottes = new LigneItem(bois,5);
            
            
            
            //ArayList de ligne item pour crée des produit
            ArrayList<LigneItem> fabricationPistolet =new ArrayList();
            ArrayList<LigneItem> fabricationWhisky =new ArrayList(); 
            ArrayList<LigneItem> fabricationBottes=new ArrayList();
           
            fabricationPistolet.add(I1pistolet);
            fabricationPistolet.add(I2pistolet);
            fabricationWhisky.add(I1whisky);
            fabricationWhisky.add(I2whisky);
            fabricationBottes.add(I1bottes);
            fabricationBottes.add(I2bottes);
            
            
            //Creation des produit          
            Produit pistolet = new Produit("pistolet",100,fabricationPistolet);
            Produit whisky = new Produit("whisky",100,fabricationWhisky);
            Produit bottes = new Produit("bottes",100,fabricationBottes);
            
            //Creation ville
            
            
            Ville beziers = new Ville("Beziers City",pistolet, villes);
            beziers.setTexture(beziersCity);
            beziers.setTextureSelection(beziersCitySelection);
            villes.add(beziers);
            
            Ville agen=new Ville("Agen City",whisky, villes);
            agen.setTexture(agenCity);
            agen.setTextureSelection(agenCitySelection);
            villes.add(agen);
            
            //Ville carson = new Ville("Carson City",bottes, villes);
            //carson.setTexture(carsonCity);
            //carson.setTextureSelection(carsonCitySelection);
            //villes.add(carson);
            
            Ville tombstone = new Ville("Tombstone",bois, villes);
            tombstone.setTexture(tombstoneIcn);
            tombstone.setTextureSelection(tombstoneSelection);
            villes.add(tombstone);
            

            Ville hillValley = new Ville("Hill Valley",cereales, villes);
            hillValley.setTexture(hillValleyIcn);
            hillValley.setTextureSelection(hillValleySelection);
            villes.add(hillValley);
            
            Ville santaFe = new Ville("Sant Fe",fer,villes );
            santaFe.setTexture(santaFeIcn);
            santaFe.setTextureSelection(santaFeSelection);
            villes.add(santaFe);

           // Ville sanAntonio = new Ville("San Antonio",cuir,villes);
            //sanAntonio.setTexture(sanAntonioIcn);
           // sanAntonio.setTextureSelection(sanAntonioSelection);
           // villes.add(sanAntonio);
            
            
            //placement des villes sur le modele et sur la vue
            map[beziers.getX()][beziers.getY()]=beziers;
            avertirAllChangementCase(beziers.getX(), beziers.getY(), beziers);
 
            map[agen.getX()][agen.getY()]=agen;
            avertirAllChangementCase(agen.getX(), agen.getY(), agen);
            
           // map[carson.getX()][carson.getY()]=carson;
            //avertirAllChangementCase(carson.getX(), carson.getY(), carson);
            
            map[tombstone.getX()][tombstone.getY()]=tombstone;
            avertirAllChangementCase(tombstone.getX(), tombstone.getY(), tombstone);
            
            map[hillValley.getX()][hillValley.getY()]=hillValley;
            avertirAllChangementCase(hillValley.getX(), hillValley.getY(), hillValley);
                        
            map[santaFe.getX()][santaFe.getY()]=santaFe;
            avertirAllChangementCase(santaFe.getX(), santaFe.getY(), santaFe);
            
            //map[sanAntonio.getX()][sanAntonio.getY()]=sanAntonio;
            //avertirAllChangementCase(sanAntonio.getX(), sanAntonio.getY(), sanAntonio);
                
            
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
            tombstone.genererPremiereRessource(tombstone.getItem());
            hillValley.genererPremiereRessource(hillValley.getItem());
            santaFe.genererPremiereRessource(santaFe.getItem());
           // sanAntonio.genererPremiereRessource(sanAntonio.getItem());
            
            
            //LigneItem pour initialiser le stock
            LigneItem ferItemTombstone = new LigneItem(fer,0);
            LigneItem cerealeItemTombstone = new LigneItem(cereales,0);
            LigneItem cuirItemTombstone = new LigneItem(cuir,0);
            
            LigneItem boisItemSantaFe = new LigneItem(bois,0);
            LigneItem cerealeItemSantaFe = new LigneItem(cereales,0);
            LigneItem cuirItemSantaFe = new LigneItem(cuir,0);
            
            LigneItem boisItemHillValley = new LigneItem(bois,0);
            LigneItem ferItemHillValley = new LigneItem(fer,0);
            LigneItem cuirItemHillValley = new LigneItem(cuir,0);
            
            LigneItem boisItemBeziers = new LigneItem(bois,0);
            LigneItem ferItemBeziers= new LigneItem(fer,0);
            LigneItem cerealeItemBeziers = new LigneItem(cereales,0);
            
            
            tombstone.setStock(ferItemTombstone);
            tombstone.setStock(cerealeItemTombstone);
            tombstone.setStock(cuirItemTombstone);
            
            santaFe.setStock(boisItemSantaFe);
            santaFe.setStock(cerealeItemSantaFe);
            santaFe.setStock(cuirItemSantaFe);

            hillValley.setStock(boisItemHillValley);
            hillValley.setStock(ferItemHillValley);
            hillValley.setStock(cuirItemHillValley);
            
           beziers.setStock(boisItemBeziers);
           beziers.setStock(ferItemBeziers);
           beziers.setStock(cerealeItemBeziers);

            
          /*  System.out.println("Limoges: "+limoges.getStock().get(0).getItem().getNom()+limoges.getStock().get(0).getQuantite());
            System.out.println("Limoges: "+limoges.getStock().get(1).getItem().getNom()+limoges.getStock().get(1).getQuantite());
            System.out.println("Limoges: "+limoges.getStock().get(2).getItem().getNom()+limoges.getStock().get(2).getQuantite());
            
           
            System.out.println("Toulouse: "+toulouse.getStock().get(0).getItem().getNom()+toulouse.getStock().get(0).getQuantite());
            System.out.println("Toulouse: "+toulouse.getStock().get(1).getItem().getNom()+toulouse.getStock().get(1).getQuantite());
            System.out.println("Toulouse: "+toulouse.getStock().get(2).getItem().getNom()+toulouse.getStock().get(2).getQuantite());
            
            System.out.println("Servian: "+servian.getStock().get(0).getItem().getNom()+servian.getStock().get(0).getQuantite());
            System.out.println("Servian: "+servian.getStock().get(1).getItem().getNom()+servian.getStock().get(1).getQuantite());
            System.out.println("Servian: "+servian.getStock().get(2).getItem().getNom()+servian.getStock().get(2).getQuantite());
            */
          
            avertirAllCreationRessource();

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
        
        public void avertirAllCreationRessource(){
            for (Observateur o : this.observateur){
                o.avertirCreationRessource();
        }  
        }
        
        public void avertirAllRafraichir(){
                        for (Observateur o : this.observateur){
                o.rafraichir();
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
        
    
        public void sauvegarder(String s) throws IOException{
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
        
        public void charger(String s) throws FileNotFoundException, IOException, ClassNotFoundException{
            //on charge le modele en fonction du nom et de l'emplacement
            temp.clear();

            Modele m = new Modele(this.nom);
            FileInputStream f = new FileInputStream(new File("./src/save/"+this.nom+s));
        try (ObjectInputStream oos = new ObjectInputStream(f)) {
            m = (Modele)oos.readObject();
        }
            
            m.register(o);
            avertirAllRafraichir();
            this.textuel();
            System.out.println("monde chargé");
        }
        
        
        
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
}



