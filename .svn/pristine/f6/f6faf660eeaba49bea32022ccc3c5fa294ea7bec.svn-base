package gui;
/*
 * Assignment 5
 * Winter15
 * TCSS305
 */


import java.awt.Image;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * The JToolBar for PowerPaint.
 * 
 * @author Mehgan Cook
 * @version 02/23/2015
 */
@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
    /** A button group for tool bar buttons. */
    private final ButtonGroup myGroup;
    
    /**
     * Construct the ToolBar.
     */
    public ToolBar() {
        super();
        myGroup = new ButtonGroup();
    }
    /**
     * Create a JToggleButton for the ToolBar.
     * 
     * @param theAction to associate with the created JToggleButton.
     * @param theImage to associate with the created JToggleButton.
     */
    public void createToolBarButton(final Action theAction, final Image theImage) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        toggleButton.setIcon(new ImageIcon(theImage));
        myGroup.add(toggleButton);
        myGroup.clearSelection();
        add(toggleButton);
    }
 
}




