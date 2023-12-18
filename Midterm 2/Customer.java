public class Customer {
    private final String name;
    private int money;
    private Cart<MarketItem> cart;

    public Cart<MarketItem> getCart() {
        return cart;
    }

    public int getMoney() {
        return money;
    }

    public Customer(String name, int money) {
        if (name.isEmpty()) throw new IllegalArgumentException("Please input non empty string.");
        if (money <= 0) throw new IllegalArgumentException("Please input positive value.");


        this.name = name;
        this.money = money;
        cart = new Cart<>();
    }

    public void addItemToCart(MarketItem item, int n) {
        cart.addItem(item, n);
    }
    public boolean removeItemFromCart (MarketItem item, int n) {
        return cart.removeItem(item, n);
    }
    public boolean buyItemsFromCart () {
        if (cart.checkout(money) < 0) return false;
        cart.checkout(money);
        return true;
    }
}
