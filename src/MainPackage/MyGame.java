package MainPackage;

import com.golden.gamedev.*;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ColorBackground;

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
    
    SpriteGroup BLOCKS;
    
    Sprite racket;
    int oldMouseX;
    SpriteGroup RACKETS;
    
    SpriteGroup FIELD_BORDERS;
    
    BallToBlocksCollision collisionBallBlocks;
    BallToRacketCollision collisionBallRacket;
    BallToFieldBordersCollision collisionBallBorders;
    
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
         
         BLOCKS = new SpriteGroup("Blocks group");
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 50, 50));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 90, 50));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 130, 50));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 170, 50));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 210, 50));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 250, 50));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 50, 75));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 90, 75));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 130, 75));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 170, 75));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 210, 75));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 250, 75));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 50, 100));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 90, 100));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 130, 100));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 170, 100));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 210, 100));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 250, 100));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 50, 125));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 90, 125));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 130, 125));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 170, 125));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 210, 125));
         BLOCKS.add(new Sprite(getImage("Images/Block_standart.png"), 250, 125));
         
         RACKETS = new SpriteGroup("Rackets group");
         racket = new Sprite(getImage("Images/Racket.png"), ScreenX/2 - 100/2, ScreenY - 20);
         racket.setID(1);
         RACKETS.add(racket);
         oldMouseX = getMouseX();
         
         FIELD_BORDERS = new SpriteGroup("Field borders group");
         FIELD_BORDERS.add(new Sprite(getImage("Images/Field_End_Horizontal.png"), 0, 0));
         FIELD_BORDERS.add(new Sprite(getImage("Images/Field_End_Horizontal.png"), 0, ScreenY - 3));
         FIELD_BORDERS.add(new Sprite(getImage("Images/Field_End_Vertical.png"), 0, 0));
         FIELD_BORDERS.add(new Sprite(getImage("Images/Field_End_Vertical.png"), ScreenX - 3, 0));
         
         collisionBallBlocks = new BallToBlocksCollision();
         collisionBallBlocks.setCollisionGroup(BALLS, BLOCKS);
         collisionBallBlocks.pixelPerfectCollision = true;
         
         collisionBallRacket = new BallToRacketCollision();
         collisionBallRacket.setCollisionGroup(BALLS, RACKETS);
         collisionBallRacket.pixelPerfectCollision = true;
         
         collisionBallBorders = new BallToFieldBordersCollision();
         collisionBallBorders.setCollisionGroup(BALLS, FIELD_BORDERS);
         collisionBallBorders.pixelPerfectCollision = true;
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
        
        BLOCKS.update(elapsedTime);
        
        RACKETS.update(elapsedTime);
        
        FIELD_BORDERS.update(elapsedTime);
        
        collisionBallBlocks.checkCollision();
        collisionBallRacket.checkCollision();
        collisionBallBorders.checkCollision();
        
        //for test only. Delete in release.
        if (keyDown(KeyEvent.VK_DOWN))
        {
            Ball.move(0, 0.8 * elapsedTime);
        }
        if (keyDown(KeyEvent.VK_UP))
        {
            Ball.move(0, -0.8 * elapsedTime);
        }
        if (keyDown(KeyEvent.VK_LEFT))
        {
            Ball.move(-0.8 * elapsedTime, 0);
        }
        if (keyDown(KeyEvent.VK_RIGHT))
        {
            Ball.move(0.8 * elapsedTime, 0);
        }
        if (keyDown(KeyEvent.VK_R))
        {
            Ball.moveTo(1, 50, 50, 1);// moveTo(speed, x, y, amount of pixels per <speed>)
        }
        if (keyPressed(KeyEvent.VK_ESCAPE))
        {
            Ball.setLocation(400, 400);
            Ball.setActive(true);
        }
        //end for test only.
        if (getMouseX() != oldMouseX)
        {
            oldMouseX = getMouseX();
            racket.setLocation(oldMouseX - 100/2, racket.getY());
        }
    }
    
    @Override
    public void render(Graphics2D g)
    {
         background.render(g);
         BALLS.render(g);
         BLOCKS.render(g);
         RACKETS.render(g);
         FIELD_BORDERS.render(g);
    }
    
    public static void main(String[] args)
    {
        GameLoader game = new GameLoader();
        game.setup(new MyGame(), new Dimension(ScreenX, ScreenY), false);
        game.start();
    }
}

