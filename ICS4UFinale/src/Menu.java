
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu {
	JFrame cadre = new JFrame("Labyrinthe");
	public Menu() {

		BoxLayout disposition = new BoxLayout(cadre.getContentPane(), BoxLayout.Y_AXIS); 
		
		Button jouer = new Button("Jouer");
		jouer.setFont(new Font("Verdana", Font.BOLD, 32));
		
		Button instruction = new Button("Instructions");
		instruction.setFont(new Font("Verdana", Font.BOLD, 32));
		
		cadre.add(jouer); 
		cadre.add(instruction);

		cadre.setLayout(disposition);
		cadre.setSize(500,500);
		cadre.setLocationRelativeTo(null);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadre.setResizable(false);
		cadre.setVisible(true);		
		
		jouer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				cadre.dispose();
				new Dificulte();
			}
		});
		
		instruction.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				JFrame cadre = new JFrame("Instructions");
				cadre.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
				JLabel textLabel = new JLabel("" +"<html>" +
						"1. Player starts as the blue character.<br> " +
						"2. Player must reach the red endpoint to win.<br> " +
						"3. Get coins while making your way through the maze. <br>" +
						"4. Achieve a higher score.<br>" +
						"" +
						"5. Move the character by using the 'W-A-S-D' keyboard or <br>" +
						"by using the standard arrow keys to move.<br>" +
						"" +
						"6. Mouse clicks can also be used on the on-screen <br>directional buttons as well. </html>");
				cadre.getContentPane().add(textLabel, BorderLayout.CENTER);
				
				cadre.setLocationRelativeTo(null);
				cadre.pack();
				cadre.setVisible(true);
			}
		});
	}

}
