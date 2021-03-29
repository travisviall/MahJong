package game;

import java.util.Random;
import java.awt.*;
import javax.swing.*;

/**
 * Implements a single six-sided die that may be rolled and graphically
 * displayed.
 */

public class Die extends JPanel
{
	private static final Random RNG = new Random();
	private static final Dimension SIZE = new Dimension(48, 48);

	private Color color;
	private int value = RNG.nextInt(6) + 1;
	private boolean active = false; // can be rolled

	/**
	 * Constructs a single white die.
	 */

	public Die()
	{
		this(Color.WHITE);
	}

	/**
	 * Constructs a single die with the specified color.
	 */

	public Die(Color color)
	{
		this.color = color;
		setPreferredSize(SIZE);
	}

	/**
	 * Rolls this die, updates its value, and repaints its graphical representation.
	 */

	public void roll()
	{
		if (!active)
			return;
		value = RNG.nextInt(6) + 1;
		repaint();
	}

	/**
	 * Get this die's current value [1-6].
	 * 
	 * @return This die's current value.
	 */

	public int getValue()
	{
		return value;
	}

	/**
	 * Sets the value of this die if the specified value is within the range [1-6].
	 * 
	 * @param value The new value for this die.
	 * @throws IllegalArguementException if value is not in [1-6].
	 */

	public void setValue(int value) throws IllegalArgumentException
	{
		if (value >= 0 && value <= 6)
			this.value = value;
		else
			throw new IllegalArgumentException(value + " is not in the range [1-6]");
	}

	/**
	 * Sets the status to active so that the die can be rolled.
	 */

	public void activate()
	{
		active = true;
	}

	/**
	 * Sets the status to inactive, preventing the die from being rolled.
	 */

	public void deactivate()
	{
		active = false;
	}

	/**
	 * Determines the status of this die.
	 * 
	 * @returns True if the die is active or false if it is inactive
	 */

	public boolean isActive()
	{
		return active;
	}

	/**
	 * Paints a graphical representation of this die based on its current value.
	 */

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(color);
		
		g.drawRoundRect(0, 0, 47, 47, 5, 5);

		switch (value)
		{
		case 1:
			g.fillOval(21, 21, 6, 6);
			break;
		case 4:
			g.fillOval(13, 29, 6, 6);
			g.fillOval(29, 13, 6, 6);	//fall through
		case 2:
			g.fillOval(13, 13, 6, 6);
			g.fillOval(29, 29, 6, 6);
			break;
		case 5:
			g.fillOval(9, 33, 6, 6);
			g.fillOval(33, 9, 6, 6);
		case 3:
			g.fillOval(9, 9, 6, 6);
			g.fillOval(21, 21, 6, 6);
			g.fillOval(33, 33, 6, 6);
			break;
		case 6:
			g.fillOval(13, 9, 6, 6);
			g.fillOval(13, 21, 6, 6);
			g.fillOval(13, 33, 6, 6);
			
			g.fillOval(29, 9, 6, 6);
			g.fillOval(29, 21, 6, 6);
			g.fillOval(29, 33, 6, 6);
			break;

		
		default:
			System.out.println("Value is out of bounds: " + value);
			break;

		}
	}

	/**
	 * Test and validate the Die class.
	 */

	public static void main(String[] args)
	{
		final Die dice[] = new Die[6];
		JButton roll = new JButton("Roll");
		JFrame f = new JFrame();

		roll.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				for (Die d : dice)
				{
					d.roll();
				}
			}
		});

		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		dice[0] = new Die(Color.RED);
		dice[0].setValue(1);
		f.add(dice[0]);
		dice[1] = new Die(Color.WHITE);
		dice[1].setValue(2);
		f.add(dice[1]);
		dice[2] = new Die(Color.RED);
		dice[2].setValue(3);
		f.add(dice[2]);
		dice[3] = new Die(Color.WHITE);
		dice[3].setValue(4);
		f.add(dice[3]);
		dice[4] = new Die(Color.RED);
		dice[4].setValue(5);
		f.add(dice[4]);
		dice[5] = new Die(Color.WHITE);
		dice[5].setValue(6);
		f.add(dice[5]);

		dice[1].activate();
		dice[2].activate();
		dice[3].activate();

		f.add(roll);

		f.pack();
		f.setVisible(true);
	}
}
