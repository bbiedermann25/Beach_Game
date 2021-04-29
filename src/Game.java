import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Game extends JPanel{
    private CharacterController controller = new CharacterController(KeyEvent.VK_RIGHT,
            KeyEvent.VK_LEFT,KeyEvent.VK_UP, KeyEvent.VK_DOWN);
    private Character character = new Character(350,700, getSize().width, getSize().height,
            new Dimension(20, 28), controller);

    public Game(){
        setFocusable(true);
        setOpaque(false);
        setSize(800, 600);
        Timer timer = new Timer(16, new TimerListener());
        timer.start();
        controller = new CharacterController(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT,KeyEvent.VK_UP,
                KeyEvent.VK_DOWN);
        addKeyListener(controller);
        character = new Character(350,350, getSize().width, getSize().height,
                new Dimension(20, 28), controller);

    }

    @Override
    public void paintComponent(Graphics g) {
        character.paint(g);
    }

    private void update(){
        character.update();
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
            repaint();
        }
    }
}
