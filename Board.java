public class Board{
  Plot[][] minefield;
  int bombCount = 0;
  public Board(){
    minefield = new Plot[10][10];
  }
  public void populate(){
    minefield[1][1].setUnavailable();
    //Creates buffer around board
    // for (int i = 0; i < minefield[0].length-1; i++){
    //   minefield[0][i].setUnavailable();
    // }
    // for (int i = 0; i < minefield[9].length-1; i++){
    //   minefield[9][i].setUnavailable();
    // }
    // for (int i = 0; i < minefield.length-1; i++){
    //   minefield[i][0].setUnavailable();
    // }
    // for (int i = 0; i < minefield.length-1; i++){
    //   minefield[i][9].setUnavailable();
    // }
    // while (bombCount != 10){
    //
    // }
  }
  public String toString(){
    String s = "";
    for (int i = 0; i < minefield.length; i++){
      for (int j = 0; j < minefield[i].length;j++){
        if (minefield[i][j].isAvailable()){
          s += 0;
        }
        else {
          s += -1;
        }
        s += "\n";
      }
    }
    return s;
  }
  public static void main(String[] args){
    Board minefield = new Board();
    minefield.populate();
    //System.out.println(minefield.toString());
  }

}
