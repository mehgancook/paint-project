package gui;

import actions.EllipseAction;
import actions.LineAction;
import actions.PencilAction;
import actions.RectangleAction;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * PowerPaint GUI gets the GUI setup.
 * @author Mehgan Cook
 * @version 02/17/2015
 */
public class PowerPaintGUI {


    /**Map with action and image to be associated with a button. */
    private final Map<Action, Image> myButtonInformation;
    /**
     * Constructor for powerPaintGUI.
     */
    public PowerPaintGUI() {
        myButtonInformation = new LinkedHashMap<>();
        setup();
    }
    /**
     * Setup sets up the menu bar, tool bar, and drawing panel for the GUI frame.
     */
    private void setup() {
        final JFrame guiFrame = new JFrame("TCSS 305 PowerPaint");
        final Image img = new ImageIcon("./images/w.gif").getImage();
        guiFrame.setIconImage(img);
        final ToolBar toolBar = new ToolBar();
        final DrawingPanel panel = new DrawingPanel();
        final MenuBar menuBar = new MenuBar(guiFrame, panel);
        panel.addPropertyChangeListener(menuBar);
        myButtonInformation.put(new PencilAction(panel), 
                                new PencilAction(panel).getImage());
        myButtonInformation.put(new LineAction(panel), 
                                new LineAction(panel).getImage());
        myButtonInformation.put(new RectangleAction(panel), 
                                new RectangleAction(panel).getImage());
        myButtonInformation.put(new EllipseAction(panel), 
                                new EllipseAction(panel).getImage());

        for (final Action action : myButtonInformation.keySet()) {
            final Image iconImage = myButtonInformation.get(action);
            menuBar.createMenuButton(action, iconImage);
            toolBar.createToolBarButton(action, iconImage);
        }

        guiFrame.setJMenuBar(menuBar);

        guiFrame.add(toolBar, BorderLayout.SOUTH);
        guiFrame.add(panel, BorderLayout.CENTER);
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        guiFrame.pack();

        guiFrame.setLocationRelativeTo(null);
        guiFrame.setVisible(true);
    }  

}

