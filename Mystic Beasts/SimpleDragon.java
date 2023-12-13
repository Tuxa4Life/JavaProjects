public class SimpleDragon implements Eats, Flies, BreathesFire {

    @Override
    public void BreatheFire() {
        System.out.println("Dragon breathes fire");
    }

    @Override
    public void eat() {
        System.out.println("Dragon eats");
    }

    @Override
    public void fly() {
        System.out.println("Drag on deez nuts");
    }
}
