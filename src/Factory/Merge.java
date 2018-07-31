package Factory;

/**
 * Created by haha on 2018/7/20.
 */
public class Merge {
    public static int[] merge(int[] A,int[] B)
    {
        if (A.length == 0)return B;
        if (B.length == 0)return A;
        int[] result = new int[A.length+B.length];
        int l = Math.min(A.length,B.length);
       int i=0;int k=0;
        int j=0;
        while (i<A.length && j<B.length)
        {
            if (A[i]>=B[j])
                result[k++]=A[i++];
            else
                result[k++]=B[j++];
        }

        if(i>=A.length)A=B;
        for (int m = i;m<A.length;m++)
            result[k++] = A[i];
        return result;
    }

    public static void main(String[] args) {
        int[] A={99,92,87,80};
        int[] B = {98,90,82};
        int[] C = merge(A,B);
        for (int i=0;i<C.length;i++)
         System.out.println(C[i]);
    }
}
