import processing.core.PApplet;

public class Sketch extends PApplet {
  //title variables 
  public String message = "KYLIE'S MEMORY GAME";

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

  //array - cards flipped colours
  public int[][] cards = {
    {0, 3, 2, 5},
    {4, 1, 0, 7},
    {2, 4, 5, 6},
    {3, 7, 1, 6}
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

  // number of moves
  public String messageMoves = "Moves: ";
  public int moves = 0;

  // keeping track of matches
  public String messageWin = "You Win!! Play Again";
  public boolean booleanMatches = false;
  public int matches = 0;


	
	
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
    //print out card layout 4 by 4 
    strokeWeight((float)0.004*height);
       
    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        float randomI = random(0, 3);
        float randomJ = random(0, 3);
        //convert to float to int
        int randomI1 = (int)randomI;
        int randomJ1 = (int)randomJ;
        // HOW TO SWAP TWO CARD COLOURS:
        // STEP 1:  SAVE ONE OF THE CARDS COLOUR (A) IN A TEMPORARY SPOT (T)
        // STEP 2:  MOVE RANDOM CARD's COLOUR (B) TO THE SAVED CARDS COLOUR (A)
        // STEP 3:  MOVE TEMPORARY SAVED COLOUR (T) TO THE RANDOM CARDS COLOUR (B)
        // T = A
        // A = B
        // B = T
        
        //save previous card first 
        int storeColour = cards[i][j];

        //swap the cards
        cards[i][j] = cards[randomI1][randomJ1];
        cards[randomI1][randomJ1] = storeColour;

        //draw boxes 
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
    background(black[0], black[1], black[2]);
    //title
    fill(white[0], white[1], white[2]);
    textSize(50);
    text(message, width/40, height/6);
    //print out moves
    fill(red[0], red[1], red[2]);
    textSize(20);
    text(messageMoves, width/2.4f, height/6 + 20);
    //print number of moves
    textSize(20);
    text(moves, width/1.7143f, height/6 +20);
    // restart box
    stroke(white[0], white[1], white[2]);
    fill(black[0], black[1], black[2]);
    rect(width/1.2f, height/1.0714f, width/6.6667f, height/17.1429f);
    textSize(16);
    fill(red[0], red[1], red[2]);
    text("RESTART", width/1.1765f, height/1.0256f);
    

    int cardX = width/6;
    int cardY = height/4;
    float cardWidth = 100;
    float cardHeight = cardWidth;

    for(int i = 0; i < rows; i++)
    {
      for(int j = 0; j < columns; j++)
      {
        // check card state - if 0: use back colour - 1 or 2: flip card and reveal colour
        if (cardState[i][j] == 0)
        {
          fill(white[0],white[1],white[2]);
        }
        else if (cardState[i][j] == 1)
        {
          fill(colourArray[cards[i][j]][0], colourArray[cards[i][j]][1], colourArray[cards[i][j]][2]);
        }
        else if (cardState[i][j] == 2)
        {
          fill(colourArray[cards[i][j]][0], colourArray[cards[i][j]][1], colourArray[cards[i][j]][2]);
        }
        else
        {
          System.out.println("CardState is Outside of Range");
        }
        squaredraw(cardX, cardY);
        cardX += cardWidth;
      }
      cardX -= rows*(cardWidth);
      cardY += cardHeight;
    }   
    
    //if all matches found, then print out "You Win!! Play again!"
    if(matches == 8)
    {
      //text 
      fill(green[0], green[1], green[2]);
      textSize(20);
      text(messageWin, width/3, height/4.138f);
    }
    else
    {
      fill(black[0], black[1], black[2]);
      textSize(20);
      text(messageWin, width/3, height/4.138f);
    }
    
    
  
  }

  public void mouseClicked()
  {
    //if clicked restart box
    if (mouseX >= width/1.2f && mouseX <= width/1.2f + width/6.6667f 
    && mouseY >= height/1.0714f && mouseY <= height/1.0714f + height/17.1429f)
    {
      background(0);
      moves = 0;
      matches = 0;
      for(int i = 0; i < rows; i++)
      {
        for(int j = 0; j < columns; j++)
        {
          //reset cardstate so all cards clear
          cardState[i][j] = 0;
          float randomI = random(0, 3);
          float randomJ = random(0, 3);
          //convert to float to int
          int randomI1 = (int)randomI;
          int randomJ1 = (int)randomJ;
          //swap cards
          int storeColour = cards[i][j];
          cards[i][j] = cards[randomI1][randomJ1];
          cards[randomI1][randomJ1] = storeColour;

          //draw boxes 
          rect(cardX1, cardY1, cardWidth1, cardHeight1);
          cardX1 += cardWidth1;
        }
        cardX1 -= rows*(cardWidth1);
        cardY1 += cardHeight1;
      } 

    }
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
            //if card clicked add another move
            moves++;
            //check if flipped card matches previous flipped card
            if (priorCardPicked == false)
            {
              //allow user to pick another card & store position of first card
              priorCardPicked = true;          
              priorCardLocation[0] = i;
              priorCardLocation[1] = j;
              cardState[i][j] = 1;
            }
            else
            {
              //check if colours match
              if (cards[i][j] == cards[priorCardLocation[0]][priorCardLocation[1]])
              {
                
                //same, so set correct
                cardState[i][j] = 2;
                cardState[priorCardLocation[0]][priorCardLocation[1]] = 2;
                matches++;
                System.out.println("match");
                priorCardPicked = false;
              }
              else 
              {
                //do not match, flip back over
                cardState[priorCardLocation[0]][priorCardLocation[1]] = 0;
                priorCardPicked = true;
                priorCardLocation[0] = i;
                priorCardLocation[1] = j;
                cardState[i][j] = 1;
                
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

  public void shuffle(int array[])
  {
    
  }



  // define other methods down here.
}
