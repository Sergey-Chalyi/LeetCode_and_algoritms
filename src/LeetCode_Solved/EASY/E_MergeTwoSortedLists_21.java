package LeetCode_Solved.EASY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//05-06-2024

//Definition for singly-linked list.
//условие задачи
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class E_MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //перед тем, как делать махинации, нужно обработать два события
        if (list1 == null && list2 == null) {// если ОБА списка пусты
            return null;
        } else if (list1 == null || list2 == null) {// если один из них пустой
            return list1 == null ? list2 : list1;
        }

        //создаем листы для хранения значений для каждого из списков
        List<Integer> valuesFromList1 = new ArrayList<>();
        List<Integer> valuesFromList2 = new ArrayList<>();

        //заполняем их значениями
        while (list1.next != null) {
            valuesFromList1.add(list1.val); //сначала это действие
            list1 = list1.next; // а потом уже это
        }
        valuesFromList1.add(list1.val); // !!! НЕ забываем добавить последнее значение, ибо цикл не доходит по условию до него

        while (list2.next != null) {
            valuesFromList2.add(list2.val);
            list2 = list2.next;
        }
        valuesFromList2.add(list2.val);

        //сортируем оба листа по возрастанию, ибо значения в лист заносились "с конца" отсортированного связанного списка
        Collections.sort(valuesFromList1);
        Collections.sort(valuesFromList2);

        //нужно пройти по одному из листов и проверять, если ли данное значение во втором листе
        for (int i = 0; i < valuesFromList1.size(); i++) {
            Integer element = valuesFromList1.get(i);
            //если во втором листе есть такое значение
            if (valuesFromList2.contains(element)) {
                //то нужно вставить под тот же индекс
                int positionToAdd = valuesFromList2.indexOf(element);
                valuesFromList2.add(positionToAdd, element);
            } else {
                // если в листе есть еллемент, больший за данный, то проходим по листу и добавляем на место
                // первого большего еллемента наш еллемент
                if (valuesFromList2.getLast() > element) {
                    for (int j = 0; j < valuesFromList2.size(); j++) {
                        if (element < valuesFromList2.get(j)) {
                            valuesFromList2.add(j, element);
                            break;
                        }
                    }
                } else { // в противном случае просто в конец добавляем наш эллемент
                    valuesFromList2.add(element);
                }
            }
        }
        // теперь создаем объект нужного нам класса и заполняем его значениями
        ListNode listNode = new ListNode();
        ListNode theHead = null; // переменная для хранения "головы связанного списка", инициализируем сначала, чтоб компилятор не ругался
        for (int i = 0; i < valuesFromList2.size() - 1; i++) { //!!!цикл проходит не полностью по листу, а СПЕЦИАЛЬНО не задевает последний элемент
            listNode.val = valuesFromList2.get(i);
            listNode.next = new ListNode();
            if (i == 0) {theHead = listNode;} //присваиваем "голову" связанного списка
            listNode = listNode.next;
        }
        //это сделано для того (не задеваем последний еллемент), чтоб последнему звену связного списка присвоить просто значение
        //и не переприсваивать переменную listNode, чтоб можно было вернуть корректный результат
        listNode.val = valuesFromList2.getLast();

        return theHead;
    }
}
