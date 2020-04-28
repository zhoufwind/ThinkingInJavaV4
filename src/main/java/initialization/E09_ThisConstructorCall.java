package initialization;

/**
 * 创建一个类，包含2个构造函数，并且函数重载。
 * 在第一个构造函数中调用第二个构造函数。
 * 本例展示了必须使用 this 的场景。
 */
public class E09_ThisConstructorCall {
    public E09_ThisConstructorCall(String s) {
        System.out.println("s = " + s);
    }

    public E09_ThisConstructorCall(int i) {
        this("i = " + i);
    }

    public static void main(String[] args) {
        new E09_ThisConstructorCall("String call");
        new E09_ThisConstructorCall(47);
    }
}
