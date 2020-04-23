package operations;

/**
 * 不同对象，相同值，用equals()判断值是否相同
 * 相同对象，相同值，用==判断对象或值是否相同
 */
public class E14_CompareStrings {
    public static void p(String s, boolean b) {
        System.out.println(s + ": " + b);
    }

    public static void compare(String lval, String rval) {
        System.out.println("lval: " + lval + " rval: " + rval);
        p("lval == rval: ", lval == rval);
        p("lval != rval: ", lval != rval);
        p("lval.equals(rval)", lval.equals(rval));
    }

    public static void main(String[] args) {
        compare("Hello", "Hello");
        // Force creation of separate object:
        String s = new String("Hello");
        compare("Hello", s);
        compare("Hello", "Goodbye");
    }
}
