/**
* @package combination_sum
* @author ZS@ZJU
* @version V1.0
*/
package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @className Solution
* @description TODO
* @author ZS@ZJU
* @date Dec 22, 2015 9:47:28 PM
*/

/**
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backtrack(ret, new ArrayList<Integer>(), 0, candidates, target);

        return ret;
    }

    // 类似dfs的解法，solution存储着当前求解的路径
    private void backtrack(List<List<Integer>> ret, List<Integer> solution, int start, int[] candidates, int target) {
        if (target == 0)
            // 将当前解的<<拷贝>>加入解集ret，不能直接将solution加入ret，因为ret包含的只是引用
            ret.add(new ArrayList<Integer>(solution));
        else if (target > 0) {
            // 将start索引之后的所有不大于target的元素都依次放入solution，继续下一步求解
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                // 同一递归深度上不能使用值相等但索引不同的元素，不然会产生重根
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                solution.add(candidates[i]); // 放入
                // 求解，由于元素可以复用，所以传入的start还是i
                backtrack(ret, solution, i, candidates, target - candidates[i]);
                solution.remove(solution.size() - 1); // 取出当前元素，准备在下一次循环中放入下一个元素
            }
        }

        return;
    }

    // simple test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum(new int[] { 2, 2, 3, 6, 7 }, 7));
        System.out.println(s.combinationSum(new int[] {}, 0));
        System.out.println(s.combinationSum(new int[] { 1, 1 }, 1));
        System.out.println(s.combinationSum(new int[] { 1, 2 }, 4));
        System.out.println(s.combinationSum(new int[] { 2, 3 }, 5));
    }
}