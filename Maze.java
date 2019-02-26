import java.util.*;
import java.io.*;

public class Maze{
  public static char[][] readFile(String name) throws FileNotFoundException{
    File f = new File(name);
    Scanner in = new Scanner(f);
    ArrayList<String> tempLines = new ArrayList<>();
    while (in.hasNextLine()){
      tempLines.add(in.nextLine());
    }
    int x = tempLines.size();
    int y = tempLines.get(0).length();
    char[][] ans = new char[x][y];
    for (int i = 0; i < x; i++){
      for (int j = 0; j < y; j++){
        ans[i][j] = tempLines.get(i).charAt(j);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    try{
      char[][] ans = readFile("Maze1.txt");
      for (int i = 0; i < ans.length; i++){
        System.out.println(Arrays.toString(ans[i]));
      }
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }
  }
}
