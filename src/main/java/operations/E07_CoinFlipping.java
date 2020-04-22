package operations;

import java.util.Random;

public class E07_CoinFlipping {
    public static void main(String[] args) {
        Random rand = new Random(System.currentTimeMillis());
        boolean flip = rand.nextBoolean();
        System.out.print("OUTCOME: ");
        System.out.println(flip ? "HEAD" : "TAIL");
    }
}
