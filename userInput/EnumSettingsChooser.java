//  Jackie Loven, 9 August 2015
//  GridBagLayout example: http://goo.gl/xYVbJn


package userInput;

import java.awt.Container;
import java.awt.Dimension;
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
import fileWriting.WriteJavaEnum;

public class EnumSettingsChooser implements ActionListener{

	private JFrame frame = new JFrame("Enumeration Settings");
	private JTextField packageNameText = new JTextField();
	private JTextField classNameText = new JTextField();
	JButton browseButton = new JButton(System.getProperty("user.home") + "/Desktop" + "    (Browse...)");
	JButton approveButton = new JButton("Create Enumeration!");
	private int originalLength = browseButton.getText().length();
	public EnumSettings settings = new EnumSettings();

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

		JLabel destinationFolderLabel = new JLabel("Destination folder", SwingConstants.LEFT);
		c.insets = new Insets(0,20,20,20);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(destinationFolderLabel, c);

		browseButton.addActionListener(this);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		pane.add(browseButton, c);

		approveButton.addActionListener(this);
		c.insets = new Insets(0,20,20,20);
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 5;
		pane.add(approveButton, c);

	}

	private void createAndShowGUI(int width, int height) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addComponentsToPane(frame.getContentPane());
		//frame.pack();
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		JFrame thisFrame = getFrame(buttonPressed);
		
		
		if (buttonPressed == approveButton) {
			String packageNameText = this.packageNameText.getText();
			String classNameText = this.classNameText.getText();
			settings.setPackageName(packageNameText);
			settings.setClassName(classNameText);
			settings.setDestinationFolder(FolderChooser.getSelectedFilePath());
			WriteJavaEnum.main(settings);
			thisFrame.setVisible(false);
			thisFrame.dispose();
		} else if (buttonPressed == browseButton) {
			//  For some reason the JFrame twitches before rendering.
			//  Doesn't make sense because it's only visible after it's created.
			thisFrame.setVisible(false);
			FolderChooser.main(null);
			String newText = FolderChooser.getSelectedFilePath().toString();
			buttonPressed.setText(newText);
			
			//  Dynamically resize JFrame depending on selected file path.
			if (newText.length() <= originalLength) {
				thisFrame.setSize(500 - buttonPressed.getSize().width / 4, 300);
			} else {
				thisFrame.setSize(500 + buttonPressed.getSize().width, 300);
			}
			thisFrame.setLocationRelativeTo(null);
			thisFrame.setVisible(true);
		}
		System.out.println(settings.toString());
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
				chooser.createAndShowGUI(500, 300);
			}
		});
	}
}