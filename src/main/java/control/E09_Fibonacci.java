package control;

/**
 * 递归计算斐波纳切数列
 */
public class E09_Fibonacci {
    static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n < 0) {
            System.out.println("Cannot use negative numbers");
            return;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(fib(i) + ", ");
        }
    }
}
