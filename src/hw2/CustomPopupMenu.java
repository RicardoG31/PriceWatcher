package hw2;

import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class CustomPopupMenu extends JPopupMenu{

	Main context;
	Utils utils = new Utils();
	
	public CustomPopupMenu(Main c) {
		this.context = c;
	}
	
	public JPopupMenu getCustomPopupMenu() {
		createPopupMenu();
		return this;
	}
	
	private void createPopupMenu() {
		JMenuItem price = utils.createMenuItem("Price", KeyEvent.VK_P, "assets/checkGreen.png", context.checkItemPrice);
    	JMenuItem view = utils.createMenuItem("View", KeyEvent.VK_E, "assets/file.png", context.viewItem);
    	JMenuItem edit = utils.createMenuItem("Edit", KeyEvent.VK_R, "assets/editGreen.png", context.editItem);
    	JMenuItem remove = utils.createMenuItem("Remove", KeyEvent.VK_F, "assets/minusGreen.png", context.removeItem);
    	JMenuItem copyName = utils.createMenuItem("Copy Name", KeyEvent.VK_NONCONVERT, context.copyName);
    	JMenuItem copyURL = utils.createMenuItem("Copy URL", KeyEvent.VK_NONCONVERT, context.copyURL);
    	
    	add(price); add(view); add(edit); add(remove);
    	addSeparator();
    	add(copyName); add(copyURL);
	}
	
}
