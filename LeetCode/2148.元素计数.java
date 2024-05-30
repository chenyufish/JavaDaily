/*
 * @lc app=leetcode.cn id=2148 lang=java
 *
 * [2148] 元素计数
 *
 * https://leetcode.cn/problems/count-elements-with-strictly-smaller-and-greater-elements/description/
 *
 * algorithms
 * Easy (57.07%)
 * Likes:    27
 * Dislikes: 0
 * Total Accepted:    16K
 * Total Submissions: 28K
 * Testcase Example:  '[11,7,2,15]'
 *
 * 给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [11,7,2,15]
 * 输出：2
 * 解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
 * 元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
 * 总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [-3,3,3,90]
 * 输出：2
 * 解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
 * 由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 100
 * -10^5 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
public int countElements(int[] nums) {
    int n = nums.length; // 数组长度
    if (n == 1)
        return 0; // 特殊情况：数组长度为1，返回0
    Arrays.sort(nums); // 对数组进行排序

    int i = 0; // 左指针
    int j = n - 1; // 右指针

    while (true) {
        while (i < j && nums[i] == nums[i + 1]) {
            i++; // 移动左指针，直到找到第一个不相同的元素
        }
        while (j > i && nums[j] == nums[j - 1]) {
            j--; // 移动右指针，直到找到第一个不相同的元素
        }
        break; // 找到不相同的元素后跳出循环
    }
    // 如果左指针大于等于右指针，表示没有不相同的元素，返回0
    return i >= j ? 0 : j - i - 1; // 返回不相同元素的个数
    }
}
// @lc code=end

