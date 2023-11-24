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
        addObject(new Play_Button(), 300, 200); 
    }
}
