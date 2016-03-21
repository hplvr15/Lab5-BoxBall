import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Hannah Dela cruz
 * Lab 5 
 * 3/21/16
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private static final int BOUNDARY = 15;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) 
        {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) 
            {
                finished = true;
            }
        }
    }
    
    //length and witdh of canvas
    
    private void drawCanvas(Canvas canvas)
    {
        Double height = canvas.getSize().getHeight();
        Double width = canvas.getSize().getWidth();
        canvas.setVisible(true);
        //rectangle drawn using four lines and size of the canvas
        canvas.drawLine(BOUNDARY, height.intValue() - BOUNDARY, width.intValue() - BOUNDARY, height.intValue() - BOUNDARY);
        canvas.drawLine(BOUNDARY, BOUNDARY, width.intValue() - BOUNDARY, BOUNDARY);
        canvas.drawLine(BOUNDARY, BOUNDARY, BOUNDARY, height.intValue()- BOUNDARY);
        canvas.drawLine(width.intValue() - BOUNDARY, BOUNDARY, width.intValue() - BOUNDARY, height.intValue() - BOUNDARY);
    }
    
    public void boxBounce(int numberOfBalls)
    {
        if (numberOfBalls < 0)
       {
           System.out.println("Enter a positive number");
           return;
       }
       int tballs = numberOfBalls - 1;
       int x = 0;
       ArrayList<Boxball> balls = new ArrayList<>();
       drawCanvas(myCanvas);
       //add balls to arraylist based on numbrOfBalls
       for(int i = 0; i <= tballs; i++)
       {
         balls.add(new Boxball(myCanvas, BOUNDARY));
       }
       //draw balls from arraylist
       for(Boxball ball : balls)
       {
           ball.draw();
       }
       //timer of how long balls will move
       while(x <= 150)
       {
           //small delay
           myCanvas.wait(50); 
           for(Boxball ball : balls)
           {
               ball.move();
           }
           x++;
       }
    
       
    }




}
