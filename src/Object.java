import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Object extends JPanel {
    public int px, py, x, y;
    public boolean playerNear = false;
    public boolean found = false;
    private Image emerald = new ImageIcon("Assets/emerald.png").getImage();
    Random rd = new Random();
    //List<String> inv = new ArrayList<String>();
    public Object (int px, int py){
        this.px = px;
        this.py = py;
    }

    public void spawn(){
        this.x = rd.nextInt(792);
        this.y = rd.nextInt(592);
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
