
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Cadre {

		static JFrame cadre = new JFrame("Labyrinthe");
		JPanel p_1 = new JPanel(new BorderLayout());
		JPanel p_2 = new JPanel(new BorderLayout());
		
		public Cadre(int niveau){		
			
			Labyrinthe test = new Labyrinthe(niveau,niveau,niveau-5);
			Joueur Joueur = new Joueur(test);
			
			p_1.add(test, BorderLayout.CENTER);
			p_1.setFocusable(true);
			cadre.add(p_1, BorderLayout.CENTER);				
			cadre.add(p_2, BorderLayout.SOUTH);	
			
			
			JButton sud = new JButton("Sud");
			sud.setFocusable(false);
			p_2.add(sud, BorderLayout.SOUTH);			
			sud.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{	
					Joueur.moveDown(test);
				}
			});
			
			JButton nord = new JButton("Nord");
			nord.setFocusable(false);
			p_2.add(nord, BorderLayout.NORTH);
			nord.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{	
					Joueur.moveUp(test);
				}
			});
			
			JButton est = new JButton("Est");
			est.setFocusable(false);
			p_2.add(est, BorderLayout.EAST);
			est.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{	
					Joueur.moveRight(test);
				}
			});		
			
			
			JButton ouest = new JButton("Ouest");
			ouest.setFocusable(false);
			p_2.add(ouest, BorderLayout.WEST);
			ouest.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{	
					Joueur.moveLeft(test);
				}
			});	
			
			JButton menu = new JButton("New Game");
			menu.setFocusable(false);
			p_2.add(menu, BorderLayout.CENTER);
			menu.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{	
					cadre.dispose();
					new Menu();
				}
			});	
					
			p_1.addKeyListener(new KeyAdapter()
			{
				public void keyPressed(KeyEvent e){				
					int keyCode = e.getKeyCode();
					if(e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT) Joueur.moveLeft(test);
					if(e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT) Joueur.moveRight(test);
					if(e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP) Joueur.moveUp(test);
					if(e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN) Joueur.moveDown(test);
				}
			});	
			
			cadre.setSize(500, 500);
			cadre.setLocationRelativeTo(null);
			cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cadre.setResizable(false);
			cadre.setBackground(Color.green);
			cadre.setVisible(true);
		}

		public Cadre(int niveau, int argent){
	        
	        cadre.dispose();        
	        JFrame cadre1 = new JFrame();
	        
	        JLabel labelTexte = new JLabel("<html>Congratulations!<br>You got " + argent + " coin(s)!</html>", JLabel.CENTER);
	        labelTexte.setFont(new Font("Verdana", Font.BOLD, 32));
	        
	        cadre1.setBackground(Color.green);
	        cadre1.add(labelTexte, BorderLayout.CENTER);
	        cadre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        cadre1.setSize(500,500);
	        cadre1.setLocationRelativeTo(null);
	        cadre1.setVisible(true);
	    }

}
