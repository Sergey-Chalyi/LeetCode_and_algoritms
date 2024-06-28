package LeetCode_NOT_Solved.MEDIUM;

//13-06-2024
public class M_IncreasingTripletSubsequence_334 {
    public static void main(String[] args) {
        System.out.println(new M_IncreasingTripletSubsequence_334().increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
    }
    public boolean increasingTriplet(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                count++;
            }
            if (count == 3) return true;
        }
        return false;
    }

    /*
    вторая попытка
    public boolean increasingTriplet(int[] numbers) {
        Set<Integer> set = new TreeSet<>(Arrays.asList(Arrays.stream(numbers).boxed().toArray(Integer[]::new)));
        List<Integer> list = new ArrayList<>(set);
        int max = Integer.MAX_VALUE;
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < max) {
                max = list.get(i);
                count++;
            }
        }
        return count >= 3;
    }

     */

    /*
    первая попытка
    public boolean increasingTriplet(int[] numbers) {
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

     */
}
