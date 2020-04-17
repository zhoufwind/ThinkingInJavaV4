package operations;

import static net.mindview.util.Print.print;

public class E03_Aliasing2 {

    // passing references
    static void f(Integral y) {
        y.f = 1.0f;
    }

    public static void main(String[] args) {
        Integral x = new Integral();
        x.f = 2.0f;
        print("1: x.f: " + x.f);
        f(x);
        print("2: x.f: " + x.f);
    }
}
