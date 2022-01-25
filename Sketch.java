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
  public int cardX = width/6;
  public float cardY = height/4;
  public float cardWidth = 90;
  public float cardHeight = cardWidth;

  //
  public int rows = 4;
  public int columns = 4;
  public boolean initial = true;

	
	
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
    background(white);  //print out card layout 4 by 4 

    strokeWeight((float)0.004*height);
       
    for(int i = 0; i < rows; i++){
      for(int j = 0; j < columns; j++){
        rect(cardX, cardY, cardWidth, cardHeight);
        cardX += cardWidth + 10;
      }
      cardX -= rows*(cardWidth + 10);
      cardY += cardHeight + 10;
    } 

  }

  //public static Scanner scanner = new Scanner(System.in);


  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

  

    stroke(black);
    fill(white);
    //rect(cardX, cardY, cardWidth, cardHeight);


    

    /**for (cardX; cardX <= 225; cardX += 75) {
      ellipse(cardX, 150, 50, 50);
    }
    
    for (int circleX = 75; circleX <= 225; circleX += 75) {
      ellipse(circleX, 225, 50, 50);
    }
    */
  

    }
  
    
    
    

	// sample code, delete this stuff
    
  
  // define other methods down here.
}




