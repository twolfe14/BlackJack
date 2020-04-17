import java.awt.Canvas;
import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand;
	private boolean isDealer;
	private Canvas cards;
	
	public Player()
	{
		hand = new ArrayList<Card>();
		isDealer = false;
		cards = new Canvas();
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
	
	public Canvas getCards()
	{
		//redraw all the cards for every move
		return cards;
	}
}
