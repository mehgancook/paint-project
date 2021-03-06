package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The MenuBar for PowerPaint.
 * @author Mehgan Cook
 * @version 02/23/2015
 *
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar implements PropertyChangeListener {

    /**Size to be used for the Icon. */
    private static final int ICON_SIZE = 14;  

    /** The initial thickness for shapes. */
    private static final int INITIAL_THICKNESS = 1;

    /** The maximum thickness. */
    private static final int MAX_THICKNESS = 20;

    /** The minor tick spacing for slider. */
    private static final int MINOR_TICK_SPACING = 1;

    /** The major tick spacing for slider. */
    private static final int MAJOR_TICK_SPACING = 5;

    /**The Tools menu. */
    private final JMenu myToolsMenu;

    /**The Color Menu. */
    private  JMenuItem myColorMenu;

    /**The Slider. */
    private JSlider mySlider;

    /** A button to clear the drawing panel. */
    private  JMenuItem myUndoAllChanges;

    /** A button group for radio buttons. */
    private final ButtonGroup myGroup;

    /**
     * Construct the menu bar.
     * 
     * @param theFrame the JFrame which will contain this JMenuBar
     * @param thePanel the drawingPanel that will be used.
     */
    public MenuBar(final JFrame theFrame, final DrawingPanel thePanel) {
        super();        
        myToolsMenu = new JMenu("Tools");
        myGroup = new ButtonGroup();
        setupFileMenu(theFrame, thePanel);
        setupOptionsMenu(thePanel);
        add(myToolsMenu);
        setupHelpMenu(theFrame);
        setupColorMenu(thePanel);
    }
    /**
     * Sets up the components of the file menu.
     * 
     * @param theFrame the JFrame containing this menu.
     * @param thePanel is the drawing panel.
     */
    private void setupFileMenu(final JFrame theFrame, final DrawingPanel thePanel) {
        final JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        myUndoAllChanges = new JMenuItem("Undo all changes", KeyEvent.VK_U);
        myUndoAllChanges.setEnabled(false);
        myUndoAllChanges.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                thePanel.clearList();
            }
        });
        fileMenu.add(myUndoAllChanges);
        fileMenu.addSeparator();
        final JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                theFrame.dispatchEvent(new WindowEvent(theFrame,
                                                       WindowEvent.WINDOW_CLOSING));
            }
        });
        fileMenu.add(exit);
        add(fileMenu);

    }
    /**
     * Sets up the components of the options menu.
     * 
     * @param thePanel is the drawing panel of power paint.
     */
    private void setupOptionsMenu(final DrawingPanel thePanel) {
        final JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic(KeyEvent.VK_O);
        final JCheckBoxMenuItem grid = new JCheckBoxMenuItem("Grid");
        grid.setMnemonic(KeyEvent.VK_G);
        grid.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                thePanel.toggleGrid();
            }           
        });

        optionsMenu.add(grid);
        optionsMenu.addSeparator();

        final JMenu thickness = new JMenu("Thickness");
        thickness.setMnemonic(KeyEvent.VK_T);
        mySlider = new JSlider(SwingConstants.HORIZONTAL, 0, MAX_THICKNESS,
                               INITIAL_THICKNESS);        
        mySlider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        mySlider.setMinorTickSpacing(MINOR_TICK_SPACING);
        mySlider.setPaintLabels(true);
        mySlider.setPaintTicks(true);
        mySlider.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent theEvent) {
                final int sliderSize = mySlider.getValue();
                thePanel.setThicknessSize(sliderSize);
            }
        });
        thickness.add(mySlider);
        optionsMenu.add(thickness);    
        add(optionsMenu);
    }

    /**
     * Creates a radio button menu item, associates an action with the button,
     * adds the button to a button group, adds the button to the View menu.
     * 
     * @param theAction the Action to associate with the new button being created
     * @param theImage is the Image to associate with the new button being created
     */
    public void createMenuButton(final Action theAction, final Image theImage) {
        final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(theAction);
        createdButton.setIcon(new ImageIcon(theImage));
        myGroup.add(createdButton);
        myToolsMenu.setMnemonic(KeyEvent.VK_T);
        myToolsMenu.add(createdButton);
    }
    /**
     * Sets up the components of the help menu.
     * 
     * @param theFrame is the JFrame containing this menu.
     */
    private void setupHelpMenu(final JFrame theFrame) {
        final JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        final JMenuItem about = new JMenuItem("About...", KeyEvent.VK_A);
        about.addActionListener(new ActionListener() {  
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(theFrame, "TCSS 305 PowerPaint, Winter 2015");
            }
        });
        helpMenu.add(about);
        add(helpMenu);

    }
    /**
     * Sets up the components of the help menu.
     * 
     * @param thePanel is the drawing panel for power paint.
     */
    private void setupColorMenu(final DrawingPanel thePanel) {
        myColorMenu = new JMenuItem("Color...", new ColorIcon(Color.BLACK));
        myColorMenu.setMnemonic(KeyEvent.VK_C);
        myColorMenu.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final Color color = JColorChooser.showDialog(null, "Pick your color!", null);
                myColorMenu.setIcon(new ColorIcon(color));
                thePanel.setColor(color);
            }
        });
        add(myColorMenu);

    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("shape".equals(theEvent.getPropertyName())) {
            myUndoAllChanges.setEnabled(true);
        } else {
            myUndoAllChanges.setEnabled(false);
        }
    }
    /**
     * ColorIcon is an inner class that sets the ColorIcon.
     * @author Mehgan Cook
     * @version 02/17/2015
     */
    public class ColorIcon implements Icon {  

        /**MyColor is the current Color of the Icon. */
        private final Color myColor;  

        /**
         * Constructor for ColorIcon. Sets myColor to an incoming selected Color.
         * @param theColor is the current color selected.
         * */
        public ColorIcon(final Color theColor) {  
            myColor = theColor;  
        }  
        
        /** 
         * gets the Icon Height.
         * @return the Height of the Icon.
         * */
        public int getIconHeight() {  
            return ICON_SIZE;  
        }  

        /** 
         * gets the Icon Width.
         * @return the Width of the Icon.
         * */
        public int getIconWidth() {  
            return ICON_SIZE;  
        }  
        /**Paints the Icon to the current color and size.
         * @param theComponent used for positioning.
         * @param theGraphics to be used for painting.
         * @param theX used for size.
         * @param theY used for size.
         *  */
        public void paintIcon(final Component theComponent, final Graphics theGraphics,
                              final int theX, final int theY) {  
            theGraphics.setColor(myColor);  
            theGraphics.fillRect(theX, theY, ICON_SIZE - 1, ICON_SIZE - 1);  

            theGraphics.setColor(Color.BLACK);  
            theGraphics.drawRect(theX, theY, ICON_SIZE - 1, ICON_SIZE - 1);  
        }  
    }  

}









