import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Game extends JPanel{
    private PauseMenu pauseMenu = new PauseMenu(600, 800);
    private CharacterController controller = new CharacterController(KeyEvent.VK_RIGHT,
            KeyEvent.VK_LEFT,KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_P, KeyEvent.VK_ENTER);
    private Character character = new Character(400,300,
            new Dimension(20, 28), controller, pauseMenu);
    private Object object;
    private Meter meter = new Meter();
    private InventoryPanel inventoryPanel;

    public Game(){
        setFocusable(true);
        setOpaque(false);
        setSize(800, 600);
        Timer timer = new Timer(16, new TimerListener());
        timer.start();
        controller = new CharacterController(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT,KeyEvent.VK_UP,
                KeyEvent.VK_DOWN, KeyEvent.VK_SPACE, KeyEvent.VK_ENTER);
        addKeyListener(controller);
        character = new Character(400,300, new Dimension(20, 28), controller, pauseMenu);
        object = new Object();
        object.setup();
        inventoryPanel = new InventoryPanel(object);
        add(inventoryPanel);

    }

    @Override
    public void paintComponent(Graphics g) {
        object.paint(g);
        character.paint(g);
        meter.paint(g);
        pauseMenu.paint(g);


    }

    private void update(){
        //updates character
        character.update();

        //calculates euclidean distance from object
        int x = Math.abs(character.getX() - object.x);
        int y = Math.abs(character.getY() - object.y);
        int dist = (int) Math.sqrt((Math.pow(x, 2)) + Math.pow(y,2));

        //cases that change the meter depending on player distance from object
        if (x <= 30){
            meter.setXClose(true);
        }
        if (y <= 30){
            meter.setYClose(true);
        }
        if (x > 30){
            meter.setXClose(false);
        }
        if (y > 30){
            meter.setYClose(false);
        }


        if (dist <= 30){
            meter.setImage("near");
            object.playerNear = true;
            //if player presses collect then object is added to inventory and respawned
            if(controller.getCollected()) {
                inventoryPanel.add(object.getType());
                object.spawn();
            }

        }
        else if (dist <= 40){
            meter.setImage("near1");
        }
        else if (dist <= 60){
            meter.setImage("near2");
        }
        else if (dist <= 80){
            meter.setImage("near3");
        }
        else if (dist <= 100){
            meter.setImage("far3");
        }
        else if (dist <= 150){
            meter.setImage("far2");
        }
        else if (dist <= 200){
            meter.setImage("far1");
        }
        else{
            meter.setImage("far");
        }

    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
            repaint();
        }
    }
}
