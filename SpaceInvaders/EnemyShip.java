import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip extends Enemy
{
    /**
     * Act - do whatever the CopyOfEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public EnemyShip(int Speed, int Health) {
        super(Speed+Greenfoot.getRandomNumber(3), Health);
    }

    public int GetHealth(){
        return super.GetHealth();
    }

    public void Damage(){
        super.Damage();
    }  
}
