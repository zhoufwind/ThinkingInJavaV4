package control;

import java.util.Random;

/**
 * 生成（伪）随机数，判断值大小
 */
public class E02_RandomInts {
    static Random r = new Random(47);

    public static void compareRand() {
        int a = r.nextInt();
        int b = r.nextInt();
        System.out.println("a = " + a + ", b = " + b);
        if (a < b) {
            System.out.println("a < b");
        } else if (a > b) {
            System.out.println("a > b");
        } else {
            System.out.println("a = b");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            compareRand();
        }
    }
}
