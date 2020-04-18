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
		if(value == 1)
			image = new JLabel(new ImageIcon(getClass().getResource("A" + suit +".png")));
		else if(value == 11)
			image = new JLabel(new ImageIcon(getClass().getResource("J" + suit +".png")));
		else if(value == 12)
			image = new JLabel(new ImageIcon(getClass().getResource("Q" + suit +".png")));
		else if(value == 13)
			image = new JLabel(new ImageIcon(getClass().getResource("K" + suit +".png")));
		else
			image = new JLabel(new ImageIcon(getClass().getResource(""+ value + suit +".png")));
	}
	
	public JLabel getImage()
	{
		return image;
	}
}
