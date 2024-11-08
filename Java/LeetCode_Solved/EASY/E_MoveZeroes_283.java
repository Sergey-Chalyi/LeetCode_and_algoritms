package LeetCode_Solved.EASY;
//20-05-24
public class E_MoveZeroes_283 {
    public void moveZeroes(int[] numbers) {
        int[] tempArray = new int[numbers.length];
        int index = 0;
        for (int number : numbers) {
            if (number != 0) {
                tempArray[index] = number;
                index++;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = tempArray[i];
        }
    }

}
