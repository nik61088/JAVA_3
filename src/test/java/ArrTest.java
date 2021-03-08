import Lesson2.Chat.Arr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArrTest {
    private Arr a = new Arr();

    @Test
    public void testExtracted(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] result = a.extracted(arr);
        int[] arrNew = {5, 6};
        //Assertions.assertArrayEquals(arrNew, result);
        Assert.assertArrayEquals(arrNew, result);
    }

    @Test
    public void testExtracted2(){
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] result = a.extracted(arr);
        int[] arrNew = {1, 7};
        Assert.assertArrayEquals(arrNew, result);
    }

    @Test(expected = RuntimeException.class)
    public void testExtracted3(){
        int[] arr = {7};
        int[] result = a.extracted(arr);
        int[] arrNew = {};
        Assert.assertArrayEquals(arrNew, result);
    }

    @Test
    public void oneOrFour1(){
        int[] arr = {7};
        Assert.assertFalse(a.oneOrFour(arr));
    }

    @Test
    public void oneOrFour3(){
        int[] arr = {7};
        Assert.assertTrue(a.oneOrFour(arr));
    }

    @Test
    public void oneOrFour2(){
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assert.assertFalse(a.oneOrFour(arr));
    }

    @Test
    public void oneOrFour4(){
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assert.assertTrue(a.oneOrFour(arr));
    }
    @Test
    public void oneOrFour5(){
        int[] arr = {1, 4, 4, 1};
        Assert.assertTrue(a.oneOrFour(arr));
    }
    @Test
    public void oneOrFour6(){
        int[] arr = {1, 1};
        Assert.assertTrue(a.oneOrFour(arr));
    }
    @Test
    public void oneOrFour7(){
        int[] arr = {1, 1};
        Assert.assertFalse(a.oneOrFour(arr));
    }
}
