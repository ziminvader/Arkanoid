package MainPackage;

import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

public class GameObject
{
    public int ID;
    public double X;
    public double Y;
    public Sprite MainSprite;
    public Sprite[] SpriteEffects;
    
    public GameObject(BufferedImage bi, double x, double y)
    {
        this.X = x;
        this.Y = y;
        this.MainSprite = new Sprite(bi);
    }
    public GameObject(BufferedImage bi)
    {
        this.X = 0;
        this.Y = 0;
        this.MainSprite = new Sprite(bi);
    }
    public GameObject()
    {
        this.X = 0;
        this.Y = 0;
        this.MainSprite = null;
    }
}
