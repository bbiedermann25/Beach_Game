import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Window extends JFrame {
    public static int Height;
    public static int Width;
    private Image image;

    public Window() {
        Height = 600;
        Width = 800;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setContentPane(new BackgroundPanel());
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setPreferredSize(new Dimension(Width, Height));
        pack();
        Game game = new Game();
        add(game);
        BackgroundPanel backgroundPanel = new BackgroundPanel("Assets/Beach.png");
        add(backgroundPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Window window = new Window();
    }
}