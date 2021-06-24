
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
						"1. Le joueur commence et s'identifie avec le point bleu.<br> " +
						"2. Le joueur doit atteindre le point rouge pour gagner.<br> " +
						"3. Amasse des jettons lorsque tu parcours le labyrinthe. <br>" +
						"4. Atteint un score elevee.<br>" +
						"" +
						"5. Bouge le point bleu en utillisant 'W-A-S-D' sur votre clavier ou <br>" +
						"en utillisant les touches directionelles standard.<br>" +
						"" +
						"6. Les clics de souris peuvent egalement etre utiliser sur l'ecran <br>les bouttons directionels aussi. </html>");
				cadre.getContentPane().add(textLabel, BorderLayout.CENTER);
				
				cadre.setLocationRelativeTo(null);
				cadre.pack();
				cadre.setVisible(true);
			}
		});
	}

}
