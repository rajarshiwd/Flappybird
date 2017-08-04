package crappyBird;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener   {
	
	
	public boolean[] keys ;
	public boolean up;
	
	
	public KeyManager()
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
	 up = keys[KeyEvent.VK_W];
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()]= true ;
		System.out.println("pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()]= false ;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
 
}

