
import java.awt.*;
import javax.swing.*;


public class GameRunner extends JFrame{

	GameRunner(){
		setLayout(new FlowLayout());
		
		Card a = new Card(1, 'S');
		Card b = new Card(1, 'H');
		Card c = new Card(1, 'D');
		Card d = new Card(1, 'C');
	
		setContentPane(a.getImage());
	}
	
	public static void main(String[] args) {
		
		GameRunner go = new GameRunner();

		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		go.setVisible(true);
		go.pack();
		
		
	}

}
