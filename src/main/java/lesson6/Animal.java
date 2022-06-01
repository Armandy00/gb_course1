package lesson6;

public abstract class Animal {
    String type;
    String name;
    int maxRunDistance;
    int maxSwimDistance;

    public static int count=0;

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        count++;
    }

    public void run(int distanse) {
        if (distanse <= this.maxRunDistance) {
            System.out.println(this.name + " преодолел кросс на дистанцю " + distanse + " метров");
        } else {
            System.out.println(this.name + " не смог закончить кросс на дистанцию " + distanse + " метров");
        }
    }

    public void swim(int distanse) {
        if (this.maxSwimDistance==0) {
            System.out.println(this.name + " не умеет плавать :(");
            return;
        }
        if (distanse <= this.maxSwimDistance) {
            System.out.println(this.name + " преодолел заплыв на дистанцю " + distanse + " метров");
        } else {
            System.out.println(this.name + " не смог закончить заплыв на дистанцию " + distanse + " метров");
        }
    }


}
