import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Satellite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Satellite extends Enemy
{
    /**
     * Act - do whatever the CopyOfEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Satellite(int Speed, int Health) {
        super(Speed+Greenfoot.getRandomNumber(3), Health);
    }

    public int Get_Health(){
        return super.Get_Health();
    }

    public void Damage(){
        super.Damage();
    }
}
