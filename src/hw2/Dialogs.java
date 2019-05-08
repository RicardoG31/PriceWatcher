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
	public static JDialog itemDialog(JFrame c, ListUtils items, int pos) {
		JDialog dialog = new JDialog(c, "Add Item", false);
		dialog.setSize(new Dimension(300, 200));
		dialog.setLayout(new BorderLayout());
		
		JPanel form = new JPanel(new GridLayout(3,3));
		
		JLabel name = new JLabel("Name: ");
		JTextField nameTextField = new JTextField();  
		JLabel url = new JLabel("URL: ");
		JTextField urlTextField = new JTextField();
		JLabel price = new JLabel("Price: ");
		JLabel priceField = new JLabel("0.0");
		
		if(pos >= 0) {
			Item selectedItem = items.getItem(pos);
			nameTextField.setText(selectedItem.getName());
			urlTextField.setText(selectedItem.getUrl());
			priceField.setText(Double.toString(selectedItem.getPrice()));
		}

		form.add(name); form.add(nameTextField); form.add(url); 
		form.add(urlTextField); form.add(price); form.add(priceField);
		
		JPanel buttonsContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton add = new JButton("Add");
		JButton edit = new JButton("Edit");
		JButton cancel = new JButton("Cancel");
		
		add.addActionListener((event) -> {
			String itemName = nameTextField.getText();
			String itemURL = urlTextField.getText();
			double itemPrice = PriceFinder.urlPrice(itemURL);
			priceField.setText(Double.toString(itemPrice));
			
			Item newItem = new Item(itemName, itemPrice, itemPrice, itemURL);
			items.addItem(newItem);
			dialog.setVisible(false);
		});
		
		edit.addActionListener((event) -> {
			String itemName = nameTextField.getText();
			String itemURL = urlTextField.getText();
			double itemPrice = PriceFinder.urlPrice(itemURL);
			priceField.setText(Double.toString(itemPrice));
			
			Item newItem = new Item(itemName, itemPrice, itemPrice, itemURL);
			items.updateItem(newItem, pos);
			dialog.setVisible(false);
		});
		
		cancel.addActionListener((event) -> {
			dialog.setVisible(false);
		});
		
		if(pos >= 0) {
			buttonsContainer.add(edit);
		} else {
			buttonsContainer.add(add);
		}
		buttonsContainer.add(cancel);

		dialog.add(form, BorderLayout.CENTER);
		dialog.add(buttonsContainer, BorderLayout.SOUTH);
		
		return dialog;
		
	}
	
	//Search item dialog
	//Ask user for a term and filter list by elements that contain that list
	public static JDialog searchItemDialog(JFrame c, ListUtils items) {
		JDialog dialog = new JDialog(c, "Search Item", false);
		dialog.setSize(new Dimension(300, 115));
		dialog.setLayout(new BorderLayout());
		
		JPanel form = new JPanel(new GridLayout(1, 2));
		
		JLabel searchLabel = new JLabel("Search: ");
		JTextField searchTextField = new JTextField(); 
		
		form.add(searchLabel); form.add(searchTextField);
		
		JPanel btnContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton search = new JButton("Search");
		JButton reset = new JButton("Reset");
		JButton cancel = new JButton("Cancel");
		
		search.addActionListener((event) -> {
			String term = searchTextField.getText();
			items.resetList();
			items.searchItems(term);
			dialog.setVisible(false);
		});
		
		reset.addActionListener((event) -> {
			items.resetList();
		});
		
		cancel.addActionListener((event) -> {
			dialog.setVisible(false);
		});
		
		btnContainer.add(search); btnContainer.add(reset); btnContainer.add(cancel);
		
		dialog.add(form, BorderLayout.CENTER);
		dialog.add(btnContainer, BorderLayout.SOUTH);
		
		return dialog;
	}
	
	//Remove item dialog
	//Ask user for confirmation if he/she wants to delete the selected item
	public static void confirmRemoveDialog(JFrame c, ListUtils items) {
		int resp = JOptionPane.showConfirmDialog(c, "Are you sure that you want to delete this item?");
		if(resp == JOptionPane.YES_OPTION) {
			items.removeItem();
		}
	}
	
}
