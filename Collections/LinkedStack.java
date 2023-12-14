public class LinkedStack<T>  implements Stack<T> {
    private T value;
    private LinkedStack<T> next;
    public LinkedStack(T x) {
        value = x;
        next = null;
    }

    public LinkedStack(T x, LinkedStack<T> l) {
        value = x;
        next = l;
    }

    public LinkedStack<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public int size() {
        int result = 1;
        for (LinkedStack<T> t = getNext(); t != null; t = t.getNext()) result ++;
        return result;
    }

    @Override
    public void push(T x) {
        next = new LinkedStack<T>(value, next);
        value = x;
    }

    @Override
    public T pop() {
        T output = value;
        if (next != null) value = next.getValue();
        else value = null;

        if (next != null) next = next.next;
        return output;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[" + getValue());
        for (LinkedStack<T> t = getNext(); t != null; t = t.getNext()) result.append(", ").append(t.getValue());
        return result + "]";
    }
}
