package crappyBird;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;



import javax.swing.JPanel;

import crappyBird.gfx.ImageLoader;






@SuppressWarnings("serial")
public class Game extends JPanel{
	
	static int HEIGHT = 800;						//height of the window
	static int WIDTH = 600;							//width of the window
	BirdMan birdy = new BirdMan();					//makes a new bird 
	Wall wall = new Wall(WIDTH);					//makes the first wall you see
	Wall wall2 = new Wall(WIDTH + (WIDTH / 2));		//makes the second wall you see
	static int score = 0;							//the score (how many walls you've passed)
	int scrollX = 0;								//scrolls the background
	static boolean dead = false;					//used to reset the walls
	static String deathMessage = "" ; 	
	private BufferedImage pic ;// "you died, try again";
	static BufferedImage deathimage  ;
	
	
	
	
	private void init() // includes all the graphics in it 
	 {
		
		 pic = ImageLoader.LoadImage("/text/new.PNG");
		 
		 
		 
	 }
	
		 
		
	
	public Game(){
		
		init();
		

		
		
		
		

		
		
		
		//this mouseAdapter just listens for clicks, whereupon it then tells the bird to jump 
		this.addMouseListener(new MouseAdapter(){

			public void mousePressed(MouseEvent arg0) {
				birdy.jump();
			}
		
		});	
		
	}

	


	@SuppressWarnings("static-access")
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(pic,0, 0, null);
		
		
		g.drawImage(pic, scrollX, 0, null);					//there are two backgrounds so you get that seamless transition, this is the first			
		g.drawImage(pic, scrollX + 1334, 0, null);			//number 2, exactly one background length away (1800 pixels)
		
		wall.paint(g);			//paints the first wall
		wall2.paint(g);			//the second wall
 		birdy.paint(g);			//the wee little birdy
 	
 		g.setFont(new Font("comicsans", Font.BOLD, 40));
 		g.drawString("" + score, WIDTH / 2 - 20, 700);
 		//paints "" if the player has not just died, paints "you died, try again" if the user just died
	    
	}
	
	@SuppressWarnings("static-access")
	public void move(){

		wall.move();			//moves the first wall
		wall2.move();			//moves the second wall
		birdy.move();			//moves the wee little birdy
	
		scrollX += Wall.speed;	//scrolls the wee little background
		
		if (scrollX == -1334)	//this loops the background around after it's done
			scrollX = 0;
		
		if (dead){				//this block essentially pushes the walls back 600 pixels on birdy death
			wall.x = 600;
			wall2.x = 600 + (WIDTH / 2);
			dead = false;
		}
		
		if ( (wall.x == BirdMan.X) || (wall2.x == BirdMan.X) ) 	//Increments the score when the player passes a wall
			score();
	}
	
	public static void score(){
		score+= 1;

	}
	
}
