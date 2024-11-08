package LeetCode_Solved.MEDIUM;

//19-06-2024
public class M_StringCompression_443 {
    public static void main(String[] args) {
        System.out.println(new M_StringCompression_443().compress(new char[]{'a','b','b','c','c','c'}));
    }
    public int compress(char[] chars) {
        // создаем объект для записи всех результатов в строку
        StringBuilder finalString = new StringBuilder();
        finalString.append(chars[0]); // и сразу добавляем первый еллемент, чтоб удобно было циклом по массиву пройти
        char symbol = chars[0]; // переменная для удобства, чтоб постоянно последний символ из строки не вырезать
        int count = 1; // счетчик

        for (int i = 1 ; i < chars.length; i++) {
            if (chars[i] != symbol) {
                if (count > 1) finalString.append(count); // по условию, если count == 1, то в результат не записываем 1
                symbol = chars[i];
                count = 1;
                finalString.append(symbol);
            } else {
                count++;
            }
        }
        // не забываем добавить последнее значение счетчика
        if (count > 1) finalString.append(count);

        // заполняем ИСХОДНЫЙ масив новыми значениями (по условию задачи)
        for(int i = 0; i < finalString.length(); i++) {
            chars[i] = finalString.charAt(i);
        }

        //возвращаем длину массива
        return finalString.length();
    }
}
