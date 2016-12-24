/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public interface Observateur {
    
     void avertirSelectionVille(int i, int j, Ville v);
     void avertirChangementCase(int i, int j, Case c);
     void avertirTrainTrue(int i, int j, Case c);
     void avertirTrainFalse(int i, int j, Case c);
     void avertirCreationRessource();

}
