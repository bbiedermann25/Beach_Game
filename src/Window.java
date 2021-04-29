import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static int Height;
    public static int Width;


    public Window() {
        Height = 1000;
        Width = 700;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(Color.LIGHT_GRAY);
        getContentPane().setPreferredSize(new Dimension(Width, Height));
        pack();
        Game game = new Game();
        add(game);
        setVisible(true);
    }
    public static void main(String[] args) {
        Window window = new Window();
    }
}
