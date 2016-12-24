
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
public class Train {
    private int x;
    private int y;
    private ArrayList<int[]> trajet;
    private  ArrayList<Ressource> stock;
    private Ville depart;
    private Ville arrivee;
    int random = (int)(Math.random() * ((5 - 0) + 1));
    
    //Constructeurs  
    public Train(int x, int y, ArrayList<int[]> trajet, Ville d, Ville a){
        this.x=x;
        this.y=y;
        //image train
        this.trajet=new ArrayList(trajet);
        this.stock=new ArrayList();
        this.depart=d;
        this.arrivee=a;
 
    }

     //Accesseur 
    public ArrayList<int[]> getTrajet() {
        return trajet;
    }

    public void setTrajet(ArrayList<int[]> trajet) {
        this.trajet = trajet;
    }

    public ArrayList<Ressource> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Ressource> stock) {
        this.stock = stock;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ville getDepart() {
        return depart;
    }

    public void setDepart(Ville depart) {
        this.depart = depart;
    }

    public Ville getArrivee() {
        return arrivee;
    }

    public void setArrivee(Ville arrivee) {
        this.arrivee = arrivee;
    }
    
    public void deplacer(Modele modele) throws InterruptedException{
        
        boolean aller=true;
        boolean retour=false;
        Ville temp=new Ville();
           
        //ALLER
        if (aller=true){
            
            //lecture de la liste trajet
            for(int c=1;c<this.getTrajet().size()-1;c++){
                //premiere case on charge
                if (c==1){
                    this.chargerRessources();                   
                    modele.avertieAllCreationRessource();
                }
                
                if (c>=2){
                    //a partir de la deuxieme case, on efface l'image de la case precedente
                    modele.setCaseTrainFalse(this.getTrajet().get(c-1)[0], this.getTrajet().get(c-1)[1]);
                    modele.avertirAllTrainFalse(this.getTrajet().get(c-1)[0],this.getTrajet().get(c-1)[1], modele.getCase(this.getTrajet().get(c-1)[0], this.getTrajet().get(c-1)[1])); 
                                                           }
                                //si la case n'est pas la derniere du trajet                           
                                if (c<=this.getTrajet().size()-1){
                                    //on change la variable train ainsi que l'image
                                    modele.setCaseTrainTrue(this.getTrajet().get(c)[0], this.getTrajet().get(c)[1]);
                                    modele.avertirAllTrainTrue(this.getTrajet().get(c)[0],this.getTrajet().get(c)[1], modele.getCase(this.getTrajet().get(c)[0], this.getTrajet().get(c)[1]));
                                }
                                //si le train est sur la derniere case du trajet
                                if (c==this.getTrajet().size()-2){
                                    //l'allé étant effectué il devient false et le retour devient true
                                    aller=false;
                                    retour=true;
                                    //decharger
                                    this.dechargerRessources();
                                    modele.avertieAllCreationRessource();
                                    //le depart devient l'arrivé et l'arrivé le départ
                                    temp=this.depart;
                                    this.depart=this.arrivee;
                                    this.arrivee=temp;
                                    
                                    
                                    
                                    
                                }    
                                
                                Thread.sleep(1000);
                            }

                        }
                        //RETOUR
                        if (retour=true){
                            //on parcoure le trajet en partant de la fin
                            for(int c=this.getTrajet().size()-2;c>=1;c--){
                                
                                //derniere case du trajet devient la premiere du retour donc on charge 
                                if(c==this.getTrajet().size()-2){

                                    this.chargerRessources();
                                    modele.avertieAllCreationRessource();
                                }
                                //a partir de la deuxieme case du retour (size-3) on efface la case precedente
                                if (c<=this.getTrajet().size()-3){
                                    modele.setCaseTrainFalse(this.getTrajet().get(c+1)[0], this.getTrajet().get(c+1)[1]);
                                    modele.avertirAllTrainFalse(this.getTrajet().get(c+1)[0],this.getTrajet().get(c+1)[1], modele.getCase(this.getTrajet().get(c+1)[0], this.getTrajet().get(c+1)[1])); 
                                                           }
                                //le train se deplace jusqu'a revenir a la derniere case  du retour soit la premier case de trajet
                                if (c>=1){
                                    modele.setCaseTrainTrue(this.getTrajet().get(c)[0], this.getTrajet().get(c)[1]);
                                    modele.avertirAllTrainTrue(this.getTrajet().get(c)[0],this.getTrajet().get(c)[1], modele.getCase(this.getTrajet().get(c)[0], this.getTrajet().get(c)[1]));
                                }
                                
                                //premiere case le retour est terminé ! on decharge on inverse depar et arrivé
                                if (c==1){
                                    aller=true;
                                    retour=false;
                                    temp=this.depart;
                                    this.dechargerRessources();
                                    this.depart=this.arrivee;
                                    this.arrivee=temp;
                                    modele.avertieAllCreationRessource();
                                }    
                                
                                Thread.sleep(1000);
                            }

                        }
    }
    
    public void chargerRessources(){
      
        System.out.println("je pars de "+this.depart.getNom());
   
        synchronized(this.depart.getStock()) {
                //parcours de la liste de la ville de depart
                for (LigneItem li : this.depart.getStock()){
                    //si la quantité de l'item est >= 2
                    if (li.getQuantite()>=2){
                        //LigneItem l = new LigneItem(li.getItem(),li.getQuantite()/3);
                        //on l'ajoute au stock du train
                        this.stock.add(((Ressource)li.getItem()));
                        
                        //et on decrement le stock de la ville
                        li.setQuantite(li.getQuantite()-2);
 
                }

            }
        }
    }
    
    public void dechargerRessources(){
        LigneItem lit = new LigneItem();
        
            for (Ressource r : this.getStock()){
                synchronized(this.arrivee.getStock()) {
                    for (LigneItem li : this.arrivee.getStock()){ 
                        //si les ressources du train sont deja dans le stock sous forme de ligneItem
                        if (r.nom.equals(li.getItem().nom)){
                            
                            //on incremente
                            li.setQuantite(li.getQuantite()+2);                           
                        }
                    }
     
                }         
            }
            this.stock.clear();
    }
        
    
}

