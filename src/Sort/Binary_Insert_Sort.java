package Sort;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/27.
 */
public class Binary_Insert_Sort {
    public static void sort(int[] nums)
    {
        int N = nums.length;
        for (int i=1;i<N;i++)
        {
            int tmp = nums[i];
            int low = 0;
            int high = i-1;
            while (low <= high)
            {
                int mid = (low+high)/2;
                if (nums[mid]>tmp)high = mid-1;
                else low = mid+1;
            }
            for (int j = i-1; j>=high+1; j--)
            {
                nums[j+1] = nums[j];
            }
            nums[high+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,67,3,9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
