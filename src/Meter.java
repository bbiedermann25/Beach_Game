import javax.swing.*;
import java.awt.*;

public class Meter  extends JPanel {
    //image instance variables
    private Image meter;
    private Image near = new ImageIcon("Assets/near.png").getImage();
    private Image near1 = new ImageIcon("Assets/near1.png").getImage();
    private Image near2= new ImageIcon("Assets/near2.png").getImage();
    private Image near3 = new ImageIcon("Assets/near3.png").getImage();
    private Image far = new ImageIcon("Assets/far.png").getImage();
    private Image far1 = new ImageIcon("Assets/far1.png").getImage();
    private Image far2= new ImageIcon("Assets/far2.png").getImage();
    private Image far3 = new ImageIcon("Assets/far3.png").getImage();
    private Image x= new ImageIcon("Assets/x.png").getImage();
    private Image y = new ImageIcon("Assets/y.png").getImage();

    //booleans for whether or not the character is close on on each axis
    private boolean xClose = false;
    private boolean yClose = false;

    public void setXClose(boolean xClose){
        this.xClose = xClose;
    }
    public void setYClose(boolean yClose){
        this.yClose = yClose;
    }

    //sets image based on what string it is told. This process is done in the Game class
    public void setImage(String s){
        //not close
        if (s.equals("near")){
            meter = near;
        }
        //close on x
        if (s.equals("near1")){
            meter = near1;
        }
        if (s.equals("near2")){
            meter = near2;
        }
        //close on x
        if (s.equals("near3")){
            meter = near3;
        }
        if (s.equals("far")){
            meter = far;
        }
        //close on x
        if (s.equals("far1")){
            meter = far1;
        }
        if (s.equals("far2")){
            meter = far2;
        }
        //close on x
        if (s.equals("far3")){
            meter = far3;
        }

    }

    public void paint(Graphics g){
        g.drawImage(meter, 676, 476, null);

        //if character is close on the x or y then a x or y with
        //a check mark is drawn over the meter indicating that
        //the player is on the same x or y as the object
        if(xClose){
            g.drawImage(x, 676, 451, null);
        }
        if(yClose){
            g.drawImage(y, 720, 451, null);
        }
        setOpaque(false);
    }
}
