package LeetCode_Solved.MEDIUM;
// 20-06-2024
// n в названии значит - алгоритм придумал НЕ сам
public class M_n_ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        // если у нас всего два бортика,
        if (height.length == 2) return Math.min(height[0], height[1]);

        // если у нас все бортики равны между собой
        int count = 0;
        for (int number : height) {
            if (height[0] == number) count++;
        }
        if (count == height.length) return height.length * height[0];

        // во всех противных случаях
        // первое решение - не подходит по времени (слишком долго)
        /*
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int multiply = Math.min(height[i], height[j]) * (j - i);
                if (max < multiply) max = multiply;
            }
        }
        return max;
         */

        // вторая попытка (не мое решение) %%%%%
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            if (currentArea > maxArea) maxArea = currentArea;
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
