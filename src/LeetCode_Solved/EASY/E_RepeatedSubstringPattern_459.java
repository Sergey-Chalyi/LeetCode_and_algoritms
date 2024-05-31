package LeetCode_Solved.EASY;
//19-05-24
public class E_RepeatedSubstringPattern_459 {
    public boolean repeatedSubstringPattern(String string)  {
        for(int i = 0; i < string.length() / 2; i++) {
            if (string.length() % (i + 1) != 0) continue;
            if (string.replaceAll(string.substring(0, i + 1), "").isEmpty()) return true;
        }
        return false;
    }
}
