package LeetCode;

import java.util.ArrayList;

/**
 * Created by haha on 2018/7/26.
 */
public class Subset {
    public static void dfs(int[] nums, ArrayList<Integer> temp, int start, ArrayList<ArrayList<Integer>> res){
        for (int i=start; i<nums.length; i++)
        {
            temp.add(nums[i]);
            res.add(new ArrayList<Integer>(temp));
            dfs(nums,temp,i+1,res);
            temp.remove(temp.size()-1);
        }
    }
    public static void subset(int[] nums)
    {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        double MAX = Math.pow(2,nums.length);
        for (int i=0; i<MAX; i++)
        {
            ArrayList<Integer> set1 = new ArrayList<Integer>();
            int index = i;
            for (int j = 0; j<nums.length;j++)
            {
                if ((index & 1) == 1)
                {
                    set1.add(nums[j]);
                }
                index >>= 1;
                //else if ()
            }
            results.add(set1);
        }
        System.out.println(results.toString());

    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        subset(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        dfs(nums,new ArrayList<Integer>(),0,res);
        res.add(new ArrayList<Integer>());
        System.out.println(res);

    }
}
