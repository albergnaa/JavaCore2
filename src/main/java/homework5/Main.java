package homework5;

public class Main {

    public static void formWholeArray() {
        final int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long begin = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Время вычисления без потоков: " + (end - begin));
    }

    public static void formArrayInParts() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        float[] arrOne = new float[h];
        float[] arrTwo = new float[h];
        long begin = System.currentTimeMillis();
        System.arraycopy(arr, 0, arrOne, 0, h);
        System.arraycopy(arr, h, arrTwo, 0, h);

        new Thread(() ->{
            for (int i = 0; i < h; i++) {
                arrOne[i] = (float) (arrOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        new Thread(() ->{
            for (int i = 0; i < h; i++) {
                arrTwo[i] = (float) (arrTwo[i] * Math.sin(0.2f + (i+h) / 5) * Math.cos(0.2f + (i+h) / 5) * Math.cos(0.4f + (i+h) / 2));
            }
        }).start();

        System.arraycopy(arrOne, 0, arr, 0, h);
        System.arraycopy(arrTwo, 0, arr, h, h);
        long end = System.currentTimeMillis();
        System.out.println("Время вычисления с потоками: " + (end - begin));
    }


    public static void main(String[] args) {
        formWholeArray();
        formArrayInParts();
    }
}
