import java.util.Scanner;
public class Game{

    public Game(){
        BoardTest minefield = new BoardTest();
    }

    public static void main(String[] args){
        //STUFFS VAR
        Scanner scan = new Scanner(System.in);
        String difficulty = "1211920914";
        String x = "1211920914", startX = "1211920914";
        String y = "1211920914", startY = "1211920914";
        String action = "1211920914";

        //SELECT DIFFICULTY
        while(difficulty == "1211920914"){
            System.out.println("Select a difficulty: \n [<1] Easy \n [1] Medium \n [>1] Hard");
            difficulty = scan.next();
            if ( ! (difficulty == "1211920914") ){
                break;
            }
            else{
                System.out.println("Please input a valid number");
            }
        }

        //MAKE MAGIC
        Game minesweeper = new Game();
        BoardTest minefield = new BoardTest(Integer.parseInt(difficulty));

        //START SQUARE
        while (startX == "1211920914"){
            System.out.println("Choose an starting x coordinate");
            startX = scan.next();
            if ( ! (startX == "1211920914") ){
                break;
            }
            else{
                System.out.println("Please input a number within the board");
            }
        }

        while(startY == "1211920914"){
            System.out.println("Choose a starting y coordinate");
            startY = scan.next();
            if ( ! (startY == "1211920914") ){
                break;
            }
            else{
                System.out.println("Please input a number within the board");
            }
          }

        minefield.populate(Integer.parseInt(startY), Integer.parseInt(startX));
        System.out.println(minefield.revealString());

        //PLAY
        while (!minefield.gameOver){

            while(x == "1211920914"){
                System.out.println("Choose an x coordinate");
                x = scan.next();
                if ( ! (x == "1211920914") ){
                    break;
                }
                else{
                    System.out.println("Please input a number within the board");
                }
            }

            while(y == "1211920914"){
                System.out.println("Choose an y coordinate");
                y = scan.next();
                if ( ! (y == "1211920914") ){
                    break;
                }
                else{
                    System.out.println("Please input a number within the board");
                }
            }

            //ACTION - EXPLORE OR FLAG
            while (action == "1211920914"){
                System.out.println("Actions: \n [<=1] Explore \n [>1] Flag/Unflag");
                action = scan.next();
                if ( ! (y == "1211920914") ){
                    break;
                }
                else{
                    System.out.println("Please input a valid number");
                }
            }

            //BOARD MAGIC
            if (Integer.parseInt(difficulty) < 1 && Integer.parseInt(action) <= 1){
              if (Integer.parseInt(x) > 0 && Integer.parseInt(y) > 0 && Integer.parseInt(x) <= 8 && Integer.parseInt(y) <= 8){
                  minefield.explore(Integer.parseInt(y), Integer.parseInt(x));

                  System.out.println(minefield.revealString());
              }
              else{
                System.out.println("Coordinates not on board.");
              }
            }
            else if (Integer.parseInt(difficulty) < 1 && Integer.parseInt(action) > 1){
              if (Integer.parseInt(x) > 0 && Integer.parseInt(y) > 0 && Integer.parseInt(x) <= 8 && Integer.parseInt(y) <= 8){
                minefield.setFlag(Integer.parseInt(y), Integer.parseInt(x));

                System.out.println(minefield.revealString());
              }
            }

            if (Integer.parseInt(difficulty) == 1 && Integer.parseInt(action) <= 1){
              if (Integer.parseInt(x) > 0 && Integer.parseInt(y) > 0 && Integer.parseInt(x) <= 16 && Integer.parseInt(y) <= 16){
                  minefield.explore(Integer.parseInt(y), Integer.parseInt(x));

                  System.out.println(minefield.revealString());
              }
              else{
                System.out.println("Coordinates not on board.");
              }
            }
            else if (Integer.parseInt(difficulty) == 1 && Integer.parseInt(action) > 1){
              if (Integer.parseInt(x) > 0 && Integer.parseInt(y) > 0 && Integer.parseInt(x) <= 16 && Integer.parseInt(y) <= 16){
                minefield.setFlag(Integer.parseInt(y), Integer.parseInt(x));

                System.out.println(minefield.revealString());
              }
            }

            if (Integer.parseInt(difficulty) > 1 && Integer.parseInt(action) <= 1){
              if (Integer.parseInt(x) > 0 && Integer.parseInt(y) > 0 && Integer.parseInt(x) <= 16 && Integer.parseInt(y) <= 32){
                  minefield.explore(Integer.parseInt(y), Integer.parseInt(x));

                  System.out.println(minefield.revealString());
              }
              else{
                System.out.println("Coordinates not on board.");
              }
            }
            else if (Integer.parseInt(difficulty) > 1 && Integer.parseInt(action) > 1){
              if (Integer.parseInt(x) > 0 && Integer.parseInt(y) > 0 && Integer.parseInt(x) <= 16 && Integer.parseInt(y) <= 32){
                minefield.setFlag(Integer.parseInt(y), Integer.parseInt(x));

                System.out.println(minefield.revealString());
              }
            }



        }

        System.out.println(minefield.revealString());
        System.out.println(minefield.toString());
        System.out.println("You Hit a Bomb! \n Game Over.");

    }
}
