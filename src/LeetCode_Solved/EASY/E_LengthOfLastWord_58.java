package LeetCode_Solved.EASY;
//26-05-24
public class E_LengthOfLastWord_58 {
    public int lengthOfLastWord(String string) {
        string.trim();
        int length = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) != ' ') {
                length++;
            } else if (length > 0) break;
        }
        return length;
    }
}
