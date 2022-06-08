public class BoardTest{
  Plot[][] minefield;
  Plot[][] revealed;
  int bombCount = 0;
  int xCord;
  int yCord;
  int difficulty;
  int boardBomb;
  boolean gameOver;
  //int startingSquareX;
  //int startingSquareY;
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
    if (difficulty <= 0){
      minefield = new Plot[10][10];
      boardBomb = 10;
      gameOver = false;
      int squares = 54;
    }
    if (difficulty == 1){
      minefield = new Plot[18][18];
      boardBomb = 40;
      gameOver = false;
      int squares = 216;
    }
    if (difficulty >= 2){
      minefield = new Plot[18][32];
      boardBomb = 99;
      gameOver = false;
      int squares = 381;

    }
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length; j++){
          minefield[i][j] = new Plot();
      }
  }
  //int squares = minefield[0].length * minefield.length - boardBomb;
  gameOver = false;
}


  public void populate(int startY, int startX){
    //minefield[1][1].setUnavailable();
    //Creates buffer around board
    for (int i = 0; i < minefield[0].length-1; i++){
      minefield[0][i].setUnavailable();
      minefield[0][i].setBuffer();
      minefield[0][i].setBuffVal(i);
      revealed[0][i].setUnavailable();
      revealed[0][i].setBuffer();
      revealed[0][i].setBuffVal(i);
    }
    for (int i = 0; i < minefield[minefield.length-1].length-1; i++){
      minefield[minefield.length-1][i].setUnavailable();
      minefield[minefield.length-1][i].setBuffer();
      minefield[minefield.length-1][i].setBuffVal(i);
      revealed[minefield.length-1][i].setUnavailable();
      revealed[minefield.length-1][i].setBuffer();
      revealed[minefield.length-1][i].setBuffVal(i);
    }
    for (int i = 0; i < minefield.length-1; i++){
      minefield[i][0].setUnavailable();
      minefield[i][0].setBuffer();
      minefield[i][0].setBuffVal(i);
      revealed[i][0].setUnavailable();
      revealed[i][0].setBuffer();
      revealed[i][0].setBuffVal(i);
    }
    for (int i = 0; i < minefield.length-1; i++){
      minefield[i][minefield[i].length-1].setUnavailable();
      minefield[i][minefield[i].length-1].setBuffer();
      minefield[i][minefield[i].length-1].setBuffVal(i);
      revealed[i][minefield[i].length-1].setUnavailable();
      revealed[i][minefield[i].length-1].setBuffer();
      revealed[i][minefield[i].length-1].setBuffVal(i);
    }

    revealed[0][minefield[0].length-1].setBuffVal(0);
    revealed[0][minefield[0].length-1].setUnavailable();
    revealed[0][minefield[0].length-1].setBuffer();

    revealed[0][0].setBuffVal(0);
    revealed[0][0].setUnavailable();
    revealed[0][0].setBuffer();

    revealed[minefield.length-1][0].setBuffVal(0);
    revealed[minefield.length-1][0].setBuffer();
    revealed[minefield.length-1][0].setUnavailable();

    revealed[minefield.length-1][minefield[minefield.length-1].length-1].setBuffVal(0);
    revealed[minefield.length-1][minefield[minefield.length-1].length-1].setUnavailable();
    revealed[minefield.length-1][minefield[minefield.length-1].length-1].setBuffer();
    
    minefield[0][minefield[0].length-1].setBuffVal(0);
    minefield[0][minefield[0].length-1].setUnavailable();
    minefield[0][minefield[0].length-1].setBuffer();

    minefield[0][0].setBuffVal(0);
    minefield[0][0].setUnavailable();
    minefield[0][0].setBuffer();

    minefield[minefield.length-1][0].setBuffVal(0);
    minefield[minefield.length-1][0].setBuffer();
    minefield[minefield.length-1][0].setUnavailable();

    minefield[minefield.length-1][minefield[minefield.length-1].length-1].setBuffVal(0);
    minefield[minefield.length-1][minefield[minefield.length-1].length-1].setUnavailable();;
    minefield[minefield.length-1][minefield[minefield.length-1].length-1].setBuffer();
    //Generates starting area

    boolean startingSquare = false;

    while (startingSquare != true){
      // xCord = (int) (Math.random()*minefield[0].length);
      // yCord = (int) (Math.random()*minefield.length);
      if (minefield[startY][startX].isAvailable()){
        startingSquare = true;
        //startingSquareX = startX;
        //startingSquareY = startY;
        minefield[startY][startX].setStarter();
        minefield[startY-1][startX+1].setStarter();
        minefield[startY-1][startX-1].setStarter();
        minefield[startY-1][startX].setStarter();
        minefield[startY][startX-1].setStarter();
        minefield[startY][startX+1].setStarter();
        minefield[startY+1][startX-1].setStarter();
        minefield[startY+1][startX].setStarter();
        minefield[startY+1][startX+1].setStarter();
        // minefield[yCord][xCord].setExplored();
        // minefield[yCord-1][xCord+1].setExplored();
        // minefield[yCord-1][xCord-1].setExplored();
        // minefield[yCord-1][xCord].setExplored();
        // minefield[yCord][xCord-1].setExplored();
        // minefield[yCord][xCord+1].setExplored();
        // minefield[yCord+1][xCord-1].setExplored();
        // minefield[yCord+1][xCord].setExplored();
        // minefield[yCord+1][xCord+1].setExplored();

        revealed[startY][startX].setUnavailable();
        revealed[startY-1][startX+1].setUnavailable();
        revealed[startY-1][startX-1].setUnavailable();
        revealed[startY-1][startX].setUnavailable();
        revealed[startY][startX-1].setUnavailable();
        revealed[startY][startX+1].setUnavailable();
        revealed[startY+1][startX-1].setUnavailable();
        revealed[startY+1][startX].setUnavailable();
        revealed[startY+1][startX+1].setUnavailable();

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
    expand(startY, startX);

  }



  public int expand(int yCord, int xCord){
    //System.out.println(yCord + " " + xCord);
    //System.out.println((yCord >= 0 && yCord < minefield.length) || (xCord >= 0 && xCord < minefield[0].length));
    //minefield[yCord][xCord].setExplored();
    if ((yCord >= 0 && yCord < minefield.length) && (xCord >= 0 && xCord < minefield[0].length)){
      //System.out.println(yCord + " " + xCord);
      
      if (minefield[yCord][xCord].bombCount() > 0) {
        System.out.println("xCord: " + xCord + " yCord: " + yCord);
        minefield[yCord][xCord].setExplored();
        return minefield[yCord][xCord].bombCount();
        
      }
      else if (minefield[yCord][xCord].isAvailable() && minefield[yCord][xCord].bombCount() == 0 && !minefield[yCord][xCord].isBuffer() && !minefield[yCord][xCord].getExplored()){
        minefield[yCord][xCord].setExplored();
        //revealed[yCord][xCord].setFlag();
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
        return 0;
      }
    }
    return 0;
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

  public void explore(int yCord, int xCord){
    if (minefield[yCord][xCord].hasBomb()){
      gameOver = true;
    }
    else {
      minefield[yCord][xCord].setExplored();
      expand(yCord, xCord);
    }
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
        s += "minefield[" + i + "][" + j + "] explored " + minefield[i][j].getExplored() + "| available " + minefield[i][j].isAvailable() + "| bomb " + minefield[i][j].bombCount() + "\n";
      }
    }
    return s;
  }

  public String revealString(){
    String s = "";
    int tracker = 0;
    for (int i = 0; i < revealed.length; i++){
      for (int j = 0; j <revealed[i].length;j++){
        tracker = j;
        if (minefield[i][j].isBuffer()){
          s += "\t " + minefield[i][j].getBuffVal() + "   ";
        }
        else if (minefield[i][j].getExplored() && minefield[i][j].bombCount()>0){
          s += "\t " + minefield[i][j].bombCount();
        }
        else if (!minefield[i][j].getExplored()){
          s += "\t ?";
        }
        else if (minefield[i][j].isBuffer()){
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
      }
      if (minefield[i][tracker].getBuffVal()==0){
        s += "\n";
      }
      else if(minefield[i][tracker].getBuffVal()==8){
        s += "\n";
      }
      s += "\n";
    }

    return s;
  }

  public static void main(String[] args){
    BoardTest minefield = new BoardTest();
    minefield.populate(5, 5);
    System.out.println(minefield.toString());
    System.out.println(minefield.revealString());
    minefield.explore(1,1);
    System.out.println(minefield.revealString());

  }

}
