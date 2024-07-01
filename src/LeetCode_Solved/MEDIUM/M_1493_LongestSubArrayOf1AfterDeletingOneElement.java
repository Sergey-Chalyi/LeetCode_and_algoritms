package LeetCode_Solved.MEDIUM;
//28-06-2024
//29-06-2024
public class M_1493_LongestSubArrayOf1AfterDeletingOneElement {
    public int longestSubArray(int[] numbers) {
        // my thoughts:
        // 0 1 2 3 4 5 6 7 8

        // 0 1 1 1 0 1 1 0 0
        //   { }

        // set left index of sliding window
        // (we set -1 to check if out array contains any ones - if contains than we will correct this index)
        int leftIndex = -1;

        int countOfZeroes = 0;
        int maxLengthOfSubArray = 0;

        // looking for the first 1`s
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                leftIndex = i;
                break;
            }
        }

        // if there isn`t any ones return 0
        if(leftIndex == -1) return 0;

        // set rigwt index of sliding window
        int rightIndex = leftIndex;

        // set flag to mark if our array contains zeroes (ture), or not (false)
        // we need this flag to correct calculation of the result
        boolean flagForZeroes = false;


        // main algorithm (sliding window)
        for(/**/; rightIndex < numbers.length; rightIndex++) {
            if (numbers[rightIndex] == 0) {
                countOfZeroes++;
                if(!flagForZeroes) // flag changes only once
                    flagForZeroes = true;
            }
            if (countOfZeroes == 1){
                maxLengthOfSubArray = Math.max(maxLengthOfSubArray, rightIndex - leftIndex + 1 - 1); // we need to decrease to 1 because we need to delete 0 from our array
                continue;
            } else if (countOfZeroes == 2) {
                if (numbers[rightIndex - 1] == 0) { // if two zeroes goes each after each we need to find another leftIndex witch goes after rightIndex
                    // looking for the next 1 and index of that 1 write to leftIndex
                    leftIndex = rightIndex;
                    int saferForLeftIndex = leftIndex;
                    for(/**/; leftIndex < numbers.length; leftIndex++) {
                        if (numbers[leftIndex] == 1)
                            break;
                    }
                    // if we don`t find one more 1 than we need to finish the loop
                    if (saferForLeftIndex == leftIndex){
                        break;
                    } else {
                        rightIndex = leftIndex;
                        countOfZeroes = 0;
                    }
                } else { // if two zeroes DOESN`T goes each after each we need to change leftIndex to the second index after first zero (witch goes after current leftIndex)
                    countOfZeroes = 1; // change countOfZeroes

                    // looking for the first 0 index
                    for(/**/; leftIndex < numbers.length; leftIndex++)
                        if (numbers[leftIndex] == 0)
                            break;
                    leftIndex++; // the second index after first zero
                    maxLengthOfSubArray = Math.max(maxLengthOfSubArray, rightIndex - leftIndex + 1 - 1); // we need to decrease to 1 because we need to delete 0 from our array
                    continue;
                }
            }
            // if countOfZeroes == 0 we simply calculate the length rightIndex - leftIndex + 1
            maxLengthOfSubArray = Math.max(maxLengthOfSubArray, rightIndex - leftIndex + 1);
        }
        if (leftIndex == 0 && rightIndex - 1 == numbers.length - 1 && flagForZeroes == false) // if our array contains only ones
            return maxLengthOfSubArray - 1;
        else
            return maxLengthOfSubArray;
    }

    public static void main(String[] args) {
        System.out.println(new M_1493_LongestSubArrayOf1AfterDeletingOneElement().longestSubArray(new int[]{1,0,1,1,1,1,1,1,0,1,1,1,1,1}));
    }
}
