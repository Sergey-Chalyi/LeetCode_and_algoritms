import java.util.ArrayList;
import java.util.List;


class Solution {
    public static void main(String[] args) {
        //тест
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotateAndCut(matrix);

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        while(countOfPositionsInMatrix(matrix) != 1) {

            //добавляем в лист верхний слой
            for(int j = 0; j < matrix[0].length; j++) {
                result.add(matrix[0][j]);
            }
            //теперь нужно удалить верхний слой и повернуть матрицу на 90 против часовой
            rotateAndCut(matrix);

        }
        return result;
    }

    public void rotateAndCut(int[][] matrix) {
        List<Integer> tempList = new ArrayList<>();
        int high = matrix.length;
        int width = matrix[0].length;

        for(int countOfIterationsHigh = width - 1; countOfIterationsHigh >= 0; countOfIterationsHigh--) {
            for(int countOfIterationsWidth = 1; countOfIterationsWidth <= width - 1; countOfIterationsWidth++) {
                tempList.add(matrix[countOfIterationsWidth][countOfIterationsHigh]);
            }
        }

        //создаем новую матрицу
        int[][] newMatrix = new int[width][high - 1];
        //и заполняем ее значениями
        int indexForTempList = 0;
        for(int i = 0; i < newMatrix.length; i++) {
            for(int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = tempList.get(indexForTempList);
                indexForTempList++;
            }
        }
        //присваиваем исходной матрице новую матрицу
        matrix = newMatrix;
    }

    private int countOfPositionsInMatrix(int[][] matrix) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count++;
            }
        }
        return count;
    }
}