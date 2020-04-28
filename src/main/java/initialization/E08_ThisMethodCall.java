package initialization;

/**
 * 用this代表当前对象
 * 只有在必须的时候用this，否则会增加阅读代码的困难度
 */
public class E08_ThisMethodCall {
    public void a() {
        b();
        this.b();
    }

    public void b() {
        System.out.println("b() called");
    }

    public static void main(String[] args) {
        new E08_ThisMethodCall().a();
    }
}
