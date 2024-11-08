package LeetCode_Solved.EASY;

import java.util.ArrayList;
import java.util.Collections;

class E_RichestCustomerWealth_1672 {
    public int maximumWealth(int[][] accounts) {
        ArrayList<Integer> ammountsOfMoney = new ArrayList<>();
        for(int i = 0; i < accounts.length; i++) {
            int countOfMoney = 0;
            for(int j = 0; j < accounts[i].length; j++) {
                countOfMoney += accounts[i][j];
            }
            ammountsOfMoney.add(countOfMoney);
        }

        return Collections.max(ammountsOfMoney);
    }
}