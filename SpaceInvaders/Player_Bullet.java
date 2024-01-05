import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player_Bullet extends Global_Object
{
    
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
        Actor enemy = getOneIntersectingObject(Enemy.class);
        Actor powerup = getOneIntersectingObject(Powerup.class);
        
        if (powerup != null) {
            ((MyWorld) getWorld()).activatePowerup();
        }
        
        if (enemy != null) {
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
        }
    }
    
}
