package LeetCode_Solved.EASY;
//07-06-2024
public class E_MergeStringsAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        //получайм длины слов, чтоб потом в коде удобно было все читать
        int len1 = word1.length(), len2 = word2.length();
        // узнаем длину МЕНЬШЕГО числа, чтоб пройтись в цикле и не выйди за границы ни одного из чисел
        int minLength = (len1 <= len2 ? len1 : len2);
        // создаем этот объект, ибо так правильнее, вместо String += String
        StringBuilder finalString = new StringBuilder();
        //собственно, сам цикл
        for(int i = 0; i < minLength; i++) {
            finalString.append(word1.charAt(i));
            finalString.append(word2.charAt(i));
        }
        // если длины числе равны, то цик прошел по всему, что нужно
        if (len1 == len2) return finalString.toString();
        //в противном случае добавляем то, что осталось
        else if (len1 > len2) return finalString.append(word1.substring(len1 - (len1 - len2), len1)).toString();
        else return finalString.append(word2.substring(len2 - (len2 - len1), len2)).toString();
    }
}
