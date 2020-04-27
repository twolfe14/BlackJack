
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class GameRunner{

	
	public static void main(String[] args) {
		
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
		
		for(int i = players.length-1 ; i >= 0 ; i--)
		{
			if(players[i].sumCards() == 21) {
				System.out.println(players[i] + " was dealt a BlackJack!");
				
				for(Player p: players)
					p.pass();
			}
		}
		
		//Run the Game as long as both players have not passed
		while( !(player.hasPassed() && dealer.hasPassed()) && !dealer.hasBlackJacked())
		{
			//Act for each player in the game
			for(Player p : players) {
				
			while(!p.hasPassed()) {
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
							//Player will pass if the sum is 19 or higher
							if(p.sumCards() >= 18)
							{
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
							p.getHand().get(0).setValue(1);
							System.out.println(p + " drew a " + temp2);
							p.hit(temp2);
						}
					}
				}

					if(p.sumCards() < 17) {
						Card temp = deck.deal();
						System.out.println(p + " drew a " + temp);
						p.hit(temp);
						
						//Player will bust if their cards' sum is over 21, unless they have an Ace
						if(p.sumCards() > 21) {
							for(Card c : p.getHand())
								if(c.getValue() == 11)
									c.setValue(1);	
							if(p.sumCards() > 21)
								p.bust();
						}
					}				
					else 
					p.pass();		
				
			}
		  }
		}
		
		//Print out each player's hand
		System.out.println();
		for(Player p : players){
			System.out.print(p + "'s hand: " + p.getHand() +" "+ p.sumCards());
			if(p.hasBusted())
				System.out.print(" (BUST)");
			System.out.println();
		}
		
		System.out.println();
		
		if(player.hasBusted())
			System.out.print("Dealer WINS!");
		else if(player.sumCards() == dealer.sumCards())
			System.out.print("PUSH!");
		else if(!dealer.hasBusted() && !player.hasBusted() && 21 - player.sumCards() < 21 - dealer.sumCards())
			System.out.print("Player WINS!");
		else if(!dealer.hasBusted() && !player.hasBusted() && 21 - player.sumCards() > 21 - dealer.sumCards())
			System.out.print("Dealer WINS!");
		else if(dealer.hasBusted())
			System.out.print("Player WINS!");
		else
			System.out.print("This shouldn't happen");
		
		if(player.hasBlackJacked() || dealer.hasBlackJacked())
			System.out.print(" Blackjack!");
	
	}
}
