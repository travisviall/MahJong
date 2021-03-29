package game;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.*;

public class WhiteDragonTile extends Tile
{
	public WhiteDragonTile()
	{
		setToolTipText(toString());
	}
	
	
	public String toString()
	{
		return "White Dragon";
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		Graphics2D g2 = (Graphics2D)g;
		Rectangle2D rect;
		
		rect = new Rectangle2D.Double(28, 8, 60, 60);
		g2.draw(rect);
		rect = new Rectangle2D.Double(34, 15, 47, 47);
		g2.draw(rect);
		
		g2.setColor(Color.BLUE);
		rect = new Rectangle2D.Double(28,8,12,7);
		g2.fill(rect);
		rect = new Rectangle2D.Double(52,8,12,7);
		g2.fill(rect);
		rect = new Rectangle2D.Double(76,8,12,7);
		g2.fill(rect);
		rect = new Rectangle2D.Double(101,8,12,7);
		g2.fill(rect);
		rect = new Rectangle2D.Double(28,27,7,12);
		g2.fill(rect);
		rect = new Rectangle2D.Double(28,51,7,12);
		g2.fill(rect);
		rect = new Rectangle2D.Double(42,62,12,7);
		g2.fill(rect);
		rect = new Rectangle2D.Double(66,62,12,7);
		g2.fill(rect);
		rect = new Rectangle2D.Double(81,50,7,13);
		g2.fill(rect);
		rect = new Rectangle2D.Double(81,27,7,13);
		g2.fill(rect);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("White Dragon Tile");

		frame.add(new WhiteDragonTile());

		frame.pack();
		frame.setVisible(true);
	}
}
