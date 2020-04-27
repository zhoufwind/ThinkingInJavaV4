package initialization;

/**
 * 当不需要创建对象时，用static方法更为合适
 */
public class E03_DefaultConstructor {
    E03_DefaultConstructor() {
        System.out.println("Default constructor");
    }

    public static void main(String[] args) {
        new E03_DefaultConstructor();
    }
}
