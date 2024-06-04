package LeetCode_NOT_Solved.MEDIUM;

public class M_Pow_50 {
    public static void main(String[] args) {
        System.out.println(new M_Pow_50().myPow(2.00000, -2));
    }
    public double myPow(double x, int n) { // n может быть и отрицательным и нулем
        if (n == 0) return 1;
        if (n < 0) {
            if (n == -1) return x;
            return 1 / myPow(x, n + 1);
        } else { // n > 0
            if (n == 1) return x;
            return x * myPow(x, n - 1);
        }
    }
}
