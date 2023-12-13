public class Artist {
    private final String firstName, lastName;
    private final int birthYear;
    Album[] albums;
    Song[] singles;

    public Artist (String firstName, String lastName, int birthYear, Album[] albums, Song[] singles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.albums = albums;
        this.singles = singles;
    }

    public String getFirstName () { return this.firstName; }
    public String getLastName () { return this.lastName; }
    public int getBirthYear () { return birthYear; }
    public Album[] getAlbums () { return albums; }
    public Song[] getSingles () { return singles; }

    public Song mostLikedSong () {
        Song result = new Song("Default", 0);

        for (Song single : this.singles) if (single.getLikes() >= result.getLikes()) result = single;
        for (Album album : this.albums) {
            for (int k = 0; k < album.getSongs().length; k++) {
                if (album.getSongs()[k].getLikes() >= result.getLikes()) {
                    result = album.getSongs()[k];
                }
            }
        }

        return result;
    }
    public Song leastLikedSong () {
        Song result = new Song("Default", 0, 60, 9999);

        for (Song single : this.singles) if (single.getLikes() <= result.getLikes()) result = single;
        for (Album album : this.albums) {
            for (int k = 0; k < album.getSongs().length; k++) {
                if (album.getSongs()[k].getLikes() <= result.getLikes()) {
                    result = album.getSongs()[k];
                }
            }
        }

        return result;
    }

    public int totalLikes () {
        int total = 0;

        for (Song single : this.singles) total += single.getLikes();
        for (Album album : this.albums) {
            for (int k = 0; k < album.getSongs().length; k++) {
                total += album.getSongs()[k].getLikes();
            }
        }

        return total;
    }

    public boolean isEqual (Artist other) {
        return this.firstName.equals(other.getFirstName()) &&
                this.lastName.equals(other.getLastName()) &&
                this.birthYear == other.getBirthYear();
    }

    public String toString () {
        return String.format("Name: %s %s,Birth year:%d,Total likes:%d", this.firstName, this.lastName, this.birthYear, totalLikes());
    }
}
