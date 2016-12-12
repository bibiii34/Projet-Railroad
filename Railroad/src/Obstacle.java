
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
    
    public Obstacle(){
        this.x=0 + (int)(Math.random() * ((14 - 0) + 1));
        this.y=0 + (int)(Math.random() * ((14 - 0) + 1));
        ImageIcon CROIX = new ImageIcon("./src/imgs/croix.jpg");
        this.texture = CROIX;
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
}
