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
	
	public class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			if(e.getKeyChar() == 'a') 	moveLeft(labyrinthe);
			if(e.getKeyChar() == 'w') 	moveUp(labyrinthe);
			if(e.getKeyChar() == 'd')	moveRight(labyrinthe);
			if(e.getKeyChar() == 's')	moveDown(labyrinthe);
		
		}
	}
	public void moveLeft(Labyrinthe labyrinthe){
		if((labyrinthe.obtenir(xPos-1, yPos) != '#') && (labyrinthe.obtenir(xPos-1, yPos) != '=')){
			labyrinthe.definir(xPos, yPos, 'O');
			if(labyrinthe.obtenir(xPos-=1, yPos) == '8')	Win();
			else if(labyrinthe.obtenir(xPos, yPos) == '+') argent++;
			else 	labyrinthe.definir(xPos, yPos, 'X');
		}
	}

	public void moveRight(Labyrinthe labyrinthe){
		if((labyrinthe.obtenir(xPos+1, yPos) != '#') && (labyrinthe.obtenir(xPos+1, yPos) != '=')){
			labyrinthe.definir(xPos, yPos, 'O');
			if(labyrinthe.obtenir(xPos+=1, yPos) == '8')	Win();
			else if(labyrinthe.obtenir(xPos, yPos) == '+') argent++;
			else	labyrinthe.definir(xPos, yPos, 'X');
		}
	}
	public void moveUp(Labyrinthe labyrinthe){
		if((labyrinthe.obtenir(xPos, yPos-1) != '#') && (labyrinthe.obtenir(xPos, yPos-1) != '=')){
			labyrinthe.definir(xPos, yPos, 'O');
			if(labyrinthe.obtenir(xPos, yPos-=1) == '8')	Win();
			else if(labyrinthe.obtenir(xPos, yPos) == '+') argent++;
			else	labyrinthe.definir(xPos, yPos, 'X');
		}
	}

	public void moveDown(Labyrinthe labyrinthe){
		if((labyrinthe.obtenir(xPos, yPos+1) != '#') && (labyrinthe.obtenir(xPos, yPos+1) != '=')){
			labyrinthe.definir(xPos, yPos, 'O');
			if(labyrinthe.obtenir(xPos, yPos+=1) == '8') Win();
			else if(labyrinthe.obtenir(xPos, yPos) == '+') argent++;
			else	labyrinthe.definir(xPos, yPos, 'X');
		}
	}

	public void Win(){
        new Cadre(20, argent);        
	}	

}
