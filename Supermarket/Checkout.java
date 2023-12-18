package pgdp.collections;

public class Checkout {
    private Queue<PenguinCustomer> penguins;
    private Queue<FishyProduct> bandBeforeCashier;
    private Queue<FishyProduct> bandAfterCashier;

    public Checkout() {
        penguins = new LinkedQueue<>();
        bandAfterCashier = new LinkedQueue<>();
        bandBeforeCashier = new LinkedQueue<>();
    }

    public Queue<PenguinCustomer> getQueue() {
        return penguins;
    }

    public Queue<FishyProduct> getBandBeforeCashier() {
        return bandBeforeCashier;
    }

    public Queue<FishyProduct> getBandAfterCashier() {
        return bandAfterCashier;
    }

    public void serveNextCustomer() {
        if (!penguins.isEmpty()) {
            PenguinCustomer next = penguins.dequeue();
            next.placeAllProductsOnBand(bandBeforeCashier);
            int sum = scanAllProducts();
            next.takeAllProductsFromBand(bandAfterCashier);
            next.pay(sum);
        }
    }

    public int queueLength() {
        return penguins.size();
    }

    void close(PenguinSupermarket supermarket) {
        Stack<PenguinCustomer> ps = new LinkedStack<>();
        DataStructureLink<PenguinCustomer> link = new DataStructureLink<>(new QueueConnector<>(penguins),
                new StackConnector<>(ps));
        // this effectively reverses the PenguinCustomers in the Queue
        link.moveAllFromAToB();
        while (!ps.isEmpty()) {
            ps.pop().goToCheckout(supermarket);
        }
    }

    private int scanAllProducts() {
        int sum = 0;
        while (!bandBeforeCashier.isEmpty()) {
            FishyProduct fp = bandBeforeCashier.dequeue();
            sum += fp.getPrice();
            bandAfterCashier.enqueue(fp);
        }
        return sum;
    }

    @Override
    public String toString() {
        return penguins.toString();
    }
}