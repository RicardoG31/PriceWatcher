package hw2;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Utils {
	
	public Utils() {}

	//Method to resize a Image icon (15x15)
	public ImageIcon resizeIcon(ImageIcon icon) {
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return new ImageIcon(newimg); 
	}
	
	//Creates a menu for a JMenuBar with name "menuName" and its triggerKey
	public JMenu createMenu(String menuName, int triggerKey) {
		JMenu menu = new JMenu(menuName);
		menu.setMnemonic(triggerKey);
		return menu;
	}
	
	//Creates a menuItem with an icon (iconPath) for a JMenuBar with name "menuName" and its triggerKey
	//If the menu item is clicked and "action" will be triggered
	public JMenuItem createMenuItem(String itemName, int triggerKey, String iconPath, ActionListener action) {
		JMenuItem menuItem = new JMenuItem(itemName);
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(iconPath));
		
		menuItem.setIcon(this.resizeIcon(imageIcon));
		menuItem.setMnemonic(triggerKey);
		menuItem.addActionListener(action);
		
		return menuItem;
	}
	
	//Creates a menuItem for a JMenuBar with name "menuName" and its triggerKey
	//If the menu item is clicked and "action" will be triggered
	public JMenuItem createMenuItem(String itemName, int triggerKey, ActionListener action) {
		JMenuItem menuItem = new JMenuItem(itemName);
		
		menuItem.setMnemonic(triggerKey);
		menuItem.addActionListener(action);
		
		return menuItem;
	}
	
	//Creates a buttno for a JToolbar with an icon
	//If the button is clicked and "action" will be triggered
	public JButton createToolbarButton(String iconPath, ActionListener action){
		JButton toolbarButton = new JButton();
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(iconPath));
		imageIcon = this.resizeIcon(imageIcon);
		toolbarButton.setIcon(imageIcon);
		toolbarButton.addActionListener(action);
		return toolbarButton;
	}
	
	
}
