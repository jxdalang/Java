/**
* @package leetcode
* @author ZS@ZJU
* @version V1.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* @className Permutation
* @description TODO
* @author ZS@ZJU
* @date May 19, 2016 2:05:13 PM
*/
public class Solution {

    public static List<List<Integer>> permutation(int[] array) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(array);
        if (array.length != 0) {
            List<Integer> solution = new ArrayList<>();
            Set<Integer> remainIndex = new HashSet<>();
            for (int i = 0; i < array.length; i++) {
                remainIndex.add(i);
            }

            calculate(ret, solution, array, remainIndex);
        }
        return ret;
    }

    private static void calculate(List<List<Integer>> ret, List<Integer> solution, int[] array,
            Set<Integer> remainIndex) {
        if (solution.size() == array.length) {
            ret.add(solution);
        } else {
            for (Integer i : remainIndex) {
                // bypass duplicates
                
                ArrayList<Integer> newSolution = new ArrayList<>(solution);
                newSolution.add(array[i]);
                Set<Integer> newRemainIndex = new HashSet<>(remainIndex);
                newRemainIndex.remove(i);
                calculate(ret, newSolution, array, newRemainIndex);
            }
        }
    }

    /**
    * @description simple test
    * @param args 
    * @returnType void
    */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test_array = { 1, 2, 1 };
        System.out.println(Solution.permutation(test_array));
    }

}
