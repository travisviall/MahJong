package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.*;

/**
 * 
 * @author Travis Viall
 * @version 1.0
 * Class that creates the MahJong game; extending JFrame.
 */
public class MahJong extends JFrame
{
	private MahJongBoard board;
	JMenuBar menuBar;
	JMenu game, move, help;
	private PlayClip clip;
	private Fireworks reward;
	private Help operationHelp = new Help("help.html", "Mah Jong Operation");
	private Help rulesHelp = new Help("rules.html", "Mah Jong Rules");
	private boolean sound;
	private Stack<Tile> removedStack = new Stack<Tile>();

	public MahJong()
	{
		board = new MahJongBoard(this);
		clip = board.getClip();
		reward = board.getReward();
		sound = board.isSound();
		removedStack = board.getRemovedStack();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				exit();
			}
		});
		JPanel header = new JPanel();
		header.setSize(this.getWidth(), 100);
		add(header, BorderLayout.NORTH);	
		setTitle("Game Number: " + String.valueOf(board.getGameNumber()));
		add(board, BorderLayout.CENTER);
		setSize(1200, 740);
		this.setLocationRelativeTo(null);
		createMenu();
		setVisible(true);

	}

	/**
	 * Creates the JMenuBar
	 */
	private void createMenu()
	{
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		game = new JMenu("Game");
		game.setMnemonic('G');
		menuBar.add(game);

		JMenuItem play = new JMenuItem("Play", 'P');
		play.setToolTipText("If already playing, start a new game");
		play.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
		game.add(play);
		play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				play();
			}
		});

		// restart - restart the current game
		JMenuItem restart = new JMenuItem("Restart", 'R');
		restart.setToolTipText("Restart the current game");
		restart.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
		game.add(restart);
		restart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				restart();
			}
		});

		// numbered - play a numbered(repeatable game)
		JMenuItem numbered = new JMenuItem("Numbered", 'N');
		numbered.setToolTipText("Play a numbered game");
		numbered.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		game.add(numbered);
		numbered.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				numbered();
			}
		});
		
		// numbered - play a numbered(repeatable game)
		JMenuItem removedTiles = new JMenuItem("Removed Tiles", 'M');
		removedTiles.setToolTipText("View Removed Tiles");
		removedTiles.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
		game.add(removedTiles);
		removedTiles.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
								
//				ScrollRemoved removed = new ScrollRemoved();
//				
//				JFrame frame = new JFrame();
//				frame.add(removed);
//				frame.setSize(800, 400);
//				frame.setVisible(true);
//				
//				for(Tile t: removedTilesArray)
//				{
//					removed.addToUndo(t);
//					t.resetZOrder();
//				}
				
			}
		});

		game.addSeparator();

		// exit the game
		JMenuItem exit = new JMenuItem("Exit", 'E');
		exit.setToolTipText("Exit the game");
		exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
		game.add(exit);

		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				exit();
			}

		});

		// sound menu
		ButtonGroup soundGroup = new ButtonGroup();
		JMenu soundMenu = new JMenu("Sound");
		soundMenu.setMnemonic('S');
		menuBar.add(soundMenu);

		// sound sub-menus

		// on
		JRadioButtonMenuItem on = new JRadioButtonMenuItem("On", true);
		soundGroup.add(on);
		soundMenu.add(on);
		on.setToolTipText("Turn sound on");
		on.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		on.setMnemonic('O');
		on.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				board.setClip(clip);
				reward.setSound(sound);

			}
		});

		// off
		JRadioButtonMenuItem off = new JRadioButtonMenuItem("Off");
		soundGroup.add(off);
		soundMenu.add(off);
		off.setToolTipText("Turn sound off");
		off.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
		off.setMnemonic('F');
		off.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) throws NullPointerException
			{

				board.setClip(null);
				reward.setSound(sound);
				// board.setReward(null);

			}
		});

		// move menu
		move = new JMenu("Move");
		menuBar.add(move);

		// move sub-menus

		// undo
		JMenuItem undo = new JMenuItem("Undo", 'U');
		move.add(undo);
		undo.setToolTipText("Undo previous move");
		undo.setAccelerator(KeyStroke.getKeyStroke("ctrl U"));
		undo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				undo();
			}
		});

		// help menu
		help = new JMenu("Help");
		menuBar.add(help);

		// help sub-menus

		// operation
		JMenuItem operation = new JMenuItem("Operation", 'I');
		help.add(operation);
		operation.setToolTipText("Help");
		operation.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));
		operation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				operationHelp.display();
			}
		});

		// rules
		JMenuItem rules = new JMenuItem("Game Rules", 'L');
		help.add(rules);
		rules.setToolTipText("Rules of the game");
		rules.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
		rules.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				rulesHelp.display();
			}
		});

	}
	/**
	 * Exits the program asking for confirmation from the user
	 */
	private void exit()
	{
		if (JOptionPane.showConfirmDialog(this, "Do you want to end this program?", "End Program",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			System.exit(0);
	}

	/**
	 * Starts a new game after confirmation from the user
	 */
	private void play()
	{
		if (JOptionPane.showConfirmDialog(this, "Are you sure you want to start a new game?", "Start New Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		{
			remove(board);
			board = new MahJongBoard(this);
			setTitle("Game Number: " + String.valueOf(board.getGameNumber()));
			add(board, BorderLayout.CENTER);
			repaint();
			setVisible(true);
		}

	}

	/**
	 * Restarts the currently running game using the removedStack stack and the {@link #undo()} method
	 */
	private void restart()
	{
		if (JOptionPane.showConfirmDialog(this, "Are you sure you want to restart current game?", "Start New Game",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		{

			while (!removedStack.isEmpty())
				undo();
		}

	}

	/**
	 * Starts a numbered game using the overloaded {@link game.MahJongBoard#MahJongBoard(MahJong, long)} method
	 * that takes a long value to generate the same shuffle using the {@link game.TileDeck#shuffle(long)} method.
	 */
	private void numbered()
	{
		String gameNumber = JOptionPane.showInputDialog("Enter Game Number: ");

		if (gameNumber != null)
		{
			long value = Long.valueOf(gameNumber);
			remove(board);
			board = new MahJongBoard(this, value);
			setTitle("Game Number: " + gameNumber);
			add(board, BorderLayout.CENTER);
			setVisible(true);

		}

	}

	/**
	 * Undoes the previous move.  The {@link game.Tile#setShowing(boolean)} method is used to determine if the
	 * tile is open or not. @see {@link game.MahJongModel#isTileOpen(Tile)}
	 */
	private void undo()
	{

		try
		{

			Tile removed1 = removedStack.pop();
			removed1.setShowing(true);
			board.add(removed1, removed1.getzOrder());

			Tile removed2 = removedStack.pop();
			removed2.setShowing(true);
			board.add(removed2, removed2.getzOrder());

			board.repaint();
			board.revalidate();
			
		} catch (EmptyStackException ese)
		{

		}
	}

	/**
	 * Gets the stack of removed tiles
	 * @return The stack of removed tiles
	 */
	public Stack<Tile> getRemovedStack()
	{
		return removedStack;
	}

	/**
	 * Sets the stack of removed tiles
	 * @param removedStack The stack of removed Tiles
	 */
	public void setRemovedStack(Stack<Tile> removedStack)
	{
		this.removedStack = removedStack;
	}

	public static void main(String[] args)
	{
		new MahJong();
	}
}
