//////////////////////
//ICS4U PROJET FINALE
//KHADIJA AISSIOUI
/////////////////////
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dificulte {

	public Dificulte() {
		//ce code definie les difficultes a chaque niveau et te donne l'option de choisir un a partir du menu
		final JFrame cadre = new JFrame("Menu");	
		BoxLayout boxLayout = new BoxLayout(cadre.getContentPane(), BoxLayout.Y_AXIS); 
		//le boutton pour l'option facile
		Button facile = new Button("facile");
		facile.setFont(new Font("Verdana", Font.BOLD, 32));
		//le boutton pour l'option moyen
		Button moyen = new Button("moyen");
		moyen.setFont(new Font("Verdana", Font.BOLD, 32));
		//le boutton pour l'option dur
		Button dur = new Button("dur");
		dur.setFont(new Font("Verdana", Font.BOLD, 32));
		//nommee chaque boutton 
		cadre.add(facile); 
		cadre.add(moyen);
		cadre.add(dur);
		//layout des bouttons
		cadre.setLayout(boxLayout);
		cadre.setSize(500,500);
		cadre.setLocationRelativeTo(null);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadre.setResizable(false);
		cadre.setVisible(true);		
		//les characteristique du niveau facile
		facile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				//cadre.dispose();
				new Cadre(10);
			}
		});
		//les characteristique du niveau moyen
		moyen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				//cadre.dispose();
				new Cadre(15);
				
			}
		});
		//les characteristique du niveau dur
		dur.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				//cadre.dispose();
				new Cadre(20);
			}
		});		
	}
}
