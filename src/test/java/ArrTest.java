import Lesson2.Chat.Arr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArrTest {
    private Arr arr;

    @Test
    public void testExtracted(){
        Arr a = new Arr();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] result = a.extracted(arr);
        int[] arrNew = {5, 6};
        //Assertions.assertArrayEquals(arrNew, result);
        Assert.assertArrayEquals(arrNew, result);
    }
}
