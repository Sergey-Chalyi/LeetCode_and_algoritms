package LeetCode_Solved.EASY;

import java.util.HashSet;
import java.util.Set;

public class E_CheckIfItIsAStraightLine_1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        //проверяем координаты х-ов
        Set<Integer> setX = new HashSet<>();
        for(int[] coordinate : coordinates) {
            setX.add(coordinate[0]);
        }
        // если в множестве одна координата х - у нас вертикальная прямая,
        // ибо по условию нам дан массив РАЗНЫХ точе -> y-ки буду все разные
        if (setX.size() == 1) return true;
            //если в множестве меньше х-ов, чем в исходных координатах, значит минимум две точки какие-то повторяются
            // т.е. у они лежат на одой вертикальной прямой, когда другие - нет
        else if (setX.size() < coordinates.length) return false;
            //в противном случае
        else {
            //кладем во множество координаты y
            Set<Integer> setY = new HashSet<>();
            for(int[] coordinate : coordinates) {
                setY.add(coordinate[1]);
            }
            // все точки лежат на одной горизонтальной прямой
            if (setY.size() == 1) return true;
                //по той же причине
            else if (setY.size() < coordinates.length) return false;
            else {
                //теперь нам нужно получить формулу прямой y = mx + b
                int x1 = coordinates[0][0], x2 = coordinates[1][0];
                int y1 = coordinates[0][1], y2 = coordinates[1][1];
                double m = (y2 - y1) * 1.0 /(x2 - x1);
                double b = y1 - (m * x1);

                for(int i = 0; i < coordinates.length; i++) {
                    if (coordinates[i][1] != m * coordinates[i][0] + b) return false;
                }
                return true;
            }
        }
    }
}
