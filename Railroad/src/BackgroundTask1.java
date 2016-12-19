
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
    
    BackgroundTask1(ArrayList<Ville> v){
        villes=v;
    }
    
    @Override
    public void run() {
        
        
        for (int i=0;i<20;i++){
            
            try {
                for (Ville v : villes){
                    v.genererItem();
                    for (LigneItem l:v.getStock()){
                        System.out.println(v.getNom()+" :"+l.getItem().getNom()+" "+l.getQuantite());
                    }
                    
                    
                }

                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BackgroundTask1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }        

    
}
