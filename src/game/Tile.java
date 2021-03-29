package game;

import java.awt.*;
import javax.swing.*;

public class Tile extends JPanel
{

	private static Dimension SIZE;
	private static Polygon SIDE1;
	private static Polygon SIDE2;
	private static Polygon BOTTOM1;
	private static Polygon BOTTOM2;
	private static Rectangle FACE;
	private static Rectangle FACE2;
	private static GradientPaint FACE_GRAD;
	private static GradientPaint SIDE_GRAD;
	private static int WIDTH;
	private static int HEIGHT;
	private static int EDGE;
	private GradientPaint faceColor;
	
	private int tileRow;
	private int tileColumn;
	private int tileLayer;
	private boolean showing;
	private int zOrder;

	//1536x864
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	static
	{
		SIZE = new Dimension(101, 101);
		//1536x864
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int[] xSide1 =
		{ 10, 20, 20, 10 };
		int[] ySide1 =
		{ 10, 0, 75, 85};
		SIDE1 = new Polygon(xSide1, ySide1, 4);

		int[] xSide2 =
		{ 0, 10, 10, 0 };
		int[] ySide2 =
		{ 20, 10, 85, 95 };
		SIDE2 = new Polygon(xSide2, ySide2, 4);

		FACE = new Rectangle(20, 0, 75, 75);
		FACE2 = new Rectangle(20, 0, 75, 75);
		
		int[] xBottom1 =
		{ 20, 95, 85, 10 };
		int[] yBottom1 =
		{ 75, 75, 85, 85 };
		BOTTOM1 = new Polygon(xBottom1, yBottom1, 4);

		int[] xBottom2 =
		{ 10, 85, 75, 0 };
		int[] yBottom2 =
		{ 85, 85, 95, 95 };
		BOTTOM2 = new Polygon(xBottom2, yBottom2, 4);

		Color c1 = new Color(238, 230, 133);
		Color c2 = new Color(255, 248, 220);
		SIDE_GRAD = new GradientPaint(20, 100, Color.white, 120, 0, c1);
	}

	public Tile()
	{
		WIDTH = FACE.width;
		HEIGHT = FACE.height;
		EDGE = 20;
		
		setPreferredSize(SIZE);
		setOpaque(false);
		setSize(101, 101);
		showing = true;

	}

	public boolean matches(Object other)
	{
		if (other == null)
			return false;
		if (this.equals(other))
			return false;
		if (!this.getClass().isInstance(other))
			return false;

		return true;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setPaint(SIDE_GRAD);
		g2.fill(SIDE1);
		g2.fill(BOTTOM1);
		g2.setPaint(faceColor);
		g2.fill(FACE);

		g2.setColor(Color.GREEN);
		g2.fill(SIDE2);
		g2.fill(BOTTOM2);

		g2.setColor(Color.BLACK);
		g2.draw(FACE);
		g2.draw(SIDE1);
		g2.draw(BOTTOM1);
		g2.draw(SIDE2);
		g2.draw(BOTTOM2);
		



	}
	
	public int getWIDTH()
	{
		return WIDTH;
	}

	public int getHEIGHT()
	{
		return HEIGHT;
	}

	public int getEDGE()
	{
		return EDGE;
	}
	
	public int getTileRow()
	{
		return tileRow;
	}

	public void setTileRow(int tileRow)
	{
		this.tileRow = tileRow;
	}

	public int getTileColumn()
	{
		return tileColumn;
	}

	public void setTileColumn(int tileColumn)
	{
		this.tileColumn = tileColumn;
	}

	public int getTileLayer()
	{
		return tileLayer;
	}

	public void setTileLayer(int tileLayer)
	{
		this.tileLayer = tileLayer;
	}
	
	public boolean isShowing()
	{
		return showing;
	}

	public void setShowing(boolean visible)
	{
		this.showing = visible;
	}
	
	public int getzOrder()
	{
		return zOrder;
	}

	public void setzOrder()
	{
		zOrder = getParent().getComponentZOrder(this);
		
	}
	
	public void resetZOrder()
	{
		getParent().setComponentZOrder(this, zOrder);
	}

	public void selected(boolean b)
	{
		Color c1 = new Color(238, 230, 133);
		
		if(b == true)
			faceColor= new GradientPaint(20, 100, Color.GRAY, 120, 0, c1);
			else
				faceColor = SIDE_GRAD;
	}
	
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		// frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");
		Tile t = new Tile();
		t.selected(true);
		frame.add(t);

		frame.pack();
		frame.setVisible(true);
	}
}
