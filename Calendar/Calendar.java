public class Calendar {
    public EventList events;

    public Calendar (EventList events) {
        this.events = events;
    }

    public void addNewEvent(Event e) {
        events = events.addEvent(e);
    }
    public Event[] eventsAt (int day) {
        int length = 0;
        for (EventList e = events; e != null; e = e.getNext()) {
            if (e.getEvent().diff(day) == 0) {
                length ++;
            }
        }

        Event[] arr = new Event[length];
        int index = 0;
        for (EventList e = events; e != null; e = e.getNext()) {
            if (e.getEvent().diff(day) == 0) {
                arr[index] = e.getEvent();
                index ++;
            }
        }

        return arr;
    }

    public Event nextEvent (int day) {
        Event nextEvent = null;
        int minDays = Integer.MAX_VALUE;
        for (EventList current = events; current != null; current = current.getNext()) {
            if (current.getEvent().diff(day) >= 0 && current.getEvent().diff(day) < minDays) {
                nextEvent = current.getEvent();
                minDays = current.getEvent().diff(day);
            }
        }
        return nextEvent;
    }
}
