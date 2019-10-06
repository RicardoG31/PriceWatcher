package hw2;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListUtils {
	
	DefaultListModel<Item> items = new DefaultListModel<>();
	
	public ListUtils() {}

	public void addItem(Item newItem){
		items.addElement(newItem);
	}
	
	public void updatePrices(){
		int listSize = items.getSize();
		for(int i=0; i<listSize; i++) {
			Item item = items.get(i);
			item.updatePrice();
		}
	}
	
	public JScrollPane getScrollComp() {
		JList<Item> itemsList = new JList<>(items);
        itemsList.setCellRenderer(new ItemRender());
        
        JScrollPane scrollableArea = new JScrollPane(itemsList);
        
        return scrollableArea;
	}
	
}
