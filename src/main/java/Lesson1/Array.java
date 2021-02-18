package Lesson1;

import java.util.Arrays;
import java.util.List;

public class Array<T> {
    private T[] nums;

    public Array(T... nums) {
        this.nums = nums;
    }
    public void arrayToArrayList(){

        T[] words = nums;
        List<T> wordList = Arrays.asList(words);
        for (T a : wordList) {
            System.out.println(a);
        }
    }

    public void changeElement(){
        int n = nums.length;
        for (int i = 0; i<n/2; i++){
            T temp;
            temp = nums[n-i-1];
            nums[n-i-1] = nums[i];
            nums[i] = temp;
        }
        for (int i = 0; i< nums.length; i++)
        System.out.print(nums[i]);
    }

}
