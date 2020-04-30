package initialization;

enum PaperCurrencyTypes {
    ONE, TWO, FIVE, TEN, TWENTY, FIFTY
}

/**
 * 以纸币类型创建枚举类，循环输出其值，并且打印它的ordinal()方法。
 */
public class E21_PaperCurrencyTypesEnum {
    public static void main(String[] args) {
        for (PaperCurrencyTypes s : PaperCurrencyTypes.values()) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}
