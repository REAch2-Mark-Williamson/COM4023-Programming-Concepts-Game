import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the player object which is controlled by the player
 * 
 * @author Mark Williamson
 * @version 0.1
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("a")){
            move(-5);
        }
        if (Greenfoot.isKeyDown("d")){
            move(5);
        }
    }
}
