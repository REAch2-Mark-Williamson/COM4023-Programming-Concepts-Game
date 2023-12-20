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
    

    public HP_Display(String Player_HP_Text) {
        GreenfootImage Player_HP_Label = new GreenfootImage(Player_HP_Text, 30, Color.WHITE, Color.BLACK);
        Player_HP_Label.drawString(Player_HP_Text, 2, 20);
        setImage(Player_HP_Label);
    }

    public void Set_Text(String Player_HP_Text){
        GreenfootImage Player_HP_Label = new GreenfootImage(Player_HP_Text, 30, Color.WHITE, Color.BLACK);
        Player_HP_Label.drawString(Player_HP_Text, 2, 20);
        setImage(Player_HP_Label);
    }


    //Seans Additions
    public HP_Display(String Output_Beginning, int Player_Score) {
        this.Player_Score = Player_Score;
        this.Output_Beginning = Output_Beginning;
        String Input_Score = Integer.toString(Player_Score);
        updateDisplay(Output_Beginning, Input_Score);
    }

    public void updateDisplay(String Output_Beginning, String Display_Text){ //Output_Beginning = string that goes before the tracked value. "Score = ", "Health :", etc.
        GreenfootImage Display_Label = new GreenfootImage(Output_Beginning + Display_Text, 30, Color.WHITE, Color.BLACK);
        Display_Label.drawString(Display_Text, 0, 0);
        setImage(Display_Label);
    }

    public void addScore() {
        Player_Score ++ ;
        String Input_Score = Integer.toString(Player_Score);
        updateDisplay(Output_Beginning, Input_Score);
    }

        
    public void minusScore() {
        Player_Score -- ;
        String Input_Score = Integer.toString(Player_Score);
        updateDisplay(Output_Beginning, Input_Score);
    }

    public int intValue(){
        return Player_Score;
    }
}
