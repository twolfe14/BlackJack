import java.awt.*;
import java.util.ArrayList;

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
			//Act for each player in the game
			for(Player p : players) {
				
				//Determine whether to hit or not (will not hit if sum of card values is 17 or higher)
				
				//Special Ace Case
				if(p.howmanyAces() != 0)
				{
					//Access the hand of the player if they have an ace or more
					ArrayList<Card> tempHand = p.getHand();
				
					//A.K.A. if this is the first round
					if(tempHand.size() == 2)
					{
						//If the player has only one ace...
						if(p.howmanyAces() == 1)
						{
							int nonAceValue = 0;
							for(int i = 0; i < tempHand.size(); i++)
							{
								if(tempHand.get(i).getValue() != 1)
									nonAceValue = tempHand.get(i).getValue();
							}
							
							//Player will pass if the sum is 19 or higher
							if((nonAceValue + 11) >= 19 && (nonAceValue + 11) < 22)
							{
								//BlackJack case
								if((nonAceValue + 11) == 21 && nonAceValue == 11)
								{
									System.out.println("Player " + p + "has gotten a BlackJack!");
								}
								else
									p.pass();
							}
							//Player did not have a sum 19 or higher, thus they are hitting if the sum is less than 17
							else {
								Card temp3 = deck.deal();
								System.out.println(p + " drew a " + temp3);
								p.hit(temp3);
							}
						}
						
						//If the player has two aces, the player will hit
						if(p.howmanyAces() == 2)
						{
							Card temp2 = deck.deal();
							System.out.println(p + " drew a " + temp2);
							p.hit(temp2);
						}
					}
				}
				else {
					if(p.sumCards() < 17) {
						Card temp = deck.deal();
						System.out.println(p + " drew a " + temp);
						p.hit(temp);
						
						//Player will bust if their cards' sum is over 21
						if(p.sumCards() > 21)
							p.bust();
					}				
					else 
						p.pass();		
				}
			}
		}
		
		//Print out each player's hand
		for(Player p : players){
			System.out.print(p + "'s hand: " + p.getHand());
			if(p.hasBusted())
				System.out.print(" (BUST)");
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		GameRunner go = new GameRunner();

		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go.setVisible(false);
		go.pack();
		
		
	}

}
