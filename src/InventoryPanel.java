import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {

    int coinCount = 0;
    int necklaceCount = 0;
    int ringCount = 0;
    int emeraldCount = 0;

    public JButton coin = new JButton(String.valueOf(coinCount));
    public JButton necklace = new JButton(String.valueOf(necklaceCount));
    public JButton ring = new JButton(String.valueOf(ringCount));
    public JButton emerald = new JButton(String.valueOf(emeraldCount));

    public InventoryPanel(Object object){
        setBounds(250,350,350,150);
        setBackground(Color.white);
        setLayout(new GridLayout(1,5));

        coin.setIcon(new ImageIcon(object.getCoin()));
        necklace.setIcon(new ImageIcon(object.getNecklace()));
        ring.setIcon(new ImageIcon(object.getRing()));
        emerald.setIcon(new ImageIcon(object.getEmerald()));
        add(coin, 0);
        add(necklace, 0);
        add(ring, 0);
        add(emerald, 0);

    }

    public void add(String item){
        if (item.equals("ring")){
            ringCount++;
            ring.setText(String.valueOf(ringCount));
        }
        if (item.equals("necklace")){
            necklaceCount++;
            necklace.setText(String.valueOf(necklaceCount));
        }
        if (item.equals("emerald")){
            emeraldCount++;
            emerald.setText(String.valueOf(emeraldCount));
        }
        if (item.equals("coin")){
            coinCount++;
            coin.setText(String.valueOf(coinCount));
        }
    }


}
