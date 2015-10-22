package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import tools.PencilTool;
import tools.Tool;

/**
 * The JPanel that the shapes will be drawn on.
 * 
 * @author Mehgan Cook
 * @version 02/23/2015
 */
@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {

    /** The default size for this JPanel. */
    private static final Dimension DEFUALT_SIZE = new Dimension(400, 200);
    
    /** The number of pixels before a grid mark is made. */
    private static final int GRID_SPACING = 10;

    /** The default radius for a Circle. */
    private Color myColor;

    /**Stores thickness.*/
    private int myThickness;

    /**Stores thickness.*/
    private Tool myCurrentTool;
      
    /** Checks to see if the grid is visible. */
    private boolean myGridVisible;
    
    /**the Current Shape. */
    private Shape myCurrentShape;
    
    /**Checks to see if there are any previous shapes. */
    private boolean myIsCurrentShapes;
    

    /** A collection of Points; each represents the center of a Circle. */
    private final List<DrawnShapes> myShapes;
    


    /**
     * Constructor for drawing panel.
     */
    public DrawingPanel() {
        super();
        setPreferredSize(DEFUALT_SIZE);
        setBackground(Color.WHITE);
        myThickness = 1;
        myColor = Color.BLACK;
        myShapes = new ArrayList<>();
        myCurrentTool = new PencilTool();
        myGridVisible = false;
        myIsCurrentShapes = false;
        final MouseAdapter mouseAdapter = new DrawingPanelMouseAdapter();
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }
     
    /**
     * Sets the thickness size.
     * @param theSliderSize is the value of the slider.
     * */
    public void setThicknessSize(final int theSliderSize) {
        myThickness = theSliderSize;
    }
    
    /**
     * Sets the Color.
     * @param theColor that the shape should be.
     * */
    public void setColor(final Color theColor) {
        myColor = theColor;        
    }
    
    /**
     * setTool sets the current tool based on the tool provided from the action.
     * @param theTool is the tool passed in from the action.
     * */
    public void setTool(final Tool theTool) {
        myCurrentTool = theTool;
       // repaint();
    }   
    /**
     * clearList clears the current list of drawings and sets undo button to deactivate.
     * */
    public void clearList() {
        myShapes.clear();
        myIsCurrentShapes = false;
        firePropertyChange("clear", true, false);
        repaint();


    }
    
    /**
     * storeFinishedShapes stores the finished shape.
     * 
     * */
    public void storeFinishedShape() {
        myShapes.add(new DrawnShapes(myThickness, myColor, myCurrentTool.getShape()));
        myIsCurrentShapes = false;
    }
    
    /**
     * Sets if the grid has been activated or not.
     * */
    public void toggleGrid() {
        if (myGridVisible) {
            myGridVisible = false;
        } else {
            myGridVisible = true;
        }
        repaint();
    }
    
    /**checks to see if the grid is visible.
     * @return of grid is visible.
     */
    public boolean isGridVisible() {
        return myGridVisible;
    }
    
    /** 
     * SetCurrentShape sets the shape being drawn and lets a boolean variable
     * know that there is a current shape.
     * @param theShape is the current shape.
     * */
    public void setCurrentShape(final Shape theShape) {
        myCurrentShape = theShape;
        myIsCurrentShapes = true;
    }
    
    
    /** {@inheritDoc} */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D graphics = (Graphics2D) theGraphics;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                            RenderingHints.VALUE_ANTIALIAS_ON);        
        for (final DrawnShapes drawn : myShapes) {
            graphics.setColor(drawn.getColor());
            graphics.setStroke(new BasicStroke(drawn.getThickness()));
            graphics.draw(drawn.getShape());
        }                      
        if (myIsCurrentShapes) {
            graphics.setColor(myColor);
            graphics.setStroke(new BasicStroke(myThickness));
            graphics.draw(myCurrentShape);
        }
        if (myGridVisible) {
            final int height = getHeight();
            final int width = getWidth();
            graphics.setColor(Color.GRAY);
            graphics.setStroke(new BasicStroke(1));
            final Line2D.Double gridLines = new Line2D.Double();
            for (int i = 0; i < width; i++) {
                if (i % GRID_SPACING == 0) {
                    gridLines.setLine(i, 0, i, height);
                    graphics.draw(gridLines);
                }
            }
            for (int j = 0; j < height; j++) {
                if (j % GRID_SPACING == 0) {
                    gridLines.setLine(0, j, width, j);
                    graphics.draw(gridLines);
                }
            }
        }
    }
    /**
     * DrawingPaenlMouseAdapter is an inner class that sets up mouse Events.
     * @author Mehgan Cook
     * @version 02/17/2015
     */
    public class DrawingPanelMouseAdapter extends MouseAdapter {
        /** {@inheritDoc} */
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            myCurrentShape = myCurrentTool.recordStartPoint(theEvent.getPoint());
            setCurrentShape(myCurrentShape);
        //    repaint();
        }

        /** {@inheritDoc} */
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myCurrentShape = myCurrentTool.recordDragPoint(theEvent.getPoint());
            repaint();
        }
        /** {@inheritDoc} */
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            storeFinishedShape();
            firePropertyChange("shape", false, true);
            repaint();
        }
    }
}






