package hw2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/** A special panel to display the detail of an item. */

@SuppressWarnings("serial")
public class ItemView extends JPanel {
	
	private Item item;
	
	//Decimal formatter
	private NumberFormat df = new DecimalFormat("#0.00");
    
	/** Interface to notify a click on the view page icon. */
	public interface ClickListener {
		
		/** Callback to be invoked when the view page icon is clicked. */
		void clicked();
	}
        
	/** View-page clicking listener. */
    private ClickListener listener;
    
    /** Create a new instance. */
    public ItemView() {
    	setPreferredSize(new Dimension(100, 160));
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	System.out.println("Test");
            	if (isViewPageClicked(e.getX(), e.getY()) && listener != null) {
            		listener.clicked();
            	}
            }
        });
    }
    
    public void setItem(Item item) {
    	this.item = item;
    }
        
    /** Set the view-page click listener. */
    public void setClickListener(ClickListener listener) {
    	this.listener = listener;
    }
    
    /** Overridden here to display the details of the item. */
    @Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        int x = 10, y = 20;
        g.drawImage(getImage("assets/file.png"), x, y, 20, 20, null);
        y += 50;
        g.drawString("Name:", x, y);
		y += 20;
		g.drawString("URL:", x, y);
		y += 20;
		g.drawString("Price:", x, y);
		y += 20;
		g.drawString("Change:", x, y);
		y += 20;
		g.drawString("Added:", x, y);
		
		// second section
		x += 60;
		y = 70;
		
		g.drawString(item.getName(), x, y);
		y += 20;
		g.drawString(item.getUrl(), x, y);
		y += 20;
		g.setColor(Color.BLUE);
		g.drawString(df.format(item.getPrice()), x, y);
		y += 20;
		// change color of "change"
		if (item.getPrice() < item.getInitPrice()) {
			g.setColor(Color.GREEN);
		} else if (item.getPrice() == item.getInitPrice()) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(Color.RED);
		}
		g.drawString(df.format(item.getChange()) + "%", x, y);
		y += 20;
		g.setColor(Color.BLACK);
		g.drawString(item.getDateAdded() + "($" + item.getInitPrice() + ")", x, y);
    }
    
    /** Return true if the given screen coordinate is inside the viewPage icon. */
    private boolean isViewPageClicked(int x, int y) {
    	//--
    	//-- WRITE YOUR CODE HERE
    	//--
    	return new Rectangle(20, 20, 30, 20).contains(x,  y);
    }
        
    /** Return the image stored in the given file. */
    public Image getImage(String filePath) {
    	Utils utils = new Utils();
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(filePath));
    	imageIcon = utils.resizeIcon(imageIcon);
    	Image img = imageIcon.getImage();
        return img;
    }
}

