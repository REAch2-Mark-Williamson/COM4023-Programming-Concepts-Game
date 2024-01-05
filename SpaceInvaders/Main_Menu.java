import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Main_Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main_Menu extends World
{

    /**
     * Constructor for objects of class Main_Menu.
     * 
     */
    public Main_Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Set_Background();
        addObject(new New_Game_Button(), getWidth()-(getWidth()/2), 250); 
        addObject(new Galactic_Dash_Logo(), getWidth()-(getWidth()/2), 120);
    }
    
    public void Set_Background() {
        //Gets current background
        GreenfootImage background = getBackground();
        
        //Sets the current background to black
        background.setColor(Color.BLACK);
        
        //Fills the background in using the dimensions of the current world size
        background.fillRect(0,0,getWidth(),getHeight());
    }
}
