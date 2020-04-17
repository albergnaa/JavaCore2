package homework2;

public class ArrayUtils {


    public long arraySum(Object[][] array) throws ArraySizeException, ArrayDataException {
        if ((array.length != 4) || (array[0].length != 4)) {
            throw new ArraySizeException("impossible size");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j].toString());
                } catch (NumberFormatException e) {
                    throw new ArrayDataException( "(" + i + " " + j + ") is not integer");
                }
            }
        }
        return sum;
    }
}
