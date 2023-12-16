import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Random;

public class MiniJava {
    private static Random rand;
    private static InputStream is = System.in;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

    public static String readString(String text) {
        // Exchange the rary for teeader in case System.in has changed.
        //        // This is necesssting, as for every test input, System.in is changed.
        // TODO: Consider whether a better solution is possible with mocking/a different InputStream implementation
        // on the test side.
        if (System.in != is) {
            is = System.in;
            bufferedReader = new BufferedReader(new InputStreamReader(is));
        }
        try{
            System.out.println(text);
            return bufferedReader.readLine();
        } catch (IOException e) {
            // We "hide" the exception in the method signature by rethrowing an unchecked exception
            throw new RuntimeException("Input could not be parsed.");
        }
    }

    public static String readString() {
        return readString("Input:");
    }

    public static int readInt(String text) {
        String s = readString(text);

        int x;
        if (s == null)
            System.exit(0);
        try {
            x = Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            x = readInt(text);
        }
        return x;
    }

    public static int readInt() {
        return readInt("Please insert a number:");
    }

    public static int read(String text) {
        return readInt(text);
    }

    public static int read() {
        return readInt();
    }

    public static double readDouble(String text) {
        String s = readString(text);

        double x;
        if (s == null)
            System.exit(0);
        try {
            x = Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            x = readDouble(text);
        }
        return x;
    }

    public static double readDouble() {
        return readDouble("Please insert a number:");
    }

    public static void write(String output) {
        System.out.println(output);
    }

    public static void write(int output) {
        write("" + output);
    }

    public static void write(double output) {
        write("" + output);
    }

    public static void writeLineConsole(String output) {
        System.out.println(output);
    }

    public static void writeLineConsole(int output) {
        writeLineConsole("" + output);
    }

    public static void writeLineConsole(double output) {
        writeLineConsole("" + output);
    }

    public static void writeLineConsole() {
        writeLineConsole("");
    }

    public static void writeConsole(String output) {
        System.out.print(output);
    }

    public static void writeConsole(int output) {
        writeConsole("" + output);
    }

    public static void writeConsole(double output) {
        writeConsole("" + output);
    }

    public static int randomInt(int minval, int maxval) {
        return minval + (new java.util.Random()).nextInt(maxval - minval + 1);
    }

    public static int drawCard() {
        return randomInt(2, 11);
    }

    public static int dice() {
        return randomInt(1, 6);
    }

    public static void printPlayground(int[][] playground) {
        printPlayground(playground, -1, -1, 0, 0);
    }

    public static void printPlayground(int[][] playground, int x, int y, int direction, int blocks) {
        int width = playground.length;
        int height = playground[0].length;
        writeConsole("┏━━━");
        for (int j = 1; j < width; j++)
            writeConsole("┯━━━");
        writeLineConsole("┓");
        for (int k = height - 1; k >= 0; k--) {
            writeConsole("┃ ");
            for (int j = 0; j < width; j++) {
                if (j == x && k == y)
                    writeConsole(formatDirection(direction));
                else
                    writeConsole(formatField(playground, j, k));
                if (j < width - 1)
                    writeConsole(" │ ");
            }
            writeConsole(" ┃");
            if (k == y)
                writeConsole(" Standing on height " + playground[x][y] + ", carrying " + blocks + " ice blocks.");
            if (k != 0) {
                writeLineConsole();
                writeConsole("┠───");
                for (int j = 1; j < width; j++)
                    writeConsole("┼───");
                writeConsole("┨");
            }
            writeLineConsole();
        }
        writeConsole("┗━━━");
        for (int j = 1; j < width; j++)
            writeConsole("┷━━━");
        writeLineConsole("┛");
    }

    private static String formatField(int[][] playground, int x, int y) {
        if (playground[x][y] == -1)
            return "~";
        if (playground[x][y] == 0)
            return " ";
        return String.valueOf(playground[x][y]);
    }

    private static String formatDirection(int dir) {
        return switch (dir) {
            case 0 -> "►";
            case 1 -> "▲";
            case 2 -> "◄";
            case 3 -> "▼";
            default -> throw new IllegalArgumentException("dir: " + dir);
        };
    }

    public static void setRandom() {
        setRandomWithSeed(42, null);
    }

    public static void resetRandom(Random oldRandom) {
        if (rand != null && rand != oldRandom)
            throw new SecurityException("Don't use resetRandom()!");
        rand = null;
    }

    public static Random setRandomWithSeed(int seed, Random oldRandom) {
        if (rand != null && rand != oldRandom)
            throw new SecurityException("Don't use setRandom()!");
        rand = new Random(seed);
        return rand;
    }

    public static void write2DArray (int[][] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr[i].length; j ++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void write2DArray (boolean[][] arr) {
        for (boolean[] booleans : arr) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean + " ");
            }
            System.out.println();
        }
    }
}
