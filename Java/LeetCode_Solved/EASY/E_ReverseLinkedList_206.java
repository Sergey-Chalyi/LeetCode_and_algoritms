package LeetCode_Solved.EASY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//06-06-24
public class E_ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        // не забываем обработать специальные случаи
        if (head == null) return null;
        if (head != null && head.next == null) return head;

        List<Integer> list = new ArrayList<>(); // создаем лист, куда запишем все
        while(head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val); // не забываем добавлять последний эллемент
        Collections.reverse(list); // разворачиваем лист

        ListNode listNode = new ListNode();
        ListNode newHead = new ListNode();
        for(int i = 0; i < list.size(); i++) {
            if (i == 0) newHead = listNode;
            listNode.val = list.get(i);
            if (i != list.size() - 1) {
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }
        return newHead;
    }
}


