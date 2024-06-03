package LeetCode_Not_Solved.MEDIUM;

public class M_MultiplyStrings_43 {
    public static void main(String[] args) {

        System.out.println(new M_MultiplyStrings_43().multiply("128", "12"));
    }

    public String multiply(String num1, String num2) {
        //вычисляем большее по размеру число и присваиваем в соответствующую переменную
        String biggerNumber;
        String smallerNumber;
        if (num1.length() == num2.length()) {
            biggerNumber = num1;
            smallerNumber = num2;
        } else if (num1.length() > num2.length()) {
            biggerNumber = num1;
            smallerNumber = num2;
        } else {
            biggerNumber = num2;
            smallerNumber = num1;
        }

        //преорбазовываем числа в миссивы с цифрами
        int[] arrayWithDigitsFromBiggerNumber = new int[biggerNumber.length()];
        for(int i = 0; i < arrayWithDigitsFromBiggerNumber.length; i++) {
            arrayWithDigitsFromBiggerNumber[i] = Integer.parseInt(biggerNumber.charAt(i) + "");
        }

        int[] arrayWithDigitsFromSmallerNumber = new int[smallerNumber.length()];
        for(int i = 0; i < arrayWithDigitsFromSmallerNumber.length; i++) {
            arrayWithDigitsFromSmallerNumber[i] = Integer.parseInt(smallerNumber.charAt(i) + "");
        }

        //начинаем умножение
        long sum = 0;
        for(int i = smallerNumber.length() - 1; i >= 0; i--) {
            int digitFromSmall = arrayWithDigitsFromSmallerNumber[i];

            int countOfZeroesToAddInTheEndOfNumber = smallerNumber.length() - i - 1;

            int countOfNumbersToAdd = 0;
            String tempNumber = "";

            for(int j = biggerNumber.length() - 1; j >= 0; j--) {
                int digitFromBig = arrayWithDigitsFromBiggerNumber[j];

                int numberToAdd = countOfNumbersToAdd + (digitFromSmall * digitFromBig);

                if(numberToAdd > 9) {
                    countOfNumbersToAdd = numberToAdd / 10;
                    numberToAdd = numberToAdd % 10;
                } else {
                    countOfNumbersToAdd = 0;
                    numberToAdd = numberToAdd;
                }


                tempNumber = (numberToAdd) + tempNumber;

            }
            tempNumber = countOfNumbersToAdd == 0 ? tempNumber : countOfNumbersToAdd + tempNumber;
            //тут нужно еще добавить определенное к-во нулей к концу числа
            for(int countOfZeroes = 0; countOfZeroes < countOfZeroesToAddInTheEndOfNumber; countOfZeroes++) {
                tempNumber += 0;
            }

            sum += Long.parseLong(tempNumber);
        }
        return sum + "";
    }
    // НУЖНО дописать алгоритм плюбсования, ибо даже иногда контейнера long мало!!!
}
