import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Song song1 = new Song("Hello World", 2005);
        Song song2 = new Song("What is this", 2006);
        Song song3 = new Song("Nani kore", 2007);
        Song song4 = new Song("Ich bin nett", 2008);
        Song song5 = new Song("Hello World", 2005);

        Song[] songs = {song1, song2, song3, song4, song5};

        Album album = new Album("Garbage", 2004);
        System.out.println(album);
    }
}