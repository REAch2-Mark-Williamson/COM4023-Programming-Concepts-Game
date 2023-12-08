import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Player_Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player_Bullet extends Global_Object
{
    /**
     * Act - do whatever the Player_Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // Check if the Bullet is beyond the edge of the World's borders.
        if(isAtEdge()) {
            // If true, remove the object from the current world.
            getWorld().removeObject(this);
        } else {
            // Else, move it by 5 pixels.
            this.setLocation(this.getX()+5, this.getY());
            detectHit();
        }
        
    }
    
    public void detectHit() {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        
        if (enemy != null) {
            int health = enemy.GetHealth();
            if (health > 0){
                enemy.Damage();
                getWorld().removeObject(this);
            }
            else {
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
            }
        }
    }
    
}
