package game;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import game.CircleTile.Circle.Pancake;

public class CircleTile extends RankTile
{

	private static ArrayList<Circle> tile1 = new ArrayList<>();
	private static ArrayList<Circle> tile2 = new ArrayList<>();
	private static ArrayList<Circle> tile3 = new ArrayList<>();
	private static ArrayList<Circle> tile4 = new ArrayList<>();
	private static ArrayList<Circle> tile5 = new ArrayList<>();
	private static ArrayList<Circle> tile6 = new ArrayList<>();
	private static ArrayList<Circle> tile7 = new ArrayList<>();
	private static ArrayList<Circle> tile8 = new ArrayList<>();
	private static ArrayList<Circle> tile9 = new ArrayList<>();

	public CircleTile(int rank)
	{
		super(rank);
		setToolTipText(toString());

	}

	public String toString()
	{
		return String.format("Circle %d", rank);
	}

	static
	{
		
		tile1.add(new Circle(51, 32, Color.RED));
		
		tile2.add(new Circle(52,20,Color.GREEN));
		tile2.add(new Circle(52,50, Color.RED));
		
		tile3.add(new Circle(33,13,Color.BLUE));
		tile3.add(new Circle(50, 35, Color.RED));
		tile3.add(new Circle(68,57,Color.GREEN));
		
		tile4.add(new Circle(30, 13, Color.BLUE));
		tile4.add(new Circle(30, 53, Color.GREEN));
		tile4.add(new Circle(70, 13, Color.GREEN));
		tile4.add(new Circle(70, 53, Color.BLUE));
		
		tile5.add(new Circle(50, 35, Color.RED));
		tile5.add(new Circle(30, 13, Color.BLUE));
		tile5.add(new Circle(70, 53, Color.BLUE));
		tile5.add(new Circle(70, 13, Color.GREEN));
		tile5.add(new Circle(30, 53, Color.GREEN));
		
		tile6.add(new Circle(30, 13, Color.GREEN));
		tile6.add(new Circle(70, 13, Color.GREEN));
		tile6.add(new Circle(30, 33, Color.RED));
		tile6.add(new Circle(70, 33, Color.RED));
		tile6.add(new Circle(30, 53, Color.RED));
		tile6.add(new Circle(70, 53, Color.RED));
		
		tile7.add(new Circle(30, 38, Color.RED));
		tile7.add(new Circle(70, 38, Color.RED));
		tile7.add(new Circle(30, 58, Color.RED));
		tile7.add(new Circle(70, 58, Color.RED));
		tile7.add(new Circle(30, 8, Color.GREEN));
		tile7.add(new Circle(52, 15, Color.GREEN));
		tile7.add(new Circle(72, 20, Color.GREEN));
		
		tile8.add(new Circle(33, 3, Color.BLUE));
		tile8.add(new Circle(72, 3, Color.BLUE));
		tile8.add(new Circle(33, 20, Color.BLUE));
		tile8.add(new Circle(72, 20, Color.BLUE));
		tile8.add(new Circle(33, 40, Color.BLUE));
		tile8.add(new Circle(72, 40, Color.BLUE));
		tile8.add(new Circle(33, 60, Color.BLUE));
		tile8.add(new Circle(72, 60, Color.BLUE));
		
		tile9.add(new Circle(30, 6, Color.GREEN));
		tile9.add(new Circle(53, 6, Color.GREEN));
		tile9.add(new Circle(76, 6, Color.GREEN));
		tile9.add(new Circle(30, 32, Color.RED));
		tile9.add(new Circle(53, 32, Color.RED));
		tile9.add(new Circle(76, 32, Color.RED));
		tile9.add(new Circle(30, 58, Color.BLUE));
		tile9.add(new Circle(53, 58, Color.BLUE));
		tile9.add(new Circle(76, 58, Color.BLUE));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Pancake pancake = new Pancake();

		switch (super.rank)
		{
		case 1:
			
			pancake.draw(g);
			for(Circle c: tile1)
			{
				c.draw(g);
			}
			break;
		case 2:
			for(Circle c: tile2)
			{
				c.draw(g);
			};
			break;
		case 3:
			for(Circle c: tile3)
			{
				c.draw(g);
			}
			break;
		case 4:
			for(Circle c: tile4)
			{
				c.draw(g);
			}
			break;
		case 5:
			for(Circle c: tile5)
			{
				c.draw(g);
			}
			break;
		case 6:
			for(Circle c: tile6)
			{
				c.draw(g);
			}
			break;
		case 7:
			for(Circle c: tile7)
			{
				c.draw(g);
			}
			break;
		case 8:
			for(Circle c: tile8)
			{
				c.draw(g);
			}
			break;
		case 9:
			for(Circle c: tile9)
			{
				c.draw(g);
			}
			break;

		}
	}

	 static class Circle
	{
		private int x;
		private int y;
		private Color color;

		public Circle(int x, int y, Color color)
		{
			this.x = x;
			this.y = y;
			this.color = color;
		}

		public void draw(Graphics g)
		{
			var circle = new Ellipse2D.Double(x, y, 13, 13);
			Graphics2D g2 = (Graphics2D) g;

			g2.setColor(color);
			g2.fill(circle);
			g2.setColor(Color.WHITE);
			g2.drawLine(((int) circle.x + 2), ((int) circle.y + 2), ((int) circle.x + 10), (int) circle.y + 10);
			g2.drawLine(((int) circle.x + 2), ((int) circle.y + 10), ((int) circle.x + 10), ((int) circle.y + 2));
		}

		 static class Pancake
		{
			public  void draw(Graphics g)
			{

				var circle = new Ellipse2D.Double(28, 8, 60, 60);
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.GREEN);
				g2.fill(circle);
				g2.setColor(Color.BLACK);
				g2.draw(circle);

				Rectangle2D s;

				s = new Rectangle2D.Double(41, 19, 4, 4);
				g2.setColor(Color.WHITE);
				g2.fill(s);
				
				s = new Rectangle2D.Double(49, 15, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(59, 13, 4 , 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(70, 16, 4 , 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(78, 25, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(80, 35, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(78, 45, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(70, 55, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(60, 60, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(51, 60, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(41, 56, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(34, 48, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(34, 36, 4, 4);
				g2.fill(s);
				
				s = new Rectangle2D.Double(36, 28, 4, 4);
				g2.fill(s);
			}
		}

	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}

}
