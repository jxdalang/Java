package permutations;

import java.util.ArrayList;
import java.util.List;

/**
* @className Permutation
* @description TODO
* @author ZS@ZJU
* @date May 19, 2016 2:05:13 PM
*/

/**
Given a collection of "distinct" numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Solution {

    /**
    The basic idea is, to permute n numbers, we can add the nth number into the resulting List<List<Integer>> 
    from the n-1 numbers, in every possible position.
    
    For example, if the input num[] is {1,2,3}: First, add 1 into the initial List<List<Integer>> 
    (let's call it "answer").
    
    Then, 2 can be added in front or after 1. So we have to copy the List<Integer> in answer (it's just {1}), 
    add 2 in position 0 of {1}, then copy the original {1} again, and add 2 in position 1. 
    Now we have an answer of {{2,1},{1,2}}. There are 2 lists in the current answer.
    
    Then we have to add 3. first copy {2,1} and {1,2}, add 3 in position 0; 
    then copy {2,1} and {1,2}, and add 3 into position 1, then do the same thing for position 3. 
    Finally we have 2*3=6 lists in answer, which is what we want.
     */
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length == 0)
            return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i < num.length; ++i) {
            // new_ans contains all the solutions with length = i+1
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();

            // insert num[i] into every position of every last solution
            for (int j = 0; j <= i; ++j) { // j stands for position
                // l stands for one of the last solutions
                for (List<Integer> l : ans) {
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
        int[] test_array = { 1, 2, 3 };
        System.out.println(new Solution().permute(test_array));
    }

}
