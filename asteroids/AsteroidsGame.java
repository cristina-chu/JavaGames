import javax.swing.JFrame;


public class AsteroidsGame {
 public static void main(String[] args) {
  JFrame frame = new JFrame("Asteroids!");
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  frame.add(new GamePanel());
  
  frame.pack();
  frame.setVisible(true);
 }

}
