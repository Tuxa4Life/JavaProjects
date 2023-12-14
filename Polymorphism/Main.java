class A {
    int x() {
        return 0;
    }

    int y = 3;

    static void f(A a) {
        System.out.print(a.x() + "-");
        a.g(a);
    }

    static void f(B b) {
        System.out.print(b.y + "-");
        b.g(b);
    }

    void g(A a) {
        System.out.println(a.y);
    }

    void g(B b) {
        System.out.print(b.y + "-");
        this.f(this);
    }
}

class B extends A {
    int x() {
        return 1;
    }

    int y = 9;

    static void f(A a) {
        System.out.print(a.y + "-");
        (new A()).g(a);
    }

    static void f(B b) {
        System.out.print(b.y + "-");
        ((B) b).f((A) b);
    }

    void g(A a) {
        System.out.print(a.y + "-");
        a.f((B) a);
    }

    void g(B b) {
        System.out.print(b.x() + "-");
        b.f(b);
    }
}

public class Main extends MiniJava {
    public static void main(String[] args) {
        A aStatic = new A();
        A aDynamic = new B();
        B bStatic = new B();

        bStatic.f(bStatic); // 9 - 3 - 3
        aStatic.g(bStatic); // 9 - 0 - 3
        aDynamic.f(bStatic); // 9 - 1 - 9 - 3 - 3
        aDynamic.g(aStatic); // error
        aDynamic.f(aDynamic); // 1 - 3 - 9 - 1 - 9 - 3 - 3   why?
    }
}