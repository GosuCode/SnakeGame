package snakegame;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class GamePanel extends JPanel implements ActionListener {
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
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
