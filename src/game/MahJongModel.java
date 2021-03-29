package game;

import java.util.Random;

/**
 * 
 * @author Travis Viall
 * @version 1.0
 */
public class MahJongModel
{
	private MahJongBoard board;
	private Tile[][][] tiles = new Tile[5][8][15];
	private TileDeck deck;
	private long gameNumber;
	private int score;

	/**
	 * MahJongModel constructor
	 * @param board The MahJongBoard object
	 */
	public MahJongModel(MahJongBoard board)
	{
		this.board = board;
		Random rand = new Random();
		gameNumber = (long) (0 + rand.nextDouble() * (1000000L - 0 + 1));
		createTiles(gameNumber);
	}

	/**
	 * Gets the dimensions of the Tile in the 3D array
	 * @param layer The layer of the Tile in the 3D array
	 * @param row The row of the Tile in the 3D array
	 * @param col The column of the Tile in the 3D array
	 * @return
	 */
	public Tile getTile(int layer, int row, int col)
	{
		Tile t;
		t = tiles[layer][row][col];

		return t;
	}

	/**
	 * Gets the game number of the current game being played
	 * @return The game number of the current game
	 */
	public long getGameNumber()
	{
		return gameNumber;
	}

	/**
	 * Sets the game number of the current game being played
	 * @param gameNumber The game number of the current game
	 */
	public void setGameNumber(long gameNumber)
	{
		this.gameNumber = gameNumber;
	}

	/**
	 * Shuffles the {@link game.TileDeck.Class} using the {@link game.TileDeck.Class#shuffle(long)} method
	 * and then adds the tiles to the 3D array. {@link game.TileDeck.Class#deal()} method removes each
	 * tile from the deck until the deck is empty.
	 * @param gameNumber The game number of the current or requested game
	 */
	public void createTiles(long gameNumber)
	{

		deck = new TileDeck();
		deck.shuffle(gameNumber);
		Tile t;

		// layer
		for (int i = 0; i < 5; i++)
		{
			// row
			for (int j = 0; j < 8; j++)
			{
				// column
				for (int k = 0; k < 15; k++)
				{

					// bottom layer
					if (i == 0)
					{

						// row 1
						if (j == 0 && k > 0 && k < 13)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}

						// row 2
						if (j == 1 && k > 2 && k < 11)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}

						// row 3
						if (j == 2 && k > 1 && k < 12)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}

						// row 4
						if (j == 3 && k > 0 && k < 15)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}

						// row 5
						if (j == 4 && k >= 0 && k < 13)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}

						// row 6
						if (j == 5 && k > 1 && k < 12)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}

						// row 7
						if (j == 6 && k > 2 && k < 11)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}

						// row 8
						if (j == 7 && k > 0 && k < 13)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}
					}
					// for 1st layer (1)
					if (i == 1)
					{
						if (j > 0 && j < 7 && k > 3 && k < 10)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}
					}

					// for 2nd layer (2)
					if (i == 2)
					{
						if (j > 1 && j < 6 && k > 4 && k < 9)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}
					}

					// for 3rd layer (3)
					if (i == 3)
					{
						if (j > 2 && j < 5 && k > 5 && k < 8)
						{
							t = deck.deal();
							positionTile(t, i, j, k);

						}
					}
					// for top tile
					if (i == 4)
					{
						if (j == 3 && k == 6)
						{
							t = deck.deal();
							positionTile(t, i, (j), (k));
						}
					}

				}
			}
		}
	}
	
	/**
	 * Adds the tiles from the 3D array to the {@link game.MahJongBoard.Class}.
	 * @see #getTile(int, int, int).
	 */
	public void addTiles()
	{
		Tile t;
		
		for (int i = 4; i >= 0; i--)
		{
			// row
			for (int j = 7; j >= 0; j--)
			{
				// column
				for (int k = 0; k < 15; k++)
				{
					if (getTile(i, j, k) != null)
					{
						t = getTile(i, j, k);
						t.addMouseListener(board);
						board.add(t);
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param t The Tile to be checked if it is open
	 * @return boolean
	 * @throws IndexOutOfBoundsException
	 */
	public boolean isTileOpen(Tile t) throws IndexOutOfBoundsException
	{

		try
		{
			if (t.getTileLayer() == 0 && t.getTileRow() == 4 && t.getTileColumn() == 0)
				return true;

			else if (t.getTileLayer() == 0 && t.getTileRow() == 3 && t.getTileColumn() == 14)
				return true;

			// top tile is always open
			else if (t.getTileLayer() == 4)
			{
				return true;
			}

			// if the top tiles is gone, open next layer
			else if (t.getTileLayer() == 3 && tiles[4][3][6].isShowing() == false)
			{
				return true;
			}

			else if (t.getTileLayer() < 3)
			{
				// if the tile to the right or left is null or not visible
				if (tiles[t.getTileLayer()][t.getTileRow()][t.getTileColumn() + 1] == null
						|| tiles[t.getTileLayer()][t.getTileRow()][t.getTileColumn() - 1] == null
						|| tiles[t.getTileLayer()][t.getTileRow()][t.getTileColumn() + 1].isShowing() == false
						|| tiles[t.getTileLayer()][t.getTileRow()][t.getTileColumn() - 1].isShowing() == false)
				{
					return true;
				}
			}

		} catch (IndexOutOfBoundsException e)
		{

		}

		return false;
	}
	
	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	/**
	 * Positions the tile on the {@link game.MahJongBoard.Class} board
	 * @param t The Tile to be positioned
	 * @param layer The layer of the Tile
	 * @param row The row of the Tile
	 * @param column The column of the tile
	 */
	void positionTile(Tile t, int layer, int row, int column)
	{
		int x = (column * t.getWIDTH()) + (layer * t.getEDGE());
		int y = (row * t.getHEIGHT()) + (-layer * t.getEDGE());

		t.setTileRow(row);
		t.setTileColumn(column);
		t.setTileLayer(layer);

		if (layer == 4 && row == 3 && column == 6)
		{
			x += 40;
			y += 40;
		}

		if (layer == 0 & row == 4 && column == 0)
		{
			y -= 40;
		}

		if (layer == 0 && row == 3 && column == 13)
		{
			y += 40;
		}

		if (layer == 0 && row == 3 && column == 14)
		{
			y += 40;
		}

		tiles[layer][row][column] = t;
		t.setLocation(x, y);

	}

}
