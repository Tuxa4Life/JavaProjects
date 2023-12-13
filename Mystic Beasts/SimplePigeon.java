public class SimplePigeon implements Eats, Flies {

    @Override
    public void fly() {
        System.out.println("Pigeon flies");
    }

    @Override
    public void eat() {
        System.out.println("Pigeon eats");
    }
}
