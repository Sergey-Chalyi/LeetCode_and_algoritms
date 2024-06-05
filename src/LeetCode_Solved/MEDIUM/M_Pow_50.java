package LeetCode_Solved.MEDIUM;
//05-06-24
public class M_Pow_50 {
    public static void main(String[] args) {
        System.out.println(new M_Pow_50().myPow(2.0, -2147483648));
    }
    //это не мое решение, я его подсмотрел
    public double myPow(double x, int n) { // n может быть и отрицательным и нулем
        if (n == 0) return 1;
        if (x == 1) return 1;

        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        return recursuvePow(x, N);
    }

    private double recursuvePow(double x, long n) {
        if (n == 0) return 1;
        double result = recursuvePow(x, n / 2);
        if (n % 2 == 0) return result * result;
        else return result * result * x;
    }
}

/*
//first trying
    public double myPoww(double x, int n) { // n может быть и отрицательным и нулем
        if (n == 0) return 1;
        if (n < 0) {
            if (n == -1) return x;
            return 1 / (myPow(x, n + 1) * 2);
        } else { // n > 0
            if (n == 1) return x;
            return x * myPow(x, n - 1);
        }
    }
 */
