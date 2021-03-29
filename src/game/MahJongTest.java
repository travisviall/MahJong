//package game;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class MahJongTest extends JFrame
//{
//	public MahJongTest ()
//	{
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		add(new TestPanel());
//		setSize(500,500);
//		setVisible(true);
//	}
//	
//	public class TestPanel extends JPanel
//	{
//		//paint tiles to this panel
//		public TestPanel()
//		{
//			//discards the layout manager to allow stacking
//			
//			//whatever container the tiles in has to be set to null (JPanel or JFrame)
//			setLayout(null); 	//must change Tile.java constructor to setSize
//			
//			Tile t;
//			
//			t = new SeasonTile("Spring");
//			//sets the location in the JFrame (?)
//			t.setLocation(400,100);
//			//adds tile to the JPanel
//			add(t);
//			
//			t = new SeasonTile("Summer");
//			t.setLocation(184, 116);
//			add(t);
//			
//			t = new SeasonTile("Fall");
//			t.setLocation(168, 132);
//			add(t);
//			
//			t = new SeasonTile("Winter");
//			t.setLocation(152, 148);
//			add(t);
//		}
//	}
//	
//	public static void main(String[] args)
//	{
//		new MahJongTest();
//	}
//}
