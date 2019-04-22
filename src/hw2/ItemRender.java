package hw2;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
 

//This class is used to render a custom view in the JList
public class ItemRender extends ItemView implements ListCellRenderer<Item> {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Item> list, Item item, int index,
        boolean isSelected, boolean cellHasFocus) {
          
    	setItem(item);
    	
    	if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        return this;
    }
    
     
}
