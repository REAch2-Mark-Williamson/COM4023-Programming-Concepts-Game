import javax.management.loading.PrivateClassLoader;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the player object which is controlled by the player
 * 
 * @author 
 * @version 0.1
 */
public class Player extends Global_Object
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    
    private int Player_Speed = 5;
    private final int COOLDOWN_PERIOD = 30;
    private int Current_Cooldown = 0;
    private int Damage_Cooldown = 0;
    private HP_Display Player_HP_Display;
    public int Player_Health = 3;
    
    // Constructor, sets the player's health.
    public Player(HP_Display hp_display) {
        Player_HP_Display = hp_display;
    }

    public void act()
    {
        if (Player_Health <= 0){
            Score_Display counter = ((MyWorld)getWorld()).Get_Score();
            //If the players health is 0 or less the Actor is destroyed.
            Greenfoot.setWorld(new Death_Screen(counter));
        }
        
        if (isTouching(Enemy.class)){
            Enemy Enemy = (Enemy) getOneIntersectingObject(Enemy.class);
            //Checks if there is no damage cooldown and removes a point of HP
            if (Damage_Cooldown <= 0 && !(Enemy instanceof Powerup)){
                // Player_Health--;
                // String Player_HP_Text = Integer.toString(Player_Health);
                // Player_HP_Display.Set_Text(Player_HP_Text);
                Player_HP_Display.Decrement();
                Player_Health = Integer.valueOf(Player_HP_Display.Get_Text());
                Damage_Cooldown = COOLDOWN_PERIOD;
            }
            
            if (Damage_Cooldown > 0) {
                // If the player's cooldown has not expired, decrement it by 1.
                Damage_Cooldown--;
            }
        }
        
        if (Greenfoot.isKeyDown("s")){
            // Sets the location of the Player downwards by increasing the Y value.
            setLocation(getX(), getY()+Player_Speed);
        }
        if (Greenfoot.isKeyDown("w")){
            // Sets the location of the Player upwards by decreasing the Y value.
            setLocation(getX(), getY()-Player_Speed);
        }
        // Checks if the Player's shooting cooldown period has expired.
        if(Current_Cooldown > 0) {
                // If the player's cooldown has not expired, decrement it by 1.
                Current_Cooldown--;
                // If the player's cooldown has expired, run the bullet spawn method.
            }  else if (Greenfoot.isKeyDown("space")){
                Player_Bullet_Spawn();
                // Sets the current cooldown to the specified time after running the method.
                Current_Cooldown = COOLDOWN_PERIOD;
        }
    }
    
    //Spawn player bullet
    public void Player_Bullet_Spawn (){
        // Gets the current world and stores it in Current_World.
        World Current_World=getWorld();
        // Initialise and set's the variables for the Player's X and Y dimensions.
        int Player_X_Pos = getX();
        int Player_Y_Pos = getY();
        // Adds a new Bullet object into the current world.
        Current_World.addObject(new Player_Bullet(), Player_X_Pos + 60, Player_Y_Pos);
    }
}
