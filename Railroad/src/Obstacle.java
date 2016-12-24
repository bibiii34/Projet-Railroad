
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
public class Obstacle extends Case {
    private String type;

    public Obstacle(int x, int y) {
        super(x, y);
        //this.texture=
        this.type = "lac";
    }
    
    public Obstacle(ArrayList<Ville> v){
        boolean coordonnees = false;
        
        while (coordonnees == false){
            this.x=0 + (int)(Math.random() * ((5 - 0) + 1));
            this.y=0 + (int)(Math.random() * ((5 - 0) + 1));   
            
            if (v.isEmpty()){
                coordonnees = true;
            }    
            else{
                coordonnees=true;
                for (Ville maville : v){
                    if (this.x==maville.getX() && this.y==maville.getY()){
                    coordonnees = false;
                    }
                    
                    
                }
            }
        }
        ImageIcon OBSTACLE = new ImageIcon("./src/imgs/Texture 100x100/obstacle.png");
        this.texture = OBSTACLE;  
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    @Override
    public String toString(){
    String chaine = " 1 ";
    return chaine;
    }  
    
}
