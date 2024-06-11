package LeetCode_Solved.MEDIUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//11-06-2024
public class M_ReverseWordsInAString_151 {

    public static void main(String[] args) {
        System.out.println(new M_ReverseWordsInAString_151().reverseWords("the sky is blue"));
    }

    public String reverseWords(String string) {
        // убираем пробелы лишние в начале и конце
        string = string.trim();
        // преобразовываем строку к массиву, а потом к листу, используя регулярным выражением \\s+ - один или более пробелов
        List<String> list = Arrays.asList(string.split("\\s+"));
        // поворачиваем лист
        Collections.reverse(list);
        // возвращаем строку из листа, разделяя каждое слово 1 пробелом
        return String.join(" ", list);
    }
}
