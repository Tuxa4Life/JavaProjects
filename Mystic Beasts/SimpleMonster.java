public class SimpleMonster implements Eats, BreathesFire{
    @Override
    public void BreatheFire() {
        System.out.println("Monster breathes fire");
    }

    @Override
    public void eat() {
        System.out.println("Monster eats");
    }
}
