package hw2;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar {
	
	public Toolbar() {
		super();
	}
	
	private ImageIcon resizeIcon(ImageIcon icon) {
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return new ImageIcon(newimg); 
	}

	public void createButton(String iconPath, ActionListener action){
		JButton toolbarButton = new JButton();
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(iconPath));
		imageIcon = resizeIcon(imageIcon);
		toolbarButton.setIcon(imageIcon);
		toolbarButton.addActionListener(action);
		this.add(toolbarButton);
	}
	
}
