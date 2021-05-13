import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JPanel {

    private JLabel start;
    private Game game = new Game();
    private Window window;
    private Character character;

    public MainMenu() {
        //this.game = game;
        setFocusable(true);
        requestFocusInWindow(true);
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Beach", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 50));
        title.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));
        bottomPanel.setOpaque(false);
        start = new JLabel("Click or press enter to start", SwingConstants.CENTER);
        start.setFont(new Font("Serif", Font.BOLD, 40));
        start.setForeground(Color.WHITE);
        start.setBackground(Color.DARK_GRAY);
        start.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        bottomPanel.add(start);
        add(bottomPanel, BorderLayout.SOUTH);

        addKeyListener(new StartKeyListener());
        start.addMouseListener(new StartMouseListener());
        setOpaque(false);
    }

    private class StartMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            startGame();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            start.setOpaque(true);
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            start.setOpaque(false);
            repaint();
        }
    }

    private class StartKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyPressed = e.getKeyCode();
            //System.out.println("Key pressed: "+e.getKeyChar() + " " +e.getKeyCode());
            if (keyPressed == KeyEvent.VK_ENTER) {
                startGame();
            }
        }
    }
    public void startGame(){

        setVisible(false);
        setFocusable(false);
        //game.start();

    }
}