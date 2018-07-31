package Sort;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/27.
 */
public class Main_Sort {
    public static void main(String[] args) {
        int[] arr = {-1,3,8,5,35,61,2};
        Simple_Select_Sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
