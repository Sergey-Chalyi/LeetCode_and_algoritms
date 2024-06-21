package LeetCode_NOT_Solved.MEDIUM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//21-06-2024
public class M_MaxNumberOfKSumPairs_1679 {
    public static void main(String[] args) {
        System.out.println(new M_MaxNumberOfKSumPairs_1679().maxOperations(new int[]{1, 2, 3, 4, 5}, 5));
    }

    public int maxOperations(int[] nums, int k) {
        // проверяем на длину массива
        if (nums.length == 1) return 0;

        // если длина больше одного, то пишем  алгоритм
        // алгоритм 1 (медленный - очень долго работает для больших значений)
        /*
        int countOfRemoving = 0; // счетчик
        List<Integer> list = new ArrayList<>(); // лист с исходными данными массива (для удобного удаления на месте)
        for(int number : nums) {
            list.add(number);
        }

        label: // метка
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == k) {
                    countOfRemoving++;
                    list.remove(j);
                    list.remove(i);
                    i = -1;
                    continue label; // метка, чтоб начать два цикла заново
                }
            }
        }
        return countOfRemoving;

         */
        // алгоритм 2
        // по времени еще тоже не подходит
        int countOfRemoving = 0; // счетчик

        List<Integer> filteredList = Arrays.stream(nums)
                .boxed() // Преобразование int в Integer
                .filter(num -> num < k) // Фильтрация: оставляем только четные числа
                .collect(Collectors.toList()); // Сбор результата в список

        label: // метка
        for(int i = 0; i < filteredList.size() - 1; i++) {
            int firstNumber = filteredList.get(i);
            int neededSecondNumber = k - firstNumber;
            if (!filteredList.contains(neededSecondNumber))
                continue;
            else {
                int indexOfNeededSecondNumber = filteredList.indexOf(neededSecondNumber);
                countOfRemoving++;
                filteredList.set(i, 0);
                filteredList.set(indexOfNeededSecondNumber, 0);
            }
        }
        return countOfRemoving;
    }
}
