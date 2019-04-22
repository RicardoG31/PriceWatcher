package hw2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dialogs {

	//About the app dialog
	//Shows more details about the app
	public static void aboutDialog(JFrame c) {
		JOptionPane.showMessageDialog(c, "Price Watcher, v1.0");
	}
	
	//Add item dialog
	//Ask user information about the new item to add
	public static JDialog addItemDialog(JFrame c, ListUtils items) {
		JDialog dialog = new JDialog(c, "Add Item", false);
		dialog.setSize(new Dimension(300, 200));
		dialog.setLayout(new BorderLayout());
		
		JPanel form = new JPanel(new GridLayout(4, 3));
		
		JLabel name = new JLabel("Name: ");
		JTextField nameTextField = new JTextField();  
		JLabel url = new JLabel("URL: ");
		JTextField urlTextField = new JTextField();
		JLabel price = new JLabel("Price: ");
		JTextField priceTextField = new JTextField();
		JLabel group = new JLabel("Group: ");
		//JTextField groupTextField = new JTextField("Welcome to Javatpoint.");
		
		JPanel buttonsContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton add = new JButton("Add");
		JButton cancel = new JButton("Cancel");
		
		add.addActionListener((event) -> {
			System.out.println("Item added");
		});
		
		cancel.addActionListener((event) -> {
			dialog.setVisible(false);
		});
		
		buttonsContainer.add(add); buttonsContainer.add(cancel);
		
		form.add(name); form.add(nameTextField); form.add(url); 
		form.add(urlTextField); form.add(price); form.add(priceTextField); 
		form.add(group);
		
		dialog.add(form, BorderLayout.CENTER);
		dialog.add(buttonsContainer, BorderLayout.SOUTH);
		
		return dialog;
		
	}
	
	//Update item dialog
	//Update the selected item
	public static JDialog updateItemDialog(JFrame c, Item item) {
	
	}
	
	//Search item dialog
	//Ask user for a term and filter list by elements that contain that list
	public static JDialog searchItemDialog(JFrame c, ListUtils items) {
		JDialog dialog = new JDialog(c, "Search Item", false);
		dialog.setSize(new Dimension(300, 200));
		dialog.setLayout(new BorderLayout());
		
		JPanel form = new JPanel(new GridLayout(2, 2));
		
		JLabel searchLabel = new JLabel("Search: ");
		JTextField searchTextField = new JTextField(); 
		JButton searchButton = new JButton("Search");
		JButton cancelButton = new JButton("Cancel");
		
		searchButton.addActionListener((event) -> {
			String term = searchTextField.getText();
			items.searchItems(term);
			dialog.setVisible(false);
		});
		
		cancelButton.addActionListener((event) -> {
			dialog.setVisible(false);
		});
		
		form.add(searchLabel); form.add(searchTextField);
		form.add(searchButton); form.add(cancelButton);
		
		dialog.add(form, BorderLayout.CENTER);
		
		return dialog;
	}
	
	//Remove item dialog
	//Ask user for confirmation if he/she wants to delete the selected item
	public static void confirmRemoveDialog(JFrame c, ListUtils items) {
		int resp = JOptionPane.showConfirmDialog(c, "Are you sure that you want to delete this item?");
		if(resp == JOptionPane.YES_OPTION) {
			int position = items.getSelected();
			items.removeItem(position);
		}
	}
	
}
