package Sort;

/**
 * Created by haha on 2018/7/27.
 */
public class Simple_Select_Sort {
    public static void sort(int[] nums)
    {
        for (int i=0;i<nums.length;i++)
        {
            int k = i;
            for (int j = i+1; j < nums.length; j++)
                if (nums[j] < nums[k])
                    k = j;
            if (k != i){
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
            }
        }
    }
}
