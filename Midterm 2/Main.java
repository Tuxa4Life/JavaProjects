public class Main {
    public static void main(String[] args) {
        CarPart item1 = new CarPart("item1", 30);
        CarPart item2 = new CarPart("item2", 50);
        CarPart item3 = new CarPart("item3", 70);

        System.out.println(item1.equals(item2));
    }
}