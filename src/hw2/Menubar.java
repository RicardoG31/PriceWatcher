package hw2;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Menubar {
	
	private ImageIcon resizeIcon(ImageIcon icon) {
		Image image = icon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return new ImageIcon(newimg); 
	}
	
	public JMenu menu(String menuName, int triggerKey) {
		JMenu menu = new JMenu(menuName);
		menu.setMnemonic(triggerKey);
		return menu;
	}
	
	public JMenuItem menuItem(String itemName, int triggerKey, String iconPath, ActionListener action) {
		JMenuItem menuItem = new JMenuItem(itemName);
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(iconPath));
		
		menuItem.setIcon(resizeIcon(imageIcon));
		menuItem.setMnemonic(triggerKey);
		menuItem.addActionListener(action);
		
		return menuItem;
	}
	
	public JMenuItem menuItem(String itemName, int triggerKey, ActionListener action) {
		JMenuItem menuItem = new JMenuItem(itemName);
		
		menuItem.setMnemonic(triggerKey);
		menuItem.addActionListener(action);
		
		return menuItem;
	}
	
	
	
}
