package hw2;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class CustomMenubar extends JMenuBar {
	
	Main context;
	Utils utils = new Utils();
	
	public CustomMenubar(Main c) {
		this.context = c;
	}
	
	//Returns a custom JMenuBar with the menus "App" and "Item"
	public JMenuBar getCustomMenu() {
		createAppMenu();
		createItemMenu();
		return this;
	}
	
	//Creates all the elements that the "App" menu needs
	private void createAppMenu(){
		JMenu app = utils.createMenu("App", KeyEvent.VK_P);
    	JMenuItem about = utils.createMenuItem("About", KeyEvent.VK_A, "assets/helpBlue.png", context.aboutApp); 
    	JMenuItem exit = utils.createMenuItem("Exit", KeyEvent.VK_X, context.exitApp);
    	
    	app.add(about); app.add(new JSeparator()); app.add(exit);
    	this.add(app);
	}
	
	//Creates all the elements that the "Item" menu needs
	private void createItemMenu() {
		JMenu item = utils.createMenu("Item", KeyEvent.VK_I);
    	JMenuItem checkPrices = utils.createMenuItem("Check prices", KeyEvent.VK_C, "assets/checkBlue.png", context.checkPrices);
    	JMenuItem addItem = utils.createMenuItem("Add Item", KeyEvent.VK_A, "assets/addBlue.png", context.addItem);
    	JMenuItem searchItem = utils.createMenuItem("Search", KeyEvent.VK_S, "assets/searchBlue.png", context.searchItem);
    	JMenuItem firstItem = utils.createMenuItem("Select first", KeyEvent.VK_F, "assets/backwardBlue.png", context.firstItem);
    	JMenuItem lastItem = utils.createMenuItem("Select last", KeyEvent.VK_L, "assets/forwardBlue.png", context.lastItem);
    	
    	//Submenu items
    	JMenu selected = utils.createMenu("selected", KeyEvent.VK_I);
    	JMenuItem price = utils.createMenuItem("Price", KeyEvent.VK_P, "assets/checkGreen.png", context.checkItemPrice);
    	JMenuItem view = utils.createMenuItem("View", KeyEvent.VK_E, "assets/file.png", context.viewItem);
    	JMenuItem edit = utils.createMenuItem("Edit", KeyEvent.VK_R, "assets/editGreen.png", context.editItem);
    	JMenuItem remove = utils.createMenuItem("Remove", KeyEvent.VK_F, "assets/minusGreen.png", context.removeItem);
    	JMenuItem copyName = utils.createMenuItem("Copy Name", KeyEvent.VK_X, context.copyName);
    	JMenuItem copyURL = utils.createMenuItem("Copy URL", KeyEvent.VK_X, context.copyURL);
    	
    	selected.add(price); selected.add(view); selected.add(edit); selected.add(remove); 
    	selected.add(new JSeparator()); 
    	selected.add(copyName); selected.add(copyURL);
    	
    	item.add(checkPrices); item.add(addItem); 
    	item.add(new JSeparator()); 
    	item.add(searchItem); item.add(firstItem); item.add(lastItem); 
    	item.add(new JSeparator()); 
    	item.add(selected);
    	
    	this.add(item);
	}

}
