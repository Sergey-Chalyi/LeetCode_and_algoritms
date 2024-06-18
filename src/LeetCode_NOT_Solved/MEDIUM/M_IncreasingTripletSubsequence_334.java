package LeetCode_NOT_Solved.MEDIUM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//13-06-2024
//18-06-2024(II)
public class M_IncreasingTripletSubsequence_334 {
    public static void main(String[] args) {
        System.out.println(new M_IncreasingTripletSubsequence_334().increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
    }

    public boolean increasingTriplet(int[] numbers) {
        // проверяем длину массива и проверку на null
        if (numbers == null || numbers.length < 3) return false;

        // сначала нам нужно переписать массив в лист так, чтобы несколько повторяющихся цифр не было подряд
        // но во всем листе повторяющиеся значения могут быть
        List<Integer> list = new ArrayList<>();
        list.add(numbers[0]);
        for(int i = 1; i < numbers.length; i++) {
            if (list.get(list.size() - 1) != numbers[i]) list.add(numbers[i]);
        }

        // теперь нужно проверить на отсортированность
        List<Integer> newList = new ArrayList<>(list);
        Collections.sort(newList, Collections.reverseOrder());
        if (list.equals(newList)) return false;

        // dj всех противных случаях проходим циклами по листу
        for(int i = 0; i < numbers.length - 2; i++) {
            for(int j = i + 1; j < numbers.length - 1; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] < numbers[j] && numbers[j] < numbers[k])
                        return true;
                }
            }
        }
        return false;
    }

    // как работает алгоритм правильного решения я понял (технически), но логику его не очень понял
    // As per this logic, the final triplet being formed for the test case: [20,100,10,12,5,13] is 5,12,13. Isn't this incorrect?
    // The valid triplet should be 10,12,13 if we go by order of elements.

    private boolean correctDecision(int numbers[]) {
        // проверяем длину массива и проверку на null
        if (numbers == null || numbers.length < 3) return false;


        //алгоритм
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int number : numbers) {
            if (first <= number) first = number;
            else if (second <= number) second = number;
            else return true;
        }
        return false;
    }

}
