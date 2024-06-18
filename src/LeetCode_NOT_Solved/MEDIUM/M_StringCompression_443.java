package LeetCode_NOT_Solved.MEDIUM;

import java.util.ArrayList;
import java.util.List;

public class M_StringCompression_443 {
    public static void main(String[] args) {
        System.out.println(new M_StringCompression_443().compress(new char[]{'a','a','b','b','c','c','c'}));
    }
    public int compress(char[] chars) {
        List<Character> list = new ArrayList<>();
        list.add(chars[0]);
        int count = 1;
        for(int i = 1; i < chars.length; i++) {
            if (chars[i] == list.get(list.size() - 1)) count++;
            else {
                for(Character ch : (count + "").toCharArray()) {
                    list.add(ch);
                }
                list.add(chars[i]);
                count = 1;
            }
        }
        for(Character ch : (count + "").toCharArray()) {
            list.add(ch);
        }

        return list.size();
    }
}
