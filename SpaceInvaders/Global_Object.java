import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Global_Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Global_Object extends Actor
{
    //Destroy actors
    public void Destroy_Object() {
        getWorld().removeObject(this);
    }

}
