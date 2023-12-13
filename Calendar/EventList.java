public class EventList {
    private Event event;
    private EventList next;

    public EventList (Event event) {
        this.event = event;
        next = null;
    }
    public EventList (Event event, EventList next) {
        this.event = event;
        this.next = next;
    }

    public Event getEvent() {
        return event;
    }

    public EventList getNext() {
        return next;
    }

    public EventList addEvent (Event event) {
        return new EventList(event, this);
    }

    @Override
    public String toString() {
        String output = "{\n" + this.event;
        for (EventList l = this.next; l != null; l = l.next) {
            output += ", \n" + l.event;
        }
        output += "\n}";

        return output;
    }
}
