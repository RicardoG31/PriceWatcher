package hw2;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
* A dialog for tracking the price of an item.
*
* @author Yoonsik Cheon
*/
@SuppressWarnings("serial")
public class Main extends JFrame {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_SIZE = new Dimension(400, 600);
    
    /*Components*/
    CustomMenubar menu;
    CustomToolbar toolbar;
    JPanel contentContainer;
    JDialog dialog;
      
    /** Message bar to display various messages. */
    private JLabel msgBar = new JLabel(" ");
    
    ListUtils items;
    
    Item testItem = new Item("Macbook Pro", 2999.99, 2999.99, "http//google.com");
    
    //Actions performed in the UI
    
    
    //Show more information about the app
    ActionListener aboutApp = (event) -> {
    	Dialogs.aboutDialog(this);
    };
    
    //Close the app
    ActionListener exitApp = (event) -> {
    	System.exit(0); 
    };
    
    //Update Prices of List of Items
    ActionListener checkPrices = (event) -> {
    	items.updatePrices();
    };
    
    //Show a dialog that will ask user information
    //about a new item to add to the list
    ActionListener addItem = (event) -> {
    	dialog = Dialogs.addItemDialog(this, items);
    	dialog.setVisible(true);
    };
    
    //Show a dialog that will ask user for a term
    //then, app will show items that contain that term
    ActionListener searchItem = (event) -> {
    	dialog = Dialogs.searchItemDialog(this, items);
    	dialog.setVisible(true);
    };
    
    //Select first item of the list
    ActionListener firstItem = (event) -> {
    	items.setSelected(0);
    };
    
    //Select last item of the list
    ActionListener lastItem = (event) -> {
    	items.setSelected(items.getSize()-1);
    };
    
    //Update price of selected item
    ActionListener checkItemPrice = (event) -> {
    	int position = items.getSelected();
    	if(position>=0) {
    		Item selectedItem = items.getItem(position);
        	selectedItem.updatePrice();
    	} else {
    		showMessage("A item must be selected");
    	}
    	
    };
    
    //Open browser to watch selected item
    ActionListener viewItem = (event) -> {
    	int position = items.getSelected();
    	if(position>=0) {
    		Item selectedItem = items.getItem(position);
        	Desktop d = Desktop.getDesktop();
    		try {
    			d.browse(new URI(selectedItem.getUrl()));
    		} catch (IOException | URISyntaxException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    	} else {
    		showMessage("A item must be selected");
    	}
    };
    
    //Edit selected item
    ActionListener editItem = (event) -> {
    	int position = items.getSelected();
    	if(position>=0) {
    		//dialog = Dialogs.updateItemDialog(this, items);
    		//dialog.setVisible(true);
    	} else {
    		showMessage("A item must be selected");
    	}
    };
    
    //Remove selected Item
    ActionListener removeItem = (event) -> {
    	int position = items.getSelected();
    	if(position>=0) {
    		Dialogs.confirmRemoveDialog(this, items);
    	} else {
    		showMessage("A item must be selected");
    	}
    };
    
    //Get to clipboard name of selected item
    ActionListener copyName = (event) -> {
    	int position = items.getSelected();
    	if(position >= 0) {
    		Item selectedItem = items.getItem(position);
        	StringSelection selection = new StringSelection(selectedItem.getName());
        	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        	clipboard.setContents(selection, selection);
    	} else {
    		showMessage("A item must be selected");
    	}
    };
    
    //Get to clipboard URL of selected item
    ActionListener copyURL = (event) -> {
    	int position = items.getSelected();
    	if(position>=0) {
    		Item selectedItem = items.getItem(position);
        	StringSelection selection = new StringSelection(selectedItem.getUrl());
        	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        	clipboard.setContents(selection, selection);
    	} else {
    		showMessage("A item must be selected");
    	}
    };

    /** Create a new dialog. */
    public Main() {
    	this(DEFAULT_SIZE);
    }
    
    /** Create a new dialog of the given screen dimension. */
    public Main(Dimension dim) {
        super("Price Watcher");
        setSize(dim);
        
        configureUI();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        showMessage("Welcome!");
    }

        
    /** Configure UI. */
    private void configureUI() {
        setLayout(new BorderLayout());
        
        createMenubar();
        createToolbar();
        createContentContainer();
        createMsgBar();
    }
    
    //Creates a custom menubar
    private void createMenubar() {
    	
    	menu = new CustomMenubar(this);
    	setJMenuBar(menu.getCustomMenu());
    	
    }
    
    //Creates a custom toolbar
    //at the top of the app
    private void createToolbar() {
    	
    	toolbar = new CustomToolbar(this);
		add(toolbar.getCustomToolbar(), BorderLayout.NORTH);
		
    }
    
    //Creates a scrollable container to show list of items
    //at the center of the app
    private void createContentContainer() {
    	contentContainer = new JPanel(); 
		contentContainer.setLayout(new BoxLayout(contentContainer, BoxLayout.Y_AXIS));
		//contentContainer.setBackground(Color.BLACK);
	
		items = new ListUtils();
		items.addItem(testItem);
		items.addItem(testItem);
		contentContainer.add(items.getScrollComp(), BorderLayout.CENTER);
		
		add(contentContainer, BorderLayout.CENTER);
		
    }
    
    //Creates a messageBar at the button of the app
    private void createMsgBar() {
    	msgBar.setBorder(BorderFactory.createEmptyBorder(10,16,10,0));
        add(msgBar, BorderLayout.SOUTH);
    }

    /** Show briefly the given string in the message bar. */
    private void showMessage(String msg) {
        msgBar.setText(msg);
        new Thread(() -> {
        	try {
				Thread.sleep(3 * 1000); // 3 seconds
			} catch (InterruptedException e) {
			}
        	if (msg.equals(msgBar.getText())) {
        		SwingUtilities.invokeLater(() -> msgBar.setText(" "));
        	}
        }).start();
    }
    
    public static void main(String[] args) {
        new Main();
    }

}

