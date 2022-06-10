import java.util.Scanner;
public class Game{

    public Game(){
        BoardTest minefield = new BoardTest();
    }

    public static void main(String[] args){
        //STUFFS VAR
        Scanner scan = new Scanner(System.in);
        int difficulty = 0;
        int x = 0, startX = 0;
        int y = 0, startY = 0;
        int action = 0;

        //SELECT DIFFICULTY
        
        while (true){
          try {
            System.out.println("Select a difficulty: \n [<1] Easy \n [1] Medium \n [>1] Hard");
            difficulty = scan.nextInt();
            break;
          } catch (Exception e) {
              System.out.println("Please input a valid number");
              scan.nextLine();
        } 
        }
        
      //System.out.println("exiting");
      
        //MAKE MAGIC
        Game minesweeper = new Game();
        
        BoardTest minefield = new BoardTest(difficulty);
        
        
        

        //START SQUARE
        while (startX < 1 || startX > minefield.length()){
          //System.out.println(startX);
          //System.out.println(startX < 1 || startX > minefield.length());
          try {
            System.out.println("Pick an x coordinate");
            startX = scan.nextInt();
          } catch (Exception e) {
              System.out.println("Please input a number within the board");
              scan.nextLine();
          }
        }

        
        while (startY<1 || startY > minefield.height){
          try {
            System.out.println("Pick a y coordinate");
            startY = scan.nextInt();
          } catch (Exception e) {
              System.out.println("Please input a number within the board");
              scan.nextLine();
          }
        }
        
        minefield.populate(startY, startX);
        System.out.println(minefield.revealString());

        //PLAY
        while (!minefield.gameOver){
          x = 0; 
          y = 0;
            
          while (x < 1 || x > minefield.length()){
            try {
              System.out.println("Pick an x coordinate");
                x = scan.nextInt();
                //System.out.println(x);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Please input a number within the board");
                scan.nextLine();
            }
          }
            //System.out.println("exited");
          while (y<1 || y > minefield.height){
            try {
              System.out.println("Pick a y coordinate");
                y = scan.nextInt(); 
                
                //System.out.println(y);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Please input a number within the board");
                scan.nextLine();
            }
          }
            

            //ACTION - EXPLORE OR FLAG
            
            try {
              System.out.println("Actions: \n [<=1] Explore \n [>1] Flag/Unflag");
                action = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Please input a valid number");
                scan.nextLine();
            }

            //BOARD MAGIC
            if (difficulty < 1 && action <= 1){
              if (x > 0 && y > 0 && x <= 8 && y <= 8){
                  minefield.explore(y,x);

                  System.out.println(minefield.revealString());
              }
              else{
                System.out.println("Coordinates not on board.");
              }
            }
            else if (difficulty < 1 && action > 1){
              if (x > 0 && y > 0 && x <= 8 && y <= 8){
                minefield.setFlag(y, x);

                System.out.println(minefield.revealString());
              }
            }

            if (difficulty == 1 && action <= 1){
              if (x > 0 && y > 0 && x <= 16 && y <= 16){
                  minefield.explore(y,x);

                  System.out.println(minefield.revealString());
              }
              else{
                System.out.println("Coordinates not on board.");
              }
            }
            else if (difficulty == 1 && action > 1){
              if (x > 0 && y > 0 && x <= 16 && y <= 16){
                minefield.setFlag(y, x);

                System.out.println(minefield.revealString());
              }
            }

            if (difficulty > 1 && action <= 1){
              if (x > 0 && y > 0 && x <= 16 && y <= 32){
                  minefield.explore(y,x);

                  System.out.println(minefield.revealString());
              }
              else{
                System.out.println("Coordinates not on board.");
              }
            }
            else if (difficulty > 1 && action > 1){
              if (x > 0 && y > 0 && x <= 16 && y <= 32){
                minefield.setFlag(y,x);

                System.out.println(minefield.revealString());
              }
            }

            

        }
        System.out.println(minefield.revealString());
        System.out.println("You Hit a Bomb! \n Game Over.");

    }
}
