import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tmp {
    // создание матрицы смежности
    static void graphs() {
            int[][] graph = new int[6][6];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    graph[i][j] = j + 1;
                }
            }
            for (int[] graAph : graph) {
                for (int graAAph : graAph)
                    System.out.print(graAAph + " ");
            }
            System.out.println();
        }

       static void split() {
            try {
                String str = null;
                BufferedReader br = new BufferedReader(new FileReader("/home/andrew/IT/file.txt"));
                List<String[]> islandInfo    = new ArrayList<String[]>();
                int countStr = 0;
                while ((str = br.readLine()) != null) {
                    String[] list = str.split(" ");
                    //result = result.substring(0, result.indexOf('\n'));
                    islandInfo.add(list);
                    for (String it : list) {
                        System.out.print( "   " + it);
                    }

                    countStr++;
                    System.out.println();
                }
                System.out.println(countStr);
                br.close();
            } catch (IOException exc) {
                System.out.println("IO error!" + exc);
            }

        }
    public static void main (String[]args) {
        split();
        System.out.println();


    }

}

