import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {
	private char suit;
	private int value;
	private JLabel image;
	
	public Card(int v, int s)
	{
		if(s == 1)
			suit = 'H';
		else if(s == 2)
			suit = 'D';
		else if(suit == 3)
			suit = 'C';
			else 
			suit = 'S';
			
		
		value = v;
		if(value == 1) {
			image = new JLabel(new ImageIcon(getClass().getResource("A" + suit +".png")));
		}
		else if(value == 11) {
			image = new JLabel(new ImageIcon(getClass().getResource("J" + suit +".png")));
			value = 10;
		}
		else if(value == 12) {
			image = new JLabel(new ImageIcon(getClass().getResource("Q" + suit +".png")));
			value = 10;
		}
		else if(value == 13) {
			image = new JLabel(new ImageIcon(getClass().getResource("K" + suit +".png")));
			value = 10;
		}
		else
			image = new JLabel(new ImageIcon(getClass().getResource(""+ value + suit +".png")));
	}
	
	public int getValue()
	{
		return value;
	}
	
	public JLabel getImage()
	{
		return image;
	}
	
	public String toString()
	{
		String output = "";
			
		if(value == 1)
			output += "Ace ";
		else if(value == 11)
			output += "Jack ";
		else if(value == 12)
			output += "Queen ";
		else if(value == 13)
			output += "King ";
		else
			output += value + " ";
		
		if(suit == 'H')
			output += "of Hearts";
		else if(suit == 'D')
			output += "of Diamonds";
		else if(suit == 'C')
			output += "of Clubs";
		else
			output += "of Spades";
			
		
		return output;
	}
}
