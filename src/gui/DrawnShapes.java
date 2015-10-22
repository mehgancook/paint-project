package gui;

import java.awt.Color;
import java.awt.Shape;

/**
 * DrawnShapes stores the shapes that have been drawn.
 * @author Mehgan Cook
 * @version 02/23/2015
 *
 */
public class DrawnShapes {
    /**Thickness of the shape. */
    private final int myThickness;
    
    /**Color of the shape.*/
    private final Color myColor;
    
    /**Shape that is associated with the color and thickness. */
    private final Shape myShape;

    /**
     * Constructor to hold the information about the shape being passed in.
     * 
     * @param theThickness is the thickness of the shape.
     * @param theColor is the color of the shape.
     * @param theShape is the shape.
     */
    public DrawnShapes(final int theThickness, final Color theColor, final Shape theShape) {
        myThickness = theThickness;
        myColor = theColor;
        myShape = theShape;
    }
    /**
     * Return current Shape.
     * @return the current Shape.
     */
    public Shape getShape() {
        return myShape;
    }

    /**
     * Return current color.
     * @return the current color.
     */
    public Color getColor() {
        return myColor;
    }

    /**
     * Return current thickness.
     * @return the current thickness.
     */
    public int getThickness() {
        return myThickness;
    }

}

