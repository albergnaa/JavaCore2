package homework3;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //Task 1:
        String[] array = {"Tanya", "Maxim", "Anastasia", "Maxim", "Yaroslav", "Ivan", "Maxim", "Yaroslav", "Tanya", "Tanya"};
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str: array) {
            hashMap.put(str, hashMap.getOrDefault(str,0) + 1);
        }
        System.out.println(hashMap);

        //Task 2:
        PhoneBook book = new PhoneBook();
        book.add("Anastasia", "89251423659");
        book.add("Nikolai", "82456951475");
        book.add("Inga", "83652569574");
        book.add("Nikolai", "6352315");
        book.add("Anastasia", "5302459");
        book.add("Nikolai", "87632591004");
        book.get("Anastasia");
        book.get("Nikolai");
        book.get("Inga");
    }
}
