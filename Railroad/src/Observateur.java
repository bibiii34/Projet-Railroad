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
    
     void avertir(int i, int j);
     void avertirChangementCase(int i, int j, Case c);
}
