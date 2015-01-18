package MainPackage;

import com.golden.gamedev.*;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ColorBackground;
import com.golden.gamedev.object.collision.AdvanceCollisionGroup;

import java.awt.*;
import java.awt.event.*;

public class MyGame extends Game
{ 
    private int Time;
    private boolean Pause;
    private GameField Field;
    private Player Plr;
    
    static int ScreenX = 1024;
    static int ScreenY = 768;
    
    Background background;
    
    @Override
    public void initResources()
    {
         background = new ColorBackground(Color.DARK_GRAY, ScreenX, ScreenY);
    }
    
    @Override
    public void update(long elapsedTime)
    {
        background.update(elapsedTime); 
    }
    
    @Override
    public void render(Graphics2D g)
    {
         background.render(g);
    }
    
    public static void main(String[] args)
    {
        GameLoader game = new GameLoader();
        game.setup(new MyGame(), new Dimension(ScreenX, ScreenY), false);
        game.start();
    }
}

