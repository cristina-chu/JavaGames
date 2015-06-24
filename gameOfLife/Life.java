/** 
 * CS 1331 Summer 2012 - HW 7
 * This class takes cares of the logical part  of the game (generation step-by-step check of cells)
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */

public class Life{
  
  //instantiates variables
  private Cell[][] cells, cells2;
  private int generation=0;
  private final int ROWS, COLUMNS;
  
  /**
   *Constructor method
   *Creates a Life object (the actual logical part of the game)
   * 
   * @param: int rows - number of rows wanted in grid
   * @param: int columns - number of columns wanted in grid
   */
  public Life(int rows, int columns){
    cells = new Cell[rows][columns]; //cell array 1
    cells2 = new Cell[rows][columns]; //cell arra 2
    generation = 0;
    ROWS = rows;
    COLUMNS = columns;
    
    //creates new cells to put in the arrays
    for (int i = 0; i < ROWS; i++){
      for (int j = 0; j < COLUMNS; j++){
        cells[i][j] = new Cell(false);
        cells2[i][j] = new Cell(false);
      }
    }
  }
 
  /**
   *This method gets a cell from array 1
   * 
   * @param: int row 
   * @param: int column
   */
  public Cell getCell1(int row, int column){
    return cells[row][column];
  }
  
   /**
   *This method gets a cell from array 2
   * 
   * @param: int row 
   * @param: int column
   */
  public Cell getCell2(int row, int column){
    return cells2[row][column];
  }
  
    /**
   *This method gets the number of rows in the game
   * 
   */
  public int getRows(){
    return ROWS;
  }
  
    /**
   *This method gets the number of columns in the game
   */
  public int getColumns(){
    return COLUMNS;
  }
  
    /**
   *This method increases the generation counting by 1
   */
  public void increaseG(){
    generation++;
  }
  
  /**
   * This method resets the generation count to 0 
   */
  public void clearG(){
    generation = 0;
  }
  
    /**
   *This method gets the generation count
   */
  public int getGeneration(){
    return generation;
  }
  
   /**
   *This method checks for the state of a cell in next generation and makes new generation in a new array
   * 
   * @param: int i - number of row of cell to check
   * @param: int j - number of column of cell to chek
   */
  public boolean update(int i, int j){
    boolean d = check(i,j,cells[i][j].getIsAlive());
    cells2[i][j].changeState(d);
    return d;
  } // ends update method
  
  
  /**
   *This method checks for the neighbors of a cell to see the state of the cell in next generation
   * 
   * @return boolean true if cell will be alive next generation, boolean false if dead next generation
   * @param: int row - number of row of cell
   * @param: int column - number of column of cell
   * @param: boolean state- state of the cell at the current generation 
   */
  private boolean check(int row, int column, boolean state){
    int neighbors = 0; //number of alive cells next to cell at hand
    
    //iterates through the cells in array 1 to see which ones will survive, die or be born
    for (int x=-1; x<2; x++){
      for (int y=-1; y<2; y++){ 
        if (cells[row+x][column+y].getIsAlive() == true)
          neighbors++;
      }
    }
    
    //takes away if counted the cell at hand in neighbors
    if (cells[row+0][column+0].getIsAlive() == true)
      neighbors--;
    
    //check whether cell at hand will be alive or dead for next generation according to rules of game
    if (neighbors == 2)
      return state;
    else if (neighbors == 3)
      return true;
    else if (neighbors <= 1)
      return false;
    else
      return false;
  } //ends check method
  
    /**
   *This method puts cell array 1 as cell array 2, in order to calculate the following generation
   */
  public void stepDone(){
    //iterates through array 1, and changes state according to state of same cell in array 2
    for (int i = 0; i < ROWS; i++){
      for (int j = 0; j < COLUMNS; j++){
        cells[i][j].changeState(cells2[i][j].getIsAlive());
      }
    }
  }
  
   /**
    * This method resets all cells in both arrays of cell to false (dead/inactive)
   */
  public void reset(){
    for (int i = 0; i < ROWS; i++){
      for (int j = 0; j < COLUMNS; j++){
      cells[i][j].changeState(false);
      cells2[i][j].changeState(false);
      } //ends j for-loop
    } //ends i for-loop
  } //ends reset method
  
} //ends Life class