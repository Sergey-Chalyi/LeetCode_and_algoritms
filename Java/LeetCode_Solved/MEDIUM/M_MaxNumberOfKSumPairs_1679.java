package LeetCode_Solved.MEDIUM;

import java.util.*;
import java.util.stream.Collectors;

//21-06-2024
//23-06-2024
public class M_MaxNumberOfKSumPairs_1679 {
    public static void main(String[] args) {
        System.out.println(new M_MaxNumberOfKSumPairs_1679().maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }


    public int maxOperations(int[] nums, int k) {
        // start checking
        if (nums.length == 1) return 0;

        int counterOfPairs = 0; // counter

        List<Integer> filteredList = Arrays.stream(nums)
                .boxed() // transform  int into Integer
                .filter(num -> num < k) // filter: leave only consonant numbers
                .collect(Collectors.toList()); // collect a list

        // sort current list
        Collections.sort(filteredList);

        // create linkedMap to put element into it and count of this element in the filteredList
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (Integer number : filteredList) {
            if (map.containsKey(number))
                map.put(number, map.get(number) + 1);
            else
                map.put(number, 1);
        }

        // create a list with indexes of elements in mup so that we can refer to the mup by indexes
        List<Integer> indexes = new ArrayList<>(map.keySet());

        // create a loop to iterate all the elements in linkedMap from the beginning and from the and at the same time
        while (indexes.size() > 0){
            Integer firstElement = indexes.get(0);
            Integer lastElement = indexes.get(indexes.size() - 1);
            Integer counterOfFirstElement = map.get(firstElement);
            Integer countOfLastElement = map.get(lastElement);

            if (firstElement == lastElement) { // we have the last element
                if (counterOfFirstElement > 1 && firstElement * 2 == k) {
                    counterOfPairs += counterOfFirstElement / 2;
                    break;
                }
                else
                    break;
            }

            if (counterOfFirstElement > 1 && firstElement * 2 == k) {
                counterOfPairs += counterOfFirstElement / 2;
                counterOfFirstElement = counterOfFirstElement - (counterOfFirstElement / 2 * 2);
                map.put(firstElement, counterOfFirstElement);
            }
            if (countOfLastElement > 1 && lastElement * 2 == k) {
                counterOfPairs += countOfLastElement / 2;
                countOfLastElement = countOfLastElement - (countOfLastElement / 2 * 2);
                map.put(lastElement, countOfLastElement);
            }

            if (firstElement + lastElement == k) {
                counterOfPairs += Math.min(counterOfFirstElement, countOfLastElement); // change counter
                map.remove(firstElement);
                map.remove(lastElement);
                indexes.remove(firstElement);
                indexes.remove(lastElement);
            } else if (firstElement + lastElement > k) {
                map.remove(lastElement);
                indexes.remove(lastElement);
            } else {
                map.remove(firstElement);
                indexes.remove(firstElement);
            }
        }

        return counterOfPairs;
    }

    // algorithm 1 (slow)
    /*
    public int maxOperations(int[] nums, int k) {
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
    }
     */
}
