package gui;

import java.awt.EventQueue;

/**
 * Main program to run the GUI.
 * @author Mehgan Cook
 * @version 02/17/2015
 */
public final class PowerPaintMain {  
    /**
     * Private constructor to prevent construction of instances.
     */
    private PowerPaintMain() {
        // do nothing
    }
    /**
     * Constructs the main GUI window frame.
     * 
     * @param theArgs Command line arguments (ignored).
     */
    public static void main(final String... theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PowerPaintGUI();     
            }
        });
    }
}
