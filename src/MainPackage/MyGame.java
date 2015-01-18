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
    
    Sprite Ball;
    double speed = 0.3;
    SpriteGroup BALLS;
    
    @Override
    public void initResources()
    {
         background = new ColorBackground(Color.DARK_GRAY, ScreenX, ScreenY);
         
         BALLS = new SpriteGroup("Balls group");
         Ball = new Sprite(getImage("Images/Ball_standart.png"), ScreenX/2, ScreenY/2);
         Ball.setSpeed(speed, speed);
         Ball.setImmutable(true);
         Ball.setID(2);
         BALLS.add(Ball);
    }
    
    @Override
    public void update(long elapsedTime)
    {
        background.update(elapsedTime); 
        
        BALLS.update(elapsedTime);
        Sprite[] sprite;
        sprite = BALLS.getSprites();
        BALLS.clear();
        for (int i = 0; i < sprite.length - 1; i++)
        {
            if (sprite[i] != null)
            {
                sprite[i].setID(2);
                BALLS.add(sprite[i]);
            }
        }
    }
    
    @Override
    public void render(Graphics2D g)
    {
         background.render(g);
         BALLS.render(g);
    }
    
    public static void main(String[] args)
    {
        GameLoader game = new GameLoader();
        game.setup(new MyGame(), new Dimension(ScreenX, ScreenY), false);
        game.start();
    }
}

