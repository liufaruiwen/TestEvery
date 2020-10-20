package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Study20201018 {


    public static void main(String args[]) throws IOException {
//        char c;
//        // 使用 System.in 创建 BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("输入字符, 按下 'q' 键退出。");
//        // 读取字符`
//        do {
//            c = (char) br.read();
//            System.out.println(c);
//        } while (c != 'q');
             //从控制台读取字符串
            // 使用 System.in 创建 BufferedReader
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str;
//            System.out.println("Enter lines of text.");
//            System.out.println("Enter 'end' to quit.");
//            do {
//                str = br.readLine();
//                System.out.println(str);
//            } while (!str.equals("end"));

        int b;
        b='A';
        System.out.println(b);  //村的是ACII码，因为本身定义的就是int类型。

        }


    public static void main3(String[] args) {
//
//        int a=Integer.valueOf("123");
//        double b=Double.valueOf("456");
//        System.out.println(a);
//        System.out.println(b);
//        String str="123456";
//        int a=Integer.valueOf(str);
//        System.out.println(a);
//        System.out.println(str.indexOf());


        //123
        //456.0
    }


    public static void main2(String[] args) {
        String num1="12345";
        String num2="54321";
        System.out.println(addStrings(num1,num2));

    }
    public static String addStrings(String num1, String num2) {
        int[] str=new int[num1.length()];
        int[] str1=new int[num2.length()];
        for (int i = 0; i <num1.length() ; i++) {

            str[i]=(int)num1.charAt(i)-48;
        }
        for (int i = 0; i <num2.length() ; i++) {

            str1[i]=(int)num2.charAt(i)-48;
        }
        int tmp= (int) Math.pow(10,str.length-1);
        int sum=0;
        for (int i = 0; i <str.length ; i++) {

            sum+=str[i]*tmp;
            tmp/=10;
        }
        int tmp1= (int) Math.pow(10,str1.length-1);
        int sum1=0;
        for (int i = 0; i <str.length ; i++) {

            sum1+=str1[i]*tmp1;
            tmp1/=10;
        }
        return String.valueOf((sum+sum1));
    }


    public static void main1(String[] args) {


        int n=7;
        for(int i=7;i>=0;i--){
            int b=(n>>i)&1;
            System.out.print(b+" ");
        }

    }



    public static int threeSumMulti(int[] A, int target) {

            //为防止溢出，，定义被求余的数
            int MOD = 1_000_000_007;
            //下标为数字，内容为多少个这个数
            long[] count = new long[101];
            for (int x: A)
                count[x]++;

            long ans = 0;

            // All different
            for (int x = 0; x <= 100; ++x)
                for (int y = x+1; y <= 100; ++y) {
                    int z = target - x - y;
                    if (y < z && z <= 100) {
                        ans += count[x] * count[y] * count[z];
                        ans %= MOD;
                    }
                }

            // x == y != z
            for (int x = 0; x <= 100; ++x) {

                int z = target - 2*x;
                if (x < z && z <= 100) {
                    ans += count[x] * (count[x] - 1) / 2 * count[z];
                    ans %= MOD;
                }
            }

            // x != y == z
            for (int x = 0; x <= 100; ++x) {
                //这样判断能让y一定是偶数
                if (target % 2 == x % 2) {
                    int y = (target - x) / 2;
                    if (x < y && y <= 100) {
                        ans += count[x] * count[y] * (count[y] - 1) / 2;    //两个数相同故除以2的阶乘
                        ans %= MOD;
                    }
                }
            }

            // x == y == z
            if (target % 3 == 0) {
                int x = target / 3;
                if (0 <= x && x <= 100) {
                    ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;//三个数相同故除以3的阶乘
                    ans %= MOD;
                }
            }

            return (int) ans;
        }



    }






