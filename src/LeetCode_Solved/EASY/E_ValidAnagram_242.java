package LeetCode_Solved.EASY;

import java.util.HashMap;
import java.util.Map;

public class E_ValidAnagram_242 {
    public boolean isAnagram(String str1, String str2) {
        Map<Character, Integer> countOfSymbolsInStr1 = new HashMap<>(), countOfSymbolsInStr2 = new HashMap<>();

        for (int i = str1.length(); i > 0; /**/) {
            int startLength = i;
            countOfSymbolsInStr1.put(str1.charAt(0), startLength -(str1 = str1.replaceAll(str1.charAt(0) + "", "")).length());
            i = str1.length();
        }
        for (int i = str2.length(); i > 0; /**/) {
            int startLength = i;
            countOfSymbolsInStr2.put(str2.charAt(0), startLength -(str2 = str2.replaceAll(str2.charAt(0) + "", "")).length());
            i = str2.length();
        }
        return countOfSymbolsInStr1.equals(countOfSymbolsInStr2);

    }
}
