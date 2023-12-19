public class Main extends MiniJava {
    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[i].length; j++) {
                switch (world[i][j]) {
                    case 0 -> writeConsole("L");
                    case 1 -> writeConsole("I");
                    case 2 -> writeConsole("W");
                    case 3 -> writeConsole("S");
                    case 4 -> writeConsole("F");
                }
                if (i == pinguRow && j == pinguColumn) {
                    writeConsole("(P)");
                }
                if (j != world[i].length - 1) {
                    writeConsole("\t");
                }
            }
            writeLineConsole();
        }
    }

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn) {
        boolean[][] visited = new boolean[world.length][world[0].length];
        return isFishReachable(world, pinguRow, pinguColumn, visited);
    }

    public static boolean isFishReachable (int[][] world, int pinguRow, int pinguColumn,  boolean[][] visited){
        if (pinguRow < 0 || pinguRow >= world.length || pinguColumn < 0 || pinguColumn >= world[0].length) {
            return false;
        }
        if (world[pinguRow][pinguColumn] == 3) {
            return false;
        }
        if (visited[pinguRow][pinguColumn]) {
            return false;
        }

        visited[pinguRow][pinguColumn] = true;
        return switch (world[pinguRow][pinguColumn]) {
            case 0 -> isFishReachable(world, pinguRow - 1, pinguColumn, visited) || isFishReachable(world, pinguRow + 1, pinguColumn, visited) || isFishReachable(world, pinguRow, pinguColumn - 1, visited) || isFishReachable(world, pinguRow, pinguColumn + 1, visited);
            case 1 -> isFishReachable(world, pinguRow - 1, pinguColumn - 1, visited) || isFishReachable(world, pinguRow + 1, pinguColumn - 1, visited) || isFishReachable(world, pinguRow + 1, pinguColumn + 1, visited) || isFishReachable(world, pinguRow - 1, pinguColumn + 1, visited);
            case 2 -> isFishReachable(world, pinguRow - 3, pinguColumn - 3, visited) || isFishReachable(world, pinguRow - 3, pinguColumn + 3, visited) || isFishReachable(world, pinguRow + 3, pinguColumn - 3, visited) || isFishReachable(world, pinguRow + 3, pinguColumn + 3, visited);
            case 4 -> true;
            default -> false;
        };
    }

    public static int[][] generateExampleWorldOne(){
        return new int[][] {{2,3,3,3,3,3}, {3,0,3,3,4,3}, {3,3,3,3,3,1}, {3,3,3,0,1,3}, {3,3,3,3,3,3}};
    }

    public static int[][] generateExampleWorldTwo(){
        return new int[][] {{0,0,0,2}, {0,0,0,1}, {0,1,3,4}, {3,4,3,3}};
    }

    public static void main(String[] args){
        int pinguRow = 0;
        int pinguColumn = 0;
        int[][] world = generateExampleWorldOne();
        printWorld(world, pinguRow, pinguColumn);


        write(""+isFishReachable(world, pinguRow, pinguColumn));
    }
}