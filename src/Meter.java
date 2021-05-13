import javax.swing.*;
import java.awt.*;

public class Meter  extends JPanel {
    private Image meter;
    private Image red = new ImageIcon("Assets/red.png").getImage();
    private Image yellow = new ImageIcon("Assets/yellow.png").getImage();
    private Image green = new ImageIcon("Assets/green.png").getImage();
    private Image blue = new ImageIcon("Assets/blue.png").getImage();

    public void setImage(int x){
        //not close
        if (x == 1){
            meter =  red;
        }
        //close on x
        else if (x == 2){
            meter =  yellow;
        }
        //close on y
        else if (x == 3){
            meter =  blue;
        }
        //close
        else{
            meter =  green;
        }
    }

    public void paint(Graphics g){
        g.drawImage(meter, 676, 476, null);
        setOpaque(false);
    }
}
