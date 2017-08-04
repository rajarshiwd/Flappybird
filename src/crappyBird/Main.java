package crappyBird;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * This class is responsible for getting the game running
 *
 * @author CaptainScuttlebottom
*/ 
public class Main {

/** number of miliseconds until refreshing screen*/
private static final int refreshTime = 20;

/** Houses all the Components where all this takes place in*/
private final JFrame frame;
/** the menu used in each instance */
private final Menu menu; 
//private final PopupMenu menu; 
/** the game used in each instance */
 
/** animation timer for the game */
private final Timer animationTimer;
private KeyManager keymanager;
private  final Game game ;
private Canvas canvas ;
/**
 * Declares JFrame with sane defaults and place it in the middle of the
 * screen. Initializes Game and Menu 
 */
public Main() {
     menu = new Menu();
    game = new Game();
    frame = new JFrame();
    canvas = new Canvas();
    keymanager = new KeyManager();
  frame.setSize(Game.WIDTH, Game.HEIGHT);
  frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
   frame.add(menu);
 //  canvas.add(menu);
	//frame.setSize(Game.WIDTH, Game.HEIGHT);
	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setResizable(true);
	//frame.setLocationRelativeTo(null);
	//frame.setVisible(true);
frame.getColorModel();
	
	//canvas = new Canvas();
	//canvas.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
	//canvas.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
	//canvas.setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
	
	//frame.add(canvas);
  //  frame.pack();
   
	
	
   //canvas.setFocusable(false);
    
    
    
   
    menu.setVisible(true);

    animationTimer = new Timer(refreshTime, new ActionListener(){
        public void actionPerformed(ActionEvent event){
            game.repaint();
            game.move();
        };
    });

   frame.revalidate(); //makes sure the menu is displayed (Step 1.5)
  frame.repaint();
  canvas.revalidate();
  canvas.repaint();
    
}
/*public Canvas getcanvas()
{
return canvas;
}

/**
 * Runs the game
 * 
 * @throws InterruptedException
 */
public void runnit() throws InterruptedException{
  	 while (menu.startGame == false) { //waits until the mouse is clicked in the Menu
        Thread.sleep(10);
    }
    frame.remove(menu); //Removes menu when mouse is clicked(Step 2)
    frame.add(game); //adds the game in its place (Step 3)
    game.setVisible(true); //makes sure the game is displayed (Step 3.5)
    frame.addKeyListener(keymanager);
    
    frame.revalidate();
    animationTimer.start(); //begins animation timer, and the game begins
    }


public static void main (String [] args) throws InterruptedException{
    Main m = new Main();
    m.runnit(); // /r/running shoutout, also begins running the method below
}



}

