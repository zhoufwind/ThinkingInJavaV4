package initialization;

/**
 * 创建两个静态字符串，一个在定义时初始化，一个在静态代码块中进行初始化。
 * 演示它们是在使用前就初始化了的。
 */
public class E14_StaticStringInitialization {
    static String s1 = "Initialized at definition";
    static String s2;

    static {
        s2 = "Initialized in static block";
    }

    public static void main(String[] args) {
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
