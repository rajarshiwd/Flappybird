package crappyBird;

import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import crappyBird.gfx.ImageLoader;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/*
 * This screen just waits for a mouseclick, whereupon it is removed from the JFrame and replaced with the game
 * I'd like not have to wait for the picture to download though, so I need to figure out how to package the images
 * within the Jar file. 
 */

public class Menu extends JPanel{
	private static final long serialVersionUID = 1L;
	int highscore;
	private BufferedImage pom ;
	private boolean pause = false;
	boolean startGame = false;	
	
	
	
	
	private void init() // includes all the graphics in it 
	 {
		
		 pom = ImageLoader.LoadImage("/text/menu.PNG");
		 
		 
		 
	 }
	
	
	public Menu(){
		init();
		setFocusable(true);							//waits for a mouseclick, then toggles startGame
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				startGame = true;
			}

			});
	}

	
	public void paint (Graphics g){
		super.paint(g);
	
		g.drawImage(pom, 0, 0, null);		//paints background
	
		
	}
}
	

