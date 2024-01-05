import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    private int speedOfAsteroid = 2;
    private int speedOfShip = 2;
    private HP_Display HP_Display_Text;
    private Score_Display Score_Display_Text;
    private final int COOLDOWN_PERIOD = 1000;
    private int Current_Cooldown = 0;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); //600, 400, 1    - Changed size for now, to make it easier to demo (in my opinion)
        setBackground();

        HP_Display hp_display = new HP_Display("3");
        HP_Display_Text = hp_display;
        addObject(hp_display, 10, 50);
        
        Score_Display score_display = new Score_Display("0");
        Score_Display_Text = score_display;
        addObject(score_display, 10, 100);
        
        addObject(new Player(hp_display), 50, 200);
        addObject(new Asteroid(speedOfAsteroid), 500, 300);
    }
    
    public void act() {
        if(getObjects(EnemyShip.class).isEmpty() && getObjects(Asteroid.class).isEmpty()) {
            Score_Display_Text.Increment();
            int spawnHeight = Greenfoot.getRandomNumber(getHeight());
            int shipHeight = Greenfoot.getRandomNumber(getHeight());
            addObject(new Asteroid(speedOfAsteroid), getWidth()-50, spawnHeight); //added the getHeight and getWidth to make it auto adjust to size
            addObject(new EnemyShip(speedOfShip), getWidth()-50, shipHeight);
        }
        
        if(Current_Cooldown > 0) {
                // If the player's cooldown has not expired, decrement it by 1.
                Current_Cooldown--;
                // If the player's cooldown has expired, run the bullet spawn method.
            }  else if (Integer.valueOf(Score_Display_Text.Get_Text()) > 1 && Integer.valueOf(Score_Display_Text.Get_Text()) % 10 == 0){
                    int powerupHeight = Greenfoot.getRandomNumber(getHeight());
                    addObject(new Powerup(speedOfAsteroid), getWidth()-50, powerupHeight);
                    // Sets the current cooldown to the specified time after running the method.
                    Current_Cooldown = COOLDOWN_PERIOD;
                }
    }
    
    public void setBackground() {
        //Gets current background
        GreenfootImage background = getBackground();
        
        //Sets the current background to black
        background.setColor(Color.BLACK);
        
        //Fills the background in using the dimensions of the current world size
        background.fillRect(0,0,getWidth(),getHeight());
    }
    
    public void activatePowerup() {
        HP_Display_Text.Increment();
    }
}
