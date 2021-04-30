import javax.swing.*;

public class Object extends JPanel {
    public int x, y;
    public Object (int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public int getX()
    {
        return x;
    }
    @Override
    public int getY()
    {
        return y;
    }
    public void setX()
    {
        this.x = x;
    }
    public void setY()
    {
        this.y = y;
    }

}
