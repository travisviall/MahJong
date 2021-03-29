package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BambooTile extends RankTile
{
	private static ArrayList<Bamboo> tile2 = new ArrayList<>();
	private static ArrayList<Bamboo> tile3 = new ArrayList<>();
	private static ArrayList<Bamboo> tile4 = new ArrayList<>();
	private static ArrayList<Bamboo> tile5 = new ArrayList<>();
	private static ArrayList<Bamboo> tile6 = new ArrayList<>();
	private static ArrayList<Bamboo> tile7 = new ArrayList<>();
	private static ArrayList<Bamboo> tile9 = new ArrayList<>();
	
	static
	{
		tile2.add(new Bamboo(50, 22, Color.BLUE));
		tile2.add(new Bamboo(50, 48, Color.GREEN));
		
		tile3.add(new Bamboo(56, 22, Color.BLUE));
		tile3.add(new Bamboo(35, 50, Color.GREEN));
		tile3.add(new Bamboo(75, 50, Color.GREEN));
		
		tile4.add(new Bamboo(35, 22, Color.BLUE));
		tile4.add(new Bamboo(35, 50, Color.GREEN));
		tile4.add(new Bamboo(75, 22, Color.BLUE));
		tile4.add(new Bamboo(75, 50, Color.GREEN));
		
		tile5.add(new Bamboo(35, 22, Color.GREEN));
		tile5.add(new Bamboo(35, 50, Color.BLUE));
		tile5.add(new Bamboo(75, 22, Color.BLUE));
		tile5.add(new Bamboo(75, 50, Color.GREEN));
		tile5.add(new Bamboo(55, 38, Color.RED));
		
		tile6.add(new Bamboo(30, 22, Color.GREEN));
		tile6.add(new Bamboo(55, 22, Color.GREEN));
		tile6.add(new Bamboo(80, 22, Color.GREEN));
		tile6.add(new Bamboo(30, 48, Color.BLUE));
		tile6.add(new Bamboo(55, 48, Color.BLUE));
		tile6.add(new Bamboo(80, 48, Color.BLUE));
		
		tile7.add(new Bamboo(30, 35, Color.GREEN));
		tile7.add(new Bamboo(55, 35, Color.BLUE));
		tile7.add(new Bamboo(80, 35, Color.GREEN));
		tile7.add(new Bamboo(30, 57, Color.GREEN));
		tile7.add(new Bamboo(55, 57, Color.BLUE));
		tile7.add(new Bamboo(80, 57, Color.GREEN));
		tile7.add(new Bamboo(55, 10, Color.RED));
		
		tile9.add(new Bamboo(30, 30, Color.RED));
		tile9.add(new Bamboo(55, 30, Color.BLUE));
		tile9.add(new Bamboo(80, 30, Color.GREEN));
		tile9.add(new Bamboo(30, 54, Color.RED));
		tile9.add(new Bamboo(55, 54, Color.BLUE));
		tile9.add(new Bamboo(80, 54, Color.GREEN));
		tile9.add(new Bamboo(55, 8, Color.BLUE));
		tile9.add(new Bamboo(30, 8, Color.RED));
		tile9.add(new Bamboo(80, 8, Color.GREEN));
		
	}
	public BambooTile(int rank)
	{
		super(rank);
		setToolTipText(toString());
	}

	public String toString()
	{
		return String.format("Bamboo %d", rank);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch (super.rank)
		{
		case 2:
			for(Bamboo b: tile2)
			{
				b.draw(g);
			}
			break;
		case 3:
			for(Bamboo b: tile3)
			{
				b.draw(g);
			}
			break;
		case 4:
			for(Bamboo b: tile4)
			{
				b.draw(g);
			}
			break;
		case 5:
			for(Bamboo b: tile5)
			{
				b.draw(g);
			}
			break;
		case 6:
			for(Bamboo b: tile6)
			{
				b.draw(g);
			}
			break;
		case 7:
			for(Bamboo b: tile7)
			{
				b.draw(g);
			}
			break;
		case 8:
			Graphics2D g2 = (Graphics2D) g;
			Bamboo b28 = new Bamboo(25, 18, Color.GREEN);
			b28.draw(g);
			Bamboo b29 = new Bamboo(85, 18, Color.GREEN);
			b29.draw(g);
			Bamboo b30 = new Bamboo(25, 49, Color.BLUE);
			b30.draw(g);
			Bamboo b31 = new Bamboo(85, 49, Color.BLUE);
			b31.draw(g);
			Bamboo b32 = new Bamboo(35, 42, Color.GREEN);
			g2.rotate((Math.PI / 4), 65, 50);
			b32.draw(g2);
			Bamboo b33 = new Bamboo(60, 42, Color.GREEN);
			g2.rotate((-6.14 / 4), 50, 40);
			b33.draw(g2);
			Bamboo b34 = new Bamboo(64, 6, Color.BLUE);
			g2.rotate((Math.PI ), 45, 30);
			b34.draw(g2);
			Bamboo b35 = new Bamboo(5, 0, Color.BLUE);
			g2.rotate((6.14	 / 4), 35, 22);
			b35.draw(g2);
			break;
		case 9:
			for(Bamboo b: tile9)
			{
				b.draw(g);
			}
			break;
		}
	}

	static class Bamboo
	{
		private int x;
		private int y;
		private Color color;

		public Bamboo(int x, int y, Color color)
		{
			this.x = x;
			this.y = y;
			this.color = color;
		}

		public void draw(Graphics g)
		{
			var reed = new Polygon();

			g.setColor(color);
			reed.addPoint(x, y);
			reed.addPoint(x, y - 2);
			reed.addPoint(x + 2, y - 4);
			reed.addPoint(x + 6, y - 4);
			reed.addPoint(x + 8, y - 2);
			reed.addPoint(x + 8, y);
			reed.addPoint(x + 6, y);
			reed.addPoint(x + 6, y + 4);
			reed.addPoint(x + 8, y + 6);
			reed.addPoint(x + 8, y + 8);
			reed.addPoint(x + 6, y + 8);
			reed.addPoint(x + 6, y + 12);
			reed.addPoint(x + 8, y + 14);
			reed.addPoint(x + 8, y + 16);
			reed.addPoint(x, y + 16);
			reed.addPoint(x, y + 14);
			reed.addPoint(x + 2, y + 12);
			reed.addPoint(x + 2, y + 8);
			reed.addPoint(x, y + 8);
			reed.addPoint(x, y + 6);
			reed.addPoint(x + 2, y + 4);
			reed.addPoint(x + 2, y);
			reed.addPoint(x, y);
			g.drawPolygon(reed);
			g.fillPolygon(reed);
			g.setColor(Color.WHITE);
			g.drawLine(x + 5, y - 1, x + 5, y + 4);
			g.drawLine(x + 5, y + 9, x + 5, y + 14);
		}
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}
