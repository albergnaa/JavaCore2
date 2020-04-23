package homework3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Shopping {
    //Additional task from stepik
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();
        while (in.hasNextLine()){
            String str = in.nextLine();
            if (str.isEmpty()) {
                break;
            }
            String[] array = str.split(" ");
            String name = array[0] + " " + array[1];
            String productName = array[2];
            Integer productQuantity = Integer.parseInt(array[3]);
            if (!map.containsKey(name)) {
                map.put(name, new TreeMap<String, Integer>());
            }
            TreeMap<String, Integer> tmp = map.get(name);
            if (!tmp.containsKey(productName)) {
                tmp.put(productName, 0);
            }
            tmp.put(productName, tmp.get(productName) + productQuantity);
        }
        for (Map.Entry<String, TreeMap<String, Integer>> entry: map.entrySet()){
            String key = entry.getKey();
            TreeMap<String, Integer> value = entry.getValue();
            System.out.print(key + ": ");
            System.out.println();
            for (Map.Entry<String, Integer> product : value.entrySet()) {
                String keyProduct = product.getKey();
                Integer valueProduct = product.getValue();
                System.out.println("    " + keyProduct + " " + valueProduct);
            }
        }
    }
}
