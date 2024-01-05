import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int Speed_Of_Asteroid = 2;
    private int Health_Of_Ship = 3;
    private int Speed_Of_Ship = 2;
    private int Speed_Of_Sat = 4;
    private long Initial_Time = System.currentTimeMillis();
    private long Satellite_Time = System.currentTimeMillis();
    private HP_Display Player_Score = new HP_Display("Score  = ",0);
    private HP_Display Hp_Display = new HP_Display("3");
    private int Enemy_Count = 3;
    private boolean Score_Over_Ten;
    private boolean Score_Over_Fifteen;
    final private int WIDTH = getWidth()-50;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); //600, 400, 1    - Changed size for now, to make it easier to demo (in my opinion)
        Set_Background();
        addObject(Hp_Display, 10, 50);
        addObject(new Player(Hp_Display), 50, 200);
        addObject(new Asteroid(5,1), getWidth()-50, Greenfoot.getRandomNumber(getHeight()));
        addObject(Player_Score, getWidth()-100, 25);
    }
    
    public void act() {
        long Current_Time = System.currentTimeMillis();
        if (Current_Time >= Initial_Time + 500 + (Greenfoot.getRandomNumber(25)*100)){
            Enemy_Spawner("asteroid");
            Initial_Time = Current_Time;
        }
        if(getObjects(Enemy_Ship.class).size()<Enemy_Count) {       
            Enemy_Spawner("enemyship");
        }
        if (Current_Time >= Satellite_Time + 5000 + (Greenfoot.getRandomNumber(5)*1000)){
            Enemy_Spawner("satellite");
            Satellite_Time = Current_Time;
            }
        }
    
    
    public void Set_Background() {
        //Gets current background
        GreenfootImage background = getBackground();
        
        //Sets the current background to black
        background.setColor(Color.BLACK);
        
        //Fills the background in using the dimensions of the current world size
        background.fillRect(0,0,getWidth(),getHeight());
    }
    
    public void Enemy_Spawner(String object) {


        switch(object){
            
            case "asteroid":
                int Height = Greenfoot.getRandomNumber(getHeight()-25);
                addObject(new Asteroid(Speed_Of_Asteroid, 1), WIDTH, Height);
                break;

            case "enemyship":
                int Ship_Height = Greenfoot.getRandomNumber(getHeight())-65;
                int Score = Get_Score().Int_Value();

                if(Score > 9 && Score < 15 && !Score_Over_Ten){
                    Speed_Of_Ship = Speed_Of_Ship + 2;
                    Score_Over_Ten = true;
                }else if (Score > 14 && Score < 20 && !Score_Over_Fifteen){
                    Speed_Of_Ship = Speed_Of_Ship + 2;
                    Health_Of_Ship = Health_Of_Ship +1;
                    Score_Over_Fifteen = true;
                }

                addObject(new Enemy_Ship(Speed_Of_Ship, Health_Of_Ship), WIDTH, Ship_Height);
                break;
                
            case "satellite":
                int Sat_Height = Greenfoot.getRandomNumber(getHeight())-65;
                addObject(new Satellite(Speed_Of_Sat, 3), WIDTH, Sat_Height);
                break;            
        }
    }
    

    public HP_Display Get_Score()
    {
        return Player_Score;
    }
    
    public HP_Display Get_HP()
    {
        return Hp_Display;
    }
}
