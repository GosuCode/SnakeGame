package snakegame;

import javax.swing.JPanel;
import java.awt.event.ActionListener;

class GamePanel extends JPanel implements ActionListener {

  @Override
  public void actionPerformed(java.awt.event.ActionEvent e) {
    System.out.println("Action Performed");
  }

}
