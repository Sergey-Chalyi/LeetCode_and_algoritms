package LeetCode_Solved.EASY;
//28-05-24
public class E_FindWinnerOnATicTacToeGame_1275 {
    public String tictactoe(int[][] moves) {
        //создаем игровое поле
        String[][] field = new String[3][3];
        //заполняем его точками, чтоб потом можно было сравнивать вставленный символ с чем-то
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                field[i][j] = ".";
            }
        }
        // финализированная переменная количества мест на поле
        final int countOfPlaces = 9;
        // счетчик ходов
        int countOfMoves = 0;
        //координаты левой диагонали
        int[][] coordinatesOfSecondDiagonale = {{2, 0}, {1, 1}, {0, 2}};

        for(int I = 1; I <= moves.length; I++) {
            String symbol = (I % 2 != 0) ? "X" : "O";
            int iCoordinate = moves[I - 1][0];
            int jCoordinate = moves[I - 1][1];
            field[iCoordinate][jCoordinate] = symbol;

            int countOfSymbols = 0;
            //проверка по горизонтали
            for(int j = 0; j < 3; j++) {
                if (field[iCoordinate][j].equals(symbol)) countOfSymbols++;
            }
            if (countOfSymbols == 3) return symbol.equals("X") ? "A" : "B";

            //проверка по вертикали
            countOfSymbols = 0;
            for(int i = 0; i < 3; i++) {
                if(field[i][jCoordinate].equals(symbol)) countOfSymbols++;
            }
            if (countOfSymbols == 3) return symbol.equals("X") ? "A" : "B";

            //проверка по одной диагонали
            countOfSymbols = 0;
            for(int i = 0; i < 3; i++) {
                if(field[i][i].equals(symbol)) countOfSymbols++;
            }
            if (countOfSymbols == 3) return symbol.equals("X") ? "A" : "B";

            //проверка по другой диагонали
            countOfSymbols = 0;
            for(int[] coordinate : coordinatesOfSecondDiagonale) {
                if (field[coordinate[0]][coordinate[1]].equals(symbol)) countOfSymbols++;
            }
            if (countOfSymbols == 3) return symbol.equals("X") ? "A" : "B";

            countOfMoves++;
        }
        if (countOfMoves == countOfPlaces) return "Draw";
        return countOfMoves == countOfPlaces ? "Draw" : "Pending";
    }
}
