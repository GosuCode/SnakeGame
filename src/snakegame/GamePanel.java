package snakegame;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
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

		if (running) {
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
			
		g.setColor(Color.red);
		g.setFont(new Font("Verdana", Font.BOLD, 20));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Score: " + targetKilled, (SCREEN_WIDTH - metrics.stringWidth("Score: " + targetKilled))/2, g.getFont().getSize());

		} else {
			gameOver(g);
		}

	}

	public void newTarget() {
		targetX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		targetY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
	}

	public void move() {

		// shifting snakes body by 1
		for (int i = snakeLength; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}

		// moving snake head
		switch (direction) {
		case 'W':
			y[0] = y[0] - UNIT_SIZE;
			break;

		case 'S':
			y[0] = y[0] + UNIT_SIZE;
			break;

		case 'D':
			x[0] = x[0] + UNIT_SIZE;
			break;

		case 'A':
			x[0] = x[0] - UNIT_SIZE;
			break;
		}
	}

	public void checkTarget() {
		if ((x[0] == targetX) && (y[0] == targetY)) {
			snakeLength++;
			targetKilled++;
			newTarget();
		}
	}

	public void checkCollisions() {

		// checks if head collides with body
		for (int i = snakeLength; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}

		// left border
		if (x[0] < 0) {
			running = false;
		}

		// right border
		if (x[0] > SCREEN_WIDTH) {
			running = false;
		}

		// top border
		if (y[0] < 0) {
			running = false;
		}

		// bottom border
		if (y[0] > SCREEN_HEIGHT) {
			running = false;
		}

		if (running == false) {
			timer.stop();
		}
	}

	public void gameOver(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
		
		g.setColor(Color.red);
		g.setFont(new Font("Verdana", Font.BOLD, 30));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Score: " + targetKilled, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + targetKilled))/2, g.getFont().getSize());
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
			switch (e.getKeyCode()) {

			case KeyEvent.VK_LEFT:
				if (direction != 'D') {
					direction = 'A';
				}
				break;

			case KeyEvent.VK_RIGHT:
				if (direction != 'A') {
					direction = 'D';
				}
				break;

			case KeyEvent.VK_UP:
				if (direction != 'S') {
					direction = 'W';
				}
				break;

			case KeyEvent.VK_DOWN:
				if (direction != 'W') {
					direction = 'S';
				}
				break;
			}
		}
	}

}
