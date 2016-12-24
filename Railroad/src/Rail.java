
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
public class Rail extends Case {
    private ImageIcon railH ;
    private ImageIcon railV;
    private ImageIcon railHTrain ;
    private ImageIcon railVTrain;
    private ImageIcon railHSelection; 
    private ImageIcon railVSelection;
    private ImageIcon railVirage1; 
    private ImageIcon railVirage2;
    private ImageIcon railVirage3;
    private ImageIcon railVirage4;
    private ImageIcon railVirage1Selection;
    private ImageIcon railVirage2Selection;
    private ImageIcon railVirage3Selection;
    private ImageIcon railVirage4Selection;
    private ImageIcon railVirage1Train; 
    private ImageIcon railVirage2Train;
    private ImageIcon railVirage3Train;
    private ImageIcon railVirage4Train;
    private boolean train;
    private ImageIcon textureTrain;
    

    public Rail(int x, int y) {
        super(x, y);
        this.railH = new ImageIcon("./src/imgs/Texture 100x100/railsH.png");
        this.railV = new ImageIcon("./src/imgs/Texture 100x100/railsV.png");
        this.railHTrain = new ImageIcon("./src/imgs/Texture 100x100/railsHTrain.png");
        this.railVTrain = new ImageIcon("./src/imgs/Texture 100x100/railsVTrain.png");
        this.railHSelection = new ImageIcon("./src/imgs/Texture 100x100/railsHSelection.png");
        this.railVSelection = new ImageIcon("./src/imgs/Texture 100x100/railsVSelection.png");
        this.railVirage1 = new ImageIcon("./src/imgs/Texture 100x100/railsVirage1.png");
        this.railVirage2 = new ImageIcon("./src/imgs/Texture 100x100/railsVirage2.png");
        this.railVirage3 = new ImageIcon("./src/imgs/Texture 100x100/railsVirage3.png");    
        this.railVirage4 = new ImageIcon("./src/imgs/Texture 100x100/railsVirage4.png");
        this.railVirage1Train = new ImageIcon("./src/imgs/Texture 100x100/railsVirage1Train.png");
        this.railVirage2Train = new ImageIcon("./src/imgs/Texture 100x100/railsVirage2Train.png");
        this.railVirage3Train = new ImageIcon("./src/imgs/Texture 100x100/railsVirage3Train.png");    
        this.railVirage4Train = new ImageIcon("./src/imgs/Texture 100x100/railsVirage4Train.png");
        this.railVirage1Selection = new ImageIcon("./src/imgs/Texture 100x100/railsVirage1Selection.png");
        this.railVirage2Selection = new ImageIcon("./src/imgs/Texture 100x100/railsVirage2Selection.png");
        this.railVirage3Selection = new ImageIcon("./src/imgs/Texture 100x100/railsVirage3Selection.png");
        this.railVirage4Selection = new ImageIcon("./src/imgs/Texture 100x100/railsVirage4Selection.png");
        this.textureTrain= new ImageIcon("./src/imgs/Texture 100x100/croix.jpg");
        this.train = false;
        this.selection=false;
       
    }

    public ImageIcon getTextureSelection() {
        return textureSelection;
    }

    public void setTextureSelection(ImageIcon textureSelection) {
        this.textureSelection = textureSelection;
    }

    public ImageIcon getTexture() {
        return texture;
    }

    public void setTexture(ImageIcon texture) {
        this.texture = texture;
    }

    
    public ImageIcon getRailH() {
        return railH;
    }

    public ImageIcon getRailV() {
        return railV;
    }

    public ImageIcon getRailVTrain() {
        return railVTrain;
    }
    
    

    public ImageIcon getRailVirage1() {
        return railVirage1;
    }

    public ImageIcon getRailVirage2() {
        return railVirage2;
    }

    public ImageIcon getRailVirage3() {
        return railVirage3;
    }

    public ImageIcon getRailVirage4() {
        return railVirage4;
    }

    public ImageIcon getRailHSelection() {
        return railHSelection;
    }

    public ImageIcon getRailVSelection() {
        return railVSelection;
    }
    
    

    public ImageIcon getRailVirage1Selection() {
        return railVirage1Selection;
    }

    public ImageIcon getRailVirage2Selection() {
        return railVirage2Selection;
    }

    public ImageIcon getRailVirage3Selection() {
        return railVirage3Selection;
    }

    public ImageIcon getRailVirage4Selection() {
        return railVirage4Selection;
    }

    
    public boolean isTrain() {
        return train;
    }
    
    public void setTrain(boolean train){
        this.train= train;
    }

    public boolean isSelection() {
        return selection;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }

    public ImageIcon getRailHTrain() {
        return railHTrain;
    }

    public void setRailHTrain(ImageIcon railHTrain) {
        this.railHTrain = railHTrain;
    }

    public ImageIcon getRailVirage1Train() {
        return railVirage1Train;
    }

    public void setRailVirage1Train(ImageIcon railVirage1Train) {
        this.railVirage1Train = railVirage1Train;
    }

    public ImageIcon getRailVirage2Train() {
        return railVirage2Train;
    }

    public void setRailVirage2Train(ImageIcon railVirage2Train) {
        this.railVirage2Train = railVirage2Train;
    }

    public ImageIcon getRailVirage3Train() {
        return railVirage3Train;
    }

    public void setRailVirage3Train(ImageIcon railVirage3Train) {
        this.railVirage3Train = railVirage3Train;
    }

    public ImageIcon getRailVirage4Train() {
        return railVirage4Train;
    }

    public void setRailVirage4Train(ImageIcon railVirage4Train) {
        this.railVirage4Train = railVirage4Train;
    }

    public ImageIcon getTextureTrain() {
        return textureTrain;
    }

    public void setTextureTrain(ImageIcon textureTrain) {
        this.textureTrain = textureTrain;
    }

    
        @Override
    public String toString(){
    String chaine = " R ";
    return chaine;
    }  
  
    
    
}
