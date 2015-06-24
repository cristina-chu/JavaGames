import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * this class creates a GamePanel
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class GamePanel extends JPanel{
  
  //instantiates all the variables in GamePanel
  private ControlPanel control;
  private Path path;
  private ArrayList<Tower> towers;
  private JFrame frame;
  private ArrayList<Monster> monsters, monsters2;
  private javax.swing.Timer timer;
  private Random rand = new Random();
  private int notKilled, monsterCount;
  private boolean applies;
  private Monster current;
  
  /**
   * Constructor. It creates the panel where the game will actually take place
   * 
   * @param: ControlPanel control 
   * @param: JFrame frame
   * @param: Path path 
   * */
  public GamePanel(ControlPanel control, JFrame frame, Path path){
    this.control = control;
    this.frame = frame;
    this.path = path;
    
    setBackground(Color.cyan);
    setPreferredSize(new Dimension(1000,600));
    
    towers = new ArrayList<Tower>();

    //sets up the MouseListener that will create towers once pressed
    addMouseListener(new TowerCreator());
    
    //sets up the timer
    timer = new javax.swing.Timer(100, new TimerListener());
    timer.start();
    timer.setRepeats(true);
  }
  
  /**
   * this method draws everything in the Graphics object g
   * 
   * @param: Graphics g - where things will be drawn
   * */
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    
    path.draw(g);
    
    try{
      for (Tower t: towers)
        t.draw(g);
      
      for (Monster m: monsters)
        m.draw(g); }
    catch (Exception x){}
  }
  
  /**
   * this method awards bonus money to the player if no monster reached the end of the path
   * 
   * @param: int notKilled - the amount of monsters that passed the path
   * */
  private void bonus(int notKilled){
    if (notKilled == 0){
      control.changeMoney(100);
      JOptionPane.showMessageDialog(frame, "All enemies killed! +Bonus Money!");
    }
  }
  
  /**
   * this method removes monsters from the ArrayList that have either died or crossed the end
   * */
  private void removeMonster(){
    for (Monster m: monsters){
      if (m.getHealth() <= 0){
        control.changeMoney(m.getMoneyPts());
        control.changeScore(m.getScorePts());
        monsters.remove(m);}
      if (m.getPosition() == path.getEnd()){
        for (Tower t: towers){
          t.takeHealth();}
        monsters.remove(m);
        control.changeScore(-m.getScorePts());
        JOptionPane.showMessageDialog(frame, "An enemy has escaped! Your towers have taken damage.");
        notKilled++;}
    } 
  }
  
  /**
   * this method removes towers when they have been weakened enough
   * */
  private void removeTower(){
    for (Tower t: towers){
      if (t.getHealth() <= 0){
        control.changeScore(-200);
        towers.remove(t);
        JOptionPane.showMessageDialog(frame, "Tower down!");
      }
    }
  }
  
  /**
   * this method returns a boolean if whether the player has lost or not
   * 
   * @return: boolean true if player has lost, false if not
   * */
  private boolean lose(){
    if (control.getScore() < 0)
      return true;
    else
      return false;
  }

  /**
   * this method resets everything to default position/state
   * */
  private void resetGame(){
    control.reset();
    monsters.clear();
    towers.clear();
    notKilled = 0;
  }
  
  /**
   * this private class assigns the actions to be taken if the mouse is used
   **/
  private class TowerCreator extends MouseAdapter{
    /**
     * this method assigsn the actions to be taken when the mouse is pressed
     * 
     * @param: MouseEvent m
     * */
    public void mousePressed(MouseEvent m){
      Point p = new Point(m.getX(), m.getY());
      switch(control.getOptionTower()){
        
        //a basic tower is created if the option is basic (0)
        case 0: BasicTower b = new BasicTower(p);
        if (control.getMoney() < -b.getCost())
          JOptionPane.showMessageDialog(frame, "Not enough money.");
        else {
          towers.add(b);
          control.changeMoney(b.getCost());
          repaint();
        }
        break;
        
        //a fast tower is created if the option is fast (1)
        case 1: FastTower f = new FastTower(p);
        if (control.getMoney() < -f.getCost())
          JOptionPane.showMessageDialog(frame, "Not enough money.");
        else {
          towers.add(f);
          control.changeMoney(f.getCost());
          repaint();
        }
        break;
        
        //a strong tower is created if the option is strong (2)
        case 2:StrongTower s = new StrongTower(p);
        if (control.getMoney() < -s.getCost())
          JOptionPane.showMessageDialog(frame, "Not enough money.");
        else {
          towers.add(s);
          control.changeMoney(s.getCost());
          repaint();
        }
        break;
        
        //if not choice has been made - a message is shown
        case 3: JOptionPane.showMessageDialog(frame, "No choice made. Please select a tower to build.");
        break;
      }
    }
  } 
  
  /**
   * this private class creates the actions for the timer of the game
   * */
  private class TimerListener implements ActionListener{
    /**
     * this method gives the actions to be followed everytime the time is fired
     * 
     * @param: ActionEvent e
     * */
    public void actionPerformed(ActionEvent e){
      if (control.getCheck()){
        monsters = new ArrayList<Monster>();
        monsters2 = control.getMonsters();
        monsters.add(monsters2.get(0));
        
        monsterCount = 1;
        notKilled = 0;
        applies = true;
        control.setCheck(false);
      }
      
      try {
      //to randomnly place monsters on screen
        if (rand.nextBoolean()==true && monsterCount<monsters2.size()){
          monsters.add(monsters2.get(monsterCount));
          monsterCount++;
        }
      
      //move monsters depending on their speed
        for (Monster m: monsters)
          m.setPosition(path.nextPosition(m.getPosition(), m.getSpeed()));
      
        
      //bonus points if no monster crosses the end
        if (monsters.size() == 0 && applies==true){
          if (lose()==false)
            bonus(notKilled);
          applies = false;
        }
      
        //each tower attacks the monsters in range
        for (Tower t: towers){
          for (Monster m: monsters){
            if (t.inRange(m.getPosition())){
              t.attack(m);
            }
          }
        }
        
        //check if whether the player has lost
        if(lose()){
          int n = JOptionPane.showConfirmDialog(null, "You lost :(  Play again?", "New game", JOptionPane.YES_NO_OPTION);
          if(n==JOptionPane.NO_OPTION)
            System.exit(0);
          else
            resetGame();}
        
        removeMonster(); 
        removeTower();
      }
      
      catch (Exception x){}
      
      repaint();  
    }
  }
}