package LeetCode_Solved.MEDIUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class M_ProductOfArrayExceptSelf_238 {
    // короче, в приватном методе нужно сделать так, чтобы у нас хранился екземпляр массива БЕЗ лишних -1
    // для того, чтоб НЕ проходить каждый раз по всем еденицам, а просто на одну умножить

    public int[] productExceptSelf(int[] nums) {
        /*
        int countOfNegativeOne = countOfNegativeOne(nums);

        String result = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(".."));
        result.replaceAll(".1.", "");
        result.replaceAll(".-1.", "");
        if (countOfNegativeOne % 2 != 0) result += "..-1";
        String[] array = result.split("..");


        int[] numbers = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }


         */
        int[] finalResult = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            finalResult[i] = multiplyElementsFromArrayWithoutOne(nums, i);
        }
        return finalResult;
    }

    private int multiplyElementsFromArrayWithoutOne(int[] array, int index) {
        int result = 1;
        for(int i = 0; i < array.length; i++) {
            if (i == index) continue;
            result *= array[i];
        }
        return result;
    }

    private int countOfNegativeOne(int[] array) {
        int countOfNegative = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == -1) countOfNegative++;
        }
        return countOfNegative;
    }
}
