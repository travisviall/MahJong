package game;

import java.awt.*;
import java.util.Stack;

import javax.swing.*;

public class ScrollRemoved extends JScrollPane
{
	private JPanel removed;
	private JPanel panel;
	private Stack<Tile> undoStack = new Stack<Tile>();
	private int width = 111;
	private int height = 111;
	private int count = 0;

	public ScrollRemoved()
	{	
		setPreferredSize(new Dimension(131, this.getHeight()));
		setBorder(BorderFactory.createRaisedBevelBorder());
		panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.YELLOW);
		panel.setSize(width, this.height);
		setViewportView(panel);
		JLabel title = new JLabel(" Removed Tiles");
		title.setFont(new Font("Courier", Font.CENTER_BASELINE, 12));
		panel.add(title, BorderLayout.NORTH);
		
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		removed = new JPanel();
		removed.setBackground(Color.YELLOW);
		panel.add(removed, BorderLayout.CENTER);
		

		
		//panel.add(new Tile());
	}

	public void addToUndo(Tile t)
	{
		
		undoStack.push(t);

		Dimension size = new Dimension(width, ++ count *height);
		removed.setPreferredSize(size);
		
		removed.add(undoStack.pop());
		
		Rectangle r = new Rectangle(0, count * height, width,height);
		getViewport().scrollRectToVisible(r);

		revalidate();
		repaint();
	}
//	public void addToUndo(Tile t)
//	{
//		
//		undoStack.push(t);
//
//		Dimension size = new Dimension(width, ++ count *height);
//		removed.setPreferredSize(size);
//		
//		removed.add(t);
//		
//		Rectangle r = new Rectangle(0, count * height, width,height);
//		getViewport().scrollRectToVisible(r);
//
//		revalidate();
//		repaint();
//	}
	
	public void removeFromUndo()
	{
		//undoStack.pop();
		
		removed.remove(undoStack.pop());
		
		revalidate();
		repaint();
	}

	public Stack<Tile> getUndoStack()
	{
		return undoStack;
	}

	public void setUndoStack(Stack<Tile> undoStack)
	{
		this.undoStack = undoStack;
	}
	
	

}
