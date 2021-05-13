import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {

    int watchCount = 0;
    int coinCount = 0;
    int necklaceCount = 0;
    int ringCount = 0;
    int canCount = 0;

    public JButton coin = new JButton(String.valueOf(coinCount));

    public InventoryPanel(){
        setBounds(250,350,350,150);
        setBackground(Color.white);
        setLayout(new GridLayout(1,5));

        Image emerald = new ImageIcon("Assets/emerald.png").getImage();
        coin.setIcon(new ImageIcon(emerald));
        add(coin);


    }
    public void addWatch(){
        watchCount++;
    }
    public void addCoin(){
        coinCount++;
        System.out.println(coinCount + " coins");

    }
    public void addNecklace(){
        necklaceCount++;
    }
    public void addRing(){
        ringCount++;
    }
    public void addCan(){
        canCount++;
    }


}
