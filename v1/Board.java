public class Board{
  Plot[][] minefield;
  int bombCount = 0;
  int xCord;
  int yCord;
  int difficulty;
  int boardBomb;

  public Board(){
    minefield = new Plot[10][16];
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length; j++){
          minefield[i][j] = new Plot();
      }
  }
  boardBomb = 10;
  }

  public Board(int difficulty){
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
}


  public void populate(){
    //minefield[1][1].setUnavailable();
    //Creates buffer around board
    for (int i = 0; i < minefield[0].length; i++){
      minefield[0][i].setUnavailable();
    }
    for (int i = 0; i < minefield[minefield.length-1].length; i++){
      minefield[minefield.length-1][i].setUnavailable();
    }
    for (int i = 0; i < minefield.length; i++){
      minefield[i][0].setUnavailable();
    }
    for (int i = 0; i < minefield.length; i++){
      minefield[i][minefield[i].length-1].setUnavailable();
    }

    //Generates starting area
    xCord = (int) (Math.random()*minefield[0].length);
    yCord = (int) (Math.random()*minefield.length);
    boolean startingSquare = false;
    while (startingSquare != true){
    if (minefield[yCord][xCord].isAvailable()){
      startingSquare = true;
      for (int i = 0; i < 3; i++){
        if (minefield[yCord][xCord-i].isAvailable()){
          minefield[yCord][xCord-i].setUnavailable();
          //Test method
          minefield[yCord][xCord-i].setFlag();
        }
        if (minefield[yCord-i][xCord].isAvailable()){
          minefield[yCord-i][xCord].setUnavailable();
          //Test method
          minefield[yCord-i][xCord].setFlag();
        }
      }
    }
  }
    //Bomb generation

    while (bombCount != boardBomb){
      xCord = (int) (Math.random()*minefield[0].length);
      yCord = (int) (Math.random()*minefield.length);
      if (minefield[yCord][xCord].hasBomb() == false && minefield[yCord][xCord].isAvailable()){
        minefield[yCord][xCord].setBomb();
        bombCount+=1;
        if (minefield[yCord-1][xCord-1].isAvailable()){
          minefield[yCord-1][xCord-1].addBomb();
        }
        if (minefield[yCord-1][xCord].isAvailable()){
          minefield[yCord-1][xCord].addBomb();
        }
        if (minefield[yCord-1][xCord+1].isAvailable()){
          minefield[yCord-1][xCord+1].addBomb();
        }
        if (minefield[yCord][xCord-1].isAvailable()){
          minefield[yCord][xCord-1].addBomb();
        }
        if (minefield[yCord][xCord+1].isAvailable()){
          minefield[yCord][xCord+1].addBomb();
        }
        if (minefield[yCord+1][xCord-1].isAvailable()){
          minefield[yCord+1][xCord-1].addBomb();
        }
        if (minefield[yCord+1][xCord].isAvailable()){
          minefield[yCord+1][xCord].addBomb();
        }
        if (minefield[yCord+1][xCord+1].isAvailable()){
          minefield[yCord+1][xCord+1].addBomb();
        }
      }
      
    }


  }




  public String toString(){
    String s = "";
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length;j++){
        if (minefield[i][j].hasBomb()){
          s+= "\t B";
        }

        //TEST METHOD FOR LOOKING AT STARTING SQUARE GENERATION NOT ACTUAL IMPLEMENTATION
        else if (minefield[i][j].hasFlag()){
          s += "\t F"; 
        }
        //END OF TEST METHOD

        else if (minefield[i][j].isAvailable()){
          int bCount = minefield[i][j].bombCount();
          s += "\t " + bCount;
        }
        else {
          s += "\t -1";
        }
      }
      s += "\n";
    }
    return s;
  }
  public static void main(String[] args){
    Board minefield = new Board();
    minefield.populate();
    System.out.println(minefield.toString());
  }

}
