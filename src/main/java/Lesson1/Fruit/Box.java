package Lesson1.Fruit;

import java.util.*;

public class Box<T extends Fruit>{
    private List <T> boxFruit = new ArrayList<>();


    public float getWeight(){

        float weight = 0;
        T fruit = boxFruit.get(0);

        if (boxFruit.contains(fruit)){
            weight = boxFruit.size()*fruit.getWeight();
        }
        return weight;
    }

    public void add(T x){
        boxFruit.add(x);
    }

    public void remove(T x){
        boxFruit.remove(x);
    }

    public boolean compare(Box<?> box){                //true - если их веса равны
        if (getWeight() == box.getWeight()) {
          return true;
        }
        return false;
    }

    public void pour(Box<T> box){ // не работает корректно

        if (box == null){

            box.boxFruit.addAll(boxFruit);
            boxFruit.clear();
            return;
        }

    }



}
