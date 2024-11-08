package LeetCode_Solved.EASY;

public class E_IsSubsequence_392 {
    public boolean isSubsequence(String subsequence, String startString) {
        int countCheck = 0; // cчетчик к-ва совпадающих по условию букв
        boolean flag = false; // флаг для помощи в цикле

        // по всем символам subsequence проходим
        for (char symbol : subsequence.toCharArray()) {
            // ищем первый попавшийся такой же символ
            for(int i = 0; i < startString.length(); i++) {
                // если попался
                if (startString.charAt(i) == symbol) {
                    countCheck++; // увеличиваем счетчик
                    if (i < startString.length() - 1) // если мы не дошли до последнего символа
                        startString = startString.substring(i + 1);
                    else // а если все же дошли, то меняем флаг, чтоб закончить все циклы
                        flag = true;
                    break;
                } else if (i == startString.length() - 1) flag = true; // флаг по той же причине

            }
            if (flag) break; // проверка на флаг
        }
        // возвращаем результат
        return countCheck == subsequence.length();
    }
}
