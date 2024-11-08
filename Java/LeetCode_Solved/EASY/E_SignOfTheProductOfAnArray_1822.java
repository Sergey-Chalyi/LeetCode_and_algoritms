package LeetCode_Solved.EASY;
//22-05-24
public class E_SignOfTheProductOfAnArray_1822 {
    public int arraySign(int[] numbers) {
        int countOfNegativeNumbers = 0;
        for (int number : numbers) {
            if (number == 0) return 0;
            else if (number < 0) countOfNegativeNumbers++;
        }
        return countOfNegativeNumbers % 2 == 0 ? 1 : -1;
    }
}
