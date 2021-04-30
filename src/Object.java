import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Object extends JPanel {
    public int px, py, x, y;
    public boolean playerNear = false;
    public boolean found = false;
    private Image emerald = new ImageIcon("Assets/emerald.png").getImage();
    Random rd = new Random();
    public Object (int px, int py)
    {
        this.px = px;
        this.py = py;
    }

    public void spawn(){
        if (px >= 400){
            this.x = px - rd.nextInt(100) - 20;
        }else{
            this.x = px + rd.nextInt(100) + 20;
        }

        if (py >= 300){
            this.y = py - rd.nextInt(100) - 20;
        }else{
            this.y = py + rd.nextInt(100) + 20;
        }
        playerNear = false;
        found = false;
    }

    public void paint(Graphics g){
        if(playerNear){
            g.drawImage(emerald, x, y, null);
            setOpaque(false);
        }else{
            setOpaque(true);
        }
    }



}
