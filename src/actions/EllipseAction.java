package actions;

import gui.DrawingPanel;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.EllipseTool;


/**
 * EllipseAction creates an ellipse button and adds an action to it.
 * @author Mehgan Cook
 * @version 02/23/2015
 *
 */
@SuppressWarnings("serial")
public class EllipseAction extends AbstractAction {
    /** The JPanel to associate with this Action. */
    private final DrawingPanel myPanel;

    /**
     * Construct this Action.
     * 
     * @param thePanel a JPanel to associate with this Action.
     */
    public EllipseAction(final DrawingPanel thePanel) {
        super("Ellipse");
        myPanel = thePanel;
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
        putValue(Action.SELECTED_KEY, true);
    }
    
    /** {@inheritDoc} */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setTool(new EllipseTool());
    }
    
    /**
     * Image for this action.
     * @return an image icon to be placed on the button.
     * */
    public Image getImage() {
        return new ImageIcon("./images/ellipse_bw.gif").getImage();
    }

}







   




