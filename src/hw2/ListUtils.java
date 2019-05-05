package hw2;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListUtils extends JScrollPane {
	
	JList<Item>itemsList;
	DefaultListModel<Item> items = new DefaultListModel<>();
	DefaultListModel<Item> backup;
			
	public ListUtils() {
		itemsList = new JList<>(items);
        itemsList.setCellRenderer(new ItemRender());
        setViewportView(itemsList);
	}
	
	//Update all the item prices in the list
	public void updatePrices(){
		int listSize = items.getSize();
		for(int i=0; i<listSize; i++) {
			Item item = items.get(i);
			item.updatePrice();
		}
		updateUI();
	}
	
	//Add a new item
	public void addItem(Item newItem){
		items.addElement(newItem);
	}
	
	//Search all items that contain as a string (key) as substring
	public void searchItems(String key) {
		int listSize = items.getSize();
		DefaultListModel<Item> filterList = new DefaultListModel<>();
		if(key.length() == 0) {
			this.items = this.backup;
		} else {
			this.backup = this.items;
			for(int i=0; i<listSize; i++) {
				Item item = items.get(i);
				String itemName = item.getName();
				if(itemName.indexOf(key) != -1) {
					System.out.println("Here");
					filterList.addElement(item);
				}
			}
			this.items = filterList;
		}
		updateUI();
	}
	
	//Select first item in the list
	public void setFirst() {
		itemsList.setSelectedIndex(0);
	}
	
	//Select last item in the list
	public void setLast() {
		itemsList.setSelectedIndex(items.getSize()-1);
	}
	
	//Update the price of a selected item
	public boolean updateSelectedPrice() {
		int pos = itemsList.getSelectedIndex();
		if(pos >= 0) {
			Item selected = items.get(pos);
			selected.updatePrice();
			updateUI();
			return true;
		}
		return false;
	}
	
	//Launch browser of a selected item
	public boolean launchBrowserSelected() {
		int pos = itemsList.getSelectedIndex();
		if(pos >= 0) {
			Item selected = items.get(pos);
			selected.launchBrowser();
			return true;
		}
		return false;
	}
	
	public void updateItem(Item newInfo, int pos) {
		items.set(pos, newInfo);
	}
	
	//Remove a selected item (position)
	public boolean removeItem() {
		int pos = itemsList.getSelectedIndex();
		if(pos >= 0) {
			items.remove(pos);
			return true;
		}
		return false;
	}
	
	//Get the item in the position "position"
	public Item getItem(int pos) {
		return items.get(pos);
	}
	
	//Get selected item in the list
	public int getSelected() {
		return itemsList.getSelectedIndex();
	}
	
}
