package study;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Study20201015 {
    public static void main(String[] args) {
        BigInteger one=new BigInteger("123456789111100000");
        System.out.println(one);

    }




    public static void main11(String[] args) {
        //拆字符串并遍历
        //这里用到了正则表达式
        String s="18-22-40-65";
        String regex="-";
        String[] result=s.split(regex);
        for (String i: result) {
            System.out.print(i+",");
        }

    }


    public static void main10(String[] args) {
        System.out.println("请输入一个被除数:");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) {
            int num1 = sc.nextInt();
            System.out.println("请输入一个除数:");
            if(sc.hasNextInt()) {
                int num2 = sc.nextInt();
                if(0 == num2) {
                    System.out.println("除数不能为0！");
                }else {
                    int r = num1 / num2;
                    System.out.println("r = " + r);
                }
            }else {
                System.out.println("除数输入不合法!");
            }
        }else {
            //在控制台有可能输入字符串
            System.out.println("被除数输入不合法!");
        }

    }


    public static void main9(String[] args) {
        int[] arr;
        arr= new int[]{1, 2, 3};

        int[]arr1;
        arr1=arr;
        for (int i: arr1) {
            System.out.print(i+" ");
        }

    }

    public static void main8(String[] args) {

        System.out.println(addDigits(38));
        System.out.println(addDigits(123456));
        System.out.println(addDigits1(38));
        System.out.println(addDigits1(123456));
        System.out.println(addDigits2(123456));
        System.out.println(addDigits2(38));



    }

    public static int addDigits(int num) {

        if(num>9) {
            int ret;
            ret = num % 10 + addDigits(num / 10);
            //判断结果是否为个位数，如果不是，继续分解
             return ret>9?addDigits(ret):ret ;
        }
        return num;

    }

    //一般来说能一些功能，本身可以通过递归或者循环去完成，，但题意说可以用O（1）的复杂度去解决，，，所以也就是说大概率是这个题遵循一个规律
    public static int addDigits2(int num) {
        if(num<10){
            return num;
        }
        int res=num%9;
        if(res==0){
            return 9;
        }
        return res;

    }
    public static int addDigits1(int num) {
     boolean flag=true;
        int sum = 0;
        while (flag){
            //清空计数
            sum=0;
            while (num != 0) {
                //求每一位的和
                sum += num % 10;
                num = num / 10;

            }
                if (sum > 9) {
                    num = sum;
                }else {
                    flag = false;
                }
     }
        return sum;
    }


    public static void main7(String[] args) {
        int[] arr=new int[100];
        for (int i = 0; i <100 ; i++) {
            arr[i]=i+1;
        }
        for (int i: arr) {
            System.out.print(i+" ");
        }
    }


    public static void main6(String[] args) {
        int[] arr={1,2,3,4,5,7};
//        transform(arr);
//        for (int i: arr) {
//            System.out.print(i+" ");
//        }
        printArray(arr);
    }
    //打印数组
    public static void printArray(int[] arr) {
        if(arr==null ||arr.length==0){
            System.out.print("");
        }
        for (int i: arr) {
            System.out.print(i+" ");
        }
    }
    //让数组成员每个都变成它的二倍
    public static void transform(int[] arr) {
        if(arr==null ||arr.length==0){
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=arr[i]*2;
        }
    }

    public static void main4(String[] args) {
        int[] arr={1,2,3,4,5,7};
//        System.out.println(sum(arr));
//        int[] arr1={};
        int[] arr2=null;
//        System.out.println(sum(arr1));
        System.out.println(sum(arr2));
    }
    //求和
    public static int sum(int[] arr) {
        //
        if(arr==null ||arr.length==0){
            return 0;
        }
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
        }
        return sum;
    }
    //求平均数
    public static double avg(int[] arr) {
        if(arr==null ||arr.length==0){
            return 0.0;
        }
        double sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
        }
        return sum/arr.length;
    }





    public static void main3(String[] args) {
    int[] arr={1,2,3,4,5,6,7};
        System.out.println(myToString(arr));
    }
//    String str=Arrays.toString();
//它的形参就是数组pu
    public static String  myToString(int[] arr) {
        //判断条件,,边界条件如何排除
        if(arr==null){
            return "";//判断不为空
        }
        if(arr.length==0){
            return "";//判断长度不为0
        }
        String str="[";
        for (int i = 0; i <arr.length ; i++) {
            if(i==arr.length-1){
                str+=arr[i];
                break;
            }
            str=str+arr[i]+",";

        }
        str+="]";
        return str;

    }

    public static void main2(String[] args) {
        floor(1);
        floor(2);
        floor(3);
        floor(4);
        floor(5);

    }
    public static void floor(int n) {
//        int a=1;
//        int b=2;
//        int sum=0;
//        if(n==a){
//         sum = 1;}
//        if(n==b){
//         sum = 2;}
//
//        for (int i = 3; i <=n ; i++) {
//            sum=a+b;
//            a=b;
//            b=sum;
//        }
//        System.out.println(sum);
        //优化后
        if(n==1 || n==2) {
            System.out.println(n);
            return;
        }
        int f1=1;
        int f2=2;
        int sum=0;
        for (int i = 3; i <=n; i++) {
            sum=f1+f2;
            f1=f2;
            f2=sum;
        }
        System.out.println(sum);


    }



    public static void main1(String[] args) {
        int[] arr=new int[5];
        //遍历去初始化数组
        //数组也会默认初始化，全为00000
        for (int i = 0; i <arr.length ; i++) {

            arr[i]= (int) (Math.random()*100+1);
        }
        int minn = arr[0];
        for (int i: arr) {

            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 1; i <arr.length; i++) {
            minn=Math.min(minn,arr[i]);
        }
        System.out.println(minn);

    }
}
