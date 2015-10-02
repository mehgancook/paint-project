package tools;
/*
 * Assignment 5
 * Winter15
 * TCSS305
 */

import java.awt.Point;
import java.awt.Shape;

/**
 * The Interface for Tools. 
 * @author Mehgan Cook
 * @version 02/23/2015
 */
public interface Tool {
    
   /**getShape returns allow access to the current shape that is being used by a tool.
    * @return a shape of the tool.
    * */
    Shape getShape();
    
    /**
     * Records the start point for a shape.
     * 
     * @param theStartPoint the start point of a shape.
     * @return returns the shape at the start point.
     */
    Shape recordStartPoint(Point theStartPoint);

    /**
     * Records the end point for a shape.
     * 
     * @param theEndPoint the end point of a shape.
     * @return returns the shape at the end point.
     */
    Shape recordDragPoint(Point theEndPoint);


}
