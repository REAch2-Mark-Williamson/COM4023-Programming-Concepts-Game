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
    private int healthOfShip = 3;
    private int speedOfShip = 2;
    private int speedOfSat = 4;
    private long initTime = System.currentTimeMillis();
    private long satTime = System.currentTimeMillis();
    private HP_Display score = new HP_Display("Score  = ",0);
    private HP_Display hp_display = new HP_Display("3");
    private int enemyCount = 3;
    private boolean scoreTen;
    private boolean scoreFifteen;
    final private int WIDTH = getWidth()-50;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); //600, 400, 1    - Changed size for now, to make it easier to demo (in my opinion)
        setBackground();
        addObject(hp_display, 10, 50);
        addObject(new Player(hp_display), 50, 200);
        addObject(new Asteroid(5,1), getWidth()-50, Greenfoot.getRandomNumber(getHeight()));
        addObject(score, getWidth()-100, 25);
    }
    
    public void act() {
        long currentTime = System.currentTimeMillis();
        if (currentTime >= initTime + 500 + (Greenfoot.getRandomNumber(25)*100)){
            enemySpawner("asteroid");
            initTime = currentTime;
        }
        if(getObjects(EnemyShip.class).size()<enemyCount) {       
            enemySpawner("enemyship");
        }
        if (currentTime >= satTime + 5000 + (Greenfoot.getRandomNumber(5)*1000)){
            enemySpawner("satellite");
            satTime = currentTime;
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
    
    public void enemySpawner(String object) {


        switch(object){
            
            case "asteroid":
                int Height = Greenfoot.getRandomNumber(getHeight()-25);
                addObject(new Asteroid(speedOfAsteroid, 1), WIDTH, Height);
                break;

            case "enemyship":
                int shipHeight = Greenfoot.getRandomNumber(getHeight())-65;
                int score = getScore().intValue();

                if(score > 9 && score < 15 && !scoreTen){
                    speedOfShip = speedOfShip + 2;
                    scoreTen = true;
                }else if (score > 14 && score < 20 && !scoreFifteen){
                    speedOfShip = speedOfShip + 2;
                    healthOfShip = healthOfShip +1;
                    scoreFifteen = true;
                }

                addObject(new EnemyShip(speedOfShip, healthOfShip), WIDTH, shipHeight);
                break;
                
            case "satellite":
                int satHeight = Greenfoot.getRandomNumber(getHeight())-65;
                addObject(new Satellite(speedOfSat, 3), WIDTH, satHeight);
                break;            
        }
    }
    

    public HP_Display getScore()
    {
        return score;
    }
    
    public HP_Display getHP()
    {
        return hp_display;
    }
}
