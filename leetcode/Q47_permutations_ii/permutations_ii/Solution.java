package permutations_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @className Permutation
* @description TODO
* @author ZS@ZJU
* @date May 19, 2016 2:05:13 PM
*/

/**
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length == 0)
            return ans;
        // need to sort first to ensure same elements are inserted consecutively
        Arrays.sort(num);
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i < num.length; ++i) {
            // new_ans contains all the unique solutions with length = i+1
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();

            // insert num[i] into every position of every last solution
            for (int j = 0; j <= i; ++j) { // j stands for position
                // l stands for one of the last solutions
                for (List<Integer> l : ans) {
                    // handle duplicate
                    if (j < l.size() && l.get(j) == num[i])
                        break;
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j, num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }

    /**
    * @description simple test
    * @param args 
    * @returnType void
    */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test_array = { 3, 3, 0, 3 };
        System.out.println(new Solution().permuteUnique(test_array));
    }

}
