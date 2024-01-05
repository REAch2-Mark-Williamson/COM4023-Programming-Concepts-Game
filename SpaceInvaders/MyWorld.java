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
    private int Speed_Of_Asteroid = 2;
    private int Health_Of_Ship = 3;
    private int Speed_Of_Ship = 2;
    private int Speed_Of_Sat = 4;
    private long Initial_Time = System.currentTimeMillis();
    private long Satellite_Time = System.currentTimeMillis();
    private HP_Display Player_Score = new HP_Display("Score  = ",0);
    private HP_Display Hp_Display = new HP_Display("3");
    private int Enemy_Count = 3;
    private boolean Score_Over_Ten;
    private boolean Score_Over_Fifteen;
    final private int WIDTH = getWidth()-50;
    private HP_Display HP_Display_Text;
    private Score_Display Score_Display_Text;
    private final int COOLDOWN_PERIOD = 1000;
    private int Current_Cooldown = 0;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); //600, 400, 1    - Changed size for now, to make it easier to demo (in my opinion)
        setBackground();

        HP_Display hp_display = new HP_Display("3");
        HP_Display_Text = hp_display;
        addObject(hp_display, 10, 50);
        
        Score_Display score_display = new Score_Display("0");
        Score_Display_Text = score_display;
        addObject(score_display, 10, 100);
        
        addObject(new Player(hp_display), 50, 200);
        addObject(new Asteroid(speedOfAsteroid), 500, 300);
        //addObject(Player_Score, getWidth()-100, 25);
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
                
        long Current_Time = System.currentTimeMillis();
        if (Current_Time >= Initial_Time + 500 + (Greenfoot.getRandomNumber(25)*100)){
            Enemy_Spawner("asteroid");
            Initial_Time = Current_Time;
        }
        if(getObjects(Enemy_Ship.class).size()<Enemy_Count) {       
            Enemy_Spawner("enemyship");
        }
        if (Current_Time >= Satellite_Time + 5000 + (Greenfoot.getRandomNumber(5)*1000)){
            Enemy_Spawner("satellite");
            Satellite_Time = Current_Time;
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
    
    public void Enemy_Spawner(String object) {


        switch(object){
            
            case "asteroid":
                int Height = Greenfoot.getRandomNumber(getHeight()-25);
                addObject(new Asteroid(Speed_Of_Asteroid, 1), WIDTH, Height);
                break;

            case "enemyship":
                int Ship_Height = Greenfoot.getRandomNumber(getHeight())-65;
                int Score = Get_Score().Int_Value();

                if(Score > 9 && Score < 15 && !Score_Over_Ten){
                    Speed_Of_Ship = Speed_Of_Ship + 2;
                    Score_Over_Ten = true;
                }else if (Score > 14 && Score < 20 && !Score_Over_Fifteen){
                    Speed_Of_Ship = Speed_Of_Ship + 2;
                    Health_Of_Ship = Health_Of_Ship +1;
                    Score_Over_Fifteen = true;
                }

                addObject(new Enemy_Ship(Speed_Of_Ship, Health_Of_Ship), WIDTH, Ship_Height);
                break;
                
            case "satellite":
                int Sat_Height = Greenfoot.getRandomNumber(getHeight())-65;
                addObject(new Satellite(Speed_Of_Sat, 3), WIDTH, Sat_Height);
                break;            
        }
    }
    

    public HP_Display Get_Score()
    {
        return Player_Score;
    }
    
    public HP_Display Get_HP()
    {
        return Hp_Display;
    }
}
