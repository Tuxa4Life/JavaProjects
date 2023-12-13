public class RepeatEvent extends InfiniteRepeatEvent {
    private int end;

    public RepeatEvent(int day, String description, String place, int period, int end) {
        super(day, description, place, period);

        this.end = end;
    }

    public int getEnd() {
        return end;
    }

    public int diff(int day) {
        if (day > end)
            return end - day;
        else
            return super.diff(day);
    }

    @Override
    public String toString() {
        return String.format("place: %s, desc: %s, day: %d, period: %d, end: %d", getPlace(), getDescription(), getDay(), getPeriod(), end);
    }
}
