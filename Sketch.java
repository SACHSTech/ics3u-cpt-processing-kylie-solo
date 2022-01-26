import processing.core.PApplet;

public class Sketch extends PApplet {
  // colour variables
  public int[] white = {255,255,255};
  public int[] black = {0,0,0};

  public int[] green = {0, 255, 0};
  public int[] red = {255, 0, 0};
  public int[] blue = {0, 0, 255};
  public int[] yellow = {252, 236, 3};
  public int[] purple = {113, 0, 227};
  public int[] pink = {240, 34, 233};
  public int[] orange = {230, 102, 23};
  public int[] brown = {66, 49, 31};

  public int[][] colourArray =  
  {green, red, blue, yellow, purple, pink, orange, brown};

  // size variables
  public int width = 600;
  public int height = 600;

  // card variables

  public int cardX1 = width/6;
  public float cardY1 = height/4;
  public float cardWidth1 = 100;
  public float cardHeight1 = cardWidth1;

  // board variables
  public int rows = 4;
  public int columns = 4;
  public boolean initial = true;
  public boolean squaredraw = false;

  //pairs of cards variables

  //array - cards flipped colours
  public int[][] cards = {
    {0, 1, 2, 3},
    {4, 5, 6, 7},
    {7, 6, 5, 4},
    {3, 2, 1, 0}
  };

  //state of cards - 0 = back, 1 = front, 2 = correct
  // toggle state when clicked and display this
  public int[][] cardState = {
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0}
  };

  //Cards currently picked
  // toggle when clicked - compare
  public boolean priorCardPicked = false;

  public int[] priorCardLocation = {0, 0};


	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() 
  {
	// put your size call here
    size(width, height);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() 
  {
    background(white[0],white[1],white[2]);  

    //print out card layout 4 by 4 
    strokeWeight((float)0.004*height);
       
    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        rect(cardX1, cardY1, cardWidth1, cardHeight1);
        cardX1 += cardWidth1;
      }
      cardX1 -= rows*(cardWidth1);
      cardY1 += cardHeight1;
    } 

  }

  //public static Scanner scanner = new Scanner(System.in);


  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() 
  {
    int cardX = width/6;
    int cardY = height/4;
    float cardWidth = 100;
    float cardHeight = cardWidth;

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        fill(colourArray[cards[i][j]][0], colourArray[cards[i][j]][1], colourArray[cards[i][j]][2]);
        squaredraw(cardX, cardY);
        cardX += cardWidth;
      }
      cardX -= rows*(cardWidth);
      cardY += cardHeight;
    }     
    
    //squaredraw(100, 150);

    // when boxes are clicked 
    //rect(cardX, cardY, cardWidth, cardHeight);
  
  }

  public void mouseClicked()
  {
    //variables
    int cardX = width/6;
    int cardY = height/4;
    float cardWidth = 100;
    float cardHeight = cardWidth;

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        if(mouseX >= cardX && mouseX <= (cardX + cardWidth) &&
           mouseY >= cardY && mouseY <= (cardY + cardHeight))
        {
          // decide current state with array
          if (cardState[i][j] == 0)
          {
            cardState[i][j] = 1;
            //check if flipped card matches previous flipped card
            if (priorCardPicked == false)
            {
              //allow user to pick another card & store position of first card
              priorCardPicked = true;
              priorCardLocation[0] = i;
              priorCardLocation[1] = j;
            }
            else
            {
              //check if colours match
              if (cards[i][j] == cards[priorCardLocation[0]][priorCardLocation[1]])
              {
                //same, so set correct
                cardState[i][j] = 2;
                cardState[priorCardLocation[0]][priorCardLocation[1]] = 2;
              }
              else 
              {
                //do not match, flip back over
                cardState[i][j] = 0;
                cardState[priorCardLocation[0]][priorCardLocation[1]] = 0;
              }
            }
            
          }
          else
          {
            // do nothing if clicked same card twice or if correct
          }
        }
        cardX += cardWidth;
      }
      cardX -= rows*(cardWidth);
      cardY += cardHeight;
    } 
    
  }

  


  public void squaredraw(int i, int j)
  {
    stroke(black[0]);
    rect(i, j, cardWidth1, cardHeight1);
  }

  public void shuffleCards()
  {
    
  }
  // define other methods down here.

}
  
    
  
    






