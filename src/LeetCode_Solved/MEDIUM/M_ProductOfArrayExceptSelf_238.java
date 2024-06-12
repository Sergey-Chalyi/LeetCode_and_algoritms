package LeetCode_Solved.MEDIUM;

import java.util.ArrayList;
import java.util.List;
//12-06-2024
public class M_ProductOfArrayExceptSelf_238 {
    // создаем лист для хранения массива без единиц и при условии, что у нас нечетное число -1, оставляем одну -1
    private List<Integer> listWithoutOnes = new ArrayList<>();

    public int[] productExceptSelf(int[] nums) {
        // создаем массив, который будем возвращать
        int[] finalResult = new int[nums.length];
        // заполняем лист значениями лист БЕЗ единиц и при условии, что у нас нечетное число -1, оставляем несколько -1
        fillInTheList(nums);

        for(int i = 0; i < nums.length; i++) {
            // решение
            finalResult[i] = multiplyElementsFromArrayWithoutOne(nums[i]);
        }
        // возвращаем финальный массив
        return finalResult;
    }

    private void fillInTheList(int[] numbers) {
        // заполняем лист значениями лист БЕЗ единиц и при условии, что у нас нечетное число -1, оставляем несколько -1
        int countOfNegativeOnes = 0;
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) continue;
            else if (numbers[i] == -1) countOfNegativeOnes++;
            else listWithoutOnes.add(numbers[i]);
        }
        // оставляем именно 3 шт, или 2 шт -1 по той причине, что если оставить одну, то метод multiplyElementsFromArrayWithoutOne
        // в части if (listWithoutOnes.get(i) == numberFromArray && oneFlag == true) будет работать НЕ правильно
        if (countOfNegativeOnes % 2 != 0) {

            listWithoutOnes.add(-1);
            listWithoutOnes.add(-1);
            listWithoutOnes.add(-1);
        } else {
            listWithoutOnes.add(-1);
            listWithoutOnes.add(-1);
        }
    }

    private int multiplyElementsFromArrayWithoutOne(int numberFromArray) {
        int result = 1;
        boolean oneFlag = true;
        for(int i = 0; i < listWithoutOnes.size(); i++) {
            if (listWithoutOnes.get(i) == numberFromArray && oneFlag == true) {
                // пропускаем то значение, которое у нас сейчас в массиве и СНИМАЕМ флаг
                // чтоб больше похожие значения НЕ пропустить
                oneFlag = false;
            } else {
                result *= listWithoutOnes.get(i);
            }
        }
        return result;
    }
}
