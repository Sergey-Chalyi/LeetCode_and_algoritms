package LeetCode_Solved.EASY;

import java.util.*;
//10-06-2024

public class E_ReverseVowelsOfAString_345 {
    public static void main(String[] args) {
        System.out.println(new E_ReverseVowelsOfAString_345().reverseVowels("hello"));
    }
    public String reverseVowels(String string) {
        // cоздаем скроку, в которую будем записывать финальный результат
        String resultString = "";
        // cоздаем лист для хранения всех гласных из слова
        List<Character> characters = new LinkedList<>();
        // заполняем его
        for(int i = 0; i < string.length(); i++) {
            if (isAVoteSymbol(string.charAt(i))) characters.add(string.charAt(i));
        }
        // переворачиваем лист
        Collections.reverse(characters);
        //теперь опять проходим циклом по исходной строке и заменяем все символы
        for(int i = 0; i < string.length(); i++) {
            if (isAVoteSymbol(string.charAt(i))) { // если буква - гласная, то добавляем в результат с заменой
                resultString += characters.get(0); // добавляем первый символ из листа (развернутого) с буквами
                characters.remove(0); // и удаляем первый елемент листа
            } else {
                resultString += string.charAt(i); // в противном случае просто добавляем согласную к результату
            }
        }
        return resultString;

    }

    private boolean isAVoteSymbol(char symbol) {
        Character[] vowels = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        List<Character> listWithVoteCharacters = Arrays.asList(vowels);
        // проверяем, находится ли символ в промежутке английских букв нижнего и верхнего регистра
        return listWithVoteCharacters.contains(symbol);
    }
}
