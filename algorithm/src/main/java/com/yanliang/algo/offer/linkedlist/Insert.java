package com.yanliang.algo.offer.linkedlist;

/**
 * 剑指 Offer II 029. 排序的循环链表 https://leetcode-cn.com/problems/4ueAj6/
 *
 * <p>给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * <p>给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * <p>如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * <p>如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 *
 * <p>示例 1：
 *
 * <p>输入：head = [3,4,1], insertVal = 2 输出：[3,4,1,2] 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3
 * 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 *
 * <p>示例 2：
 *
 * <p>输入：head = [], insertVal = 1 输出：[1] 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。 示例 3：
 *
 * <p>输入：head = [1], insertVal = 0 输出：[1,0]
 *
 * <p>提示：
 *
 * <p>0 <= Number of Nodes <= 5 * 10^4 -10^6 <= Node.val <= 10^6 -10^6 <= insertVal <= 10^6
 */
public class Insert {

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            insert(head, node);
        }
        return head;
    }

    public void insert(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = cur;
        while (!(node.val >= cur.val && node.val <= next.val) && cur.next != head) {
            cur = next;
            next = next.next;
            if (biggest.val <= cur.val) {
                biggest = cur;
            }
        }
        if (node.val >= cur.val && node.val <= next.val) {
            cur.next = node;
            node.next = next;
        } else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
