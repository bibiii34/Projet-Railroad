
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
    protected ImageIcon textureSelection;
    

    //constructeur
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon DESERT = new ImageIcon("./src/imgs/Texture 100x100/desert.png");
        this.texture = DESERT;
        ImageIcon DESERTSELECTION = new ImageIcon ("./src/imgs/Texture 100x100/desertSelection.png");
        this.textureSelection = DESERTSELECTION;
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
    
      public ImageIcon getTextureSelection() {
        return textureSelection;
    }
    
}
