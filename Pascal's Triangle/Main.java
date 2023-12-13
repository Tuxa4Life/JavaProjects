import java.util.Scanner;

public class Main extends MiniJava {
    public static int[][] pascal(int n) {
        int[][] result = new int[n + 1][];
        for (int i = 0; i <= n; i ++) {
            int[] row = new int[i];
            for (int j = 0; j < i; j ++) {
                if (j == 0) row[j] = 1;
                else if (j == i - 1) row[j] = 1;

                else row[j] = result[i - 1][j] + result[i - 1][j - 1];
            }

            result[i] = row;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = readInt("Please insert number of rows:");

        int[][] arr = pascal(n);
        for (int r = 1; r < arr.length; r ++) {
            for (int e = 0; e < arr[r].length; e ++) {
                if (r == 1 && e == 0) System.out.println("n=0" + "\t\t" + arr[r][e]);
                else if (e == 0) System.out.print("n=" + (r - 1) + "\t\t" + arr[r][e]);
                else if (e == arr[r].length - 1) System.out.println("\t" + arr[r][e]);
                else System.out.print("\t" + arr[r][e]);
            }
        }

    }
}