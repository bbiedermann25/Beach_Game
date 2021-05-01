import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory extends JPanel {
    HashMap<String, Integer> objectInventory = new HashMap<String, Integer>();
    int watchCount = 0;
    int coinCount = 0;
    int necklaceCount = 0;
    int ringCount = 0;
    int canCount = 0;

    public void buildInventory(){
        objectInventory.put("Watch", watchCount);
        objectInventory.put("Coin", coinCount);
        objectInventory.put("Necklace", necklaceCount);
        objectInventory.put("Engagement Ring", ringCount);
        objectInventory.put("Beer Can", canCount);
    }

    public void addWatch(){
        watchCount++;
    }
    public void addCoin(){
        coinCount++;
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

    public Inventory(){
        setFocusable(true);
        setSize(600,100);
        setBackground(Color.black);
    }

}
