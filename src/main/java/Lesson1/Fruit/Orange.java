package Lesson1.Fruit;

public class Orange extends Fruit{
    private static float orangeWeight = 1.5f;

    public Orange() {
        super(orangeWeight);
    }

    public static float getOrangeWeight() {
        return orangeWeight;
    }
}
