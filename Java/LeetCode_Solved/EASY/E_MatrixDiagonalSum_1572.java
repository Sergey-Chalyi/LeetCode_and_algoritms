package LeetCode_Solved.EASY;
//31-05-24
public class E_MatrixDiagonalSum_1572 {
    public int diagonalSum(int[][] mat) {
        boolean flag = mat.length % 2 == 0 ? false : true;
        int sum = 0;
        for(int i = 0; i < mat.length; i++) {
            sum += mat[i][i] + mat[mat.length - i - 1][i];
        }
        return flag == false ? sum : sum - mat[mat.length / 2][mat.length / 2];
    }
}
