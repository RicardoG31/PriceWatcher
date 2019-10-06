package hw2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
 

public class ItemRender extends JPanel implements ListCellRenderer<Item> {
 
    @Override
    public Component getListCellRendererComponent(JList<? extends Item> list, Item item, int index,
        boolean isSelected, boolean cellHasFocus) {
          
    	setLayout(new BorderLayout());
    	ItemView view = new ItemView(item);
    	
    	if(isSelected) {
    		view.setBackground(Color.BLACK);
    	}
    	
    	add(view, BorderLayout.CENTER);
         
        return this;
    }
    
     
}
