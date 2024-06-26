package LeetCode_Solved.EASY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E_643_n_MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(new E_643_n_MaximumAverageSubarrayI().findMaxAverage(new int[]{-1}, 1));
    }

    // algorithm 1 (slaw)
    public double findMaxAverage1(int[] nums, int k) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int countOfInnerLoopIteration = 0;
            for(int j = i; j < nums.length && j < i + k; j++) {
                sum += nums[j];
                countOfInnerLoopIteration++;
            }
            double averageResult = sum * 1.0 / k;
            if (countOfInnerLoopIteration == k) {
                if (averageResult > max)
                    max = averageResult;
            }
        }
        return max;
    }

    // algorithm 2 (also slow)
    public double findMaxAverage2(int[] nums, int k) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            int sum1 = 0, sum2 = 0;
            int countOfIterationOfInnerLoop = 0;
            int countOfEqualsIndexes = 0;
            for(int j = i; j < nums.length && j < i + k; j++) {
                sum1 += nums[j];
                sum2 += nums[nums.length - 1 - j];
                countOfIterationOfInnerLoop++;
                if (i == nums.length - j) countOfEqualsIndexes++;
            }
            if (countOfIterationOfInnerLoop == k) {
                double average = Math.max(sum1, sum2) * 1.0 / k;
                if (countOfEqualsIndexes == k) {
                    // the last iteration
                    if (average > max) max = average;
                    return max;
                } else {
                    if (average > max) max = average;
                }
            } else
                break;
        }
        return max;
    }

    // algorithm 3 (with threads, has mistakes)
    volatile List<Double> listWithMaxSubstringFromArray = Collections.synchronizedList(new ArrayList<>());
    private double getAverageOfSubArray(int[] array, int firstIndex, int lastIndex) {
        int sumOfNumbersInArray = 0;
        for(int i = firstIndex; i <= lastIndex; i++) {
            sumOfNumbersInArray += array[i];
        }
        return sumOfNumbersInArray * 1.0 / (lastIndex - firstIndex + 1);
    }
    public double findMaxAverage3(int[] numbers, int k) {
        List<Thread> threadsCreatedFromLoop = new ArrayList<>();
        for(int i = 0; i <= numbers.length - k; i++) {
            int finalI = i;
            Thread newThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    listWithMaxSubstringFromArray.add(getAverageOfSubArray(numbers, finalI, finalI + k - 1));
                }
            });
            threadsCreatedFromLoop.add(newThread);
        }

        for(Thread thread : threadsCreatedFromLoop) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Collections.max(listWithMaxSubstringFromArray);
    }

    //algorithm 4 (not mine)
    public double findMaxAverage(int[] numbers, int k){
        int sumOfCurrentSubArray = 0;
        int maxSumOfAllSubArrays = 0;
        for(int i = 0; i < k; i++) {
            sumOfCurrentSubArray += numbers[i];
        }
        maxSumOfAllSubArrays = sumOfCurrentSubArray;
        for(int i = k; i < numbers.length; i++) {
            sumOfCurrentSubArray += numbers[i] - numbers[i - k];
            if (Math.max(sumOfCurrentSubArray, maxSumOfAllSubArrays) > maxSumOfAllSubArrays)
                maxSumOfAllSubArrays = sumOfCurrentSubArray;
        }
        return maxSumOfAllSubArrays * 1.0 / k;
    }
}
