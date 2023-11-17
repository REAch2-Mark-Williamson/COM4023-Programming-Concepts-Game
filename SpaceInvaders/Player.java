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
    
    private int Player_Speed = 5;
    
    public void act()
    {
        if (Greenfoot.isKeyDown("a")){
            move(- Player_Speed);
        }
        if (Greenfoot.isKeyDown("d")){
            move(Player_Speed);
        }
        if (Greenfoot.isKeyDown("space")){
            Player_Bullet_Spawn();
        }
    }
    
    //Spawn player bullet
    public void Player_Bullet_Spawn (){
        World Current_World=getWorld();
        int Player_X_Pos = getX();
        int Player_Y_Pos = getY();
        Current_World.addObject(new Player_Bullet(), Player_X_Pos, Player_Y_Pos);
    }
}
