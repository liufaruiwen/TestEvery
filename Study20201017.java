package study;

import java.util.Arrays;
import java.util.Scanner;

public class Study20201017 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(count(4,3));
        
    }
    public static int count(int m, int n) {


            if(m==0||n==1)  //因为我们总是让m>=n来求解的，所以m-n>=0,所以让m=0时候结束，如果改为m=1，
                return 1;    //则可能出现m-n=0的情况从而不能得到正确解
            if(n>m)
                return count(m,m);
            else
                return count(m,n-1)+count(m-n,n);

    }

    public static void main7(String[] args) {

        System.out.println(findNumberOf1(13277435));
    }
    //计算整数二进制中1的个数
    public static int findNumberOf1( int num) {
        int count=0;
        while(num!=0){
            num=num&(num-1);
            count++;
        }
        return count;
    }


    public static void main6(String[] args) {
        int[] arr={1,4,3,2,5,6,7,8};
        System.out.println(arrayPairSum(arr));

    }
    public static int arrayPairSum(int[] nums) {
        int tmp=0;
        int sum=0;
        Arrays.sort(nums);
        int[][] arr=new int[nums.length/2][2];
        for (int i = 0; i <nums.length/2 ; i++) {
            for (int j = 0; j <2 ; j++) {
                arr[i][j]=nums[tmp++];
            }
        }
        for (int i = 0; i <arr.length ; i++) {

            sum+=arr[i][0];

        }
        return  sum;

    }



    //一个类，，能实现加减乘除
    static class Calculator{
        private double num1;
        private double num2;

        public Calculator(double num,double numm) {
            this.num1 = num;
            this.num2 = numm;
        }

        public  void add() {

            System.out.println("两数之和为："+(num1+num2));
        }
        public  void sub() {

            System.out.println("两数之差为："+(num1-num2));
        }
        public  void mul() {

            System.out.println("两数之积为："+(num1*num2));
        }
        public  void div() {

            System.out.println("两数之商为："+(num1/num2));
        }
    }

    public static void main5(String[] args) {
        Calculator calculator=new Calculator(10.0,20.0);
        calculator.add();
        calculator.sub();
        calculator.mul();
        calculator.div();
    }


    public static void main4(String[] args) {
        int[] arr={1,2,3,4};
        int[] arr1={4,3,2,1};
        int[] tmp=arr.clone();
        arr=arr1.clone();
        arr1=tmp.clone();
        exchangeArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

    }
    public static void exchangeArray(int[] arr) {
        int[] tmp={1,2,5,5};
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=tmp[i];
        }

    }


    public static void go() {


        System.out.println("gogogogo");
        System.out.println();


    }
    public static void main3(String[] args) {

        int[] arr=new int[10];
        //Arrays的填充方法
        Arrays.fill(arr,8);
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,2,6,5);
        System.out.println(Arrays.toString(arr));

    }






    public static void main2(String[] args) {

        int[]arr={1,2,3,4,5,6,7};
        oddEvenSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    //奇数偶数对换
    public static void oddEvenSort(int[] arr) {
        if(arr==null ||arr.length==0){
            return;
        }

        int left=0;
        int right=arr.length-1;
        int tmp;
        while(left<right) {
            //奇数出列
            while (arr[left]%2==0){
                left++;
            }
            //偶数数列
            while (arr[right]%2!=0){
                right--;
            }
            if(left<right) {
                tmp=arr[left];
                arr[left]=arr[right];
                arr[right]=tmp;
            }
        }
    }


    public static void main1(String[] args) {

        int[] arr={1,5,4,3,2};
        popoSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Hello,lwt");
    }

    //冒泡算法；；；；；；；
    public static void popoSort(int[] arr) {
        if(arr==null || arr.length==0){
            return;
        }
         int tmp;
         //判断这一轮是否有变化，没有直接退出，优化了算法
         boolean flag=true;
        for (int i = 0; i <arr.length-1 ; i++) {
            if (flag) {
                        flag = false;
                for (int j = 0; j < arr.length - i - 1; j++) {
                      //这里是jjjjjjjjjj，不是iiiiiiiii
                    if (arr[j] > arr[j + 1]) {
                        tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        flag = true;
                    }
                }
            }else     {
                break;
            }
        }
    }



}
