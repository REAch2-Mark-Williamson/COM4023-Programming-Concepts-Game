import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Enemy
{
    /**
     * Act - do whatever the CopyOfEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Asteroid(int Speed, int Health) {
        super(Speed+Greenfoot.getRandomNumber(5), Health);
    }

    public int GetHealth(){
        return super.GetHealth();
    }

    public void Damage(){
        super.Damage();
    }   
}
