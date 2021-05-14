import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class InventoryPanel extends JPanel {

    private int coinCount = 0;
    private int necklaceCount = 0;
    private int ringCount = 0;
    private int emeraldCount = 0;
    private int value = 0;
    private HashMap itemList;

    public JButton coin = new JButton(String.valueOf(coinCount));
    public JButton necklace = new JButton(String.valueOf(necklaceCount));
    public JButton ring = new JButton(String.valueOf(ringCount));
    public JButton emerald = new JButton(String.valueOf(emeraldCount));

    //GridLayout where items are listed as a row at the top of the screen
    public InventoryPanel(Object object){
        setBounds(250,350,350,150);
        setBackground(Color.white);
        setLayout(new GridLayout(1,5));
        itemList = object.getItemList();

        //item images set for each item using images from object class
        coin.setIcon(new ImageIcon(object.getCoin()));
        necklace.setIcon(new ImageIcon(object.getNecklace()));
        ring.setIcon(new ImageIcon(object.getRing()));
        emerald.setIcon(new ImageIcon(object.getEmerald()));


        add(coin, 0);
        add(necklace, 0);
        add(ring, 0);
        add(emerald, 0);

    }

    //items are added based on what type of item they are. using the hashmap in
    //the object class, overall value of items is calculated
    public void add(String item){
        if (item.equals("ring")){
            ringCount++;
            ring.setText(String.valueOf(ringCount));
            value += (int)itemList.get(item);
        }
        if (item.equals("necklace")){
            necklaceCount++;
            necklace.setText(String.valueOf(necklaceCount));
            value += (int)itemList.get(item);
        }
        if (item.equals("emerald")){
            emeraldCount++;
            emerald.setText(String.valueOf(emeraldCount));
            value += (int)itemList.get(item);
        }
        if (item.equals("coin")){
            coinCount++;
            coin.setText(String.valueOf(coinCount));
            value += (int)itemList.get(item);
        }
    }

    public int getValue(){
        return this.value;
    }

    /*
    public void clearInventory(){
        this.coinCount = 0;
        this.necklaceCount = 0;
        this.ringCount = 0;
        this.emeraldCount = 0;
        ring.setText(String.valueOf(ringCount));
        necklace.setText(String.valueOf(necklaceCount));
        emerald.setText(String.valueOf(emeraldCount));
        coin.setText(String.valueOf(coinCount));
    }
    */
}
