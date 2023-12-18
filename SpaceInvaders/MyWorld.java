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
    private long initTime = System.currentTimeMillis();
    private Counter score = new Counter();
    private int enemyCount = 2;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); //600, 400, 1    - Changed size for now, to make it easier to demo (in my opinion)
        setBackground();
        HP_Display hp_display = new HP_Display("3");
        addObject(hp_display, 10, 50);
        addObject(new Player(hp_display), 50, 200);
        addObject(new Asteroid(5,1), getWidth()-50, Greenfoot.getRandomNumber(getHeight()));
        addObject(score, getWidth()-100, 25);
        getCounter();

    }
    
    public void act() {
        long currentTime = System.currentTimeMillis();
        if (currentTime >= initTime + 1000){
            enemySpawner("asteroid", 6);
            initTime = currentTime;
        }
        if(getObjects(EnemyShip.class).size()<enemyCount) {       
            enemySpawner("enemyship", 0);
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
    
    public void enemySpawner(String object, int maxRand) {
        int width = getWidth()-50;
            if (object.contains("asteroid")){
                int rand = Greenfoot.getRandomNumber(maxRand);
                while (rand >0) {
                    int Height = 50+Greenfoot.getRandomNumber(getHeight()-50);
                    addObject(new Asteroid(speedOfAsteroid, 1), width, Height);
                    rand--;
                }
            } //added the getHeight and getWidth to make it auto adjust to size
            else if (object.contains("enemyship")){
                int Height = 50+Greenfoot.getRandomNumber(getHeight()-50);
                addObject(new EnemyShip(speedOfShip, 3), width, Height);
            }

            

        }
    

    public Counter getCounter()
    {
        return score;
    }
}
