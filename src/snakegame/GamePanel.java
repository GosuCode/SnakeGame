package snakegame;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

class GamePanel extends JPanel implements ActionListener {

	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 75; // Delay for timer
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int snakeLength = 6;
	int targetKilled;
	int targetX;
	int targetY;
	char direction = 'D'; // direction where snakes will go when game starts
	boolean running = false;
	Timer timer;
	Random random;

//	 Setting up UI and starting the game
	public GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());

		startGame();
	}

	public void startGame() {
		for (int i = 0; i < snakeLength; i++) {
	        x[i] = SCREEN_WIDTH / 2 - (i * UNIT_SIZE);
	        y[i] = SCREEN_HEIGHT / 2;
	    }
		
		newTarget();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {

		for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
			g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
		}

		g.setColor(Color.red);
		g.fillOval(targetX, targetY, UNIT_SIZE, UNIT_SIZE);

		// Snake
		for (int i = 0; i < snakeLength; i++) {
			if (i == 0) {
				g.setColor(Color.green);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			} else {
				g.setColor(new Color(45, 180, 0));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
		}

	}

	public void newTarget() {
		targetX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		targetY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
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
		if (running) {
			move();
			checkTarget();
			checkCollisions();
		}
		repaint();
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}

}
