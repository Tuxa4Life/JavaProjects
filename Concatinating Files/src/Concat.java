import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Concat {
    public static void main (String in1, String in2, String out) {
        File f1 = new File(in1);
        File f2 = new File(in2);
        File output = new File(out);
        List<String> content = new LinkedList<>();

        try {
            Scanner s1 = new Scanner(f1);
            Scanner s2 = new Scanner(f2);
            while (s1.hasNextLine()) {
                content.add(s1.nextLine());
            }
            while (s2.hasNextLine()) {
                content.add(s2.nextLine());
            }


            System.out.println(content);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter writer = new FileWriter(output);
            content.forEach(s -> {
                try {
                    writer.write(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
