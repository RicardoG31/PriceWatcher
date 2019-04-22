package hw2;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class CustomToolbar extends JToolBar {

	Main context;
	Utils utils = new Utils();
	
	public CustomToolbar(Main c) {
		this.context = c;
	}
	
	//Returns a custom JToolbar divided in 3 sections
	//List actions: Check prices, add item, search, first item, and last item
	//Item actions: Check item price, view item, edit item, and remove item
	//About action: show about the app
	public JToolBar getCustomToolbar() {
		createListActions();
		createItemActions();
		createAboutAction();
		return this;
	}
	
	//Creates list actions: Check prices, add item, search, first item, and last item
	public void createListActions() {
		JButton checkPrices = utils.createToolbarButton("assets/checkBlue.png", context.checkPrices);
		JButton addItem = utils.createToolbarButton("assets/addBlue.png", context.addItem);
		JButton searchItem = utils.createToolbarButton("assets/searchBlue.png", context.searchItem);
		JButton firstItem = utils.createToolbarButton("assets/backwardBlue.png", context.firstItem);
		JButton lastItem = utils.createToolbarButton("assets/forwardBlue.png", context.lastItem);
		
		this.add(checkPrices); this.add(addItem); this.add(searchItem);
		this.add(firstItem); this.add(lastItem);
		
		this.addSeparator();
	}
	
	//Creates item actions: Check item price, view item, edit item, and remove item
	public void createItemActions() {
		JButton checkItemPrice = utils.createToolbarButton("assets/checkGreen.png", context.checkItemPrice);
		JButton viewItem = utils.createToolbarButton("assets/file.png", context.viewItem);
		JButton editItem = utils.createToolbarButton("assets/editGreen.png", context.editItem);
		JButton removeItem = utils.createToolbarButton("assets/minusGreen.png", context.removeItem);
		
		this.add(checkItemPrice); this.add(viewItem); 
		this.add(editItem); this.add(removeItem);
		
		this.addSeparator();
	}
	
	//Creates about action: show about the app
	public void createAboutAction() {
		JButton about = utils.createToolbarButton("assets/helpBlue.png", context.aboutApp);
		
		this.add(about);
	}
	
}
