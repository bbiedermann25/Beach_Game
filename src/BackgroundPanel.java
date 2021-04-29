import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BackgroundPanel extends JPanel {
    private Image image;
<<<<<<< HEAD
    public BackgroundPanel(String filePath) {
        try {
            image = ImageIO.read(new File(filePath));
        } catch (Exception e) {
            System.err.println("Couldn't find image: " + filePath);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
=======
    public BackgroundPanel () {
        try {
            image = ImageIO.read(new File("Assets/Beach.png"));
        } catch (Exception e) {
            System.err.println("couldn't find image");
            setBackground(Color.BLACK);
        }
    }
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (image !=null) {
>>>>>>> origin/master
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
