import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Game extends JPanel{
    private Character character;

    public Game(){
        setFocusable(true);
        setSize(700, 1000);
        Timer timer = new Timer(16, new TimerListener());
        timer.start();
        CharacterController charactercontroller = new CharacterController(KeyEvent.VK_RIGHT, KeyEvent.VK_LEFT);
        addKeyListener(charactercontroller);
        character = new Character(10,10, new Dimension(20, 28), charactercontroller);
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
