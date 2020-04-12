package object;

public class E05_DataOnly2 {
    public static void main(String[] args) {
        E04_DataOnly d = new E04_DataOnly();
        d.i = 47;
        System.out.println("d.i = " + d.i);
        d.d = 1.1;
        System.out.println("d.d = " + d.d);
        d.b = false;
        System.out.println("d.b = " + d.b);
    }
}
