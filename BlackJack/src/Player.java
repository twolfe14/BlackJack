import java.awt.Canvas;
import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand;
	private boolean isDealer;
	private Canvas cards;
	private boolean pass;
	private String name;
	
	public Player(String n)
	{
		name = n;
		hand = new ArrayList<Card>();
		isDealer = false;
		cards = new Canvas();
		pass = false;
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
	
	public Canvas getCards()
	{
		//redraw all the cards for every move
		return cards;
	}
		
	public String toString()
	{
		return name;
	}
}
