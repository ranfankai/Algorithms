package LeetCode;

/**
 * Created by haha on 2018/7/17.
 */
public class LongestSubWORepeat_3 {
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() <= 1 )return s.length();
//        String tmp = s.substring(0,1);
//        int left = 0; int right = 1; int len = 0;
//        int maxLen = 1; int maxLeft = 0; int maxRight = 0;
//
//        for (right = 1; right<s.length(); right++)
//        {
//            char a = s.charAt(right);
//            int index = tmp.substring(left,right).indexOf(a);
//
//            if (index > -1)
//                left = left + index + 1;
//            else {
//                len = right - left + 1;
//                if (len > maxLen)
//                {
//                    maxLen = len;
//                    maxLeft = left;
//                    maxRight = right;
//                }
//            }
//            tmp += a;
//        }
//        System.out.println(s.substring(maxLeft,maxRight+1));
//        return maxLen;
//    }
public int lengthOfLongestSubstring(String s) {
    if (s.length() <= 1 )return s.length();
    String tmp = s.substring(0,1);
//    int left = 0; int right = 1;
    int len = 0;
    int maxLen = 1;
//    int maxLeft = 0; int maxRight = 0;
    for (int right = 1; right<s.length(); right++)
    {
        char a = s.charAt(right);
        int index = tmp.indexOf(a);

        if (index > -1)
            tmp = tmp.substring(index+1,tmp.length());
        else {
            len = tmp.length() + 1;
            if (len > maxLen)
            {
                maxLen = len;
            }
        }
        tmp += a;
    }
    return maxLen;
}
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new LongestSubWORepeat_3().lengthOfLongestSubstring(s));
    }
}
