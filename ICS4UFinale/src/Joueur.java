///////////////////////
//ICS4U PROJET FINALE
//KHADIJA AISSIOUI
//////////////////////
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Joueur extends JPanel implements ActionListener{
	
	public int argent=0,xPos=0,yPos=0;
	
	Labyrinthe labyrinthe;

	public Joueur(Labyrinthe labyrinthe){
		this.labyrinthe = labyrinthe;
		xPos = 1;
		yPos = 1;
	}	

	public void actionPerformed(ActionEvent e){
		repaint();
	}
	//Les commandes pour faire bouger le joueur 
	public class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			if(e.getKeyChar() == 'a') 	moveLeft(labyrinthe);
			if(e.getKeyChar() == 'w') 	moveUp(labyrinthe);
			if(e.getKeyChar() == 'd')	moveRight(labyrinthe);
			if(e.getKeyChar() == 's')	moveDown(labyrinthe);
		
		}
	}
	//code qui definit ce qui arrive quand tu bouge a la gauche
	public void moveLeft(Labyrinthe labyrinthe){
		if((labyrinthe.obtenir(xPos-1, yPos) != '#') && (labyrinthe.obtenir(xPos-1, yPos) != '=')){
			labyrinthe.definir(xPos, yPos, 'O');
			if(labyrinthe.obtenir(xPos-=1, yPos) == '8')	Win();
			else if(labyrinthe.obtenir(xPos, yPos) == '+') argent++;
			else 	labyrinthe.definir(xPos, yPos, 'X');
		}
	}
	//code qui determine ce qui arrive quand tu bouge a la droite
	public void moveRight(Labyrinthe labyrinthe){
		if((labyrinthe.obtenir(xPos+1, yPos) != '#') && (labyrinthe.obtenir(xPos+1, yPos) != '=')){
			labyrinthe.definir(xPos, yPos, 'O');
			if(labyrinthe.obtenir(xPos+=1, yPos) == '8')	Win();
			else if(labyrinthe.obtenir(xPos, yPos) == '+') argent++;
			else	labyrinthe.definir(xPos, yPos, 'X');
		}
	}
	//code qui determine ce qui arrive quand tu bouge au haut
	public void moveUp(Labyrinthe labyrinthe){
		if((labyrinthe.obtenir(xPos, yPos-1) != '#') && (labyrinthe.obtenir(xPos, yPos-1) != '=')){
			labyrinthe.definir(xPos, yPos, 'O');
			if(labyrinthe.obtenir(xPos, yPos-=1) == '8')	Win();
			else if(labyrinthe.obtenir(xPos, yPos) == '+') argent++;
			else	labyrinthe.definir(xPos, yPos, 'X');
		}
	}
	//code qui determine ce qui arrive quand tu bouge en bas
	public void moveDown(Labyrinthe labyrinthe){
		if((labyrinthe.obtenir(xPos, yPos+1) != '#') && (labyrinthe.obtenir(xPos, yPos+1) != '=')){
			labyrinthe.definir(xPos, yPos, 'O');
			if(labyrinthe.obtenir(xPos, yPos+=1) == '8') Win();
			else if(labyrinthe.obtenir(xPos, yPos) == '+') argent++;
			else	labyrinthe.definir(xPos, yPos, 'X');
		}
	}
	//ce qui arrive quand tu gagne
	public void Win(){
        new Cadre(20, argent);        
	}	

}
