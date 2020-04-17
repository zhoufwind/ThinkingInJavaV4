package operations;

class Dog {
    String name;
    String says;
}

public class E05_Dogs {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        dog1.name = "spot";
        dog1.says = "ruff!";
        dog2.name = "scruffy";
        dog2.says = "wuff!";
        System.out.println(dog1.name + " says " + dog1.says);
        System.out.println(dog2.name + " says " + dog2.says);
    }
}
