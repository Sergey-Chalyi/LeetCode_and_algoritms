package LeetCode_Solved.EASY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class E_KidsWithTheGreatestNumberOfCandies_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> resultList = new ArrayList<>();

        // находим максимальный еллемент из массива
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < candies.length; i++) {
            if (candies[i] > max) max = candies[i];
        }

        // собственно говоря, вот сам основнйо код
        for(int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) resultList.add(true);
            else resultList.add(false);
        }

        return resultList;
    }
}
