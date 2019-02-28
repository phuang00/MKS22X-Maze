import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
        File f = new File(filename);
        Scanner in = new Scanner(f);
        ArrayList<String> tempLines = new ArrayList<>();
        while (in.hasNextLine()){
          tempLines.add(in.nextLine());
        }
        // reads each line of the file into an ArrayList
        int x = tempLines.size();
        int y = tempLines.get(0).length();
        // set x to size of ArrayList and y to the number of chars per line of ArrayList
        maze = new char[x][y];
        // initialize ans array with dimensions x and y
        for (int i = 0; i < x; i++){
          for (int j = 0; j < y; j++){
            maze[i][j] = tempLines.get(i).charAt(j);
            // transfer chars from ArrayList to ans
          }
        }
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    /*Return the string that represents the maze.
         It should look like the text file with some characters replaced.
        */
        public String toString(){
          String ans = "";
          for (int i = 0; i < maze.length; i++){
            for (int j = 0; j < maze[i].length; j++){
              ans += maze[i][j];
              if (j == maze[i].length - 1 && i != maze.length - 1) ans += '\n';
            }
          }
          return ans;
        }

    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
      //find the location of the S.
      for (int i = 0; i < maze.length; i++){
        for (int j = 0; j < maze[i].length; j++){
          if (maze[i][j] == 'S'){
            maze[i][j] = ' ';
            return solve(i, j, 0);
          }
        }
      }
      //erase the S

      //and start solving at the location of the s.
      //return solve(???,???);
      return -1;
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int count){ //you can add more parameters since this is private
      //automatic animation! You are welcome.
      if(animate){
        clearTerminal();
        System.out.println(this);
        wait(20);
      }
      //COMPLETE SOLVE
      if (maze[row][col] == 'E') return count;
      if (maze[row][col] != ' ') return -1;
      int[] moves = new int[] {0,1,1,0,0,-1,-1,0};
      for (int i = 0; i < moves.length; i+=2){
        int x = row + moves[i];
        int y = col + moves[i + 1];
        maze[row][col] = '@';
        int ans = solve(x, y, count + 1);
        if (ans != -1) return ans;
        maze[row][col] = '.';
      }
      return -1; //so it compiles
    }
}
