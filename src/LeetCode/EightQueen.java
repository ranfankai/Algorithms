package LeetCode;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/26.
 */
//public class LeetCode.EightQueen {
//    /**
//     * 一共有多少个皇后（此时设置为8皇后在8X8棋盘，可以修改此值来设置N皇后问题）
//     */
//    int max = 8;
//    int num = 0;
//    /**
//     * 该数组保存结果，第一个皇后摆在array[0]列，第二个摆在array[1]列
//     */
//    int[] array = new int[max];
//
//    public static void main(String[] args) {
//        LeetCode.EightQueen queen = new LeetCode.EightQueen();
//        queen.check(0);
//        System.out.println(queen.num);
//
//    }
//
//    /**
//     * n代表当前是第几个皇后
//     * @param n
//     * 皇后n在array[n]列
//     */
//    private void check(int n) {
//        //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所以只要最后一行摆完，说明已经得到了一个正确解
//        if (n == max) {
//            num++;
//            print();
//            return;
//        }
//        //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
//        for (int i = 0; i < max; i++) {
//            array[n] = i;
//            if (judge(n)) {
//                check(n + 1);
//            }
//        }
//    }
//
//    private boolean judge(int n) {
//        for (int i = 0; i < n; i++) {
//            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void print()  {
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + 1 + " ");
//        }
//        System.out.println();
//    }
//}
public class EightQueen{
    int solutions = 0;
    final int MAX = 8;

     //该数组保存结果，第一个皇后摆在cols[0]列，第二个摆在cols[1]列
    int[] cols = new int[MAX];

    /**
     * n代表当前是第几个皇后
     * @param n
     * 皇后n在array[n]列
     */
    public void check(int n){
        //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所以只要最后一行摆完，说明已经得到了一个正确解
        if (n == MAX)
        {
            solutions++;
            print();
            return;
        }

        for (int i=0;i<MAX;i++)
        {
            //尝试把第n个放在第i列，判断是否冲突。不冲突就继续放第n+1个
            cols[n] = i;
            if (isValid(n))
                check(n+1);
        }
    }
    private boolean isValid(int n)
    {
        //第n个与之前n-1个是否冲突。（放在了同一列、同一对角线）
        for (int i=0; i<n; i++)
            if (cols[i] == cols[n] || Math.abs(n-i) == Math.abs(cols[i] - cols[n]))
                return false;
        return true;
    }
    private void print(){
        System.out.println(Arrays.toString(cols));
    }

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.check(0);
        System.out.println(queen.solutions);
    }
}