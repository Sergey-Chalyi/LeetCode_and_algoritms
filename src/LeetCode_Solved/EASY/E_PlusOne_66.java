package LeetCode_Solved.EASY;
import java.math.BigInteger;
//22-05-24
public class E_PlusOne_66 {
    public static void main(String[] args) {

//        System.out.println(new BigInteger("123").add(new BigInteger("1")).toString());
        System.out.println(new E_PlusOne_66().plusOne(new int[]{1, 2, 3}));
    }
    public int[] plusOne(int[] digits) {
        String startNUmberStr = "";
        for (int number : digits) {
            startNUmberStr += number;
        }
        BigInteger number = new BigInteger(startNUmberStr);
        number = number.add(new BigInteger("1"));
        char[] arrayFromNumber = number.toString().toCharArray();
        int[] result = new int[arrayFromNumber.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(arrayFromNumber[i] + "");
        }

        return result;
    }
}
