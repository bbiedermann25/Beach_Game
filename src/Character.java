import javax.swing.*;
import java.awt.*;

public class Character {
    private int x, y;
    private Dimension size;
    private CharacterController controller;

    public Character(int x, int y, Dimension size, CharacterController controller){
        this.x = x;
        this.y = y;
        this.size = size;
        this.controller = controller;
    }

    public void update(){
        x += controller.getCharacterMovement();
    }

    public void paint(Graphics g){
        g.fillRect(x, y, size.width, size.height);
        g.drawImage(new ImageIcon("Assets/MC_idle.png").getImage(), x, y, null);

    }


}
