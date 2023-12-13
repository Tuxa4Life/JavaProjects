public class InfiniteRepeatEvent extends Event {
    private int period;

    public InfiniteRepeatEvent(int day, String description, String place, int period) {
        super(day, description, place);

        this.period = period;
    }

    public int getPeriod () {
        return period;
    }

    public int diff (int day) {
        if (day < getDay())
            return super.diff(day);
        else
            return (super.diff(day) % period + period) % period;
    }

    public String toString() {
        return String.format("place: %s, desc: %s, day: %d, period: %d", getPlace(), getDescription(), getDay(), period);
    }
}
