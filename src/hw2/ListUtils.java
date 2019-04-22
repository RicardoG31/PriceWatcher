package hw2;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListUtils {
	
	DefaultListModel<Item> items = new DefaultListModel<>();
	JList<Item> itemsList; 
			
	public ListUtils() {}
	
	//Get the item in the position "position"
	public Item getItem(int position) {
		return items.get(position);
	}
	
	//Get size of list
	public int getSize() {
		return items.getSize();
	}
	
	//Get selected item in the list
	public int getSelected() {
		return itemsList.getSelectedIndex();
	}
	
	//Set the selected item in the list
	public void setSelected(int position) {
		itemsList.setSelectedIndex(position);
	}
	
	//Add a new item
	public void addItem(Item newItem){
		items.addElement(newItem);
	}
	
	//Remove a selected item (position)
	public void removeItem(int position) {
		items.remove(position);
	}
	
	//Update all the item prices in the list
	public void updatePrices(){
		int listSize = getSize();
		DefaultListModel<Item> updatedList = new DefaultListModel<>();
		for(int i=0; i<listSize; i++) {
			Item item = items.get(i);
			item.updatePrice();
			updatedList.addElement(item);
		}
		this.items = updatedList;
	}
	
	//Search all items that contain as a string (key) as substring
	public void searchItems(String key) {
		int listSize = getSize();
		DefaultListModel<Item> updatedList = new DefaultListModel<>();
		for(int i=0; i<listSize; i++) {
			Item item = items.get(i);
			String itemName = item.getName();
			if(itemName.indexOf(key) != -1) {
				updatedList.addElement(item);
			}
		}
		this.items = updatedList;
	}
	
	
	//Convert list of items to scrollable component in the App
	public JScrollPane getScrollComp() {
		itemsList = new JList<>(items);
        itemsList.setCellRenderer(new ItemRender());
        itemsList.getSelectedIndex();
        
        JScrollPane scrollableArea = new JScrollPane(itemsList);
        
        return scrollableArea;
	}
	
}
