public class Event {
    private int day;
    private String description, place;

    public Event (int day, String description, String place) {
        this.day = day;
        this.description = description;
        this.place = place;
    }

    public int getDay () {
        return day;
    }
    public String getDescription () {
        return description;
    }
    public String getPlace () {
        return place;
    }

    public int diff (int day) {
        return day - this.day;
    };

    @Override
    public String toString() {
        return String.format("place: %s, desc: %s, day: %d", place, description, day);
    }
}
