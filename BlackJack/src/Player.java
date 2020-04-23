import java.awt.Canvas;
import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand;
	private boolean isDealer;
	private Canvas cards;
	private boolean pass;
	private String name;
	private boolean bust;
	
	public Player(String n)
	{
		name = n;
		hand = new ArrayList<Card>();
		isDealer = false;
		cards = new Canvas();
		pass = false;
		bust = false;
	}
	
	public void hit(Card c)
	{
		hand.add(c);
	}
	
	public boolean hasPassed()
	{
		return pass;
	}
	
	public void pass()
	{
		pass = true;
	}
	
	public boolean isDealer()
	{
		return isDealer;
	}
	
	public void setDealer(boolean d)
	{
		isDealer = d;
	}
	
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	
	public int sumCards()
	{
		int sumVals = 0;
		for(Card c : hand)
			sumVals += c.getValue();
			
		return sumVals;
	}
	
	public int howmanyAces()
	{
		int count = 0;
		for(Card c : hand)
		{
			if(c.getValue() == 1)
				count++;
		}
	
		return count;
	}
	
	public Canvas getCards()
	{
		//redraw all the cards for every move
		return cards;
	}
	
	public void bust()
	{
		bust = true;
	}
	
	public boolean hasBusted()
	{
		return bust;
	}
	
	public String toString()
	{
		return name;
	}
}
