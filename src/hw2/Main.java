package hw2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
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
    JMenuBar menu;
    Toolbar toolbar;
    JPanel contentContainer;
    JDialog dialog;
      
    /** Message bar to display various messages. */
    private JLabel msgBar = new JLabel(" ");
    
    ListUtils items;
    
    Item testItem = new Item("Macbook Pro", 2999.99, 2999.99, "http//google.com");

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
    
    private void createMenubar() {
    	menu = new JMenuBar();
    	Menubar menuUtils = new Menubar();
    	
    	JMenu app = menuUtils.menu("App", KeyEvent.VK_P);
    	JMenuItem about = menuUtils.menuItem("About", KeyEvent.VK_A, "assets/helpBlue.png", (event) -> { 
    		Dialogs.aboutDialog(this);
    	}); 
    	JMenuItem exit = menuUtils.menuItem("Exit", KeyEvent.VK_X, (event) -> { System.exit(0); });
    	
    	app.add(about); app.add(new JSeparator()); app.add(exit);
    	
    	JMenu item = menuUtils.menu("Item", KeyEvent.VK_I);
    	JMenuItem checkPrices = menuUtils.menuItem("Check prices", KeyEvent.VK_C, "assets/checkBlue.png", (event) -> { System.out.println("Test"); });
    	JMenuItem addItem = menuUtils.menuItem("Add Item", KeyEvent.VK_A, "assets/addBlue.png", (event) -> { 
    		dialog = Dialogs.addItemDialog(this);
    		dialog.setVisible(true);
    	});
    	JMenuItem searchItem = menuUtils.menuItem("Search", KeyEvent.VK_S, "assets/searchBlue.png", (event) -> { System.out.println("Test"); });
    	JMenuItem firstItem = menuUtils.menuItem("Select first", KeyEvent.VK_F, "assets/backwardBlue.png", (event) -> { System.out.println("Test"); });
    	JMenuItem lastItem = menuUtils.menuItem("Select last", KeyEvent.VK_L, "assets/forwardBlue.png", (event) -> { System.out.println("Test"); });
    	
    	JMenu selected = menuUtils.menu("selected", KeyEvent.VK_I);
    	JMenuItem price = menuUtils.menuItem("Price", KeyEvent.VK_P, "assets/checkGreen.png", (event) -> { System.out.println("Test"); });
    	JMenuItem view = menuUtils.menuItem("View", KeyEvent.VK_E, "assets/file.png", (event) -> { System.out.println("Test"); });
    	JMenuItem edit = menuUtils.menuItem("Edit", KeyEvent.VK_R, "assets/editGreen.png", (event) -> { System.out.println("Test"); });
    	JMenuItem remove = menuUtils.menuItem("Remove", KeyEvent.VK_F, "assets/minusGreen.png", (event) -> { Dialogs.confirmDialog(this); });
    	JMenuItem copyName = menuUtils.menuItem("Copy Name", KeyEvent.VK_X, (event) -> { System.out.println("Test"); });
    	JMenuItem copyURL = menuUtils.menuItem("Copy URL", KeyEvent.VK_X, (event) -> { System.out.println("Test"); });
    	
    	selected.add(price); selected.add(view); selected.add(edit);
    	selected.add(remove); selected.add(new JSeparator()); selected.add(copyName); selected.add(copyURL);
    	
    	item.add(checkPrices); item.add(addItem); item.add(new JSeparator()); item.add(searchItem); 
    	item.add(firstItem); item.add(lastItem); item.add(new JSeparator()); item.add(selected);
    	
    	JMenu sort = menuUtils.menu("Sort", KeyEvent.VK_S);
    	JRadioButton sortOld =new JRadioButton("Added Oldest");    
    	JRadioButton sortNew =new JRadioButton("Added Newest");
    	JRadioButton sortNameDes =new JRadioButton("Name Descending");  
    	JRadioButton sortNameAsc =new JRadioButton("Name Ascending");    
    	JRadioButton priceChange =new JRadioButton("Price Change (%)");    
    	JRadioButton priceLow =new JRadioButton("Price Low ($)");  
    	JRadioButton priceHigh =new JRadioButton("Price High ($)");  
    	
    	ButtonGroup rb = new ButtonGroup();
    	
    	rb.add(sortOld); rb.add(sortNew); rb.add(sortNameDes); rb.add(sortNameAsc);
    	rb.add(priceChange); rb.add(priceLow); rb.add(priceHigh);
    	
    	sort.add(sortOld); sort.add(sortNew); sort.add(new JSeparator()); 
    	sort.add(sortNameDes); sort.add(sortNameAsc); sort.add(new JSeparator());
    	sort.add(priceChange); sort.add(priceLow); sort.add(priceHigh);
    	
    	menu.add(app); menu.add(item); menu.add(sort);
    	
    	setJMenuBar(menu);
    }
    
    private void createToolbar() {
    	toolbar = new Toolbar();
		ActionListener test = (event) -> {
			System.out.println("Test?");
		};
		toolbar.createButton("assets/checkBlue.png", test);
		toolbar.createButton("assets/addBlue.png", test);
		toolbar.createButton("assets/searchBlue.png", test);
		toolbar.createButton("assets/backwardBlue.png", test);
		toolbar.createButton("assets/forwardBlue.png", test);
		
		toolbar.addSeparator();
		
		toolbar.createButton("assets/checkGreen.png", test);
		toolbar.createButton("assets/file.png", test);
		toolbar.createButton("assets/editGreen.png", test);
		toolbar.createButton("assets/minusGreen.png", test);
		
		toolbar.addSeparator();
		
		toolbar.createButton("assets/helpBlue.png", test);
		
		add(toolbar, BorderLayout.NORTH);
    }
    
    private void createContentContainer() {
    	contentContainer = new JPanel(); 
		contentContainer.setLayout(new BoxLayout(contentContainer, BoxLayout.Y_AXIS));
		contentContainer.setBackground(Color.BLACK);
		
		
		
		items = new ListUtils();
		items.addItem(testItem);
		items.addItem(testItem);
		contentContainer.add(items.getScrollComp(), BorderLayout.CENTER);
		
		add(contentContainer, BorderLayout.CENTER);
		
    }
    
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

