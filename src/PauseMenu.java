import javax.swing.*;
import java.awt.*;

public class PauseMenu extends JPanel {
    private boolean paused;
    private int height, width;
    private Image pauseImg = new ImageIcon("Assets/pause.png").getImage();
    private Dimension size;

    public PauseMenu(int height, int width){
        this.height = height;
        this.width = width;
        setSize(width, height);
    }

    public void setPaused(boolean paused){
        this.paused = paused;
    }

    public void paint(Graphics g){
        if(paused){
            g.drawImage(pauseImg, 0, 0, null);
            setOpaque(false);
        }else{
            setOpaque(true);
        }
    }
}
