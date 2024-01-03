import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Global_Object
{
    public int Enemy_Speed;
    public int Enemy_Health;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemy(int Speed, int Health) {
        Enemy_Speed = Speed;
        Enemy_Health = Health;
    }

    public int GetHealth(){
        return Enemy_Health;
    }

    public void Damage(){
        Enemy_Health--;
    }

    
    public void act()
    {
        if(isAtEdge()) {
            // If true, remove the object from the current world.
            this.Destroy_Object();
        } else {
            // Else, move it by 5 pixels.
            this.setLocation(this.getX() - Enemy_Speed, this.getY());
        }
    }
}
