package lesson7;

public class Plate {
    private final String label;
    private int countFood;

    public Plate(String label, int countFood) {
        this.countFood = countFood;
        this.label = label;
    }
    public void foodInfo() {
        System.out.println("В миске " + this.label + " осталось корма " + this.countFood + " шт");
    }

    public void decreaseFood(int catEatFoodCount) {
        this.countFood -=catEatFoodCount;
    }

    public int getCountFood() {
        return this.countFood;
    }

    public void additionFood(int countFood) {
        this.countFood+=countFood;
    }
}
