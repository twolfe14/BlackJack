
import java.awt.*;
import javax.swing.*;


public class GameRunner extends JFrame{

	GameRunner(){
		setLayout(new FlowLayout());
		
		//Instantiate Deck
		Deck deck = new Deck();
		
		//Create Array of Players
		Player[] players = new Player[2];
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		players[0] = player;
		players[1] = dealer;
		dealer.setDealer(true);
		
		//Deal in each play 2 cards from the deck
		for(Player p : players){
			p.hit(deck.deal());
			p.hit(deck.deal());
		}
		
		//Run the Game as long as both players have not passed
		while( !(player.hasPassed() && dealer.hasPassed()) )
		{
			//Sum up the card values in each player's hand
			for(Player p : players) {
				int sumVals = 0;
				for(Card c : p.getHand())
					sumVals += c.getValue();
				
				//Determine whether to hit or not (will not hit if sum of values is 17 or higher)
				if(sumVals < 17) {
					Card temp = deck.deal();
					System.out.println(p + " drew a " + temp);
					p.hit(temp);
				}				
				else 
					p.pass();		
			}
		}
		
		//Print out each player's hand
		for(Player p : players){
			System.out.println(p + "'s hand: " + p.getHand());
		}
		
	}
	
	public static void main(String[] args) {
		
		GameRunner go = new GameRunner();

		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go.setVisible(false);
		go.pack();
		
		
	}

}
