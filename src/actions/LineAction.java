package actions;
/*
 * Assignment 5
 * Winter15
 * TCSS305
 */


import gui.DrawingPanel;

import java.awt.Image; 
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.LineTool;

/**
 * LineAction creates a Line button and adds an action to it.
 * @author Mehgan Cook
 * @version 02/23/2015
 *
 */
@SuppressWarnings("serial")
public class LineAction extends AbstractAction {
    /** The JPanel to associate with this Action. */
    private final DrawingPanel myPanel;

    /**
     * Construct this Action.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public LineAction(final DrawingPanel thePanel) {
        super("Line");
        myPanel = thePanel;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_L);
        putValue(Action.SELECTED_KEY, true);
    }

    /** {@inheritDoc} */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setTool(new LineTool());
    }
    
    /**
     * Image for this action.
     * @return an image icon to be placed on the button.
     * */
    public Image getImage() {
        return new ImageIcon("./images/line_bw.gif").getImage();
    }
}















