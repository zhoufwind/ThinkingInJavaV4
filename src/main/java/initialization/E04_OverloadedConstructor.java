package initialization;

public class E04_OverloadedConstructor {
    E04_OverloadedConstructor() {
        System.out.println("Default constructor");
    }

    E04_OverloadedConstructor(String s) {
        System.out.println("String arg constructor");
        System.out.println(s);
    }

    public static void main(String[] args) {
        // Call default version:
        new E04_OverloadedConstructor();
        // Call overloaded version:
        new E04_OverloadedConstructor("Overloaded");
    }
}
