public class Mechanic extends Customer {
    private final int reduction;

    public Mechanic(String name, int money, int reduction) {
        super(name, money);
        if (reduction < 0) throw new IllegalArgumentException("Reduction value must be non-negative");

        this.reduction = reduction;
    }

    @Override
    public boolean buyItemsFromCart() throws IllegalArgumentException {
        double reduced = getMoney() - getMoney() * reduction * 0.01;

        if (getCart().checkout(getMoney() - (int) reduced) < 0) return false;
        getCart().checkout(getMoney() - (int) reduced);
        return true;
    }
}
