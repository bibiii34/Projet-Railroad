
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author btorralba
 */
public class BackgroundTask1 extends Thread{ 
    
    private ArrayList<Ville> villes;
    private ArrayList<Train> trains;
    private Modele modele;
    
    public BackgroundTask1(ArrayList<Ville> v, ArrayList<Train> t, Modele m){
        villes=v;
        trains=t;
        modele=m;
    }

  /*     public BackgroundTask1(ArrayList<Train> t, Modele m){
        trains=t;
        modele=m;
    }*/
    
    @Override
    public void run() {
        int i=1;
        boolean aller=true;
        boolean retour=false;
        
        //for (int i=0;i<20;i++){
          while (1==1){  
            try {
                for (Ville v : villes){
                    v.genererItem();
                    /*for (LigneItem l:v.getStock()){
                        System.out.println(v.getNom()+" :"+l.getItem().getNom()+" "+l.getQuantite());
                    }*/
                    
                    
                }
                
                //Si il existe des trains
                synchronized(trains) {
                if (trains.isEmpty()==false){
                    
                    
                    //System.out.println("nombre de train: "+trains.size());
               
                    
                    for (Train t : trains){
                    
                      /*  for (int[] tra : t.getTrajet()){
                            System.out.println("trajet :"+tra[0]+tra[1]);
                        }*/
                        if (aller=true){
                            for(int c=1;c<t.getTrajet().size()-1;c++){
                                if (c>=2){
                                    modele.setCaseTrainFalse(t.getTrajet().get(c-1)[0], t.getTrajet().get(c-1)[1]);
                                    modele.avertirAllTrainFalse(t.getTrajet().get(c-1)[0],t.getTrajet().get(c-1)[1], modele.getCase(t.getTrajet().get(c-1)[0], t.getTrajet().get(c-1)[1])); 
                                                           }
                            
                                if (c<=t.getTrajet().size()-1){
                                    modele.setCaseTrainTrue(t.getTrajet().get(c)[0], t.getTrajet().get(c)[1]);
                                    modele.avertirAllTrainTrue(t.getTrajet().get(c)[0],t.getTrajet().get(c)[1], modele.getCase(t.getTrajet().get(c)[0], t.getTrajet().get(c)[1]));
                                }
                            
                                if (c==t.getTrajet().size()-1){
                                    aller=false;
                                    retour=true;
                                }    
                                
                                Thread.sleep(200);
                            }

                        }
                        
                        if (retour=true){
                            for(int c=t.getTrajet().size()-2;c>=1;c--){
                                if (c<=t.getTrajet().size()-3){
                                    modele.setCaseTrainFalse(t.getTrajet().get(c+1)[0], t.getTrajet().get(c+1)[1]);
                                    modele.avertirAllTrainFalse(t.getTrajet().get(c+1)[0],t.getTrajet().get(c+1)[1], modele.getCase(t.getTrajet().get(c+1)[0], t.getTrajet().get(c+1)[1])); 
                                                           }
                            
                                if (c>=1){
                                    modele.setCaseTrainTrue(t.getTrajet().get(c)[0], t.getTrajet().get(c)[1]);
                                    modele.avertirAllTrainTrue(t.getTrajet().get(c)[0],t.getTrajet().get(c)[1], modele.getCase(t.getTrajet().get(c)[0], t.getTrajet().get(c)[1]));
                                }
                            
                                if (c==1){
                                    aller=true;
                                    retour=false;
                                }    
                                
                                Thread.sleep(200);
                            }

                        }
                    }
                    
                    
                    
                    
                }
            }
                //Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BackgroundTask1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }        

    
}
