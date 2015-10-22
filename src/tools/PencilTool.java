package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * The Pencil Tool used to draw pencil shapes.
 * @author Mehgan Cook
 * @version 02/23/2015
 */
public class PencilTool implements Tool {
    /**myLine is the shape of Line tool. */
    private Path2D myPencil;

    
    /**Constructor for Line tool. */
    public PencilTool() {
        myPencil = new Path2D.Double();
    }
   
    @Override
    public Shape getShape() {       
        return myPencil;
    }

    @Override
    public Shape recordStartPoint(final Point theStartPoint) {
        myPencil = new Path2D.Double();
        myPencil.moveTo(theStartPoint.x, theStartPoint.y);
        return myPencil;
    }

    @Override
    public Shape recordDragPoint(final Point theEndPoint) {
        myPencil.lineTo(theEndPoint.x, theEndPoint.y);
        return myPencil;
    }    
    
}
