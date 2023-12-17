public class Main extends MiniJava {
    public static void main(String[] args) {
        int k = readInt("Please indicate number:");

        if (k < 1) {
            write("Error: number >= 1 expected!");
        } else {
            int[] integers = new int[k];
            for (int i = 0; i < k; i++) {
                int number = readInt("Please insert integer:");
                integers[i] = number;
            }

            int max = integers[0];
            for (int i = 1; i < integers.length; i++) {
                if (integers[i] > max) {
                    max = integers[i];
                }
            }

            write("Maximum:");
            write(max);
        }



        // Two maximums
        k = readInt("Please indicate number:");

        if (k < 2) {
            write("Error: number >= 2 expected!");
        } else {
            int[] integers = new int[k];
            for (int i = 0; i < k; i++) {
                int number = readInt("Please insert integer:");
                integers[i] = number;
            }

            int max = integers[0];
            int secondMax = integers[0];
            for (int i = 1; i < integers.length; i++) {
                if (integers[i] > max) {
                    max = integers[i];
                    integers[i] = 0;
                }
            }
            for (int i = 1; i < integers.length; i++) {
                if (integers[i] > secondMax) {
                    secondMax = integers[i];
                    integers[i] = 0;
                }
            }

            write("First:");
            write(max);
            write("Second:");
            write(secondMax);
        }
    }
}