import javax.swing.*;

public class BuriedObject extends JPanel {
    protected int x, y;
    public BuriedObject (int x, int y)
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
