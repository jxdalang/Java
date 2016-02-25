/**
* @package pat_java
* @author ZS@ZJU
* @version V1.0
*/
package pat_java;

/**
Count PAT's (25)
*/
public class Solution {

    public static long countPAT(String s) {
        long p = 0L, pa = 0L, pat = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P') {
                p++;
            } else if (s.charAt(i) == 'A') {
                pa+=p;
            } else if (s.charAt(i) == 'T') {
                pat+=pa;
            }
        }

        return pat%1000000007L;
    }

    /**
    * @description test
    * @param args
    * @returnType void
    */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Solution.countPAT("APPAPT"));
        System.out.println(Solution.countPAT("TAPPTATPAT"));
        System.out.println(Solution.countPAT("TAPTATA"));
    }

}
