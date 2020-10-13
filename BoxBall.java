import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2016.02.29
 */

public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int xSpeed;
    private int ySpeed;
    private int direction;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private Random randomx;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int ballDiameter, Color ballColor,
                        int groundPos, Canvas drawingCanvas)
    {
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
        randomx = new Random();
        xPosition = (randomx.nextInt(350)) + 100;
        yPosition = (randomx.nextInt(300)) + 50;
        xSpeed = (randomx.nextInt(7)) + 1;
        ySpeed = (randomx.nextInt(7)) + 1;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
        
        // line positions
        int right_side = 550;
        int bottom = 400;
        int top = 25;
        int left_side = 50;
            
        // compute new position
        
        yPosition += ySpeed;
        xPosition += xSpeed;
        
        if (xPosition > (right_side - (diameter + 7))) {
          xSpeed = -xSpeed;
        }
        
        if (yPosition > (bottom - (diameter + 7))) {
          ySpeed = -ySpeed;
        }
        
        if (yPosition < (top + 7)) {
          ySpeed = -ySpeed;
        }
        
        if (xPosition < (left_side + 8)) {
          xSpeed = -xSpeed;
        }
        
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
