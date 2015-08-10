//  Jackie Loven, 9 August 2015
//  GridBagLayout example: http://goo.gl/xYVbJn


package userInput;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EnumSettingsChooser implements ActionListener{
	
	private int numClicks = 0;

	public void addComponentsToPane(Container pane) {
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel bigLabel = new JLabel("Choose your enumeration class settings below.", SwingConstants.CENTER);
		// Top, Left, Bottom, Right
		c.insets = new Insets(20,20,0,20);
		c.gridwidth = 3; 
		c.gridx = 0;
		c.gridy = 0;
		pane.add(bigLabel, c);

		JLabel packageLabel = new JLabel("Package name", SwingConstants.LEFT);
		c.insets = new Insets(20,20,20,20);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(packageLabel, c);

		JTextField packageText = new JTextField();
		c.insets = new Insets(20,0,20,20);
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(packageText, c);
		
		JLabel classNameLabel = new JLabel("Class name", SwingConstants.LEFT);
		c.insets = new Insets(0,20,20,20);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(classNameLabel, c);

		JTextField classNameText = new JTextField();
		c.insets = new Insets(0,0,20,20);
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 3;
		pane.add(classNameText, c);
		
		JButton approveButton = new JButton("Create Enumeration!"); 
		approveButton.addActionListener(this);
		// Top, Left, Bottom, Right
		c.insets = new Insets(0,20,20,20);
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(approveButton, c);
		
	}

	private void createAndShowGUI() {
		JFrame frame = new JFrame("Enumeration Settings");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		final EnumSettingsChooser gBLT = new EnumSettingsChooser();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gBLT.createAndShowGUI();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		numClicks++;
        System.out.println("Button Clicked " + numClicks + " times");
	}
}