package MainPackage;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

public class SwarmElement extends GameObject
{
    public void collision(int id)
    {
        
    }
    public SwarmElement(BufferedImage bi, double x, double y)
    {
        this.X = x;
        this.Y = y;
        this.MainSprite = new Sprite(bi);
    }
    public SwarmElement(BufferedImage bi)
    {
        this.X = 0;
        this.Y = 0;
        this.MainSprite = new Sprite(bi);
    }
}
