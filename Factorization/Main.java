public class Main extends MiniJava {
    public static void main(String[] args) {
        int n = readInt();

        if (n <= 1) {
            write("Error: n>1 expected!");
        } else {
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    if (i == n) {
                        writeConsole(i);
                    } else {
                        writeConsole(i + " ");
                    }
                    n /= i;
                }
            }
        }
    }
}