import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
     List<Integer> importante = new ArrayList<Integer>();
    int totalSuerte = 0;
    for(int i = 0; i < contests.length; i++){
         if(contests[i][1] == 1){

             importante.add(contests[i][0]);
             
         } 
        totalSuerte += contests[i][0];
        
    }
    int Ganar = importante.size() - k, puntos = 0;
     Collections.sort(importante);
    for(int i = 0; i < Ganar; i++){
        puntos += 2 * importante.get(i);
    }
    return totalSuerte - puntos;
    }
    
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}