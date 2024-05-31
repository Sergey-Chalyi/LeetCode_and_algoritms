package LeetCode_Solved;

import java.util.ArrayList;
import java.util.List;

public class M_SetMatrixZeroes_73 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        M_SetMatrixZeroes_73 solution = new M_SetMatrixZeroes_73();
        solution.setZeroes(matrix);
        System.out.println(matrix.toString());
    }

    public void setZeroes(int[][] matrix) {
        //создаем лист с координатами нулей в исходной матрице
        List<Integer> coordinatesOfZeros = new ArrayList<>();

        //ищем координаты в матрице
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    coordinatesOfZeros.add(i);
                    coordinatesOfZeros.add(j);
                }
            }
        }

        //теперь проходим по координатам нулей и заменяем во всех горизонтальных и вертикальных линиях цифры на нули
        for(int i = 0; i < coordinatesOfZeros.size(); i += 2) {
            int coordinateI = coordinatesOfZeros.get(i);
            int coordinateJ = coordinatesOfZeros.get(i + 1);
            //заменяем все по горизонтали
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[coordinateI][j] = 0;
            }

            //заменяем все по вертикали
            for(int I = 0; I < matrix.length; I++) {
                matrix[I][coordinateJ] = 0;
            }
        }
    }
}
