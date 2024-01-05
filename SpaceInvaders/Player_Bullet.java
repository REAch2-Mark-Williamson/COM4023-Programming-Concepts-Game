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
            Detect_Hit();
        }
        
    }
    
    public void detectHit() {
        // Checks whether the given class is intersecting with this object and stores the results in the variable.
        Enemy enemy = getOneIntersectingObject(Enemy.class);
        Actor powerup = getOneIntersectingObject(Powerup.class);
        
        // If the result of the intersectingObject function is not null run this code.
        if (powerup != null) {
            // Runs the activatePowerup function in the MyWorld subclass.
            ((MyWorld) getWorld()).activatePowerup();
        }
        
        if (Enemy != null) {
            Enemy.Damage();
            int Health = Enemy.Get_Health();
            if (Health >= 1){
                getWorld().removeObject(this);
            }
            else if (Health < 1){
                if (Enemy instanceof Enemy_Ship){
                    HP_Display Player_HP_Display = ((MyWorld)getWorld()).Get_Score();
                    Player_HP_Display.Add_Score();
                }else if (Enemy instanceof Satellite){
                    HP_Display Player_HP_Display = ((MyWorld)getWorld()).Get_Score();
                    Player_HP_Display.Minus_Score();
                }
                getWorld().removeObject(Enemy);
                getWorld().removeObject(this);
            }
        }
    }
    
}
