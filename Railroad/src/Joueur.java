
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author btorralba
 */
public class Joueur {
    private String pseudo;
    private ArrayList<Modele> parties;
    private ArrayList<Integer> scores;
    
    public Joueur(String p, Modele m){
        this.parties=new ArrayList();
        this.pseudo=p;
        this.scores=new ArrayList();
    }
}
