import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Album {
    private final String title;
    private final int releaseYear;
    private Song[] songs = new Song[0];

    public Album (String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle () {
        return this.title;
    }
    public int getReleaseYear () {
        return this.releaseYear;
    }
    public Song[] getSongs () {
        return this.songs;
    }

    public int addSongs (Song[] songs) {
        List<Song> existingSongs = new ArrayList<>(Arrays.asList(this.songs));
        int added = 0;

        for (Song newSong : songs) {
            boolean isDuplicate = false;
            for (Song existingSong : existingSongs) {
                if (existingSong.isEqual(newSong)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                existingSongs.add(newSong);
                added ++;
            }
        }

        Song[] tmp = new Song[existingSongs.size()];
        for (int i = 0; i < tmp.length; i++) tmp[i] = existingSongs.get(i);

        this.songs = tmp;
        return added;
    }

    public int getAllLikes () {
        int total = 0;

        for (Song song : songs) total += song.getLikes();
        return total;
    }
    
    public static Song[] reverse (Song[] songs) {
        Song[] reversed = new Song[songs.length];
        
        for (int i = 0; i < songs.length; i ++) {
            reversed[i] = songs[songs.length - 1 - i];
        }
        
        return reversed;
    }

    public Song[] shuffle () {
        Song[] result = new Song[this.songs.length];

        List<Song> shuffled = new ArrayList<>(Arrays.asList(this.songs));
        Collections.shuffle(shuffled);

        for (int i = 0; i < this.songs.length; i ++) {
            result[i] = shuffled.get(i);
        }

        return result;
    }

    public Song[] sortByTitle (boolean isAscending) {
        Song[] result = this.songs;

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].getTitle().compareTo(result[j].getTitle()) > 0) {
                    Song temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }

        return isAscending ? result : reverse(result);
    }

    public Song[] sortByDuration (boolean isAscending) {
        Song[] result = new Song[this.songs.length];
        for (int i = 0; i < this.songs.length; i++) {
            int j = 0;

            while (j < i && this.songs[i].getDuration() >= result[j].getDuration()) j++;
            for (int k = i-1; k >= j; k--) result[k+1] = result[k];

            result[j] = this.songs[i];
        }

        return  isAscending ? result : reverse(result);
    }

    public Song[] sortByReleaseYear (boolean isAscending) {
        Song[] result = new Song[this.songs.length];
        for (int i = 0; i < this.songs.length; i++) {
            int j = 0;

            while (j < i && this.songs[i].getReleaseYear() >= result[j].getReleaseYear()) j++;
            for (int k = i-1; k >= j; k--) result[k+1] = result[k];

            result[j] = this.songs[i];
        }

        return  isAscending ? result : reverse(result);
    }

    public Song[] sortByPopularity (boolean isAscending) {
        Song[] result = new Song[this.songs.length];
        for (int i = 0; i < this.songs.length; i++) {
            int j = 0;

            while (j < i && this.songs[i].getLikes() >= result[j].getLikes()) j++;
            for (int k = i-1; k >= j; k--) result[k+1] = result[k];

            result[j] = this.songs[i];
        }

        return  isAscending ? result : reverse(result);
    }

    public String toString () {
        String songOutput = "{";
        for (int i = 0; i < this.songs.length; i ++) {
            songOutput += this.songs[i];
            if (i != this.songs.length - 1) songOutput += "|";
        }
        songOutput +="}";

        return String.format("Title:%s,Release year:%d,songs:%s", this.title, this.releaseYear, songOutput);
    }
}