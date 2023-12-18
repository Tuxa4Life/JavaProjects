import java.util.HashMap;
import java.util.Map;

public class Cart<T extends MarketItem> {
    Map<T, Integer> cart = new HashMap<>();

    public void addItem(T item, int n) {
        if (item == null) throw new IllegalArgumentException("Item must be non-null object.");
        if (n <= 0) throw new IllegalArgumentException("Amount 'n' must be positive.");

        if (cart.containsKey(item)) cart.put(item, cart.get(item) + n);
        else cart.put(item, n);
    }

    public boolean removeItem (T item, int n) {
        if (n > cart.get(item)) return false;
        if (!cart.containsKey(item)) throw new IllegalArgumentException("Cart doesn't contain this item");

        if (cart.get(item) - n == 0) cart.remove(item);
        else cart.put(item, cart.get(item) - n);

        return true;
    }

    public int calculatePrice() {
        int output = 0;

        for (MarketItem item : cart.keySet()) {
            output += item.getPrice() * cart.get(item);
        }

        return output;
    }

    public int checkout (int money) {
        if (money < 0) throw new IllegalArgumentException("Money must be positive");
        if (money < this.calculatePrice()) return -1;

        int tmp = this.calculatePrice();
        cart = new HashMap<>();

        return money - tmp;
    }

    @Override
    public String toString() { // Instructions didn't limit implementing this function.
        StringBuilder output = new StringBuilder("{\n");
        for (MarketItem item : cart.keySet()) {
            output.append(item).append(" (alloc)").append(" - ").append(cart.get(item)).append("\n");
        }
        return output + "}";
    }
}
