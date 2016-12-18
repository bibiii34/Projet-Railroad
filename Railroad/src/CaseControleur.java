
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class CaseControleur extends MouseAdapter{
        int i;
        int j;
        Modele model;

        public CaseControleur(int _i, int _j, Modele m){
            i = _i;
            j = _j;
            model = m;
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {
            

        }
}
