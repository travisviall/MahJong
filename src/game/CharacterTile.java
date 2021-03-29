package game;

import java.util.HashMap;
import javax.swing.*;
import java.awt.*;

public class CharacterTile extends Tile
{
	protected char symbol;
	private static String wan;
	static HashMap<Character, Character> map = new HashMap<>();

	static
	{
		map.put('1', '\u4E00');
		map.put('2', '\u4e8C');
		map.put('3', '\u4E09');
		map.put('4', '\u56DB');
		map.put('5', '\u4E94');
		map.put('6', '\u516D');
		map.put('7', '\u4E03');
		map.put('8', '\u516B');
		map.put('9', '\u4E5D');
		map.put('N', '\u5317');
		map.put('E', '\u6771');
		map.put('W', '\u897F');
		map.put('S', '\u5357');
		map.put('C', '\u4E2D');
		map.put('F', '\u767C');

		wan = Character.toString('\u842C');
		
	}

	public CharacterTile(char symbol)
	{
		this.symbol = symbol;
		setToolTipText(toString());
	}

	public boolean matches(Object other)
	{
		CharacterTile tile = (CharacterTile) other;

		if (super.matches(other) && this.symbol == tile.symbol)
			return true;
		return false;
	}

	public String toChinese()
	{
		String chinese = Character.toString(map.get(symbol));
		return chinese;
	}

	public String toString()
	{
		String name = "";

		switch (symbol)
		{
		case 'W':
			name = "West Wind";
			break;
		case 'N':
			name = "North Wind";
			break;
		case 'E':
			name = "East Wind";
			break;
		case 'S':
			name = "South Wind";
			break;
		case 'C':
			name = "Red Dragon";
			break;
		case 'F':
			name = "Green Dragon";
			break;
		default:
			return String.format("Character %c", symbol);

		}

		return String.format("%s", name);

	}
	
	public void paintComponent(Graphics g)
	{
		
		Font font;
		super.paintComponent(g);

		String value = Character.toString(this.symbol);
		
		g.setColor(Color.RED);
		font = g.getFont().deriveFont(12F);
		g.setFont(font);
		g.drawString(value, 80, 15);
		
		if(Character.isDigit(this.symbol))
		{
			font = g.getFont().deriveFont(14F);
			g.setFont(font);
			FontMetrics fm = g.getFontMetrics();
			g.setColor(Color.RED);
			g.drawString(wan, 45, 60);
			g.setColor(Color.BLACK);
			g.drawString(this.toChinese(), 45, 30);
		}
		else if(this.symbol == 'C')
		{
			font = g.getFont().deriveFont(50F);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString(this.toChinese(), 32, 62);
		}
		else if(this.symbol == 'F')
		{
			font = g.getFont().deriveFont(50F);
			g.setFont(font);
			g.setColor(Color.GREEN);
			g.drawString(this.toChinese(), 32, 63);
		}
		else
		{
			font = g.getFont().deriveFont(50F);
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString(this.toChinese(), 32, 60);
		}
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JPanel tiles = new JPanel();
		JScrollPane scroller = new JScrollPane(tiles);
		scroller.setPreferredSize(new Dimension(12 * 121, 40 + 121));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);
		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
}
