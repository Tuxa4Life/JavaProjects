public interface DataStructure<T> {
    int size();
    default boolean isEmpty(T x) {
        return x == null;
    }
}
