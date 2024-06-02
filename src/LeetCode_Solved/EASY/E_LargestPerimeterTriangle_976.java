package LeetCode_Solved.EASY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E_LargestPerimeterTriangle_976 {
    public static void main(String[] args) {
        System.out.println(new E_LargestPerimeterTriangle_976().largestPerimeter(new int[]{2, 1, 2}));
    }
    public int largestPerimeter(int[] nums) {
        //создаем лист и копируем в него все значения из массива
        List<Integer> list = new ArrayList<>();
        for(int number : nums) {
            list.add(number);
        }
        //к-во итераций (начиная с нуля) = длина массива - 3
        for (int i = 0; i <= nums.length - 3; i++) {
            //ищем первый максимальный елемент массива и присваиваем его не примитиву, а именно обертке
            // для того, чтоб можно было воспользоваться методом remove(Object), а не remove(int index)
            Integer firstMax = Collections.max(list);
            Integer secondMax = findNextMax(list, firstMax);
            Integer thirdMax = findNextMax(list, firstMax, secondMax);
            // условие - это уже теория по математике
            if (firstMax < secondMax + thirdMax) return firstMax + secondMax + thirdMax;
            // удаляем максимальный еллемент
            else list.remove(firstMax);
        }
        //если так и не нашли ничего, то возвращаем 0
        return 0;
    }

    private int findNextMax(List<Integer> lastList, Integer firstMax) {
        // создаем копию массива, чтоб не изменять исходный
        List<Integer> list = new ArrayList<>(lastList);
        list.remove(firstMax);
        return Collections.max(list);
    }

    private int findNextMax(List<Integer> lastList, Integer firstMax, Integer secondMax) {
        List<Integer> list = new ArrayList<>(lastList);
        list.remove(firstMax);
        list.remove(secondMax);
        return Collections.max(list);
    }
}
