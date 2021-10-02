package twopointers;

import java.util.List;

public class RemoveDuplicates {

    /**
     * Leetcode - 83. Remove Duplicates from Sorted List (Easy)
     * Time - O(n)
     * Space - O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode start = head, nextNode = start.next;
        while (start != null && nextNode != null) {
            nextNode = start.next;
            while (nextNode != null && nextNode.val == start.val) {
                nextNode = nextNode.next;
            }
            start.next = nextNode;
            start = start.next;
        }
        return head;
    }

    public ListNode deleteDuplicatesSingleLoop(ListNode head) {
        if (head == null) return null;
        ListNode start = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (start.val != nextNode.val) {
                start.next = nextNode;
                start = start.next;
            }
            nextNode = nextNode.next;
        }
        start.next = null;
        return head;
    }

    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null) return null;
        if (head.next != null && head.val == head.next.val) {
            head.next = head.next.next;
            deleteDuplicatesRecursive(head);
        } else {
            deleteDuplicatesRecursive(head.next);
        }
        return head;
    }

    /**
     * Leetcode - 82. Remove Duplicates from Sorted List II (Medium)
     * Time - O(n)
     * Space - O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesII(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node, cur = pre.next;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next != cur) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return node.next;
    }

    /**
     * Leetcode - 80. Remove Duplicates from Sorted Array II (Medium)
     * Time - O(n)
     * Space - O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int start = 2;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] != nums[start - 2]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return start;
    }

    /**
     * Leetcode - 287. Find the Duplicate Number (Medium)
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        /**
         *  1. First approach will be to sort the array, then iterate each element and find the repeated numbers.
         *  2. Second approach can be to use a hash map, and iterate each element and check if it has occurred previously.
         *  3. Now, there is one constraint that we have range of element [1, n]. We can take the advantage of that.
         *  Idea is to modify the current array instead of using extra hash map, we can use the array as a hash map.
         *  Modify the array in such a way, so that we can retrieve the element from the index and the frequency of that index.
         *  we can use modulo operator the current element on that index and division operator for finding the frequency.
         *  Increment each element by n. Iterate through each element and increment the value of arr[(element % n - 1] by n.
         *  4. Now, I want to solve this problem without modifying the current array...???
         *  00 - 1
         *  01 - 0
         *  10 - 0
         *  11 - 1 xnor = ~a^b
         */
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int index = nums[i] % n - 1;
            nums[index] += n;
            if (nums[index] / n > 1) {
                return index + 1;
            }
        }
        return 0;
    }

    /**
     * Leetcode - 1089. Duplicate Zeros (Easy)
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int len = arr.length, duplicates = 0;
        for (int i = 0; i + duplicates < len; i++) {
            if (arr[i] == 0) {
                duplicates++;
            }
        }
        int right = len - duplicates - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[right] == 0) {
                arr[i] = 0;
                i--;
            }
            if (i >= 0) {
                arr[i] = arr[right];
                right--;
            }
        }
    }


    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
//        ListNode node;
//
//        System.out.println("removeDuplicates()");
//        node = new ListNode(1);
//        node.next = new ListNode(1);
//        node.next.next = new ListNode(2);
//        removeDuplicates.deleteDuplicates(node).print();
//        node = new ListNode(1);
//        node.next = new ListNode(1);
//        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(3);
//        removeDuplicates.deleteDuplicates(node).print();
//        System.out.println();
//        // ---------------------------------------------
//        System.out.println("removeDuplicatesII()");
//        node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(4);
//        node.next.next.next.next.next = new ListNode(5);
//        removeDuplicates.deleteDuplicatesII(node).print();
//        node = new ListNode(1);
//        node.next = new ListNode(1);
//        node.next.next = new ListNode(1);
//        node.next.next.next = new ListNode(2);
//        node.next.next.next.next = new ListNode(3);
//        removeDuplicates.deleteDuplicatesII(node).print();
//        System.out.println();
//        // ----------------------------------------------
//        System.out.println("removeDuplicates()");
//        System.out.println(removeDuplicates.removeDuplicates(new int[] {1,1,1,2,2,3}));
//        System.out.println(removeDuplicates.removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3}));
//        System.out.println();
//        // ----------------------------------------------
//        System.out.println("findDuplicate()");
//        System.out.println(removeDuplicates.findDuplicate(new int[]{1,3,4,2,2}));
//        System.out.println(removeDuplicates.findDuplicate(new int[]{3,1,3,4,2}));
//        System.out.println(removeDuplicates.findDuplicate(new int[]{1,1}));
//        System.out.println(removeDuplicates.findDuplicate(new int[]{1,1,2}));
//        System.out.println();
        // ----------------------------------------------
        System.out.println("duplicateZeros()");
        removeDuplicates.duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
//        removeDuplicates.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
//        removeDuplicates.duplicateZeros(new int[]{1,2,3});
    }
}

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

    void print() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
