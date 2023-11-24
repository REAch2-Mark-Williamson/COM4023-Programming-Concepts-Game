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
    
    private int speedOfEnemy = 2;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground();
        addObject(new Player(), 50, 200);
        addObject(new Enemy(speedOfEnemy), 500, 300);
    }
    
    public void act() {
        if(getObjects(Enemy.class).isEmpty()) {
            int x = Greenfoot.getRandomNumber(400);
            addObject(new Enemy(speedOfEnemy), 550, x);
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
}
