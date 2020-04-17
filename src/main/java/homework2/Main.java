package homework2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ArrayDataException, ArraySizeException {
        ArrayUtils arrayUtils = new ArrayUtils();
        /*Object [][] objects1 = new Object[3][50];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 50; j++) {
                objects1[i][j] = 10;
            }
        }
        arrayUtils.arraySum(objects1);*/

        /*Object [][] objects2 = new Object[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                objects2[i][j] = 10;
            }
        }
        objects2[3][3] = "String";
        objects2[1][2] = new ArrayList<Integer>();
        arrayUtils.arraySum(objects2);*/

        Object [][] objects = new Object[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                objects[i][j] = 10;
            }
        }
        long result = arrayUtils.arraySum(objects);
        System.out.println(result);
    }
}
