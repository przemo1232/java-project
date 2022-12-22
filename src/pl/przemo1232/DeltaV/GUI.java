package src.pl.przemo1232.DeltaV;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GUI extends JFrame {
  BufferedImage ship;
  BufferedImage asteroid;
  GUI() throws Exception {
    File file = new File(System.getProperty("user.dir") + "/resources/ship.png");
    ship = ImageIO.read(file);
    File file2 = new File(System.getProperty("user.dir") + "/resources/asteroid1.png");
    asteroid = ImageIO.read(file2);
    this.setTitle("test");
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setSize(1024, 768);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    PaintPanel panel = new PaintPanel(this);
    this.add(panel, BorderLayout.CENTER);
    panel.repaint();
  }
}

class PaintPanel extends JPanel {
  GUI gui;
  PaintPanel(GUI gui) {
    this.gui = gui;
  }
  // @Override
  protected void paintComponent(Graphics g) {
    super.paintComponents(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(Color.black);
    g2.fillRect(0, 0, 1024, 768);
    g2.rotate(Math.toRadians(10), gui.ship.getWidth(null) / 2, gui.ship.getHeight(null) / 2);
    g2.drawImage(gui.ship, 0, 0, null);
    g2.rotate(Math.toRadians(-10), gui.ship.getWidth(null) / 2, gui.ship.getHeight(null) / 2);
    g2.drawImage(gui.asteroid, 200, 200, null);
  }
}