package pgdp.collections;

public class PenguinCustomer {
    private final String name;
    private final Stack<FishyProduct> products;
    private int money;

    public PenguinCustomer(String name, int money) {
        if (name == null)
            ExceptionUtil.illegalArgument("name must not be null");
        this.name = name;
        if (money < 0)
            ExceptionUtil.illegalArgument("money must not be negative: " + money);
        this.money = money;
        this.products = new LinkedStack<>();
    }

    public String getName() {
        return name;
    }

    public Stack<FishyProduct> getProducts() {
        return products;
    }

    public int getMoney() {
        return money;
    }

    public void addProductToBasket(FishyProduct product) {
        products.push(product);
    }

    public void placeAllProductsOnBand(Queue<FishyProduct> band) {
        DataStructureLink<FishyProduct> dsl = new DataStructureLink<>(new StackConnector<>(products),
                new QueueConnector<>(band));
        dsl.moveAllFromAToB();
    }

    public void takeAllProductsFromBand(Queue<FishyProduct> band) {
        DataStructureLink<FishyProduct> dsl = new DataStructureLink<>(new QueueConnector<>(band),
                new StackConnector<>(products));
        dsl.moveAllFromAToB();
    }

    public void goToCheckout(PenguinSupermarket supermarket) {
        supermarket.getCheckoutWithSmallestQueue().getQueue().enqueue(this);
    }

    public void pay(int amount) {
        if (amount < 0)
            ExceptionUtil.illegalArgument("paying a negative amount is not allowed: " + amount);
        if (money - amount < 0)
            ExceptionUtil.unsupportedOperation(name + " cannot pay " + amount);
        money -= amount;
    }

    @Override
    public String toString() {
        return "Customer " + name + ", money: " + money + ", products: " + products;
    }
}