import processing.core.PApplet;

public class Sketch extends PApplet {
  // colour variables
  public int red = 225;
  public int green = 225;
  public int blue = 255;
  public int white = 255;
  public int black = 0;

  // size variables
  public int width = 600;
  public int height = 600;

  // card variables
  public int cardX;
  public int cardY = 150;
  public int cardWidth = 90;
  public int cardHeight = cardWidth;


	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(width, height);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(white);
  }
  //array for 4 by 4 layout
  public static String[][] board = new String[4][4];

  //array to store cards
  public static String[][] cards = new String[4][4];

  //public static Scanner scanner = new Scanner(System.in);


  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    //print out card layout 4 by 4 
    stroke(black);
    fill(black);
    rect(cardX, cardY, cardWidth, cardHeight);

    for (cardX = 90; cardX <= 225; cardX += 75) {
      rect(cardX, cardY, cardWidth, cardHeight);
    }
    
    /**for (int circleX = 75; circleX <= 225; circleX += 75) {
      ellipse(circleX, 150, 50, 50);
    }
    
    for (int circleX = 75; circleX <= 225; circleX += 75) {
      ellipse(circleX, 225, 50, 50);
    }
    */

    }
  
    
    
    

	// sample code, delete this stuff
    
  
  // define other methods down here.
}




