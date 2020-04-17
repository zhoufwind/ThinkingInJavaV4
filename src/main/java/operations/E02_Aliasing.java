package operations;

import static net.mindview.util.Print.print;

class Integral {
    float f;
}

public class E02_Aliasing {
    public static void main(String[] args) {
        Integral n1 = new Integral();
        Integral n2 = new Integral();
        n1.f = 9f;
        n2.f = 47f;
        print("1: n1.f: " + n1.f + ", n2.f: " + n2.f);
        // n1指向n2对象
        n1 = n2;
        print("2: n1.f: " + n1.f + ", n2.f: " + n2.f);
        n1.f = 27f;
        print("3: n1.f: " + n1.f + ", n2.f: " + n2.f);
    }
}
