public class Triangle implements Comparable{ 
  
  private int height, base;
  private double area;
  
  public Triangle(int height, int base){
    this.height = height; 
    this.base = base;
    
    area = .5*height*base;
  }
  
  public int getHeight(){
    return height;
  }
  
  public int getBase(){
    return base;
  }
  
  public double getArea(){
    return area;
  }
  
  public int compareTo(Object o){
    if (((Triangle)o).getArea() < area)
      return 1;
    else if (((Triangle)o).getArea() > area)
      return -1;
    else
      return 0;
  }
  
  public static void main(String[] args){
    Triangle a = new Triangle(2,3);
    Triangle b = new Triangle(4,5);
    Triangle c = new Triangle(4,5);
    
    System.out.println(a.compareTo(b));
    System.out.println(b.compareTo(c));
    System.out.println(c.compareTo(a));
  }
}
      
    
    