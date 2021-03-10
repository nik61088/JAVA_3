package Lesson1.Fruit;


public class Market {


    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        System.out.println("Вес одного яблока = "+apple.getWeight());
        System.out.println("Вес одного апельсина = "+orange.getWeight());


        appleBox.add(apple);
        appleBox.add(apple);
        appleBox.add(apple);
        appleBox.add(apple);
        appleBox.add(apple);
        appleBox.add(apple);

        orangeBox.add(orange);
        orangeBox.add(orange);
        orangeBox.add(orange);
        orangeBox.add(orange);
        orangeBox.add(orange);


        System.out.println("Общий вес ящика с яблоками: "+appleBox.getWeight());
        System.out.println("Общий вес ящика с апельсинами: "+orangeBox.getWeight());

        System.out.println("True - веса равны, False - не равны: "+appleBox.compare(orangeBox));

        Box<Apple> appleBox1 = new Box<>();

        appleBox.pour(appleBox1);

        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());

    }
}
