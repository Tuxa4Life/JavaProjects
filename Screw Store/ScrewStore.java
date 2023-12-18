package fop.w9store;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class ScrewStore {
    private HashMap<Screw, Integer> stock;
    private LinkedList<Order> orders;

    public ScrewStore() {
        stock = new HashMap<>();
        orders = new LinkedList<>();
    }

    public void addItem(Screw type, int amount) {
        Integer current = stock.get(type);
        if (current == null)
            stock.put(type, amount);
        else
            stock.put(type, amount + current);
    }

    public void takeOrder(Screw type, int amount) {
        if (amount > 0)
            orders.add(new Order(type, amount));
    }

    public boolean executeOrder() {
        if (orders.isEmpty())
            return false;
        Order order = orders.getFirst();
        Integer amount = stock.get(order.getScrew());
        if (amount != null) {
            if (amount == order.getAmount()) {
                stock.remove(order.getScrew());
                return true;
            }
            if (amount > order.getAmount()) {
                stock.put(order.getScrew(), amount - order.getAmount());
                return true;
            }
        }
        return false;
    }

    public void inflation(double percent) {
        for (Screw key : stock.keySet())
            key.setPrice(key.getPrice() * (1 + percent));
    }

    public int count() {
        int count = 0;
        for (Integer i : stock.values())
            count += i;
        return count;
    }

    public double value() {
        double value = 0;
        for (Entry<Screw, Integer> entry : stock.entrySet())
            value += entry.getKey().getPrice() * entry.getValue();
        return value;
    }

    public String stockToString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<Screw, Integer> entry : stock.entrySet())
            sb.append(entry.getValue() + "x " + entry.getKey() + "\n");
        return sb.toString();
    }

    public HashMap<Screw, Integer> getStock() {
        return stock;
    }
}