package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Stack;

/**
 * @author Travis Viall
 * @version 1.0
 * JPanel holding the {@link game.Tile.Class} objects.
 */
public class MahJongBoard extends JPanel implements MouseListener
{

	private Tile first = null;
	private Tile second = null;
	private MahJong game;
	private MahJongModel model;
	ImageIcon image;
	private URL url;
	private Stack<Tile> removedStack = new Stack<Tile>();
	private long gameNumber;
	private PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
	private int score;
	private Fireworks reward = new Fireworks();
	private boolean sound = true;
	private Tile t;

	/**
	 * Constructor that creates the Mah Jong board
	 * @param game The JFrame the board will be placed on.
	 */
	public MahJongBoard(MahJong game)
	{
		this.game = game;
		model = new MahJongModel(this);
		gameNumber = model.getGameNumber();
		score = model.getScore();
		game.setRemovedStack(removedStack);

		setLayout(null);
		setBorder(BorderFactory.createRaisedBevelBorder());
		url = MahJongBoard.class.getResource("images/dragon_bg.png");
		image = new ImageIcon(url);
		model.addTiles();
	}

	/**
	 * Overloaded constructor that creates a board based on a specific game number.
	 * @param game The M
	 * @param gameNumber
	 */
	public MahJongBoard(MahJong game, long gameNumber)
	{
		this.game = game;
		this.gameNumber = gameNumber;
		model = new MahJongModel(this);
		model.createTiles(gameNumber);
		game.setRemovedStack(removedStack);
		setLayout(null);
		setBorder(BorderFactory.createRaisedBevelBorder());
		url = MahJongBoard.class.getResource("images/dragon_bg.png");
		image = new ImageIcon(url);

		model.addTiles();		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setBackground(Color.YELLOW);
		g.drawImage(image.getImage(), 400, 122, this);
	}

	/**
	 * Gets the current game number
	 * @return The current game number
	 */
	public long getGameNumber()
	{
		return gameNumber;
	}

	/**
	 * Sets the current game number
	 * @param gameNumber The current game number
	 */
	public void setGameNumber(long gameNumber)
	{
		this.gameNumber = gameNumber;
	}

	/**
	 * Gets the PlayClip file
	 * @return The PlayClip file
	 */
	public PlayClip getClip()
	{
		return clip;
	}

	/**
	 * Sets the PlayClip file
	 * @param clip The PlayClip File
	 */
	public void setClip(PlayClip clip)
	{
		this.clip = clip;
	}

	public Fireworks getReward()
	{
		return reward;
	}

	public void setReward(Fireworks reward)
	{
		this.reward = reward;
	}

	
	public boolean isSound()
	{
		return sound;
	}

	public void setSound(boolean sound)
	{
		this.sound = sound;
	}

	private void startReward() 
	{
		if (score > 143)
		{

			game.remove(this);
			game.add(reward.getPanel());
			game.setVisible(true);
			reward.setSound(sound);
			reward.fire();
			
		}
	}
	
	private void stopReward()
	{
		if(reward == null)
			return;
		
		reward.stop();
		reward = null;
	}
	
	public Stack<Tile> getRemovedStack()
	{
		return removedStack;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	
	@Override
	/** Checks the clicked tile using the {@link game.MahJongModel#isTileOpen(Tile t} method
	 * if it is open.  If it is open, then it compares the two objects and removes them if they match.
	 * @param The mouse pressed event
	 */
	public void mousePressed(MouseEvent e) throws NullPointerException
	{
		Tile temp  = (Tile) e.getSource();

		if (model.isTileOpen(temp))
		{
			if (first == null)
			{
				first = temp;
				first.selected(true);
				repaint();
				return;
			}

			second = temp;

			if (first.matches(second))
			{
				try
				{
					clip.play(); // plays sound
				} catch (NullPointerException npe)
				{

				}
				
				first.setShowing(false);
				second.setShowing(false);
				first.selected(false);				//takes off the highlight
			
				score++; 							//increments the score for reward

				second.setzOrder();
				remove(second); 
				removedStack.push(second);
				
				first.setzOrder();
				remove(first); 						//removes the tile from the board
				removedStack.push(first);
				
				revalidate();
				repaint();
				
				first = null;
				second = null;
				startReward();
			}

			else
			{
				first.selected(false);
				repaint();
				revalidate();
				first = null;
				second = null;

			}
		} 
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}
