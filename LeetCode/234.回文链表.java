/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (54.48%)
 * Likes:    1906
 * Dislikes: 0
 * Total Accepted:    749.3K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,2,1]'
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,2]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * 
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // 反转前半部分的链表，变成两个链表
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 节点数为奇数时，特殊处理下
        if (fast != null)
            slow = slow.next;
        // 对比两个链表的值是否完全相同
        while (slow != null) {
            if (slow.val != pre.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
// @lc code=end

