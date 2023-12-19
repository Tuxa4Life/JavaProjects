public class Main extends MiniJava {
    public static void print(int[] arr) {
        writeConsole("{");
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) writeConsole(arr[i] + ", ");
            else writeConsole(arr[i]);
        }
        writeConsole("}");
    }

    public static void minAndMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int j : arr) {
            if (min > j) min = j;
            if (max < j) max = j;
        }

        writeConsole("Minimum = " + min + ", Maximum = " + max);
    }

    public static int[] invert(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return  arr;
    }

    public static int[] cut(int[] arr, int len) {
        int[] tmp = new int[len];

        for (int i = 0; i < len; i++) {
            if (i < arr.length) tmp[i] = arr[i];
            else break;

        }

        return tmp;
    }

    public static int[] linearize(int[][] arr) {
        int length = 0;
        for (int k = 0; k < arr.length; k++) {
            length += arr[k].length;
        }

        int[] result = new int[length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[index] = arr[i][j];
                index++;
            }
        }

        return result;
    }

    public static void main (String[] args) {
        
    }
}