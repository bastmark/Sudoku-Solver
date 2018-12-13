package sudoku;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Utils class containing general useful methods.
 *
 * @author Johannes Bastmark
 * @author Szymon Stypa
 * @author Axel Domell
 *
 * @version 1.0
 * @see <a href="https://github.com/bastmark/Sudoku-solver">Github repository</a>
 */
class Utils {

    /**
     * Returns boolean. True if arr contains one or more duplicates.
     * @param arr int[]
     * @return boolean containsDuplicates
     */
    static boolean containsDuplicates(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns Stream<Object> from an array of Object.
     * @param array Object[]
     * @return Stream of type Object
     */
    static Stream<Object> flatten(Object[] array) {
        return Arrays.stream(array).flatMap(o -> o instanceof Object[] ? flatten((Object[])o): Stream.of(o));
    }
}
