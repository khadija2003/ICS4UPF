
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dificulte {

	public Dificulte() {
		
		final JFrame cadre = new JFrame("Menu");	
		BoxLayout boxLayout = new BoxLayout(cadre.getContentPane(), BoxLayout.Y_AXIS); 
		
		Button facile = new Button("facile");
		facile.setFont(new Font("Verdana", Font.BOLD, 32));
		
		Button moyen = new Button("moyen");
		moyen.setFont(new Font("Verdana", Font.BOLD, 32));
		
		Button dur = new Button("dur");
		dur.setFont(new Font("Verdana", Font.BOLD, 32));
		
		cadre.add(facile); 
		cadre.add(moyen);
		cadre.add(dur);

		cadre.setLayout(boxLayout);
		cadre.setSize(500,500);
		cadre.setLocationRelativeTo(null);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadre.setResizable(false);
		cadre.setVisible(true);		
		
		facile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				//cadre.dispose();
				new Cadre(10);
			}
		});
		
		moyen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				//cadre.dispose();
				new Cadre(15);
				
			}
		});
	
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
