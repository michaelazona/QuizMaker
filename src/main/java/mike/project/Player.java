package mike.project;

public class Player
{
	private String name;
	private int    score = 0;

	public Player(String name)
	{
		this.name = name;
	}

	public void increaseScore()
	{
		this.score++;
	}

	public int getScore()
	{
		return this.score;
	}
}