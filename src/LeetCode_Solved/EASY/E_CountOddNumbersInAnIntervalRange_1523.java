package LeetCode_Solved.EASY;

public class E_CountOddNumbersInAnIntervalRange_1523 {
    public int countOdds(int low, int high) {
        if (low == high && low % 2 != 0) return 1;
        else if (low == high && low % 2 == 0) return 0;
        if (low % 2 == 0) {
            if (high % 2 == 0) return (high - low - 1) / 2 + 1;
            else /*high % 2 != 0*/ return (high - low) / 2 + 1;
        } else /**/ {
            if (high % 2 == 0) return 1 + (high - low - 1) / 2;
            else return 2 + (high - low - 1) / 2;
        }
    }
}
