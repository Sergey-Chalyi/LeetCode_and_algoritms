package LeetCode_Solved.EASY;
//24-05-24
public class E_MonotonicArray_896 {
    public boolean isMonotonic(int[] nums) {
        int number1 = nums[0];
        int number2 = 0;
        int number2Index = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != number1) {
                number2 = nums[i];
                number2Index = i;
                break;
            }
        }
        if (number1 - number2 < 0) {
            //increasing
            for(int i = number2Index; i < nums.length - 1; i++) {
                if (!(nums[i] <= nums[i + 1])) return false;
            }
            return true;
        } else {
            //decreasing
            for(int i = number2Index; i < nums.length - 1; i++) {
                if (!(nums[i] >= nums[i + 1])) return false;
            }
            return true;
        }
    }
}
