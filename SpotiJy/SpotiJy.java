import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpotiJy {
    private Artist[] artists = new Artist[0];

    public Artist[] getArtists () { return artists; }
    public void addArtists (Artist[] artists) {
        Artist[] result = new Artist[artists.length + this.artists.length];
        List<Artist> existingArtists = new ArrayList<>(Arrays.asList(artists));
        existingArtists.addAll(Arrays.asList(artists));

        for (int i = 0; i < result.length; i ++) result[i] = existingArtists.get(i);
        this.artists = result;
    }

    public String[] getTopTrendingArtist () {
        Artist result = artists[0];
        for (Artist artist : this.artists) if (result.totalLikes() < artist.totalLikes()) result = artist;

        return new String[] {result.getFirstName(), result.getLastName()};
    }

    public String getTopTrendingAlbum () {
        Album mostLiked = artists[0].albums[0];

        for (int i = 0; i < artists.length; i ++) {
            for (int j = 0; j < artists[i].albums.length; j ++) {
                if (mostLiked.getAllLikes() < artists[i].albums[j].getAllLikes()) {
                    mostLiked = artists[i].albums[j];
                }
            }
        }

        return mostLiked.getTitle();
    }

    public String getTopTrendingSong () {
        // Last method to be created

        return "";
    }
}
