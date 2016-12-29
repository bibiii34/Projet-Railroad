
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class BackgroundTaskTrain extends Thread implements Serializable{
    
    private Train train;
    private Modele modele;
    
    public BackgroundTaskTrain(Train t, Modele m){
        this.train=t;
        this.modele=m;
    }
    
        @Override
    public void run() {
        
        while (1==1){
            try {
            train.deplacer(modele);
            } catch (InterruptedException ex) {
            Logger.getLogger(BackgroundTaskTrain.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        

    }
}
