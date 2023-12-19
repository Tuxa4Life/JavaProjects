public class Penguin extends Animal implements Comparable, Copyable{
    public String name;
    public double height;

    public Penguin(String name, double height, int age) {
        super(age);

        this.name = name;
        this.height = height;
    }


    public int compareTo(Penguin other) {
        if (age > other.age) return 1;
        if (age < other.age) return -1;

        if (height > other.height) return 1;
        if (height < other.height) return -1;

        if (name.compareTo(other.name) > 0) return 1;
        if (name.compareTo(other.name) < 0) return -1;

        return 0;
    }

    public Penguin copy() {
        return new Penguin(name, height, age);
    }
}
