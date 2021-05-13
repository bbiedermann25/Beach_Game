import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Object extends JPanel {
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

    public void setup(){
        itemList.put("emerald", 100);
        itemList.put("coin", 50);
        itemList.put("necklace", 300);
        itemList.put("ring", 500);

        spawn();
    }

    public void changeObject(int x){
        if (x <= 5){
            type = "ring";
        }
        else if(x <= 15){
            type = "necklace";
        }
        else if(x <= 50){
            type = "emerald";
        }
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

        value = itemList.get(s);

    }

    public int getValue(){
        return this.value;
    }

    public void spawn(){
        this.x = rd.nextInt(792);
        this.y = rd.nextInt(592);
        playerNear = false;
        found = false;
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


    public void paint(Graphics g){
            if (playerNear){
                g.drawImage(image, x, y, null);
                setOpaque(false);
            }
        }
}


