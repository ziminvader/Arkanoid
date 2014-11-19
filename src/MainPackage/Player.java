package MainPackage;
public class Player 
{
    private int lives;
    public int score;
    public Player()
    {
        score = 0;
        lives = 3;
    }
    public Player(int lv)
    {
        score = 0;
        this.lives = lv;
    }
}
