package Sort;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/23.
 */
public class HeapSort {

    //调整大顶堆
    public static void sift(int[] arr, int i, int length){
        int temp = arr[i]; //根数据
//        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
//            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
//                k++;
//            }
//            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//                arr[i] = arr[k];
//                i = k;
//            }else{
//                break;
//            }
//        }
        //大顶堆
//         int j = 2*i+1;
//        while (j < length)
//        {
//            if (j+1 <length && arr[j] < arr[j+1])j++; //找最大的子节点
//            if (temp > arr[j])break;   //根就是最大，直接退出
//            else {
//                arr[i] = arr[j]; i = j; j = 2*i+1;    //交换根和最大子节点
//            }
//        }
        //小顶堆
        int j = 2*i+1;
        while (j < length)
        {
            if (j+1 <length && arr[j] > arr[j+1])j++; //若存在右子树，且右子树更小，筛选右分支。
            if (temp < arr[j])break;   //根就是最小，直接退出
            else {
                arr[i] = arr[j]; i = j; j = 2*i+1;    //交换根和最小子节点
            }
        }
        arr[i] = temp;
    }
    public static void sort(int[] arr){
        int n = arr.length;
        for (int i = n/2-1;i>=0;i-- )sift(arr,i,n); //建初始对，保证每个节点的子树都是堆
        //System.out.println(arr[0]);
        for (int i = n-1; i>0; i--)
        {
            int tmp = arr[0];arr[0] = arr[i]; arr[i] = tmp;
            sift(arr,0,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1,3,8,5,35,61,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
