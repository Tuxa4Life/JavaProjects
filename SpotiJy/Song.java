public class Song {
    // Attributes
    private final String title;
    private final int releaseYear;
    private int duration;
    private int likes;

    // Constructors
    public Song (String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }
    public Song (String title, int releaseYear, int duration) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = 0;
    }
    public Song (String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }

    // Getters
    public String getTitle () {
        return this.title;
    }
    public int getReleaseYear () {
        return this.releaseYear;
    }
    public int getDuration () {
        return this.duration;
    }
    public int getLikes () {
        return this.likes;
    }

    // Setters
    public boolean changeDuration (int duration) {
        if (duration < 0 || duration > 720) return false;

        this.duration = duration;
        return true;
    }
    public void like () {
        this.likes ++;
    }
    public void unlike () {
        if (this.likes - 1 >= 0) this.likes --;
    }

    // Overrides
    public String toString () {
        return String.format("Title:%s,Duration:%.1f minutes,Release year:%d,Likes:%d", this.title, (double) this.duration / 60, this.releaseYear, this.likes);
    }
    public boolean isEqual (Song other) {
        return this.title.equals(other.getTitle()) &&
                this.duration == other.getDuration() &&
                this.releaseYear == other.getReleaseYear() &&
                this.likes == other.getLikes();
    }
}
