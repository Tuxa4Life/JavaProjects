import java.util.Objects;

public class CarPart implements MarketItem {
    private final String name;
    private final int price;

    public String getName() {
        return name;
    }

    public CarPart(String name, int price) {
        if (name.isEmpty()) throw new IllegalArgumentException("Name must be non-empty string.");
        if (price <= 0) throw new IllegalArgumentException("Price amount must be positive");
        this.name = name;
        this.price = price;
    }

    public boolean equals(CarPart obj) {
        if (obj == null) return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
