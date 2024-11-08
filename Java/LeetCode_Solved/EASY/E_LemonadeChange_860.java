package LeetCode_Solved.EASY;

import java.util.HashMap;
import java.util.Map;

public class E_LemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> money = new HashMap<>();
        money.put(5, 0);
        money.put(10, 0);
        money.put(20, 0);

        for (int bill : bills) {
            //проверяем нужно ли давать сдачу
            if (bill == 5) {
                //не нужно
                //просто добавляем в счетчик наших купюр еще одну 5-номинальную купюру
                money.put(bill, money.get(bill) + 1);
            } else if (bill == 10) {
                //проверяем, можем ли мы дать клиенту сдачу
                if (money.get(5) == 0) {
                    // не можем
                    return false;
                } else {
                    // увеличиваем к-во 10-ти номинальных купюр на 1
                    money.put(10, money.get(10) + 1);
                    // и уменьшаем на 1 счетчик 5-ти номинальных купюр
                    money.put(5, money.get(5) - 1);
                }
            } else if (bill == 20){
                if ((money.get(5) >= 1 && money.get(10) >= 1) || money.get(5) >= 3) {
                    //можем дать сдачу
                    if (money.get(5) >= 1 && money.get(10) >= 1) {
                        money.put(20, money.get(20) + 1);
                        money.put(10, money.get(10) - 1);
                        money.put(5, money.get(5) - 1);
                    } else {
                        money.put(20, money.get(20) + 1);
                        money.put(5, money.get(5) - 3);
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
