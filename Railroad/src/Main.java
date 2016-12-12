/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
    public class Main {
    public static void main(String[] argc){
    Modele m = new Modele();
    RailroadFrame rf = new RailroadFrame(m);
    
    m.register(rf);
    rf.setVisible(true);
    
    m.genererMonde();
        
    }
    
}
