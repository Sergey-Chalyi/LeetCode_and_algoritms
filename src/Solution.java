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
        //создаем лист с результатами
        List<Integer> result = new ArrayList<>();

        //пока в листе есть эллементы выполням цикл
        while(countOfPositionsInMatrix(matrix) > 0) {

            //добавляем в лист верхний слой
            for(int j = 0; j < matrix[0].length; j++) {
                result.add(matrix[0][j]);
            }
            //теперь нужно удалить верхний слой и повернуть матрицу на 90 против часовой
            matrix = rotateAndCut(matrix);

        }
        return result;
    }

    public int[][] rotateAndCut(int[][] matrix) {
        //создаем лист, где будем хранить последовательность чисел после среза верхнего слоя
        List<Integer> tempList = new ArrayList<>();
        //записываем исходные габариты матирицы
        int high = matrix.length;
        int width = matrix[0].length;

        //основная логика последовательности записи чисел во временный лист (тут на картинке нужно объяснять)
        for(int countOfIterationsHigh = width - 1; countOfIterationsHigh >= 0; countOfIterationsHigh--) {
            for(int countOfIterationsWidth = 1; countOfIterationsWidth <= high - 1; countOfIterationsWidth++) {
                tempList.add(matrix[countOfIterationsWidth][countOfIterationsHigh]);
            }
        }

        //создаем новую матрицу с новой высотой и шириной (почему именно такие высота и ширина - нужно рисовать)
        int[][] newMatrix = new int[width][high - 1];
        //и заполняем ее значениями просто последовательно из листа, ибо в листе числа уже в нужной нам последовательности расположены
        int indexForTempList = 0;
        for(int i = 0; i < newMatrix.length; i++) {
            for(int j = 0; j < newMatrix[0].length; j++) {
                newMatrix[i][j] = tempList.get(indexForTempList);
                indexForTempList++;
            }
        }
        return newMatrix;
    }

    private int countOfPositionsInMatrix(int[][] matrix) {
        //тупо подсчет
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count++;
            }
        }
        return count;
    }
}
