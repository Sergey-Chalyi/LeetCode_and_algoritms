package LeetCode_Solved.MEDIUM;

public class M_1456_MaximumNumberOfVowelsInASubstringOfGivenLength {
    // algorithm 1 (tile limit expression)
    public int maxVowels1(String string, int k) {
        int countOfVowelLettersInCurrentSubstring = getCountOfVowelLettersInString(string.substring(0, k));
        int maxCountOfVowelLettersInAllSubstrings = countOfVowelLettersInCurrentSubstring;
        int lastIndex = 0;

        for(int i = k; i < string.length(); i++) {
            countOfVowelLettersInCurrentSubstring = getCountOfVowelLettersInString(string.substring(lastIndex + 1, i + 1));
            if (countOfVowelLettersInCurrentSubstring > maxCountOfVowelLettersInAllSubstrings)
                maxCountOfVowelLettersInAllSubstrings = countOfVowelLettersInCurrentSubstring;
            if (maxCountOfVowelLettersInAllSubstrings == k)
                return k;
            lastIndex++;
        }
        return maxCountOfVowelLettersInAllSubstrings;
    }

    // algorithm 2
    public int maxVowels(String string, int k) {
        int countOfVowelsInCurrentStr = getCountOfVowelLettersInString(string.substring(0, k));
        int maxCountOfVowelsInSubstrings = countOfVowelsInCurrentStr;
        int indexForFirstLetterInLastSubstring = 0;
        boolean isFirstLetterInLastSubstringVowel = isTheCharVowel(string.charAt(indexForFirstLetterInLastSubstring));

        for(int i = k; i < string.length(); i++) {
            if (isTheCharVowel(string.charAt(i))) {
                if (isFirstLetterInLastSubstringVowel) {
                    // countOfVowelsInCurrentStr stays the same
                } else
                    countOfVowelsInCurrentStr++;
            } else {
                if (isFirstLetterInLastSubstringVowel) {
                    countOfVowelsInCurrentStr--;
                } else {
                    // countOfVowelsInCurrentStr stays the same
                }
            }
            if (maxCountOfVowelsInSubstrings < countOfVowelsInCurrentStr)
                maxCountOfVowelsInSubstrings = countOfVowelsInCurrentStr;
            if (maxCountOfVowelsInSubstrings == k)
                return maxCountOfVowelsInSubstrings;

            indexForFirstLetterInLastSubstring++;
            isFirstLetterInLastSubstringVowel = isTheCharVowel(string.charAt(indexForFirstLetterInLastSubstring));
        }
        return maxCountOfVowelsInSubstrings;
    }

    private int getCountOfVowelLettersInString(String string) {
        return string.length() - string.replaceAll("[aeiou]", "").length();
    }


    private boolean isTheCharVowel(char symbol) {
        return (symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'u' || symbol == 'i');
    }
}
