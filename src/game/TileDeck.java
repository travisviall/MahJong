package game;

import java.util.*;

public class TileDeck
{
	private ArrayList<Tile> deck = new ArrayList<>(144);

	public static void main(String... args)
	{
		Random random = new Random();
		
		long gameNumber = (long)(0 + random.nextDouble()*(100000L-0+1));
		long gameNumber2 = (long)(0 + random.nextDouble()*(1000000L-0+1));
		long gameNumber3 = (long)(0 + random.nextDouble()*(1000000L-0+1));
		
		System.out.println(gameNumber);
		System.out.println(gameNumber2);
		System.out.println(gameNumber3);
		
		
		
	}

	public TileDeck()
	{
		for (int i = 0; i < 4; i++)
		{
			// CharacterTiles
			for (char c = '1'; c <= '9'; c++)
				deck.add(new CharacterTile(c));
			deck.add(new CharacterTile('N'));
			deck.add(new CharacterTile('E'));
			deck.add(new CharacterTile('W'));
			deck.add(new CharacterTile('S'));
			deck.add(new CharacterTile('C'));
			deck.add(new CharacterTile('F'));

			// CircleTiles
			for (int j = 1; j < 10; j++)
				deck.add(new CircleTile(j));

			// BambooTiles
			for (int j = 2; j < 10; j++)
				deck.add(new BambooTile(j));

			// Special Tiles
			deck.add(new WhiteDragonTile());
			deck.add(new Bamboo1Tile());
		}

		// FlowerTiles
		deck.add(new FlowerTile("Chrysanthemum"));
		deck.add(new FlowerTile("Orchid"));
		deck.add(new FlowerTile("Plum"));
		deck.add(new FlowerTile("Bamboo"));

		// SeasonTiles
		deck.add(new SeasonTile("Spring"));
		deck.add(new SeasonTile("Summer"));
		deck.add(new SeasonTile("Fall"));
		deck.add(new SeasonTile("Winter"));
	}

	public void shuffle()
	{
		Collections.shuffle(deck);
	}

	public void shuffle(long gameNumber)
	{
		Random rand = new Random(gameNumber);
		Collections.shuffle(deck, rand);
	}

	public Tile deal()
	{
		Tile tile = deck.remove(deck.size() -1);

		return tile;

	}

}
