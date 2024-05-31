import java.util.ArrayList;
import java.util.List;


class Solution {
    public static void main(String[] args) {
        //тест
        Solution solution = new Solution();
        int[][] matrix = {
                {1}
        };
        System.out.println(solution.spiralOrder(matrix).toString());

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        while(countOfPositionsInMatrix(matrix) > 0) {

            //добавляем в лист верхний слой
            for(int j = 0; j < matrix[0].length; j++) {
                result.add(matrix[0][j]);
            }
            //теперь нужно удалить верхний слой и повернуть матрицу на 90 против часовой
            matrix = rotateAndCut(matrix);

        }
        //result.add(matrix[0][0]);
        return result;
    }

    public int[][] rotateAndCut(int[][] matrix) {
        List<Integer> tempList = new ArrayList<>();
        int high = matrix.length;
        int width = matrix[0].length;

        for(int countOfIterationsHigh = width - 1; countOfIterationsHigh >= 0; countOfIterationsHigh--) {
            for(int countOfIterationsWidth = 1; countOfIterationsWidth <= high - 1; countOfIterationsWidth++) {
                tempList.add(matrix[countOfIterationsWidth][countOfIterationsHigh]);
            }
        }//nen все ок

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
        return newMatrix;
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
