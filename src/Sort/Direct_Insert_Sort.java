package Sort;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/26.
 */
public class Direct_Insert_Sort {
    public static void sort(int[] nums)
    {
        int tmp = -1;
        for (int i=1;i<nums.length; i++)
        {
            if (nums[i]>nums[i-1])continue;
            else{
                tmp = nums[i];
                int j;
                for (j=i-1;j>=0 && nums[j]>tmp;j--){
                    nums[j+1] = nums[j];
                }
                nums[j+1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,7,3,9,2};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
