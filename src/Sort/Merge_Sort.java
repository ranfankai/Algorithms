package Sort;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/27.
 */
public class Merge_Sort {
    public static void sort(int[] nums, int[]res, int s, int t)
    {
        if (s == t) res[s] = nums[s];
        else {
            int mid = (s + t)/2;
            sort(nums,res,s,mid);
            sort(nums,res,mid+1,t);
            merge(nums,res,s,mid,t);    //此时nums两部分应内部有序，合并到res才能有序
        }
    }
    public static  void merge(int[] nums, int[] res, int s, int m, int t)
    {
        int k=s,j=m+1,i=s;
        while (i<=m && j<=t)
        {
            if (nums[i] < nums[j])res[k++] = nums[i++];
            else res[k++] = nums[j++];
        }
        while (i <= m )res[k++] = nums[i++];
        while (j <= t)res[k++] = nums[j++];
        for (int l = s; l <= t; l++) {  //res已有序，赋给nums使其同样有序。才能保证下一次merge正确。
            nums[l] = res[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1,3,8,5,35,61,2};
        int[] res = new int[arr.length];
        sort(arr,res,0,arr.length-1);
        System.out.println(Arrays.toString(res));
    }
}
