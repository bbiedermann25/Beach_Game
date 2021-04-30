import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static int Height;
    public static int Width;
    private Image image;

    public Window() {
        Game game = new Game();
        Height = 600;
        Width = 800;
        PauseMenu pauseMenu = new PauseMenu(Height, Width);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new BackgroundPanel("Assets/Beach.png"));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setPreferredSize(new Dimension(Width, Height));
        pack();
        add(game);
        add(pauseMenu);
        setVisible(true);
    }

    public static void main(String[] args) {
        Window window = new Window();
    }
}
