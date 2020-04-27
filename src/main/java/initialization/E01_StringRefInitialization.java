package initialization;

/**
 * 未初始化的字符串引用，Java将该引用初始化为null
 */
public class E01_StringRefInitialization {
    String s;

    public static void main(String[] args) {
        E01_StringRefInitialization sri = new E01_StringRefInitialization();
        System.out.println("sri.s = " + sri.s);
    }
}
