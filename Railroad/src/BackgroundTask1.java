
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

        
        for (int k=0;i<10;i++){
          //while (1==1){  
              for (Ville v : villes){
                  v.genererItem();
                  //for (LigneItem l:v.getStock()){
                  //System.out.println(v.getNom()+" :"+l.getItem().getNom()+" "+l.getQuantite());
                  //}
                  modele.avertieAllCreationRessource();
              }
                                
                  try { 
                      Thread.sleep(1000);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(BackgroundTask1.class.getName()).log(Level.SEVERE, null, ex);
                  }
              //Si il existe des trains
              /*synchronized(trains) {
                  if (trains.isEmpty()==false){

                    for (Train t : trains){                                          
                          
                      }
           
                  }
              }*/
              //Thread.sleep(1000);
        }
    }        

    
}
