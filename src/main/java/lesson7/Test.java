package lesson7;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        boolean isFood = true;

        Cat[] cats = {
                new Cat("Ричард", 50),
                new Cat("Ричард2", 40),
                new Cat("Ричард3", 45),
                new Cat("Ричард4", 60)
        };
        Plate[] plates = {
                new Plate("Plate 1", 40),
                new Plate("Plate 2", 20),
                new Plate("Plate 3", 30)
        };

        while (isFood) {
            int countsNotHungry;
            countsNotHungry = 0;
            for (Cat cat : cats) {
                if (cat.isHungry()) {
                    if (cat.eat(plates)) {
                        cat.satietyInfo();
                        Thread.sleep(1000);
                    } else {
                        System.out.println("В мисках закончилась еда");
                        isFood = false;
                        break;
                    }
                } else {
                    countsNotHungry++;
                }
                if (countsNotHungry == cats.length) {
                    System.out.println("Все коты накормлены");
                    isFood = false;
                    break;
                }
            }
        }
    }
}
