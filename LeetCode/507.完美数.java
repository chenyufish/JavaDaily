/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 *
 * https://leetcode.cn/problems/perfect-number/description/
 *
 * algorithms
 * Easy (49.18%)
 * Likes:    206
 * Dislikes: 0
 * Total Accepted:    87K
 * Total Submissions: 176.9K
 * Testcase Example:  '28'
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 
 * 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * 
 * 示例 2：
 * 
 * 
 * 输入：num = 7
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= num <= 10^8
 * 
 * 
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        
        return sum == num;
    }
}
// @lc code=end

