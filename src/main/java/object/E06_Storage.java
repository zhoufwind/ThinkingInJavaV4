package object;

public class E06_Storage {
    String s = "Hello, World!";

    int storage(String s) {
        return s.length() * 2;
    }

    void print() {
        System.out.println("storage(s) = " + storage(s));
    }

    public static void main(String[] args) {
        E06_Storage st = new E06_Storage();
        st.print();
    }
}
