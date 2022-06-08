import java.util.Scanner;
public class Game{
    public Game(){
        BoardTest minefield = new BoardTest();
    }
    public static void main(String[] args){
        Game minesweeper = new Game();
        BoardTest minefield = new BoardTest();
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int y = 0;
        minefield.populate(5,5);
        System.out.println(minefield);
        while (!minefield.gameOver){
            System.out.println("Pick a x coordinate");
        
            try {
                x = scan.nextInt();
                System.out.println(x);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Please input a number");
            }
            System.out.println("Pick a y coordinate");
            try {
                y = scan.nextInt();
                System.out.println(y);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Please input a number");
            }
    
            if (x < 10 && y < 10){
                minefield.explore(y,x);
                
                System.out.println(minefield.revealString());
            }
        }
        
    }
}