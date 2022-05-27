public class Board{
  Plot[][] minefield;
  int bombCount = 0;
  int xCord;
  int yCord;
  public Board(){
    minefield = new Plot[10][10];
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
    for (int i = 0; i < minefield[9].length; i++){
      minefield[9][i].setUnavailable();
    }
    for (int i = 0; i < minefield.length; i++){
      minefield[i][0].setUnavailable();
    }
    for (int i = 0; i < minefield.length; i++){
      minefield[i][9].setUnavailable();
    }

    //Bomb generation
    while (bombCount != 10){
      xCord = (int) (Math.random()*10);
      yCord = (int) (Math.random()*10);
      if (minefield[yCord][xCord].hasBomb() == false && minefield[yCord][xCord].isAvailable()){
        minefield[yCord][xCord].setBomb();
        bombCount+=1;
      }
    }

  }
  public String toString(){
    String s = "";
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length;j++){
        if (minefield[i][j].hasBomb()){
          s+= "\t 2";
        }
        else if (minefield[i][j].isAvailable()){
          s += "\t 0";
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
