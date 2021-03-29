package game;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PictureTile extends Tile
{
	private String name;
	ImageIcon image;
	private static ImageIcon[] images = new ImageIcon[9];
	private URL url;
	
	public PictureTile(String name)
	{
		this.name = name;
		setToolTipText(toString());
		
		
		url = PictureTile.class.getResource("images/" + name + ".png");
		image = new ImageIcon(url);
		
	}
	
	public String toString()
	{
		return String.format("%s", name);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		switch(name)
		{
		case "Chrysanthemum":
			//image.paintIcon(this, g, 40, 20);
			g.drawImage(image.getImage(), 25, 12, this);
			break;
		case "Orchid":
			g.drawImage(image.getImage(), 25, 8, this);
			break;
		case "Plum":
			g.drawImage(image.getImage(), 28, 10, this);
			break;
		case "Bamboo":
			g.drawImage(image.getImage(), 30, 8, this);
			break;
		case "Spring":
			g.drawImage(image.getImage(), 27, 18, this);
			break;
		case "Summer":
			g.drawImage(image.getImage(), 25, 10, this);
			break;
		case "Fall":
			g.drawImage(image.getImage(), 25, 10, this);
			break;
		case "Winter":
			g.drawImage(image.getImage(), 25, 10, this);
			break;
		case "Sparrow":
			g.drawImage(image.getImage(), 25, 15, this);
			break;
		}
		
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new Bamboo1Tile());

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
	
}
