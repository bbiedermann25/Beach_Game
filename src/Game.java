import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Game extends JPanel{
    private PauseMenu pauseMenu = new PauseMenu(600, 800);
    private CharacterController controller = new CharacterController(KeyEvent.VK_RIGHT,
            KeyEvent.VK_LEFT,KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_P, KeyEvent.VK_ENTER);
    private Character character = new Character(400,300, getSize().width, getSize().height,
            new Dimension(20, 28), controller, pauseMenu);
    private Object object;
    private Meter meter = new Meter();
    private Inventory inventory;
    private InventoryPanel inventoryPanel = new InventoryPanel();
    //private MainMenu mainMenu = new MainMenu();

    public Game(){
        setFocusable(true);

        setOpaque(false);
        setSize(800, 600);
        Timer timer = new Timer(16, new TimerListener());
        timer.start();
        controller = new CharacterController(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT,KeyEvent.VK_UP,
                KeyEvent.VK_DOWN, KeyEvent.VK_SPACE, KeyEvent.VK_ENTER);
        addKeyListener(controller);
        character = new Character(400,300, getSize().width, getSize().height,
                new Dimension(20, 28), controller, pauseMenu);
        object = new Object(character.getX(), character.getY());
        object.spawn();

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
        character.update();
        int x = Math.abs(character.getX() - object.x);
        int y = Math.abs(character.getY() - object.y);
        System.out.println("x: " + x + " y: " + y);
        if (x <= 40 && y <=40){
            meter.setImage(4);
            if(controller.getCollected()) {
                object.playerNear = true;
                object = new Object(character.getX(), character.getY());
                object.spawn();
                inventoryPanel.addCoin();
                inventoryPanel.coin.setText(String.valueOf(inventoryPanel.coinCount));

            }

        }
        else if (x <= 40 && y > 40){
            meter.setImage(2);
        }
        else if (x > 40 && y <= 40){
            meter.setImage(3);
        }
        else{
            meter.setImage(1);
        }

    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
            repaint();
        }
    }
    public void start(){
        //add(inventoryPanel);
    }


}
