package operations;

import java.util.Date;

import static net.mindview.util.Print.print;

public class E01_PrintStatements {
    public static void main(String[] args) {
        Date currDate = new Date();
        System.out.println("Hello, it's: " + currDate);
        print("Hello, it's: " + currDate);
    }
}
