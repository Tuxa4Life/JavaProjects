import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\Tuxa\\IdeaProjects\\Playground\\src\\index.html");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

        try {
            FileWriter writer = getWriter();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static FileWriter getWriter() throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\Tuxa\\IdeaProjects\\Playground\\src\\index.html");

        writer.write("<html lang='en'>\n");
        writer.write("\t<head>\n");
        writer.write("\t\t<title>Of course this website wasn't created by Java</title>\n");
        writer.write("\t</head>\n");

        writer.write("\t<body>\n");
        writer.write("\t\t<button onclick=\"alert('wanna gex?')\">Don't Click</button>\n");
        writer.write("\t</body>\n");
        writer.write("</html>\n");

        return writer;
    }
}