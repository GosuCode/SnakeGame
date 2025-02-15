package snakegame;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;

class GamePanel extends JPanel implements ActionListener {
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT)/ UNIT_SIZE;
	static final int DELAY = 75; // Delay for timer
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int snakeLength = 6;
	int targetKilled;
	int targetX;
	int targetY;
	char direction = 'R'; // direction where snakes will go when game starts
	boolean running = false;
	Timer timer;
	Random random;
	
	public GamePanel() {
	}
	
	public void startGame() {
		
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void move() {
		
	}
	
	public void checkTarget() {
		
	}
	
	public void checkCollisions() {
		
	}
	
	public void gameOver(Graphics g) {
		
	}

  @Override
  public void actionPerformed(java.awt.event.ActionEvent e) {
    System.out.println("Action Performed");
  }
  
  public class MyKeyAdapter extends KeyAdapter{
	  @Override
	  public void keyPressed(KeyEvent e) {
		  
	  }
  }

}
