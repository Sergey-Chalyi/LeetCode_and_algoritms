package LeetCode_Solved.MEDIUM;

public class M_MultiplyStrings_43 {
    //вообще, для того, чтобы понять мой алгоритм, нужно его нарисовать, но я все же оставлю комментарии
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        //вычисляем большее по размеру число и присваиваем в соответствующую переменную
        String biggerNumber;
        String smallerNumber;
        if (num1.length() >= num2.length()) {
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
        //после каждой итерации переменная sum у нас будет увеличиваться
        String sum = "";
        for(int i = smallerNumber.length() - 1; i >= 0; i--) { //будет столько итераций, скольки цифр в меньшем числе
            int digitFromSmall = arrayWithDigitsFromSmallerNumber[i];

            //в зависимости от уровня умножения (когда считаем в столбик), у нас в конце числа будут добавлятся нули
            int countOfZeroesToAddInTheEndOfNumber = smallerNumber.length() - i - 1;


            int countOfNumbersToAdd = 0; // переменная, которая хранит число, которое при умножении в столбик мы "запоминали"/писали сверху
            String tempNumber = ""; // в эту переменную сохраняется число, которое потом будем суммировать

            for(int j = biggerNumber.length() - 1; j >= 0; j--) {
                int digitFromBig = arrayWithDigitsFromBiggerNumber[j];

                //делаем последовательное умножение цифры с меньшего числа на цифры большего числа
                int numberToAdd = countOfNumbersToAdd + (digitFromSmall * digitFromBig);

                //проверяем размер произведения и, если число двузначное, разделяем его для корректной записи результата
                if(numberToAdd > 9) {
                    countOfNumbersToAdd = numberToAdd / 10;
                    numberToAdd = numberToAdd % 10;
                } else {
                    countOfNumbersToAdd = 0;
                    numberToAdd = numberToAdd;
                }

                //дописываем, как будет выглядеть число
                tempNumber = numberToAdd + tempNumber;

            }
            //не забываем,что переменная, в которую мы "запоминаем" может все еще соделжать значение, нельзя его утерять
            if (countOfNumbersToAdd != 0) tempNumber = countOfNumbersToAdd + tempNumber;

            //тут нужно еще добавить определенное к-во нулей к концу числа в зависимости от его уровня (при умножении в столбик)
            for(int countOfZeroes = 0; countOfZeroes < countOfZeroesToAddInTheEndOfNumber; countOfZeroes++) {
                tempNumber += 0;
            }
            //суммируем
            sum = sum(sum, tempNumber);
        }
        return sum + "";
    }

    private String sum(String sum, String tempNumber) {
        //изначально написал эти переменные. Понимаю, что они лишние, но хай будут - не хочу портить логику
        String lastSum = sum;
        String numberToAdd = tempNumber;

        //тут тоже вычисляем большее число по длине
        String big;
        String small;
        if (lastSum.length() >= numberToAdd.length()) {
            big = lastSum;
            small = numberToAdd;
        } else {
            big = numberToAdd;
            small = lastSum;
        }

        //опять записываем цифры числа в массивы
        int[] arrayWithBigNumbers = new int[big.length()];
        for(int index = 0; index < arrayWithBigNumbers.length; index++) {
            arrayWithBigNumbers[index] = Integer.parseInt(big.charAt(index) + "");
        }

        //тут важно
        int[] arrayWithSmallNumber = new int[big.length()]; //да, массив должен быть по величине, как длина большего числа
        for(int index = 0; index < arrayWithSmallNumber.length; index++) { //в условие цикла ставим именно длину массива, а не самой строки
            if (index < (big.length() - small.length()))
                arrayWithSmallNumber[index] = 0; // добавляем в начало числа нули, чтоб корректно можно было суммировать в столбик
            else
                arrayWithSmallNumber[index] = Integer.parseInt(small.charAt(index - (big.length() - small.length())) + ""); //после нулей уже дописываем цифры числа
        }


        int count = 0;//переменная, в коотрую "запоминаем"
        String tempSum = ""; //сумма, которая у нас получится
        for(int index = arrayWithSmallNumber.length - 1; index >= 0; index--) {
            //получаем цифры с боьлшего и меньшего числа из одинаковых позиций (еденицы, десятки...)
            int numberFromSmall = arrayWithSmallNumber[index];
            int numberFromBig = arrayWithBigNumbers[index];

            //дальше логика такая же, как и при умножении
            int tempResult = numberFromSmall + numberFromBig + count;
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

        sum = tempSum;//не спрашивай, зачем тут сделал присваивание, я сам не понимаю, но: работает - не лезь))
        return sum;
    }
}
