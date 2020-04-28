package initialization;

/**
 * 创建一个类，包含了finalize方法
 * 因为程序无法生成足够多的垃圾来进行回收操作，所以运行后大概率看不到消息打印。
 */
public class E10_FinalizeCall {
    protected void finalize() {
        System.out.println("finalize() called");
    }

    public static void main(String[] args) {
        new E10_FinalizeCall();
    }
}
