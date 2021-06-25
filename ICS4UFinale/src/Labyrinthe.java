//////////////////////
//ICS4U PROJET FINALE
//KHADIJA AISSIOUI
/////////////////////
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//ce code determine l'allure du labyrinthe (tailles, couleurs, parcours)
public class Labyrinthe extends JPanel {
	private char[][] labyrinthe;
	private int taille;
	private int nonvisiter;
	private int echelle=1; 
	LinkedList<Position> listePosition = new LinkedList<Position>();

	public Labyrinthe (int x, int y, int obj){
		nonvisiter = (x*x);
		x *= 2; y *= 2; x++; y++;
		echelle = y;
		
		labyrinthe = new char [x][y];
		taille = x;
		
		genererLabyrinthe();
		ajouterObjet(obj);
	}	

	public void genererLabyrinthe(){
		for (int i=0; i < taille; i++){
			for (int k=0; k < taille; k++){
				labyrinthe[i][k] = 'u';
			}
		}
		
		for (int i=0; i < taille; i+=2){
			for (int k=0; k < taille; k++){
				labyrinthe[i][k] = '=';
				labyrinthe[k][i] = '=';
			}
		}
		for (int i=0; i < taille; i++){
			labyrinthe[i][0] = '#';
			labyrinthe[0][i] = '#';
			labyrinthe[taille-1][i] = '#';
			labyrinthe[i][taille-1] = '#';
		}
		generate(1,1);
	}
	//Les couleurs present dans le modele dy labyrinth
	public void paint(Graphics g){
		super.paint(g);
		int n = 500/(echelle+10);
		
		for(int i = 0; i < taille; i++){
			for( int k = 0; k < taille; k++){
				if((labyrinthe[i][k] == '#')){
					g.setColor(Color.black);
					g.fillRect(i*n, k*n, n, n);
				} else if(labyrinthe[i][k] == '='){
					g.setColor(Color.black);
					g.fillRect(i*n, k*n, n, n);
				} else if(labyrinthe[i][k] == '8'){
					g.setColor(Color.red);
					g.fillRect(i*n, k*n, n, n);
				} else if(labyrinthe[i][k] == 'X'){
					g.setColor(Color.blue);
					g.fillRect(i*n, k*n, n, n);
				} else if(labyrinthe[i][k] == '+'){
					g.setColor(Color.yellow);
					g.fillOval(i*n, k*n, n, n);
				}
			}
		}
	}	

	public char obtenir(int x, int y){
		return labyrinthe[x][y];
	}

	public void definir(int x, int y, char value){
		labyrinthe[x][y] = value;
		repaint();
	}

	public void printBoard(){
		for (int i=0; i < taille; i++){
			for (int k=0; k < taille; k++){
				System.out.print(labyrinthe[i][k]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	//donne une location random du point rouge
	public void ajouterObjet(int montant){
		Random location = new Random();
		
		for(int i=0; i<=montant; i++){
			int xPos=0, yPos=0;
			while((xPos==0) || (yPos==0)){
				int randX = location.nextInt(taille);
				int randY = location.nextInt(taille);
		
				if (((randX%2) != 0) && (randX != 0 || randX != taille))	xPos = randX;
				if (((randY%2) != 0) && (randY != 0 || randY != taille))	yPos = randY;
				
				if((obtenir(xPos,yPos) == 'X') || obtenir(xPos,yPos) == '8') {
					xPos = 0;yPos = 0;
				}
			}
			
			definir(xPos, yPos, '+');
		}
	}
		
	public class Position{
		int x,y;
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		public Position(){
			this.x = 0;
			this.y = 0;
		}
		public int obtenirX(){
			return x;
		}
		public int obtenirY(){
			return y;
		}
		public void definirX(int x){
			this.x = x;
		}
		public void definirY(int y){
			this.y = y;
		}
	}
	
	public char[] updateDirection(Position courant){
		char nord=0,sud=0,est=0,ouest=0;
		
		if (obtenir(courant.obtenirX(),courant.obtenirY()+1) != '#')
			est = obtenir(courant.obtenirX(), courant.obtenirY()+2);
		if (obtenir(courant.obtenirX(),courant.obtenirY()-1) != '#')
			ouest = obtenir(courant.obtenirX(), courant.obtenirY()-2);
		if (obtenir(courant.obtenirX()-1,courant.obtenirY()) != '#')
			nord = obtenir(courant.obtenirX()-2, courant.obtenirY());
		if (obtenir(courant.obtenirX()+1,courant.obtenirY()) != '#')
			sud = obtenir(courant.obtenirX()+2, courant.obtenirY());		
		char direction[] = {ouest,est,sud,nord};
		return direction;
	}

	
	Position listePos[] = new Position[(2*(getX()/2))];
	Position courant = new Position(5,5);
	
	public void generate(int posX, int posY){
		courant = new Position(posX,posY);
		definir(courant.obtenirX(),courant.obtenirY(), 'v');
		nonvisiter-=1;
		
		char nord=0,sud=0,est=0,ouest=0;
		char direction[] = {ouest,est,sud,nord};
		
		direction = updateDirection(courant);

		while(nonvisiter != 0){
			int libre = 0;
			if((direction[0] == 'u') || (direction[1] == 'u') || (direction[2] == 'u') || (direction[3] == 'u'))
				libre = 1;
			
			Random generateur = new Random();
			int random = generateur.nextInt(4);
			definir(courant.obtenirX(),courant.obtenirY(), 'v');
		
			if((random == 0) && (direction[0] == 'u')){ //ouest
				if (obtenir(courant.obtenirX(),courant.obtenirY()-1) != '#'){
					definir(courant.obtenirX(), courant.obtenirY()-1, 'v');
					courant = new Position(courant.obtenirX(), courant.obtenirY()-2);
					listePosition.push(courant);
					
					direction = updateDirection(courant);
					nonvisiter--;
					
				}
			}
			else if((random == 1) && (direction[1] == 'u')){ //est
				if (obtenir(courant.obtenirX(),courant.obtenirY()+1) != '#'){
					definir(courant.obtenirX(), courant.obtenirY()+1, 'v');
					courant = new Position(courant.obtenirX(), courant.obtenirY()+2);
					listePosition.push(courant);
					
					direction = updateDirection(courant);
					nonvisiter--;
				}
			}
			
			else if((random == 2) && (direction[2] == 'u')){ //sud
				if (obtenir(courant.obtenirX()+1,courant.obtenirY()) != '#'){
					definir(courant.obtenirX()+1, courant.obtenirY(), 'v');
					courant = new Position(courant.obtenirX()+2, courant.obtenirY());
					listePosition.push(courant);
					
					direction = updateDirection(courant);
					nonvisiter--;
					
				}
			}
			else if((random == 3) && (direction[3] == 'u')){ //nord
				if (obtenir(courant.obtenirX()-1,courant.obtenirY()) != '#'){
					definir(courant.obtenirX()-1, courant.obtenirY(), 'v');
					courant = new Position(courant.obtenirX()-2, courant.obtenirY());
					listePosition.push(courant);
					
					direction = updateDirection(courant);
					nonvisiter--;
					
				}
			} else {
				if(libre == 0 && listePosition.size() != 0){
					courant = listePosition.get(listePosition.size()-1);
					listePosition.remove(listePosition.size()-1);
					direction = updateDirection(courant);
					
					
				}
			}
		}
		definir(courant.obtenirX(),courant.obtenirY(),'8');
		definir(1,1,'X');
	}

}
