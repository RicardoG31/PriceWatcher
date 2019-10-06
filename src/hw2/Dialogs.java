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

	public static void aboutDialog(JFrame c) {
		JOptionPane.showMessageDialog(c, "Price Watcher, v1.0");
	}
	
	public static JDialog addItemDialog(JFrame c) {
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
	
	public static JDialog updateItemDialog(JFrame c, Item item) {
	
	}
	
	public static void confirmDialog(JFrame c) {
		int resp = JOptionPane.showConfirmDialog(c, "Are you sure that you want to delete this item?");
		if(resp == JOptionPane.YES_OPTION) {
			System.out.println("Item was deleted");
		}
	}
	
}
