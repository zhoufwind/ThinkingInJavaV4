package initialization;

/**
 * 创建一个叫Tank的类，这个类能够分别被填充和清空。
 * 当对象被清理时，类终结的前提时类必须被清空。
 * 通过写finalize方法来验证终结条件。
 */
class Tank {
    static int counter;
    int id = counter++;
    boolean full;

    public Tank() {
        System.out.println("Tank " + id + " created");
        full = true;
    }

    public void empty() {
        full = false;
    }

    protected void finalize() {
        if (full) {
            System.out.println("Error: tank " + id + " must be empty at cleanup");
        } else {
            System.out.println("Tank " + id + " cleaned up OK");
        }
    }

    @Override
    public String toString() {
        return "Tank{" +
                "id=" + id +
                ", full=" + full +
                '}';
    }
}

public class E12_TankWithTerminationCondition {
    public static void main(String[] args) {
        new Tank().empty();
        new Tank();
        // Don't empty the second one
        System.gc();    // Force finalization
        System.runFinalization();
    }
}

/**
 * Output:
 * Tank 0 created
 * Tank 1 created
 * Error: tank 1 must be empty at cleanup
 * Tank 0 cleaned up OK
 */