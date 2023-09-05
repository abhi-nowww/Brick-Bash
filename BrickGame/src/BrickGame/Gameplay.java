//This Class is Created in Order to run this panel in J Frame Panel in which game will run
package BrickGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener ,ActionListener {
	//Adding the properties
	private boolean play = false; // Set To False As The Game Should Not Start Automatically
	private int score = 0; // Storing the Game Score in Realtime
	
	private int totalbrick = 21; // Total Number of Bricks in Game
	
	private Timer timer ;
	private int delay = 8;  //Delay in ball after hitting the brick
	
	private int playerposX = 310; // initial position of the bar
	private int ballposX = 110; //initial position of the ball in X Axis 
	private int ballposY = 350; //initial position of the ball in Y Axis 
	//adding the ball direction
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private MapGenerator map ; 
	
	public Gameplay() {
		map = new MapGenerator(3,7); 
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();
	}
	public void paint(Graphics g ) {
		//background
		g.setColor(Color.black);
		g.fillRect(1,1,692,592);
		
		//Drawing the Bricks
		map.draw(( Graphics2D)g); 
		
		//Add Score
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString(""+score , 590 , 30);
		 
		
		
		
		//borders
		g.setColor(Color.yellow);
		g.fillRect(0,0,3,592);
		g.fillRect(0,0,692,3);
		g.fillRect(691,0,3,592);
		
		// the paddle
		g.setColor(Color.green);
		g.fillRect(playerposX , 550 , 100 , 8);
		
		// the ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		if(totalbrick<= 0 ) {
			play = false;
			ballXdir = 0;
			ballYdir = 0 ;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("YOU WON" , 260 , 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter To Restart " , 230 , 350);	
			
		}
		
		if(ballposY > 570){
			play = false;
			ballXdir = 0;
			ballYdir = 0 ;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 25));
			g.drawString("Game Over , score : " , 190 , 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter To Restart " , 230 , 350);			
		}
		g.dispose();		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			//Detecting the intersection of ball with paddle
			if(new Rectangle(ballposX , ballposY , 20 ,20).intersects(new Rectangle(playerposX ,550 , 100 , 8 ))) {
				ballYdir = - ballYdir;  
			}
			// iterating through each brick
		A: 	for(int i = 0 ; i<map.map.length ; i++) {
				for(int j = 0 ; j<map.map[0].length ; j++) {
					if(map.map[i][j] >0) {
						int brickX = j*map.brickWidth +80;
						int brickY = i*map.brickHeight + 50;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle (brickX , brickY , brickWidth , brickHeight);
						Rectangle ballRect = new Rectangle(ballposX ,ballposY , 20,20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							map.setBrickValue(0, i, j);
							totalbrick --;
							score +=5;
					    if(ballposX + 19 <=brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width ) {
					    	ballXdir = -ballXdir;
					    }else {
					    	ballYdir = -ballYdir;
					    }
						break A;
					}
					
				}
			}
		}
						
			ballposX +=ballXdir;
			ballposY += ballYdir;
			//Left Border
			if(ballposX <0) {
				ballXdir = -ballXdir;
			}
			// For The Top Border
			if(ballposY <0) {
				ballYdir = -ballYdir;
			}
			// For The Right Border
			if(ballposX >670) {
				ballXdir = -ballXdir;
			}
		}
		repaint();  // this function will recall the paint and draw each and everything again.
		// this is done so that when values are updated the can be reflected
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			if(playerposX>=600) {
				playerposX = 600;
			}else {
				moveRight();
			}
		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			if(playerposX<=10) {
				playerposX = 10;
			}else {
				moveLeft();
			}	
		}	
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play= true;
				ballposX = 120;
				ballposY = 350;
				ballXdir= -1;
				ballYdir = -2;
				playerposX = 310;
				score = 0 ;
				totalbrick = 21;
				map = new  MapGenerator(3,7);
				repaint();
				}
		}
		
	}
	public void moveRight() {
		play =true;
		playerposX = playerposX+20;
	}
	public void moveLeft() {
		play =true;
		playerposX = playerposX-20;
	}
	@Override
	public void keyReleased(KeyEvent e) {
	
	}
	
	
}
