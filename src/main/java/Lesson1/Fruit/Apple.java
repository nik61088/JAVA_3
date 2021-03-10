package Lesson1.Fruit;

public class Apple extends Fruit {
    private static float appleWeight = 1.0f;


    public Apple() {
        super(appleWeight);
    }

    public static float getAppleWeight() {
        return appleWeight;
    }
}
