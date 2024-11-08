package LeetCode_Solved.EASY;
//23-05-24
import java.util.Arrays;

public class E_CanMakeArithmeticProgressionFromSequence_1502 {
    public boolean canMakeArithmeticProgression(int[] array) {
        Arrays.sort(array);
        int difference = array[1] - array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] != difference) return false;
        }
        return true;
    }
}
