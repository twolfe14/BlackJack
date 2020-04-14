import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> deck;
	
	public Deck()
	{
		deck = new ArrayList<Card>();
		
		for(int suit = 1 ; suit < 4 ; suit++)
			for(int value = 1; value < 14; value++)
				deck.add(new Card(suit, value));
	}
	
	public Card deal()
	{
		return deck.remove( (int)(Math.random() * deck.size()));
	}
}
