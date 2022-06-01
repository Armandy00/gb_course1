package lesson6;

public class Main {
    public static void main(String[] args) {
        Animal[] animals= {
                new Cat("Мурзик"),
                new Dog("Бобик"),
                new Cat("Васька"),
                new Dog("Алтай"),
                new Dog("Амур")
        };

        for (Animal animal:animals){
            animal.run(100);
            animal.swim(100);
            System.out.println("_______________________");
        }
        System.out.println("Всего животных: "+ Animal.count + ". Из них собак " + Dog.count + ", кошек "+ Cat.count);
    }
}
