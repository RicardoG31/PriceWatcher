package hw2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

public class ListUtils extends JScrollPane {
	
	JList<Item>itemsList;
	DefaultListModel<Item> items = new DefaultListModel<>();
	DefaultListModel<Item> backup = new DefaultListModel<>();;
			
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
		for(int i=listSize-1; i>=0; i--) {
			Item current = items.get(i);
			backup.addElement(current);
			if(current.getName().indexOf(key) == -1) {
				items.remove(i);
			}
		}
	}
	
	//Reset all items
	public void resetList() {
		if(backup.getSize()>0) {
			items.removeAllElements();	
			
			int listSize = backup.getSize();
			for(int i=listSize-1; i>=0; i--) {
				Item current = backup.get(i);
				items.addElement(current);
			}
			backup.removeAllElements();
		}
		
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
	
	public void setPopupMenu(JPopupMenu menu) {
		itemsList.addMouseListener(new MouseAdapter() {
    		public void mouseClicked(MouseEvent e) {
    			menu.show(e.getComponent(), e.getX(), e.getY());
    		}
    	});
		itemsList.add(menu);
	}
	
}
