package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * The Rectangle Tool used to draw rectangles.
 * @author Mehgan Cook
 * @version 02/23/2015
 */
public class RectangleTool implements Tool {
    
    /**myLine is the shape of Line tool. */
    private Rectangle2D myRectangle;
    
    /**Stores my starting x value.*/
    private int myX;
    
    /**Stores my starting y value.*/
    private int myY;
    
    /**Constructor for Line tool. */
    public RectangleTool() {
        myRectangle = new Rectangle2D.Double();
        myX = 0;
        myY = 0;
    }
    
    @Override
    public Shape getShape() {
        return myRectangle;
    }
    
    @Override
    public Shape recordStartPoint(final Point theStartPoint) {
        myX = theStartPoint.x;
        myY = theStartPoint.y;
        myRectangle = new Rectangle2D.Double();
        myRectangle.setFrameFromDiagonal(theStartPoint.x, theStartPoint.y, 
                                   theStartPoint.x, theStartPoint.y);
        
        return myRectangle;
        
    }
    @Override
    public Shape recordDragPoint(final Point theEndPoint) {
        myRectangle = new Rectangle2D.Double();
        myRectangle.setFrameFromDiagonal(myX, myY, 
                                   theEndPoint.x, theEndPoint.y);
        return myRectangle;
    }

}


