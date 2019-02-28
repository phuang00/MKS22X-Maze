import java.io.*;

public class Driver{
    public static void main(String[]args){
      String filename = "data1.dat";
      try{
        Maze f;
        f = new Maze("data1.dat");//true animates the maze.

        //f.setAnimate(true);
        f.solve();
        System.out.println();
        System.out.println(f);

        System.out.println();
        System.out.println();
        System.out.println();

        f = new Maze("data2.dat");

        //f.setAnimate(true);
        f.solve();
        System.out.println();
        System.out.println(f);

        System.out.println();
        System.out.println();
        System.out.println();

        f = new Maze("data3.dat");

        //f.setAnimate(true);
        f.solve();
        System.out.println();
        System.out.println(f);

        System.out.println();
        System.out.println();
        System.out.println();

      }catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename);
      }
    }
}
