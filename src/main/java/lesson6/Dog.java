package lesson6;

public class Dog extends Animal {
    public static int count = 0;

    public Dog(String name) {
        super("Собака", name, 500, 10);
        count++;
    }

}
