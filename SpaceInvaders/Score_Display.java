import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score_Display here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score_Display extends Global_Object
{
    public String Score_Text = "";
    
    public Score_Display(String Player_Score_Text) {
        GreenfootImage Player_Score_Label = new GreenfootImage(Player_Score_Text, 30, Color.WHITE, Color.BLACK);
        Player_Score_Label.drawString(Player_Score_Text, 2, 20);
        Score_Text = Player_Score_Text;
        setImage(Player_Score_Label);
    }

    public void Increment(){
        Integer Score_Int = Integer.valueOf(Score_Text) + 1;
        String Score_String = Integer.toString(Score_Int);
        GreenfootImage Player_Score_Label = new GreenfootImage(Score_String, 30, Color.WHITE, Color.BLACK);
        Player_Score_Label.drawString(Score_String, 20, 20);
        setImage(Player_Score_Label);
        Score_Text = Score_String;
    }
    
    public String Get_Text() {
        return Score_Text;
    }
}
