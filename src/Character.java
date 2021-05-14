import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Character extends JPanel{
    /**
     * Instance Variables.
     * mx and my used for player motion
     * all instance variables for character sprites are declared
     */
    private int x, y;
    private int mx = 0, my = 0;
    private int orientation = 0;
    private boolean paused;
    private CharacterController controller;
    private PauseMenu pauseMenu;
    private Image right_idle = new ImageIcon("Assets/MC_right_idle.png").getImage();
    private Image right1 = new ImageIcon("Assets/MC_right1.png").getImage();
    private Image right2 = new ImageIcon("Assets/MC_right2.png").getImage();
    private Image left_idle = new ImageIcon("Assets/MC_left_idle.png").getImage();
    private Image left1 = new ImageIcon("Assets/MC_left1.png").getImage();
    private Image left2 = new ImageIcon("Assets/MC_left2.png").getImage();
    private Image idle = new ImageIcon("Assets/MC_idle.png").getImage();
    private Image up1 = new ImageIcon("Assets/MC_up1.png").getImage();
    private Image up2 = new ImageIcon("Assets/MC_up2.png").getImage();
    private Image down_idle = new ImageIcon("Assets/MC_down_idle.png").getImage();
    private Image down1 = new ImageIcon("Assets/MC_down1.png").getImage();
    private Image down2 = new ImageIcon("Assets/MC_down2.png").getImage();

    public Character(int x, int y, Dimension size,
                     CharacterController controller, PauseMenu pauseMenu){
        this.x = x;
        this.y = y;
        this.controller = controller;
        this.pauseMenu = pauseMenu;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void paint(Graphics g){
        //character motion is done using the paint function
        //m is for x movement and n is for y movement
        int m = mx % 20;
        int n = my % 20;

        //standing still
        if (m == 0 && n == 0) {
            switch (orientation) {
                case 0 -> g.drawImage(idle, x, y, null);
                case 1 -> g.drawImage(right_idle, x, y, null);
                case 2 -> g.drawImage(left_idle, x, y, null);
                case 3 -> g.drawImage(down_idle, x, y, null);
            }
        //moving right
        } else if (m > 0 && m < 6) {
            g.drawImage(right1, x, y, null);
        } else if (m > 5 && m < 11) {
            g.drawImage(right_idle, x, y, null);
        } else if (m > 10 && m < 16) {
            g.drawImage(right2, x, y, null);
        } else if (m > 15) {
            g.drawImage(right_idle, x, y, null);
        }

        //moving left
        else if (m < 0 && m > -6) {
            g.drawImage(left1, x, y, null);
        } else if (m < -5 && m > -11) {
            g.drawImage(left_idle, x, y, null);
        } else if (m < -10 && m > -16) {
            g.drawImage(left2, x, y, null);
        } else if (m < -15) {
            g.drawImage(left_idle, x, y, null);
        }

        //moving up
        else if (n > 0 && n < 6) {
            g.drawImage(up1, x, y, null);
        } else if (n > 5 && n < 11) {
            g.drawImage(idle, x, y, null);
        } else if (n > 10 && n < 16) {
            g.drawImage(up2, x, y, null);
        } else if (n > 15) {
            g.drawImage(idle, x, y, null);

        //moving down
        } else if (n > -6) {
            g.drawImage(down1, x, y, null);
        } else if (n > -11) {
            g.drawImage(down_idle, x, y, null);
        } else if (n > -16) {
            g.drawImage(down2, x, y, null);
        } else {
            g.drawImage(down_idle, x, y, null);
        }

    }

    public void update() {
        //checking to see if paused
        paused = controller.getPaused();
        //updating to pause menu
        pauseMenu.setPaused(paused);
        //if not paused then player movement is updated
        if(!paused) {
            x += controller.getCharacterMovementX();
            y += controller.getCharacterMovementY();

            //bounds are set
            if (x < 0) {
                x = 0;
            }
            if (x > 784) {
                x = 784;
            }
            if (y < 0) {
                y = 0;
            }

            if (y > 572) {
                y = 572;
            }

            //both right an left pressed
            if (controller.getRightPressed() && controller.getLeftPressed()) {
                mx = 0;
            }

            //right pressed
            if (controller.getRightPressed() && !controller.getLeftPressed()) {
                mx++;
                orientation = 1;
            }

            //left pressed
            if (controller.getLeftPressed() && !controller.getRightPressed()) {
                mx--;
                orientation = 2;
            }

            //both up and down pressed
            if (controller.getUpPressed() && controller.getDownPressed()) {
                my = 0;
            }

            //up pressed
            if (controller.getUpPressed() && !controller.getDownPressed()) {
                my++;
                if (!controller.getRightPressed() || !controller.getLeftPressed()) {
                    orientation = 0;
                }
            }

            //down pressed
            if (controller.getDownPressed() && !controller.getUpPressed()) {
                my--;
                if (!controller.getRightPressed() || !controller.getLeftPressed()) {
                    orientation = 3;
                }
            }
        }
    }
}
