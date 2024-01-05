import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP_Display here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP_Display extends Global_Object
{   
    public int Player_Score;
    public String Output_Beginning;
    

    public String HP_Text = "";
    
    // Constructor, sets the Player's health as a label.
    public HP_Display(String Player_HP_Text) {
        GreenfootImage Player_HP_Label = new GreenfootImage(Player_HP_Text, 30, Color.WHITE, Color.BLACK);
        Player_HP_Label.drawString(Player_HP_Text, 2, 20);
        HP_Text = Player_HP_Text;
        setImage(Player_HP_Label);
    }

    // Sets the health label to the argument given.
    public void Set_Text(String Player_HP_Text){
        GreenfootImage Player_HP_Label = new GreenfootImage(Player_HP_Text, 30, Color.WHITE, Color.BLACK);
        Player_HP_Label.drawString(Player_HP_Text, 2, 20);
        setImage(Player_HP_Label);
        HP_Text = Player_HP_Text;
    }
    
    // Returns the current player's health score.
    public String Get_Text() {
        return HP_Text;
    }
    
    // Increments the player's health by 1, used as a powerup.
       public void Increment(){
        Integer HP_Int = Integer.valueOf(HP_Text) + 1;
        String HP_String = Integer.toString(HP_Int);
        GreenfootImage Player_HP_Label = new GreenfootImage(HP_String, 30, Color.WHITE, Color.BLACK);
        Player_HP_Label.drawString(HP_String, 20, 20);
        setImage(Player_HP_Label);
        HP_Text = HP_String;
    }


    //Seans Additions
    public HP_Display(String Output_Beginning, int Player_Score) {
        this.Player_Score = Player_Score;
        this.Output_Beginning = Output_Beginning;
        String Input_Score = Integer.toString(Player_Score);
        Update_Display(Output_Beginning, Input_Score);
    }

    public void Update_Display(String Output_Beginning, String Display_Text){ //Output_Beginning = string that goes before the tracked value. "Score = ", "Health :", etc.
        GreenfootImage Display_Label = new GreenfootImage(Output_Beginning + Display_Text, 30, Color.WHITE, Color.BLACK);
        Display_Label.drawString(Display_Text, 0, 0);
        setImage(Display_Label);
    }

    public void Add_Score() {
        Player_Score ++ ;
        String Input_Score = Integer.toString(Player_Score);
        Update_Display(Output_Beginning, Input_Score);
    }

        
    public void Minus_Score() {
        Player_Score -- ;
        String Input_Score = Integer.toString(Player_Score);
        Update_Display(Output_Beginning, Input_Score);
    }

    public int Int_Value(){
        return Player_Score;
    }
}
