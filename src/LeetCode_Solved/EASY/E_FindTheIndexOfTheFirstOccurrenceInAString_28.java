package LeetCode_Solved.EASY;

public class E_FindTheIndexOfTheFirstOccurrenceInAString_28 {
    public int strStr(String haystack, String needle) {
        int index = 0;
        try {
            return haystack.indexOf(needle);
        } catch (Exception e) {
            return -1;
        }
    }
}
