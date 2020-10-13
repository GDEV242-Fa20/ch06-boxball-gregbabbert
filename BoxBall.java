import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class BoxBall - a graphical ball that bounces around a box. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will move in a random direction at a random speed and bounc off the walls.
 *
 * 
 * @author Greg Babbert
 *
 * @version 2020.10.12
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
    private Random random;

    /**
     * Constructor for objects of class BoxBall
     *
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
        random = new Random();
        xPosition = (random.nextInt(350)) + 100;
        yPosition = (random.nextInt(300)) + 50;
        xSpeed = (random.nextInt(7)) + 1;
        ySpeed = (random.nextInt(7)) + 1;
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
