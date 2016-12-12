
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
public class Case {
    protected int x;
    protected int y;
    protected ImageIcon texture;
    

    //constructeur
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon HERBE = new ImageIcon("./src/imgs/herbe.png");
        this.texture = HERBE;
    }
    
    public Case(){
        
    }

    //Accesseur 
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getTexture() {
        return texture;
    }

    public void setTexture(ImageIcon texture) {
        this.texture = texture;
    }
    
    
}
