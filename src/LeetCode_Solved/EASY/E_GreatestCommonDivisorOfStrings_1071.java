package LeetCode_Solved.EASY;

public class E_GreatestCommonDivisorOfStrings_1071 {
    public static void main(String[] args) {
        System.out.println(new E_GreatestCommonDivisorOfStrings_1071().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }

    public String gcdOfStrings(String str1, String str2) {
        // находим большую из строк
        String bigger, smaller;
        if (str1.length() >= str2.length()) {
            bigger = str1;
            smaller = str2;
        } else {
            bigger = str2;
            smaller = str1;
        }

        // проверяем, если мы попробуем из строки сделать массив
        for(int i = smaller.length(); i > 0; i--) {
            String substring = smaller.substring(0, i);
            if (bigger.split(substring).length == 0 && smaller.split(substring).length == 0)
                return substring;
        }
        return "";
    }

    private String isStringSpletted (String string) {
        for(int i = 1; i < string.length(); i++) {
            if (string.split(string.substring(0, i)).length == 0) return string.substring(0, i);
        }
        return string;
    }
}
