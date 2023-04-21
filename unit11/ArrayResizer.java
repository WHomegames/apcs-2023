package unit11;

// 2021 FRQ #4
// https://apcentral.collegeboard.org/media/pdf/ap21-frq-computer-science-a.pdf#page=14
import java.util.Arrays;

public class ArrayResizer {
    public static boolean isNonZeroRow(int[][] array2D, int r)
    {
        boolean notZero = true;
        for(int i = 0; i < array2D[r].length; i++)
        {
            if(array2D[r][i] == 0)
                notZero = false;
        }

        return notZero;
    }

    public static int numNonZeroRows(int[][] array2D) {
        /* implementation not shown */
        int count = 0;
        for (int r = 0; r < array2D.length; r++) {
            if (ArrayResizer.isNonZeroRow(array2D, r))
                count++;
        }
        return count;
    }

    public static int[][] resize(int[][] array2D)
    {

        int[][] array = new int[numNonZeroRows(array2D)][array2D[0].length];

        int rowsAdded = 0;
        for(int i = 0; i < array2D.length; i++)
        {
            if(isNonZeroRow(array2D, i))
            {
                array[rowsAdded] = array2D[i];
                rowsAdded++;
            }
        }

        return array;
    }

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 1, 0 },
                { 1, 3, 2 },
                { 0, 0, 0 },
                { 4, 5, 6 } };
        check(ArrayResizer.isNonZeroRow(arr, 0) == false);
        check(ArrayResizer.isNonZeroRow(arr, 1) == true);
        check(ArrayResizer.isNonZeroRow(arr, 2) == false);
        check(ArrayResizer.isNonZeroRow(arr, 3) == true);

        int[][] smaller = ArrayResizer.resize(arr);
        int[][] target = { arr[1], arr[3] };
        check(smaller.length == 2);
        check(Arrays.deepEquals(smaller, target));
        System.out.println("Happy Panda! \uD83D\uDC3C");

    }
}