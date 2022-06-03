public class BoardTest{
  Plot[][] minefield;
  Plot[][] revealed;
  int bombCount = 0;
  int xCord;
  int yCord;
  int difficulty;
  int boardBomb;
  boolean gameOver;
  int startingSquareX;
  int startingSquareY;
  int squares;
  public BoardTest(){
    minefield = new Plot[10][10];
    revealed = new Plot[10][10];
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length; j++){
          minefield[i][j] = new Plot();
          revealed[i][j] = new Plot();
      }
  }
  boardBomb = 10;
  gameOver = false;
  int squares = 54;
  }

  public BoardTest(int difficulty){
    if (difficulty == 0){
      minefield = new Plot[10][10];
      boardBomb = 10;
      
    }
    if (difficulty == 1){
      minefield = new Plot[18][18];
      boardBomb = 40;
    }
    if (difficulty == 2){
      minefield = new Plot[18][32];
      boardBomb = 99;
    }
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length; j++){
          minefield[i][j] = new Plot();
      }
  }
  int squares = minefield[0].length * minefield.length - boardBomb;
  gameOver = false;
}

  public void pop(){
    minefield[0][0].setStarter();
    minefield[1][2].setBomb();
    minefield[2][1].setBomb();
    minefield[0][1].addBomb();
    minefield[1][0].addBomb();
    minefield[1][1].addBomb();
    minefield[1][1].addBomb();
    expand(0, 0);
  }

  public void populate(){
    //minefield[1][1].setUnavailable();
    //Creates buffer around board
    for (int i = 0; i < minefield[0].length; i++){
      minefield[0][i].setUnavailable();
      minefield[0][i].setBuffer();
      revealed[0][i].setUnavailable();
      revealed[0][i].setBuffer();
    }
    for (int i = 0; i < minefield[minefield.length-1].length; i++){
      minefield[minefield.length-1][i].setUnavailable();
      minefield[minefield.length-1][i].setBuffer();
      revealed[minefield.length-1][i].setUnavailable();
      revealed[minefield.length-1][i].setBuffer();
    }
    for (int i = 0; i < minefield.length; i++){
      minefield[i][0].setUnavailable();
      minefield[i][0].setBuffer();
      revealed[i][0].setUnavailable();
      revealed[i][0].setBuffer();
    }
    for (int i = 0; i < minefield.length; i++){
      minefield[i][minefield[i].length-1].setUnavailable();
      minefield[i][minefield[i].length-1].setBuffer();
      revealed[i][minefield[i].length-1].setUnavailable();
      revealed[i][minefield[i].length-1].setBuffer();
    }

    //Generates starting area
    
    boolean startingSquare = false;

    while (startingSquare != true){
    xCord = (int) (Math.random()*minefield[0].length);
    yCord = (int) (Math.random()*minefield.length);
    if (minefield[yCord][xCord].isAvailable()){
      startingSquare = true;
      startingSquareX = xCord;
      startingSquareY = yCord;
      minefield[yCord][xCord].setStarter();
      minefield[yCord-1][xCord+1].setStarter();
      minefield[yCord-1][xCord-1].setStarter();
      minefield[yCord-1][xCord].setStarter();
      minefield[yCord][xCord-1].setStarter();
      minefield[yCord][xCord+1].setStarter();
      minefield[yCord+1][xCord-1].setStarter();
      minefield[yCord+1][xCord].setStarter();
      minefield[yCord+1][xCord+1].setStarter();
      // minefield[yCord][xCord].setExplored();
      // minefield[yCord-1][xCord+1].setExplored();
      // minefield[yCord-1][xCord-1].setExplored();
      // minefield[yCord-1][xCord].setExplored();
      // minefield[yCord][xCord-1].setExplored();
      // minefield[yCord][xCord+1].setExplored();
      // minefield[yCord+1][xCord-1].setExplored();
      // minefield[yCord+1][xCord].setExplored();
      // minefield[yCord+1][xCord+1].setExplored();
      
      revealed[yCord][xCord].setUnavailable();
      revealed[yCord-1][xCord+1].setUnavailable();
      revealed[yCord-1][xCord-1].setUnavailable();
      revealed[yCord-1][xCord].setUnavailable();
      revealed[yCord][xCord-1].setUnavailable();
      revealed[yCord][xCord+1].setUnavailable();
      revealed[yCord+1][xCord-1].setUnavailable();
      revealed[yCord+1][xCord].setUnavailable();
      revealed[yCord+1][xCord+1].setUnavailable();

      // for (int i = 0; i < 3; i++){
      //   if (minefield[yCord][xCord-i].isAvailable()){
      //     minefield[yCord][xCord-i].setUnavailable();
      //     //Test method
      //     minefield[yCord][xCord-i].setFlag();
      //   }
      //   if (minefield[yCord-i][xCord].isAvailable()){
      //     minefield[yCord-i][xCord].setUnavailable();
      //     //Test method
      //     minefield[yCord-i][xCord].setFlag();
      //   }
      // }

    }
  }
    //Bomb generation

    while (bombCount != boardBomb){
      xCord = (int) (Math.random()*minefield[0].length);
      yCord = (int) (Math.random()*minefield.length);
      if (minefield[yCord][xCord].hasBomb() == false && (minefield[yCord][xCord].isAvailable() && !minefield[yCord][xCord].getStarter())){
        minefield[yCord][xCord].setBomb();
        minefield[yCord][xCord].setUnavailable();
        revealed[yCord][xCord].setBomb();
        bombCount+=1;
        if (minefield[yCord-1][xCord-1].isAvailable()){
          minefield[yCord-1][xCord-1].addBomb();
          revealed[yCord-1][xCord-1].addBomb();
        }
        if (minefield[yCord-1][xCord].isAvailable()){
          minefield[yCord-1][xCord].addBomb();
          revealed[yCord-1][xCord].addBomb();
        }
        if (minefield[yCord-1][xCord+1].isAvailable()){
          minefield[yCord-1][xCord+1].addBomb();
          revealed[yCord-1][xCord+1].addBomb();
        }
        if (minefield[yCord][xCord-1].isAvailable()){
          minefield[yCord][xCord-1].addBomb();
          revealed[yCord][xCord-1].addBomb();
        }
        if (minefield[yCord][xCord+1].isAvailable()){
          minefield[yCord][xCord+1].addBomb();
          revealed[yCord][xCord+1].addBomb();
        }
        if (minefield[yCord+1][xCord-1].isAvailable()){
          minefield[yCord+1][xCord-1].addBomb();
          revealed[yCord+1][xCord-1].addBomb();
        }
        if (minefield[yCord+1][xCord].isAvailable()){
          minefield[yCord+1][xCord].addBomb();
          revealed[yCord+1][xCord].addBomb();
        }
        if (minefield[yCord+1][xCord+1].isAvailable()){
          minefield[yCord+1][xCord+1].addBomb();
          revealed[yCord+1][xCord+1].addBomb();
        }
      }
      
    }

    //Expands Starting Area
    System.out.println("expand starting");
    expand(startingSquareY, startingSquareX);

  }
  


  public void expand(int yCord, int xCord){
    //System.out.println(yCord + " " + xCord);
    //System.out.println((yCord >= 0 && yCord < minefield.length) || (xCord >= 0 && xCord < minefield[0].length));
    if ((yCord >= 0 && yCord < minefield.length) && (xCord >= 0 && xCord < minefield[0].length)){
      //System.out.println(yCord + " " + xCord);
      if (minefield[yCord][xCord].bombCount() > 0) {
        //return minefield[yCord][xCord].bombCount();
      }
      else if (minefield[yCord][xCord].isAvailable() && minefield[yCord][xCord].bombCount() == 0 && !minefield[yCord][xCord].isBuffer() && !minefield[yCord][xCord].getExplored()){
        minefield[yCord][xCord].setExplored();
        revealed[yCord][xCord].setFlag();
        // expand(minefield[yCord-1][xCord-1]);
        // expand(minefield[yCord-1][xCord]);
        // expand(minefield[yCord-1][xCord+1]);
        // expand(minefield[yCord][xCord-1]);
        // expand(minefield[yCord][xCord+1]);
        // expand(minefield[yCord+1][xCord-1]);
        // expand(minefield[yCord+1][xCord]);
        // expand(minefield[yCord+1][xCord+1]);
        
        expand(yCord-1, xCord-1);
        expand(yCord-1, xCord);
        expand(yCord-1, xCord+1);
        expand(yCord, xCord-1);
        expand(yCord, xCord+1);
        expand(yCord+1, xCord-1);
        expand(yCord+1, xCord);
        expand(yCord+1, xCord+1);
        //return 1;
      }
    }
    //return 1;
    // System.out.println("yCord " + yCord);
    // System.out.println("xCord " + xCord);
    // Plot topLeft = minefield[yCord-1][xCord-1];
    // Plot topMiddle = minefield[yCord-1][xCord];
    // Plot topRight = minefield[yCord-1][xCord+1];
    // Plot left = minefield[yCord][xCord-1];
    // Plot right = minefield[yCord][xCord+1];
    // Plot bottomLeft = minefield[yCord+1][xCord-1];
    // Plot bottomMiddle = minefield[yCord+1][xCord];
    // Plot bottomRight = minefield[yCord+1][xCord+1];
    // if (minefield[yCord][xCord].hasBomb()){
    //   gameOver = true;
    // }
    // System.out.println("test " + minefield[yCord][xCord].isAvailable());
    

  }

  // //Helper method
  // public void expand(Plot square){
  //   // if (square.hasBomb()){
  //   //   gameOver = true;
  //   // }
  //   if (square.isAvailable() && square.bombCount()==0){
  //     square.setExplored();

  //   }
  // }

  public String toString(){
    String s = "";
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length;j++){
        if (minefield[i][j].isBuffer()){
          s += "\t -1";
        }
        else if (minefield[i][j].getExplored()){
          s += "\t E";
        }
        else if (minefield[i][j].hasBomb()){
          s += "\t B";
        }
        
        else if (minefield[i][j].isAvailable()){
          int bCount = minefield[i][j].bombCount();
          s += "\t " + bCount;
        }
        else {
          s += "\t T";
        }
        // if (minefield[i][j].hasBomb()){
        //   s+= "\t B";
        // }

        // //TEST METHOD FOR LOOKING AT STARTING SQUARE GENERATION NOT ACTUAL IMPLEMENTATION
        
        // //END OF TEST METHOD

        
        // else if (minefield[i][j].isBuffer()){
        //   s += "\t -1"; 
        // }
        // else if (minefield[i][j].getExplored()){
        //   s += "\t E"; 
        // }
        // else if (minefield[i][j].isAvailable()){
        //   int bCount = minefield[i][j].bombCount();
        //   s += "\t " + bCount;
        // }
        // else {
        //   s += "\t T";
        // }
      }
      s += "\n";
    }
    s += "\n";
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length; j++){
        s += "minefield[" + i + "][" + j + "] explored " + minefield[i][j].getExplored() + "| available " + minefield[i][j].isAvailable() + " \n"; 
      }
    }
    return s;
  }

  public String revealString(){
    String str = "";
    for (int i = 0; i < revealed.length; i++){
      for (int j = 0; j <revealed[i].length;j++){
        if (revealed[i][j].hasFlag() == true){
          if (revealed[i][j].hasBomb()){
            str += "\t B";
          }
          else if (revealed[i][j].isBuffer()){
            str += "\t ";
          }
          else {
            int bCount = revealed[i][j].bombCount();
            str += "\t " + bCount;
          }
        }
        else {
          str += "\t ?";
        }
      }
    }
    
    return str;
  }
  public static void main(String[] args){
    BoardTest minefield = new BoardTest();
    minefield.populate();
    //minefield.pop();
    System.out.println(minefield.toString());
    
  }

}
