package sudoku;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UtilsTest {

    private int[] arrNon = {1,2,3,4,5,6,7,8,9};
    private int[] arrDup = {1,2,2,4,5,6,7,8,9};
    private int[] arrInit = new int[9];
    private Object[][] arrStacked = {
            {0, 1, 2},
            {9, 0, 3}
    };
    private Object[] expected = {0,1,2,9,0,3};


    @Test
    public void testContainsDuplicates() {
        assertFalse("Test on non duplicates", Utils.containsDuplicates(arrNon));
        assertTrue("Test on duplicates", Utils.containsDuplicates(arrDup));
        assertTrue("Test on duplicates of initialized array", Utils.containsDuplicates(arrInit));
    }

    @Test
    public void testFlatten() {
        assertArrayEquals("Testing flatten", Arrays.stream(expected).toArray(), Utils.flatten(arrStacked).toArray());
    }
}