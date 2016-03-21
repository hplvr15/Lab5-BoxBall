import java.awt.Color;
import java.awt.geom.*;
import java.util.Random;

/**
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boxball
{
    // instance variables - replace the example below with your own
    private final Color color;
    private final int diameter;
    private final Canvas myCanvas;
    private final int bouncingBox;
    private int xPos;
    private int yPos;
    private int speedX;
    private int speedY;
    
    Random ran = new Random();
    
    /**
     * Constructor for objects of class Boxball
     */
    public Boxball(Canvas myCanvas, int bouncingBox)
    {
        this.myCanvas = myCanvas;
        this.bouncingBox = bouncingBox;
        color = new Color(ran.nextInt(245), ran.nextInt(245), ran.nextInt(245)); 
        diameter = ran.nextInt(25) + 10; 
        xPos = ran.nextInt(myCanvas.getSize().width);
        yPos = ran.nextInt(myCanvas.getSize().width);
        speedX = ran.nextInt(8) + 1;
        speedY = ran.nextInt(8) + 1;        
    }

    public void draw()
    {
        myCanvas.setForegroundColor(color);
        myCanvas.fillCircle(xPos, yPos, diameter);
    }
    
    public void erase()
    {
        myCanvas.eraseCircle(xPos, yPos, diameter);
    }
    
    public void move()
    {
        // erase from canvas at current position
        erase();
        //
        xPos += speedX;
        yPos += speedY;
        
        if (xPos <= bouncingBox)
        {
            xPos = bouncingBox;
            speedX = -speedX;
        }
        
        if (xPos >= myCanvas.getSize().getWidth() - bouncingBox - diameter)
        {
            xPos = (int)(myCanvas.getSize().getWidth() - bouncingBox - diameter);
            speedX = -speedX;
        }
        
        if (yPos <= bouncingBox)
        {
            yPos = bouncingBox;
            speedY = -speedY;
        }
        
        if (yPos >= myCanvas.getSize().getHeight() - bouncingBox - diameter)
        {
            yPos = (int)(myCanvas.getSize().getHeight() - bouncingBox - diameter);
            speedY = -speedY;
        }
        draw();
    }
    
    //
    public int getYPosition()
    {
        return yPos;
    }
}
