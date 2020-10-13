import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Greg Babbert
 * @version 2020.10.12
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random random;
    private Color color;
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        random = new Random();
        color = new Color((random.nextInt(125) + 75), (random.nextInt(125) + 75), (random.nextInt(125) + 75));
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    /**
     * Simulate balls bouncing in a box
     */
    public void boxBounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the box
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);
        myCanvas.drawLine(50, 25, 550, 25);
        myCanvas.drawLine(50, ground, 50, 25);
        myCanvas.drawLine(550, ground, 550, 25);

        // create and show the balls
        BoxBall ball = new BoxBall(16, color, ground, myCanvas);
        ball.draw();
        BoxBall ball2 = new BoxBall(100, color, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
