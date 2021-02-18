package Lesson1;

public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(1, 2, 3, 4, 5);
        Array<String> array1 = new Array<>(" d ", " w ", " qwerty ");

        array.changeElement();
        System.out.println();
        array1.changeElement();

        System.out.println();
        array.arrayToArrayList();
        array1.arrayToArrayList();
    }
}
