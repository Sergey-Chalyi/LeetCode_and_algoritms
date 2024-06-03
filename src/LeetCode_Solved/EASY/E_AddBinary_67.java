package LeetCode_Solved.EASY;

import java.math.BigInteger;

public class E_AddBinary_67 {
    public String addBinary(String a, String b) {
        //тут не получилось из-за размера числа
        //return Long.toBinaryString(Long.parseLong(a, 2) + Long.parseLong(b, 2));
        //используем именно этот класс по той причине
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);

        BigInteger sum = num1.add(num2);
        return sum.toString(2);
    }
}
