import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP_Display here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP_Display extends Global_Object
{   
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
}
