package lesson7;

import java.util.concurrent.ThreadLocalRandom;

public class Cat {
    private final String name;
    private int satiety = 0;
    private final int satietyFull;

    public Cat(String name, int satietyFull) {
        this.name = name;
        this.satietyFull = satietyFull;
    }

    public boolean eat(Plate[] plates) {
        int catEatFoodCount;
        int mayEat = this.satietyFull-this.satiety;
        for (Plate plate : plates) {
            catEatFoodCount = ThreadLocalRandom.current().nextInt(4) + 3;
            if (catEatFoodCount > plate.getCountFood()) {
                catEatFoodCount = plate.getCountFood();
            }
            if (catEatFoodCount > mayEat) {
                catEatFoodCount = mayEat;
            }
            if (catEatFoodCount > 0) {
                plate.decreaseFood(catEatFoodCount);
                this.satiety += catEatFoodCount;
                plate.foodInfo();
                return true;
            }
        }
        return false;
    }

    public void satietyInfo() {
        System.out.println("Текущее чувство насыщение у кота " + this.name + " = " + satiety +
                ". До чувства полного насыщения осталось " + (satietyFull - satiety) + " позиций корма");
    }

    public boolean isHungry() {
        return (this.satietyFull-this.satiety>0);
    }
}
