package LeetCode_Not_Solved.MEDIUM;

public class M_MultiplyStrings_43 {
    public static void main(String[] args) {

        System.out.println(new M_MultiplyStrings_43().multiply("128", "12"));
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
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
        String sum = "";
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

                if (numberToAdd != 0) tempNumber = numberToAdd + tempNumber;

            }
            tempNumber = countOfNumbersToAdd == 0 ? tempNumber : countOfNumbersToAdd + tempNumber;
            //тут нужно еще добавить определенное к-во нулей к концу числа
            for(int countOfZeroes = 0; countOfZeroes < countOfZeroesToAddInTheEndOfNumber; countOfZeroes++) {
                tempNumber += 0;
            }
            //суммируем
            sum = sum(sum, tempNumber);
        }
        return sum + "";
    }

    private String sum(String sum, String tempNumber) {
        String lastSum = sum;
        String numberToAdd = tempNumber;

        String big;
        String small;
        if (lastSum.length() >= numberToAdd.length()) {
            big = lastSum;
            small = numberToAdd;
        } else {
            big = numberToAdd;
            small = lastSum;
        }

        int[] arrayWithBigNumbers = new int[big.length()];
        for(int index = 0; index < arrayWithBigNumbers.length; index++) {
            arrayWithBigNumbers[index] = Integer.parseInt(big.charAt(index) + "");
        }

        int[] arrayWithSmallNumber = new int[big.length()];
        for(int index = 0; index < arrayWithSmallNumber.length; index++) {
            if (index < (big.length() - small.length())) arrayWithSmallNumber[index] = 0;
            else arrayWithSmallNumber[index] = Integer.parseInt(small.charAt(index - (big.length() - small.length())) + "");
        }

        int count = 0;
        String tempSum = "";
        for(int index = arrayWithSmallNumber.length - 1; index >= 0; index--) {
            int number1 = arrayWithSmallNumber[index];
            int number2 = arrayWithBigNumbers[index];

            int tempResult = number1 + number2 + count;
            if (tempResult <= 9) {
                tempSum = tempResult + tempSum;
                count = 0;
            }
            else {
                count = tempResult / 10;
                tempSum = tempResult % 10 + tempSum;
            }
        }
        if(count != 0) tempSum = count + tempSum;

        sum = tempSum;
        return sum;
    }
}
