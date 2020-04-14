import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand;
	private boolean isDealer;
	
	public Player()
	{
		hand = new ArrayList<Card>();
		isDealer = false;
	}
	
	public void hit(Card c)
	{
		hand.add(c);
	}
	
	public boolean isDealer()
	{
		return isDealer;
	}
	
	public void setDealer(boolean d)
	{
		isDealer = d;
	}
}
