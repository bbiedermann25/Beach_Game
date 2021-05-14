import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterController extends JFrame implements KeyListener {
    private int rightKey, leftKey, upKey, downKey, pauseKey, collectKey;
    private boolean rightPressed, leftPressed, upPressed, downPressed, collectPressed, paused;

    public CharacterController(int rightKey, int leftKey, int upKey, int downKey, int pauseKey, int collectKey){
        this.rightKey = rightKey;
        this.leftKey = leftKey;
        this.upKey = upKey;
        this.downKey = downKey;
        this.pauseKey = pauseKey;
        this.collectKey = collectKey;
        rightPressed = false;
        leftPressed = false;
        upPressed = false;
        downPressed = false;
        collectPressed = false;
        paused = false;
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

        if (key == upKey){
            upPressed = true;
        }

        if (key == downKey){
            downPressed = true;
        }

        if (key == collectKey){
            collectPressed = true;
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

        if (key == upKey){
            upPressed = false;
        }

        if (key == downKey){
            downPressed = false;
        }

        if (key == collectKey){
            collectPressed = false;
        }

        if (key == pauseKey){
            paused = !paused;
        }
    }

    public int getCharacterMovementX(){
        if (rightPressed && !leftPressed){
            //movement diagonally up/down and right
            if (upPressed || downPressed){
                return 1;
            }
            //moving right
            return 2;
        }

        else if (leftPressed && !rightPressed){
            //movement diagonally up/down and left
            if (upPressed || downPressed){
                return -1;
            }
            //moving left
            return -2;
        }

        else{
            return 0;
        }

    }

    public int getCharacterMovementY(){
        if (upPressed && !downPressed){
            //movement diagonally up and right/left
            if (rightPressed || leftPressed){
                return -1;
            }
            //movement up
            return -2;
        }
        else if (downPressed && !upPressed){
            //movement diagonally down and right/left
            if (rightPressed || leftPressed){
                return 1;
            }
            //movement down
            return 2;
        }
        else{
            return 0;
        }
    }

    public boolean getRightPressed(){
        return rightPressed;
    }

    public boolean getLeftPressed(){
        return leftPressed;
    }

    public boolean getUpPressed(){
        return upPressed;
    }

    public boolean getDownPressed(){
        return downPressed;
    }

    public boolean getCollected(){
        return collectPressed;
    }

    public boolean getPaused(){return paused;}
}
