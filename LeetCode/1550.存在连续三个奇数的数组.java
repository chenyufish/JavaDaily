/*
 * @lc app=leetcode.cn id=1550 lang=java
 *
 * [1550] 存在连续三个奇数的数组
 *
 * https://leetcode.cn/problems/three-consecutive-odds/description/
 *
 * algorithms
 * Easy (65.64%)
 * Likes:    30
 * Dislikes: 0
 * Total Accepted:    33.5K
 * Total Submissions: 51K
 * Testcase Example:  '[2,6,4,1]'
 *
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 
 * 
 * 示例 2：
 * 
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                count++;
                if (count >= 2) {
                    return true;
                }
            } 
            else {
                count = 0;
            }
        }
        return false;
    }
}
// @lc code=end

