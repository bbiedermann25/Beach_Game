import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterController extends JFrame implements KeyListener {
    private int rightKey, leftKey;
    private boolean rightPressed, leftPressed;

    public CharacterController(int rightKey, int leftKey){
        this.rightKey = rightKey;
        this.leftKey = leftKey;
        rightPressed = false;
        leftPressed = false;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == rightKey){
            rightPressed = true;
        }
        if (key == leftKey){
            leftPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == rightKey){
            rightPressed = false;
        }
        if (key == leftKey){
            leftPressed = false;
        }
    }

    public int getCharacterMovement(){
        if (rightPressed){
            return 2;
        }
        else if (leftPressed){
            return -2;
        }
        else{
            return 0;
        }

    }
}
