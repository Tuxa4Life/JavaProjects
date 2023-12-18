package pgdp.collections;

public class DataStructureLink<T> {
    private DataStructureConnector<T> a;
    private DataStructureConnector<T> b;

    public DataStructureLink(DataStructureConnector<T> a, DataStructureConnector<T> b) {
        if (a == null || b == null)
            ExceptionUtil.illegalArgument("DataStructureConnector must not be null");
        this.a = a;
        this.b = b;
    }

    public void moveAllFromAToB() {
        while (a.hasNextElement()) {
            b.addElement(a.removeNextElement());
        }
    }

    public boolean moveNextFromAToB() {
        if (!a.hasNextElement())
            return false;
        b.addElement(a.removeNextElement());
        return true;
    }
}