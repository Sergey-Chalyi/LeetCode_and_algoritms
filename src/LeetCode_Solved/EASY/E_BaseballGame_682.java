package LeetCode_Solved.EASY;

import java.util.ArrayList;
import java.util.List;
//27-05-24
public class E_BaseballGame_682 {
    public int calPoints(String[] operations) {
        List<Integer> finishList = new ArrayList<>();
        //-----
        for(String operation : operations) {
            int listLength = finishList.size();
            switch (operation) {
                case "+":
                    finishList.add(finishList.get(listLength - 1) + finishList.get(listLength - 2));
                    break;
                case "D":
                    finishList.add(finishList.get(listLength - 1) * 2);
                    break;
                case "C":
                    finishList.remove(listLength - 1);
                    break;
                default:
                    finishList.add(Integer.parseInt(operation));
                    break;
            }
        }
        //-----
        int finalSum = 0;
        for(Integer number : finishList) finalSum += number;
        return finalSum;
    }
}
