import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Main_Menu_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main_Menu_Button extends Global_Object
{
    /**
     * Act - do whatever the Main_Menu_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Main_Menu());
        }
    }
}
