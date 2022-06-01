package lesson6;

public class Cat extends Animal {
    public static int count = 0;

    public Cat(String name) {
        super("Кот", name, 200, 0);
        count++;
    }
}
