package Factory;

/**
 * Created by haha on 2018/7/20.
 */
public class NewString {
     static long i=1000;
     String nums = "0123456789";
    String Lower = "abcdefghijklmnopqrstuvwxyz";
    String Uppers = Lower.toUpperCase();
    String res = nums+Lower+Uppers;
    int len = res.length();
    //List<String> list = new ArrayList<>();
    public String generic()
    {
        System.out.println(res+getTotal());
        char[] chars = new char[4];
        long mod = 0;
        long div = getTotal();
        for (int i=3;i>=0;i--)
        {
            mod = div%len;
            div = div/len;
            chars[i] = res.charAt((int)mod);
            System.out.println();
        }
        return new String(chars);
    }
    public synchronized long getTotal()
    {
        return i++;
    }

    public static void main(String[] args) {
        System.out.println(new NewString().generic());
    }
}
