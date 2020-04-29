package initialization;

/**
 * 创建一个类，初始化时使用一个叫"instance initialization"的字符串。
 */
public class E15_StringInstanceInitialization {
    String s;

    {
        s = "'instance initialization'";
    }

    public E15_StringInstanceInitialization() {
        System.out.println("Default constructor: s = " + s);
    }

    public E15_StringInstanceInitialization(int i) {
        System.out.println("int constructor: s = " + s);
    }

    public static void main(String[] args) {
        new E15_StringInstanceInitialization();
        new E15_StringInstanceInitialization(1);
    }
}
