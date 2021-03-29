package game;

public class RankTile extends Tile
{
	protected int rank;
	
	public RankTile(int rank)
	{
		this.rank = rank;
	}
	
	public boolean matches(Object other)
	{
		RankTile tile = (RankTile) other;

		if(super.matches(other) && this.rank == tile.rank)
			return true;
		
		return false;
	}
}
