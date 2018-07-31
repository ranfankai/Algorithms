package LeetCode; /**
 * Created by haha on 2018/7/15.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class threeSum_15 {

    public static  List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3)return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);  //先排序

        int left,right;
        for (int i = 0; i<nums.length-2;i++)
        {
            if (i>0 && nums[i]==nums[i-1])continue; //防重复，跳过首数字相同的列表
            if (nums[i]>0)break;
            left = i + 1 ;
            right = nums.length-1;
            while (left < right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                if (sum>0)
                    right--;
                else if (sum<0)
                    left++;
                else {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left++]);  //命中，同时左指针右移
                    tmp.add(nums[right--]);
                    res.add(tmp);

                    while (left<right && nums[left]==nums[left-1])left++;   //跳过已命中的重复的数
                    while (left<right && nums[right]==nums[right-1])right--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-1,-1, 0, 1, 2, -4};
        long a = System.currentTimeMillis();
        //List<Integer> ls = Arrays.asList(nums[1],nums[2],nums[3]);
        System.out.println(threeSum(nums));
        long b = System.currentTimeMillis();
        System.out.println(String.format("%d %d %d",a,b,b-a));
    }
}

