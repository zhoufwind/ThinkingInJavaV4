package object;

import java.util.Date;

/**
 * The first Thinking in Java example program.
 * Displays a string and today's date.
 * @author Bruce Eckel
 * @author www.MindView.net
 * @version 4.0
 * @see <a href="https://blog.csdn.net/vbirdbest/article/details/80296136">Javadoc 使用详解</a>
 */
public class E12_HelloDateJavaDoc {
    /** Entry point to class and application.
     *
     * @param args array of string arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's: ");
        System.out.println(new Date());
    }
}
