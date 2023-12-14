public class LinkedQueue<T> implements Queue<T> {
    private T value;
    private LinkedQueue<T> next;
    public LinkedQueue(T x) {
        value = x;
        next = null;
    }

    public LinkedQueue(T x, LinkedQueue<T> l) {
        value = x;
        next = l;
    }

    public T getValue() {
        return value;
    }

    public LinkedQueue<T> getNext() {
        return next;
    }

    @Override
    public int size() {
        int result = 1;
        for (LinkedQueue<T> t = getNext(); t != null; t = t.getNext()) result ++;
        return result;
    }

    @Override
    public void enqueue(T x) {
        LinkedQueue<T> current = this;
        for (int i = 0; i < size() ; i++) {
            if (i == size() - 1) {
                current.next = new LinkedQueue<T>(x, null);
                break;
            }
            current = current.next;
        }
    }

    @Override
    public T dequeue() {
        T output = value;
        if (next != null) value = next.getValue();
        else value = null;

        if (next != null) next = next.next;
        return output;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[" + getValue());
        for (LinkedQueue<T> t = getNext(); t != null; t = t.getNext()) result.append(", ").append(t.getValue());
        return result + "]";
    }
}
