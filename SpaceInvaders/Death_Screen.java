import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death_Screen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Death_Screen extends World
{

    /**
     * Constructor for objects of class Death_Screen.
     * 
     */
    public Death_Screen(Counter counter)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground();
        addObject(new Main_Menu_Button(), 150, 250); 
        addObject(new New_Game_Button(), 440, 250); 
        addObject(counter, getWidth()-(getWidth()/2), getHeight()-50);
        addObject(new Wasted(), getWidth()-(getWidth()/2), 100);
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
