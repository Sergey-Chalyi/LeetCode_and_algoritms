package LeetCode_Solved.EASY;
//28-05-24
public class E_RobotReturnToOrigin_657 {
    public boolean judgeCircle(String moves) {
        int countOfUpDown = 0;
        int countOfLeftRight = 0;
        for(char symbol : moves.toCharArray()){
            switch (symbol) {
                case 'R':
                    countOfLeftRight++;
                    break;
                case 'L':
                    countOfLeftRight--;
                    break;
                case 'U':
                    countOfUpDown++;
                    break;
                case 'D':
                    countOfUpDown--;
                    break;
            }
        }
        return countOfLeftRight == 0 && countOfUpDown == 0 ? true : false;
    }
}
