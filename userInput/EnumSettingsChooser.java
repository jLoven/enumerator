//  Jackie Loven, 9 August 2015
//  GridBagLayout example: http://goo.gl/xYVbJn


package userInput;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import dataStoring.EnumSettings;

public class EnumSettingsChooser implements ActionListener{

	private JFrame frame = new JFrame("Enumeration Settings");
	private JTextField packageNameText = new JTextField();
	private JTextField classNameText = new JTextField();
	
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

		c.insets = new Insets(20,0,20,20);
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(packageNameText, c);

		JLabel classNameLabel = new JLabel("Class name", SwingConstants.LEFT);
		c.insets = new Insets(0,20,20,20);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(classNameLabel, c);

		c.insets = new Insets(0,0,20,20);
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 3;
		pane.add(classNameText, c);

		JButton approveButton = new JButton("Create Enumeration!"); 
		approveButton.addActionListener(this);
		c.insets = new Insets(0,20,20,20);
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(approveButton, c);

	}

	private void createAndShowGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		JFrame thisFrame = getFrame(button);
		
		String packageNameText = this.packageNameText.getText();
		String classNameText = this.classNameText.getText();
		EnumSettings settings = new EnumSettings();
		settings.setPackageName(packageNameText);
		settings.setClassName(classNameText);
		System.out.println(settings.toString());
		
		thisFrame.setVisible(false);
		thisFrame.dispose();
	}

	public JFrame getFrame(JButton button) {
		JRootPane relevantFrame = (JRootPane) button.getParent().getParent().getParent();
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(relevantFrame);
		return frame;
	}
	
	public static void main(String[] args) {
		final EnumSettingsChooser chooser = new EnumSettingsChooser();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				chooser.createAndShowGUI();
			}
		});
	}
}