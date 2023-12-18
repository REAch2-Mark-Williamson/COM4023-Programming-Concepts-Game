import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    public int score = 0;
    public void updateCount(){
        setImage(new GreenfootImage("Score = " + score , 50, Color.WHITE, Color.BLACK));
    }

    public Counter(){
        updateCount();
    }

    public void addCount(){
        score++;
        updateCount();
    }

}
