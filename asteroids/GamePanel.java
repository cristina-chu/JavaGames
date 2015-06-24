import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Makes the game of asteroids happen! It has the ship, asteroids, bullets, and scoring stuff.
 * Everything is drawn onto the panel
 * 
 * NOTE: You should NOT change anything in this class - if you want to play around with things that 
 * is fine, but keep in mind that your final code should function when used with this GamePanel
 * 
 * @author Elizabeth, Andrey
 *
 */
public class GamePanel extends JPanel{
	private final int WIDTH = 500;
	private final int HEIGHT = 500;
	private final int NUM_AST = 5; //number of asteroids initially
	private ArrayList<Asteroid> asteroids; //keeps track of all the asteroids in the game
	private ArrayList<Bullet> bullets; //keeps track of all the bullets fired from the ship
	private Rectangle field = new Rectangle(new Dimension(WIDTH,HEIGHT)); //rectangle that keeps track of the playing field
	private javax.swing.Timer timer; //timer to let us move everything around
	private Ship ship; //the ship/player!
	
	/**
	 * Makes a new game panel
	 */
	public GamePanel(){
		ship = new Ship (field, new Point(250,250));
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		//makes the panel take keyboard input
		setFocusable(true);
		addKeyListener(new ShipController());
		
		//sets up the timer
		timer = new javax.swing.Timer(50, new TimerListener());
		timer.start();
		timer.setRepeats(true);
		
		asteroids = new ArrayList<Asteroid>();
		bullets = new ArrayList<Bullet>();
		
		//populate our asteroid list
		for(int i = 0; i< NUM_AST; i++)
			asteroids.add(new Asteroid(field));
	}
	
	/**
	 * Draws everything on screen
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//draws all the asteroids
		for(Asteroid a: asteroids)
			a.draw(g);
		
		//draws all the bullets
		for(Bullet b: bullets)
			b.draw(g);
		
		//draws the ship
		ship.draw(g);
		
		//draws the score
		g.drawString("Score: " + ship.getKills()*20, 10, 20);
		
		
		int x = 14;
		int y = 34;
		
		//makes and draws the "life" indicators
		for(int i = 0; i<ship.getLives(); i++){
			Polygon p = new Polygon(new int[]{x, x-7, x+7},new int[]{y-8,y+4,y+4}, 3);
			g.drawPolygon(p);
			x+=16;
		}
		
	}
	
	/**
	 * Check for casualties of warfare, clean up if necessary. Private, since only the game should be able to do this and not
	 * some cheating player.
	 */
	private void checkCollisions(){
		//"killed-in-action" arraylist for asteroids that have been destroyed
		ArrayList<Asteroid> KIA = new ArrayList<Asteroid>();
		
		// figures out if any bullets hit any asteroids
		for(Bullet b: bullets){
			for(Asteroid a: asteroids){
				if(b.hit(a)){
					KIA.add(a);
				}
			}
		}
		
		//goes through the killed in action list and splits those asteroids
		for(Asteroid casualty: KIA){
			ship.kill();
			asteroids.remove(casualty);
			asteroids.addAll(casualty.split());
		}
		
		//check to see if the ship crashed into an asteroid
		for(Asteroid a: asteroids){
			if(ship.crash(a)){
				ship.loseLife();
				break;
			}
		}
		
		//check to see if the player has lost
		if(ship.getLives() <=0){
			int n = JOptionPane.showConfirmDialog(this, "You lost :[  Play again?", "New game", JOptionPane.YES_NO_OPTION);
			if(n==JOptionPane.NO_OPTION)
				System.exit(0);
			else{
				reset();
			}
		}
	}
	
	/**
	 * Check to see if the player has won (if they have destroyed all the asteroids)
	 * 
	 * @return true if they won
	 */
	private boolean win(){
		return asteroids.size()==0;
	}
	
	/**
	 * Resets the game to its initial state
	 */
	public void reset(){
		asteroids.clear();
		bullets.clear();
		
		ship = new Ship(field, new Point(250,250));
		
		for(int i = 0; i< NUM_AST; i++)
			asteroids.add(new Asteroid(field));
		
		repaint();
	}
	
	/**
	 * Removes bullets that have left the play field
	 */
	private void removeBullets(){
		int bulletCount = bullets.size();
		int count = 0;
		while(count <bulletCount){
			if(bullets.get(count).isOffScreen()){
				bullets.remove(count);
				bulletCount--;
			}
			count++;
		}
	}
	
	/**
	 * Listener for the timer - every time the timer goes off, the game elements (bullets and asteroids)
	 * move, and collisions/win/lose conditions are checked for
	 * 
	 * @author Elizabeth
	 *
	 */
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//move the asteroids
			for(Asteroid a: asteroids)
				a.move();
			
			//move the bullets
			for(Bullet b: bullets)
				b.move();
			
			checkCollisions();
			removeBullets();
			ship.move();
			
			//check for win
			if(win()){
				int n = JOptionPane.showConfirmDialog(null, "You win! :]  Play again?", "New game", JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.NO_OPTION)
					System.exit(0);
				else
					reset();
			}
			
			//make the panel show the updates
			repaint();
		}
	}
	
	/**
	 * Allows the user to control the ship with the arrow keys
	 * 
	 * @author Elizabeth
	 *
	 */
	private class ShipController extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			switch(e.getKeyCode()){
				case KeyEvent.VK_DOWN: //down is move backwards
					ship.changeSpeed(-2.5);
					break;
				case KeyEvent.VK_UP: //up is move forwards
					ship.changeSpeed(2.5);
					break;
				case KeyEvent.VK_LEFT: //left rotates the ship to the left
					ship.rotate(false);
					break;
				case KeyEvent.VK_RIGHT: // right rotates it to the right
					ship.rotate(true);
					break;
				case KeyEvent.VK_SPACE: //space bar shoots bullets
					bullets.add(ship.shoot());
					break;
			}
			
			//update!
			repaint();
		}
	}
}
