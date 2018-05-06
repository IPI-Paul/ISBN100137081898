package chapter08; // plaf

import java.awt.event.*;
import javax.swing.*;

import ipi.Views;

/**
 * PlafFrame JFrame Listing 8.2
 * A frame with a button panel for changing look-and-feel
 */
public class PlafFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MAIN_CLASS = "chapter08.Chapter08";
	private static String message = "";
	
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 200;
	
	public PlafFrame() {
		buttonPanel = new JPanel();
		
		try {
			UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
			for (UIManager.LookAndFeelInfo info : infos) {
				makeButton(info.getName(), info.getClassName());
			}
			add(buttonPanel);
			pack();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		Views.openWindowOpenerListener(this, MAIN_CLASS, message);
	}
	
	/**
	 * Makes a button to change the pluggable look-and-feel.
	 * @param name the button name
	 * @param plafName the name of the look-and-feel class
	 */
	void makeButton(String name, final String plafName) {
		// add button to panel
		JButton button = new JButton(name);
		buttonPanel.add(button);
		
		// set button action
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// button action: switch to the new look-and-feel
				try {
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
					pack();
					setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
