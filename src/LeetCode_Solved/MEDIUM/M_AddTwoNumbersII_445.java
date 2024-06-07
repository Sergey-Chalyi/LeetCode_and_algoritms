package LeetCode_Solved.MEDIUM;
//07-06-2024
public class M_AddTwoNumbersII_445 {
    // этот метод скопирован из задачи 2 и чуток переделан
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        //создаем строки для хранения значений для каждого из списков
        String numberFromList1 = "";
        while (list1.next != null) {
            numberFromList1 += list1.val;
            list1 = list1.next;
        }
        numberFromList1 += list1.val;
        // не нужно это действие numberFromList1 = new StringBuffer(numberFromList1).reverse().toString(); // это действие по условию задачи

        String numberFromList2 = "";
        while (list2.next != null) {
            numberFromList2 += list2.val;
            list2 = list2.next;
        }
        numberFromList2 += list2.val;
        // не нужно это действие numberFromList2 = new StringBuffer(numberFromList2).reverse().toString();


        // преобразовываем строки в числа и суммируем
        String sum = mySum(numberFromList1, numberFromList2);
        //обратно в строку

        // не нужно это действие sum = new StringBuffer(sum).reverse().toString(); // по условию задачи


        //теперь создаем и заполняем новый связанный лист
        ListNode listNode = new ListNode();
        ListNode newHead = new ListNode();
        for(int i = 0; i < sum.length(); i++) {
            if (i == 0) {
                newHead = listNode;
            }
            listNode.val = Integer.parseInt(sum.charAt(i) + "");
            if (i != sum.length() - 1) {
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }
        return newHead;
    }

    //этот метод позаимствовал из задачи 43
    private String mySum(String sum, String tempNumber) {
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
