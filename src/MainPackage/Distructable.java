package MainPackage;

import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

public class Distructable extends Brick{
    public Distructable(BufferedImage bi, double x, double y)
    {
        this.X = x;
        this.Y = y;
        this.MainSprite = new Sprite(bi);
    }
    public Distructable(BufferedImage bi)
    {
        this.X = 0;
        this.Y = 0;
        this.MainSprite = new Sprite(bi);
    }
    public Distructable()
    {
        this.X = 0;
        this.Y = 0;
        this.MainSprite = null;
    }
}
