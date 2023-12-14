public class List<T> {
    private final T value;
    private List<T> next;

    public T getValue () {
        return value;
    }

    public List<T> getNext () {
        return next;
    }

    public List (T x) {
        if (x == null) ExceptionUtil.illegalArgument("Object must differ from null to create list with solo value");

        value = x;
        next = null;
    }

    public List (T x, List<T> l) {
        if (x == null) ExceptionUtil.illegalArgument("Object must differ from null to create an object with value");

        value = x;
        next = l;
    }

    public void insert (T x) {
        if (x == null) ExceptionUtil.illegalArgument("Object must differ from null to insert.");
        next = new List<T>(x, next);
    }

    public void delete () {
        if (next != null) next = next.getNext();
    }

    public int length () {
        int result = 1;
        for (List<T> t = getNext(); t != null; t = t.getNext()) result ++;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[" + getValue());
        for (List<T> t = getNext(); t != null; t = t.getNext()) result.append(", ").append(t.getValue());
        return result + "]";
    }
}