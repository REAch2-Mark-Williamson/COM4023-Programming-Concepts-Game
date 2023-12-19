import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
            enemy.Damage();
            int health = enemy.GetHealth();
            String s = String.valueOf(health);
            if (health >= 1){
                getWorld().removeObject(this);
            }
            else if (health < 1){
                if (enemy instanceof EnemyShip){
                    HP_Display Player_HP_Display = ((MyWorld)getWorld()).getScore();
                    String Player_HP_Text = "7";
                    Player_HP_Display.addScore();
                }
                getWorld().removeObject(enemy);
                getWorld().removeObject(this);
            }
        }
    }
    
}
