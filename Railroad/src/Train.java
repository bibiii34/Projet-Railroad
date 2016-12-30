
import java.io.Serializable;
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
public class Train implements Serializable {
    private int x;
    private int y;
    private ArrayList<int[]> trajet;
    private  ArrayList<Ressource> stock;
    private Ville depart;
    private Ville arrivee;
    int random = (int)(Math.random() * ((5 - 0) + 1));
    transient BackgroundTaskTrain thd;
    private boolean aller;
    
    //Constructeurs  
    public Train(int x, int y, ArrayList<int[]> trajet, Ville d, Ville a){
        this.x=x;
        this.y=y;
        //image train
        this.trajet=new ArrayList(trajet);
        this.stock=new ArrayList();
        this.depart=d;
        this.arrivee=a;
        this.aller=true;
 
    }

    public BackgroundTaskTrain getThd() {
        return thd;
    }

    public void setThd(BackgroundTaskTrain thd) {
        this.thd = thd;
    }
    

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

    public boolean isAller() {
        return aller;
    }
    
    
    public void deplacer(Modele modele) throws InterruptedException{
        
        boolean aller=true;
        boolean retour=false;
        Ville temp=new Ville();
           
        //ALLER
        if (aller=true){
            
            //lecture de la liste trajet
            for(int c=1;c<this.getTrajet().size()-1;c++){
                
                if(modele.getCase(this.getTrajet().get(c)[0], this.getTrajet().get(c)[1])instanceof Rail) {
                 //premiere case on charge
                    if (c==1){
                        this.chargerRessources();                   
                        modele.avertirAllCreationRessource();
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
                        modele.avertirAllCreationRessource();
                        for(LigneItem li: this.getArrivee().getStock()){
                            System.out.println(li.getItem().nom+li.getQuantite());
                        }
                        //le depart devient l'arrivé et l'arrivé le départ                       
                        changementVilles();  
                        this.aller=false;
                    }    
                                
                Thread.sleep(1000); 
                }
                else {
                    System.out.println("le train s'arrete");
                    this.thd.stop();
                }
                

            }

                        }
                        //RETOUR
                        if (retour=true){
                            
                            
                            //on parcoure le trajet en partant de la fin
                            for(int c=this.getTrajet().size()-2;c>=1;c--){
                                
                                //On verifie que le rail n'est pas etait supprimer
                                if(modele.getCase(this.getTrajet().get(c)[0], this.getTrajet().get(c)[1])instanceof Rail) {
                                    
                                    //derniere case du trajet devient la premiere du retour donc on charge 
                                    if(c==this.getTrajet().size()-2){

                                       // this.chargerRessources();
                                        modele.avertirAllCreationRessource();
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
                                        //this.dechargerRessources();
                                        changementVilles();
                                        this.aller=true;
                                        modele.avertirAllCreationRessource();
                                    }    
                                
                                Thread.sleep(1000);
                                }
                                else {
                                     System.out.println("Plus de rail le train s'arrete");
                                        this.thd.stop();
                                }
                            }

                        }
    }
    
    public void chargerRessources(){
      
        System.out.println("je pars de "+this.depart.getNom());
   
        synchronized(this.depart.getStock()) {
                //parcours de la liste de la ville de depart
                for (LigneItem li : this.depart.getStock()){
                    //si la quantité de l'item est >= 2
                    if (li.getQuantite()>=2 && li.getItem() instanceof Ressource){
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
        
    public void changementVilles(){
        Ville temp=this.depart;
        this.depart=this.arrivee;
        this.arrivee=temp;
    }
}

