package initialization;

/**
 * 强制垃圾回收，消息打印
 */
public class E11_FinalizeAlwaysCalled {
    protected void finalize() {
        System.out.println("finalize() called");
    }

    public static void main(String[] args) {
        new E11_FinalizeAlwaysCalled();
        System.gc();
        System.runFinalization();
    }
}
