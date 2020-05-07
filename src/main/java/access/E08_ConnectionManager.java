package access;

import access.connection.Connection;
import access.connection.ConnectionManager;

/**
 * Connection类的包权限，不允许直接调用，需要通过ConnectionManager类间接进行调用；
 */
public class E08_ConnectionManager {
    public static void main(String[] args) {
        Connection c = ConnectionManager.getConnection();
        while (c != null) {
            System.out.println(c);
            c.doSomething();
            c = ConnectionManager.getConnection();
        }
    }
}
