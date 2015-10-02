package tools;
/*
 * Assignment 5
 * Winter15
 * TCSS305
 */
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
/**
 * The Line Tool used to draw lines.
 * @author Mehgan Cook
 * @version 02/23/2015
 */

public class LineTool implements Tool {
    
    /**myLine is the shape of Line tool. */
    private Line2D myLine;
    
    /**Stores my starting x value.*/
    private int myX;
    
    /**Stores my starting y value.*/
    private int myY;
    
    /**Constructor for Line tool. */
    public LineTool() {
        myLine = new Line2D.Double();
        myX = 0;
        myY = 0;
    }
    
    @Override
    public Shape getShape() {
        return myLine;
    }
    
    @Override
    public Shape recordStartPoint(final Point theStartPoint) {
        myX = theStartPoint.x;
        myY = theStartPoint.y;
        myLine = new Line2D.Double(theStartPoint.x, theStartPoint.y, 
                                   theStartPoint.x, theStartPoint.y);
        return myLine;
        
    }
    @Override
    public Shape recordDragPoint(final Point theEndPoint) {
        myLine = new Line2D.Double(myX, myY, 
                                   theEndPoint.x, theEndPoint.y);
        return myLine;
    }

}
