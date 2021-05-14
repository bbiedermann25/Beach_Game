import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Object extends JPanel {
    //instance variables
    public int x, y;
    public boolean playerNear = false;
    public boolean found = false;
    private String type;
    private int value;
    private Image image;
    private HashMap<String,Integer> itemList = new HashMap<String,Integer>();
    private Image emerald = new ImageIcon("Assets/emerald.png").getImage();
    private Image coin = new ImageIcon("Assets/coin.png").getImage();
    private Image necklace = new ImageIcon("Assets/necklace.png").getImage();
    private Image ring = new ImageIcon("Assets/ring.png").getImage();
    Random rd = new Random();

    //item names with corresponding values are added to the hashmap
    //and item is spawned
    public void setup(){
        itemList.put("emerald", 100);
        itemList.put("coin", 50);
        itemList.put("necklace", 300);
        itemList.put("ring", 500);
        spawn();
    }

    public void changeObject(int x){
        //5% of ring spawn
        if (x <= 5){
            type = "ring";
        }
        //10% chance of necklace spawn
        else if(x <= 15){
            type = "necklace";
        }
        //35% spawn of necklace
        else if(x <= 50){
            type = "emerald";
        }
        //50% chance of coin spawn
        else{
            type = "coin";
        }
    }

    public void setValues(String s){
        if (s.equals("ring")){
            image = ring;
        }
        if (s.equals("necklace")){
            image = necklace;
        }
        if (s.equals("emerald")){
            image = emerald;
        }
        if (s.equals("coin")){
            image = coin;
        }

        //value of item changed depending on item
        value = itemList.get(s);

    }

    public int getValue(){
        return this.value;
    }

    public void spawn(){
        //x and y randomized
        this.x = rd.nextInt(780);
        this.y = rd.nextInt(580);
        playerNear = false;
        found = false;
        //generates number 1-100 to randomly select item type
        int generator = rd.nextInt(99) + 1;
        changeObject(generator);
        setValues(type);
    }

    public Image getEmerald() {
        return emerald;
    }
    public Image getCoin() {
        return coin;
    }
    public Image getNecklace() {
        return necklace;
    }
    public Image getRing() {
        return ring;
    }

    public String getType(){
        return this.type;
    }

    public HashMap<String, Integer> getItemList(){
        return this.itemList;
    }


    public void paint(Graphics g){
            if (playerNear){
                g.drawImage(image, x, y, null);
                setOpaque(false);
            }
        }
}


