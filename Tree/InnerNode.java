import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class InnerNode<T> implements TreeElement<T> {
    T info;
    TreeElement<T> left;
    TreeElement<T> right;
    public InnerNode(T value) {
        info = value;
        left = new Leaf<>();
        right = new Leaf<>();
    }

    @Override
    public TreeElement<T> insert(T value, Comparator<T> comp) {
        if (comp.compare(value, info) > 0) {
            right = right.insert(value, comp);
        } else {
            left = left.insert(value, comp);
        }
        return this;
    }

    @Override
    public void toString(StringBuilder sb) {
        sb.append(left).append(", ").append(right).append(info);
    }

    @Override
    public int size() {
        return left.size() + right.size() + 1;
    }

    @Override
    public T getMin() {
        if (left instanceof Leaf) return info;
        return left.getMin();
    }

    @Override
    public TreeElement<T> remove(T value, Comparator<T> comp) {
        if (comp.compare(value, info) > 0) {
            right = right.remove(value, comp);
        } else if (comp.compare(value, info) < 0) {
            left = left.remove(value, comp);
        } else {
            if (right instanceof Leaf<T>) {
                return left;
            }
            info = right.getMin();
            right = right.remove(info, comp);
        }

        return this;
    }

    @Override
    public boolean contains(T value, Comparator<T> comp) { // This was different
        if (comp.compare(value, info) == 0) return true;
        if (comp.compare(value, info) > 0) return right.contains(value, comp);
        return left.contains(value, comp);
    }

    @Override
    public int countMatches(Predicate<T> filter) {
        if (filter.test(info)) return 1 + right.countMatches(filter) + left.countMatches(filter);
        return right.countMatches(filter) + left.countMatches(filter);
    }

    @Override
    public int getAll(Predicate<T> filter, T[] array, int index) {
        index = left.getAll(filter, array, index);
        if (filter.test(info)) {
            array[index] = info;
            index ++;
        }
        index = right.getAll(filter, array, index);
        return index;
    }
}
