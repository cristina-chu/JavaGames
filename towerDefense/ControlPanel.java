import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * This class creates a ControlPanel that contains buttons for the different towers, send wave of monsters, 
 * and shows score, money and level
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class ControlPanel extends JPanel{
  
  //instantiates all the variables
  private JButton sendWave;
  private JRadioButton basic, fast, strong;
  private JLabel scoreLabel, moneyLabel, levelLabel;
  private ButtonGroup towers;
  private JPanel info, options;
  private Random rand = new Random();
  private Path path; 
  private ArrayList<Monster> monsters;
  private int score, money, level;
  private boolean check;
  
  /**
   * constructor. It creates the ControlPanel with all its labels (score, money, level), 
   * tower options and send Wave button
   * 
   * @param: Path path - path that monsters will follow in the game
   * */
  public ControlPanel(Path path){
    this.path = path;
    check = false;
    score = 0;
    money = 750;
    
    setPreferredSize(new Dimension(1000,50));
    
    moneyLabel = new JLabel("   Money: 250");
    scoreLabel = new JLabel("   Score: 0");
    levelLabel = new JLabel("Level: 0");
    
    basic = new JRadioButton("Basic Tower = $100");
    fast = new JRadioButton("Fast Tower = $350");
    strong = new JRadioButton("Strong Tower = $500");
    
    ButtonGroup towers = new ButtonGroup();
    towers.add(basic);
    towers.add(fast);
    towers.add(strong);
    
    JButton sendWave = new JButton("Send Wave");
    sendWave.addActionListener(new WaveListener());
    
    JPanel info = new JPanel();
    info.add(levelLabel);
    info.add(scoreLabel);
    info.add(moneyLabel);
    
    add(info);
    add(basic);
    add(fast);
    add(strong);
    add(sendWave);  
  } 
  
  /**
   * this method returns an int depending on the tower chosen by the player
   * 
   * @return: int - 0 if basic tower, 1 if fast tower and 2 if strong tower
   * */
  public int getOptionTower(){
    if (basic.isSelected())
      return 0;
    else if (fast.isSelected())
      return 1;
    else if (strong.isSelected())
      return 2;
    else 
      return 3;
  }
  
  /**
   * this method returns the amount of money the player currently has
   * 
   * @return: int money 
   * */
  public int getMoney(){
    return money;
  }
  
  /**
   * this method changes the amount of money the player has
   * 
   * @param: int change - money that is taken from or given to the pool of money of the player
   * */
  public void changeMoney(int change){
    money = money+change;
    moneyLabel.setText("Money: "+money);
  }
  
  /**
   * this method returns the arraylist of monsters
   * 
   * @return: ArrayList<Monster> monsters
   * */
  public ArrayList<Monster> getMonsters(){
    return monsters;
  }
  
  /**
   * this method returns boolean check
   * 
   * @return: boolean check - true to pass monsters to the game panel and start the game
   * */
  public boolean getCheck(){
    return check;
  }
  
  /**
   * this method sets the boolean check
   * 
   * @param: boolean c - to change boolean check
   * */
  public void setCheck(boolean c){
    check = c;
  }
  
  /**
   * this method returns the score of the player
   * 
   * @return: int score - score of player
   * */
  public int getScore(){
    return score;
  }
  
  /**
   * this method changes the score of the player
   * 
   * @param: int points - points awarded or taken away from the player's score. 
   * */
  public void changeScore(int points){
    score = score+points;
    scoreLabel.setText("Score: "+score);
  }
  
  /**
   * this method levels up the game once the player has defeated a monster wave. 
   * */
  public void levelUp(){
    level++;
    levelLabel.setText("Level: "+level);
  }
  
  /**
   * this method resets all variables to the starting position. 
   * */
  public void reset(){
    score = 0;
    money = 200;
    level = 0;
    
    scoreLabel.setText("Score: 0");
    moneyLabel.setText("Money: 200");
    levelLabel.setText("Level: 0");
    
    monsters.clear();
  }  
  
  /**
   * this private class gives the actions to the button sendWave
   * */
  private class WaveListener implements ActionListener{
    
    /**
     * this method gives instructions for when the button sendWave is pressed. 
     * 
     * @param: ActionEvent e
     * */
    public void actionPerformed(ActionEvent e){
      monsters = new ArrayList<Monster>();
      
      //if the level is less than 2, only trolls and basilisks will be in the monster's wave
      if (level < 2){
        for (int i=0; i<10; i++){
          int x = rand.nextInt(2);
          if (x == 0)
            monsters.add(new Troll(path.getStart()));
          else
            monsters.add(new Basilisk(path.getStart()));
        }
      }
      else {  //for higher levels, all the types of monsters will be in the wave
        for (int i=0; i<10; i++){
          int x = rand.nextInt(3);
          if (x == 0)
            monsters.add(new Troll(path.getStart()));
          else if (x == 1)
            monsters.add(new Basilisk(path.getStart()));
          else
            monsters.add(new Dragon(path.getStart()));
        }
      }
      levelUp(); 
      check = true; 
    }
  }
}