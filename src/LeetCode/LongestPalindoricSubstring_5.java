package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2018/7/16.
 */
public class LongestPalindoricSubstring_5 {
    int maxLen = 0;
    String sub = "";
    //O(n)  Manacher 算法
    public String longestPalindrome(String s) {
        String result = "";
        List<Character> snew = new ArrayList<Character>();
        List<Integer> len = new ArrayList<Integer>();
        for (int i=0;i<s.length();i++)
        {
            snew.add('#');
            snew.add(s.charAt(i));
        }
        snew.add('#');

        len.add(1);
        int sub_mid = 0;
        int sub_side = 0;

        for (int i=1 ; i<snew.size(); i++)
        {
            if (i<sub_side)
            {
                int j = 2*sub_mid - i;
                if (len.get(j)<sub_mid-j)
                {
                    len.add(len.get(j));
                }
                else
                {
                    while (snew.get(sub_side+1) == snew.get(2*i-sub_side))
                    {
                        sub_side++;
                    }
                    len.add(sub_side-i);
                }
            }
            else {

            }
        }
        return result;
    }

    // O(n^2)
//    public String longestPalindrome(String s) {
//        for (int i=0;i<s.length();i++)
//        {
//            findLongestSub(s,i,i);
//            findLongestSub(s,i,i+1);
//        }
//        return sub;
//    }
//    public void findLongestSub(String s, int i, int j)
//    {
//        int len = 0;
//        while (i>=0 && j<=s.length()-1 && i<=j)
//        {
//            if (s.charAt(i) == s.charAt(j))
//            {
//                len = j-i+1;
//                if (len > maxLen)
//                {
//                    maxLen = len;
//                    sub = s.substring(i,j+1);
//                }
//                i--;j++;
//            }
//            else break;
//        }
//    }
    public static void main(String[] args) {
        String s = "asdfdsd";
        System.out.println(new LongestPalindoricSubstring_5().longestPalindrome(s));
    }
}
