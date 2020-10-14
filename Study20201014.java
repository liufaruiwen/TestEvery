package study;

import java.util.Arrays;
import java.util.Scanner;

public class Study20201014 {


    public static void main(String[] args) {
//        Integer.reverse()
        System.out.println(reverseBits(43261596));

    }
    //颠倒给定的 32 位无符号整数的二进制位

    public static int reverseBits(int n) {
        int res=0;

        for (int i = 0; i <32 ; i++) {
            int tmp=n&1;
            n>>=1;
            //这一步很有讲究
//            res=(res<<1)^tmp;
//            res<<=1;
            res=res|tmp;
            res<<=1;
            //一定要先往左移，然后放数，否则最后结果会×2
        }
        return res;
//        int res = 0;
//        for (int i = 0; i < 32; i++) {
//            int bit = n & 1;
//            n = n >> 1;
//            res = (res << 1) ^ bit;
//        }
//        return res;
    }




    public static void main12(String[] args) {
        int[] nums={11,11,12,12,2,7};
        for(int i :twoSum(nums,9)){
            System.out.println(i);
        }
    }
    // 为数组中的某两数之和为一个数，求它两的下标
    public static int[] twoSum(int[] nums, int target) {
        int[] over=new int[2];
        for (int i = 0; i < nums.length; i++) {
            //如果数组全是正数，这个操作可以减少循环
//            if(nums[i]>target){
//                break;
//            }
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    over[0]=i;
                    over[1]=j;
                    return over;
                }

            }
        }
        return over;
    }

    public static void main11(String[] args) {
        frogAbstract(4);
    }

    //青蛙跳台阶问题
    public static void frogJumpOne(){
        System.out.println("1"+"");
    }
    public static void frogJumpTwo(){
        System.out.println("2"+"");
    }

    public static void frogAbstract(int n) {

        frogAbstractA(n);


    }

    public static void frogAbstractA(int n) {
        if(n==1 ){
            frogJumpOne();
            return;
        }

        frogJumpOne();
        frogAbstractA(n-1);


    }
    public static void frogAbstractB(int n) {

        if(n==2 ){
            frogJumpTwo();
            return;
        }
        frogJumpTwo();
        frogAbstractB(n-2);

    }


    public static void main10(String[] args) {
        System.out.println(factorial(3));
    }
    public static int factorial(int num) {
        if(num!=1){

            return num*factorial(num-1);
        }
        return 1;
    }

    
    public static void main9(String[] args) {
        System.out.println(fibonacci(2));


    }
    //递归求斐波那契数列的第 N 项
    public static int fibonacci(int n) {
        if(n==1 || n==2){
            return 1;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    
    }


    public static void main8(String[] args) {
        hanoiTower(3,'A','B','C');
    }
    public static void move(char pos1,char pos2) {
        System.out.println(pos1+"--->"+pos2);
    }

    /*
    n为盘子数量
    pos1 盘子所在位置
    pos2 中转位置
    pos3 目的位置
     */
    public static void  hanoiTower(int n,char pos1,char pos2,char pos3) {
        if(n==1){
            move(pos1,pos3);
            return;
        }
        hanoiTower(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanoiTower(n-1,pos2,pos1,pos3);
        //最终到pos3

    }


    public static void main7(String[] args) {
        System.out.println(frog(5));
    }

    //青蛙台阶问题
    public static int frog(int n) {

        if(n==1 || n==2){
            return 1;
        }

        return frog(n-1)+frog(n-2);

    }


    //青蛙跳台阶问题
//    public static void frogJumpOne(){
//        System.out.println("1"+"");
//    }
//    public static void frogJumpTwo(){
//        System.out.println("2"+"");
//    }
//
//
//    public static void frogAbstract(int n) {
//        if(n==1 ||n==2){
//            frogJumpOne();
//            return;
//        }
//         frog(n-1);
//        frogJumpOne();
//        frog(n-2);
//        frogJumpTwo();
//
//    }


    public static void main6(String[] args) {
        System.out.println(add(1,2));
        System.out.println(add(1.5,1.5,1.5));
    }

    //求和的重载
    public static int add(int a,int b) {
        return a+b;
    }
    public static double add(double a,double b,double c) {
        return a+b+c;
    }



    public static void main5(String[] args) {

        System.out.println(max(1,2));
        System.out.println(max(2.5,2.6));
        System.out.println(max(3,2.5,3.2));

    }

    //求最大值方法的重载
    public static int max(int a,int b) {
        return a>b? a:b;
    }
    public static double max(double a,double b) {
        return a>b? a:b;
    }
    public static double max(double a,double b,double c) {
      return   c>max(a,b)? c:max(a,b);
    }


    public static void main4(String[] args) {
        System.out.println(sumEvery(1729));
//        sumEvery(1729);
    }

    public static int sumEvery(int num) {
        //这个是按照数字顺序进行
        if (num > 9) {
            return num % 10 + sumEvery(num / 10);
        }
        return num;
    
        //这个是只求答案不要求顺序
//        if(num!=0){
//
//            sumEvery(num/10);
//            System.out.println(num%10);
//
//        }



    }


    public static void main3(String[] args) {
        System.out.println(sum(3));
    }
    public static int sum(int num) {

        if(num==1){
            return 1;
        }
        return  num+sum(num-1);
    }


public static void main2(String[] args) {
    every(12345);
    }

 public static void every(int num) {

        if(num>9) {
            every(num/10);
        }
        System.out.print(num%10+" ");
    }

    public static void main1(String[] args) {
            displayOne();
        }

    static void displayOne() {
        System.out.println("请输入一个正整数：");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int count=0;
        while(num!=0){
            num=num&(num-1);
            count++;
        }
        System.out.println("这个数的二进制含有"+count+"个1");
    }


    }


