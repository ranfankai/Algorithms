package Sort;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/22.
 */
public class QuickSort {

    private static int partition(int[] nums, int start,int end)
    {
        int base = nums[start];
        while (start < end)
        {
            while (start < end && nums[end]>=base)end--;
            if (start < end)
                nums[start++] = nums[end];

            while (start < end && nums[start] <= base)start++;
            if (start < end)
                nums[end--] = nums[start];
        }

        nums[start] = base;
        return start;
    }
    public static void  sort(int[] nums, int start,int end)
    {
            if (start < end){
                int i = partition(nums,start,end);
                sort(nums,start,i-1);
                sort(nums,i+1,end);
            }
    }

    public static void main(String[] args) {
        int[] nums = {12,53,17,36,1,66,23};
        QuickSort.sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
