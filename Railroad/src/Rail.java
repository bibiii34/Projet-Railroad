
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
    private ImageIcon railH = new ImageIcon("./src/imgs/Texture 100x100/railsH.png");;
    private ImageIcon railV = new ImageIcon("./src/imgs/Texture 100x100/railsV.png");;
    private ImageIcon railVirage1 = new ImageIcon("./src/imgs/Texture 100x100/railsVirage1.png");
    private ImageIcon railVirage2 = new ImageIcon("./src/imgs/Texture 100x100/railsVirage2.png");
    private ImageIcon railVirage3 = new ImageIcon("./src/imgs/Texture 100x100/railsVirage3.png");
    private ImageIcon railVirage4 = new ImageIcon("./src/imgs/Texture 100x100/railsVirage4.png");
    private boolean train;

    public Rail(int x, int y) {
        super(x, y);
        this.train = false;
        this.texture=railH;
    }

    public ImageIcon getRailH() {
        return railH;
    }

    public ImageIcon getRailV() {
        return railV;
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

    public boolean isTrain() {
        return train;
    }

    
  
    
    
}
