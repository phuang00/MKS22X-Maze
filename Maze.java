import java.util.*;
import java.io.*;

public class Maze{
  public static void readFile(String name) throws FileNotFoundException{
    File f = new File(name);
    Scanner in = new Scanner(f);
    ArrayList<String> tempLines = new ArrayList<>();
    while (in.hasNextLine()){
      tempLines.add(in.nextLine());
    }
    for (int i = 0; i < tempLines.size(); i++){
      System.out.println(tempLines.get(i));
    }
  }

  public static void main(String[] args) {
    try{
      readFile("Maze1.txt");
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }
  }
}
