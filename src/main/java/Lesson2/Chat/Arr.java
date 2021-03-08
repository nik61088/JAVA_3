package Lesson2.Chat;

import java.util.Arrays;

public class Arr {

    public int[] extracted(int[] arr) {
        for (int i = arr.length-1; i>=0; i--) {
            if (arr[i] == 4){
               return Arrays.copyOfRange(arr, i+1, arr.length);
            }
        }
        throw new RuntimeException();
    }

}
