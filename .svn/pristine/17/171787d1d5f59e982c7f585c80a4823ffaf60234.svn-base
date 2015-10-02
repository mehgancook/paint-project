package tools;
/*
 * Assignment 5
 * Winter15
 * TCSS305
 */
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
/**
 * The Ellipse Tool used to draw ellipses.
 * @author Mehgan Cook
 * @version 02/23/2015
 */

public class EllipseTool implements Tool {
    
    /**myLine is the shape of Line tool. */
    private Ellipse2D myEllipse;
    
    /**Stores my starting x value.*/
    private int myX;
    
    /**Stores my starting y value.*/
    private int myY;
    
    /**Constructor for Line tool. */
    public EllipseTool() {
        myEllipse = new Ellipse2D.Double();
        myX = 0;
        myY = 0;
    }
    
    @Override
    public Shape getShape() {
        return myEllipse;
    }
    
    @Override
    public Shape recordStartPoint(final Point theStartPoint) {
        myX = theStartPoint.x;
        myY = theStartPoint.y;
        myEllipse = new Ellipse2D.Double();
        myEllipse.setFrameFromDiagonal(theStartPoint.x, theStartPoint.y, 
                                       theStartPoint.x, theStartPoint.y);
        return myEllipse;
        
    }
    @Override
    public Shape recordDragPoint(final Point theEndPoint) {
        myEllipse = new Ellipse2D.Double();
        myEllipse.setFrameFromDiagonal(myX, myY, 
                                   theEndPoint.x, theEndPoint.y);
        return myEllipse;
    }

}







