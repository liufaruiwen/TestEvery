package study;

import java.util.Arrays;
import java.util.Scanner;

public class Study20201016 {


    public static void main(String[] args) {

        String str="add123#$%#%#O";
        System.out.println(CalcCapital(str));
    }

    public static int CalcCapital(String str) {

        Scanner sc = new Scanner(System.in);
        int flag = 0;
        while (sc.hasNext()) {
            flag=0;
            char[] ch=sc.next().toCharArray();
            int count = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] >= 'A' && ch[i]<= 'Z') {
                    count++;
                }
            }
            flag=count;

        }
        return flag;


    }


    public static void main11(String[] args) {
        int[] arr={-7,-3,2,15,11};
    Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //双指针进行排序并且注入
    public static int[] sortedSquares1(int[] A) {
        int start = 0;
        int end = A.length;
        int i = end - 1;
        int[] nums = new int[end--];
        while (i >= 0) {
            nums[i--] = A[start]*A[start] >= A[end]*A[end] ? A[start]*A[start++] : A[end]*A[end--];
        }
        return nums;
    }


    public static void main10(String[] args) {
        int[] arr={-7,-3,2,3,11};
        int[] A=sortedSquares(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static int[] sortedSquares(int[] A) {
        int tmp;
        boolean flag=true;
        for (int i = 0; i <A.length-1 ; i++) {

            if (flag) {
                flag=false;
                for (int j = 0; j < A.length - 1 - i; j++) {
                    if (Math.abs(A[j]) > Math.abs(A[j + 1])) {
                        tmp = A[j];
                        A[j] = A[j + 1];
                        A[j + 1] = tmp;
                        flag=true;
                    }
                }
            }else {
                break;
            }
        }
        for (int i = 0; i <A.length ; i++) {
            A[i]= (int) Math.pow(A[i],2);
        }
        return A;
    }


    public static void main9(String[] args) {
        int[][] arr=new int[2][];
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        arr[0] = new int[3];
        arr [1] = new int[4];
        System.out.println(arr[0]);
        System.out.println(arr[1]);

    }



    public static void main8(String[] args) {

        int[] arr={1,2,3,4,5};
        int[] copy=Arrays.copyOf(arr,arr.length);
        int[] copy1=new int[arr.length];
        System.arraycopy(arr,0,copy1,0,arr.length);
        int[] copy2=arr.clone();


        copy1[0]=99;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(copy1));
        System.out.println(Arrays.toString(copy2));

    }


    public static void main7(String[] args) {

        int[] arr={1,2,3,4,5};
        int[] copy=copyOf(arr);
        System.out.println(Arrays.toString(copy));
    }
    //对一个整型数组进行拷贝，得到一个新的数组
    public static int[] copyOf(int[] arr) {
        int []copy=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            copy[i]=arr[i];
        }
        return copy;
    }


    public static void main6(String[] args) {
        int[]arr={4,3,2,1};
        inversion(arr);
        System.out.println(Arrays.toString(arr));
    }
    //逆序
    public static void inversion(int[] arr) {
        if(arr==null || arr.length==0){
            return;
        }
        int left=0;
        int tmp;
        int right=arr.length-1;
        while (left<right) {
            tmp = arr[right];
            arr[right] = arr[left];
            arr[left] = tmp;
            left++;
            right--;
        }
    
    }
    public static void main5(String[] args) {
        int[] arr={-4,-1,0,3,10};
        bubbleSort(arr);
        for (int i: arr) {
            System.out.print(i+",");
        }
    }
    //冒泡排序优化算法
    public static void bubbleSort(int[] arr) {
        if(arr==null || arr.length==0){
            return;
        }
        boolean flag=true;//判断是否发生交换，默认交换
        for (int i = 0; i <arr.length-1 ; i++) {
            //加标识符
            if(flag) {
                    flag=false;
                for (int j = 0; j < arr.length - i - 1; j++) {
                    int tmp;
                    //判断并且往后移动最大的数字
                    if (Math.abs(arr[j])  > Math.abs(arr[j + 1])) {
                        tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        flag=true;
                    }
                }
            }else {
                break;
            }
        }
    }

    public static void main4(String[] args) {

        int[] arr={1,2,3,4,5};
        System.out.println(isSorted(arr));
        int[] arr1={1,2,3,5,4};
        System.out.println(isSorted(arr1));
        
    }
    //判断是否有序（升序）
    public static boolean isSorted(int[] arr) {
        if(arr==null || arr.length==0){
            return false;
        }
        int a=arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if(a<=arr[i]){
                a=arr[i];

            }else {
                return false;
            }
        }
        return  true;
    }
    
    
    public static void main3(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
//        Arrays.sort(arr);
//        for (int i: arr) {
//            System.out.println(i);
//        }

        System.out.println(binaryFind(arr,87));
    }
    //二分查找
    public static int binaryFind(int[] arr,int num) {
        //二分查找前提是排过序，，
        if(arr==null || arr.length==0){
            return -1;
        }
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        int mid;
        while (left<=right) {
            mid = (left + right) / 2;
            if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    
    
    
    
    public static void main2(String[] args) {
        int[] arr={1,2,3,5,9,7};
        System.out.println(maxArrayNum(arr));
        int[] arr1=null;
        System.out.println(maxArrayNum(arr1));
        int[] arr2={};
        System.out.println(maxArrayNum(arr2));
        int num=1;
        double num1=num*1.0;//这样可以吗

    }
    public static int maxArrayNum(int[] arr) {
        if(arr==null || arr.length==0){
        return -1;
        }
        int arr1=arr[0];
        for (int i = 0; i <arr.length ; i++) {
            arr1=max(arr1,arr[i]);
        }
        return arr1;
    }

    public static int max(int a,int b) {
        return a>b?a:b;
    }


    public static void main1(String[] args) {
        System.out.println("Hello，lwt");
        int[] arr={1,2,3,4};
        int[] copy=arr.clone();
        System.out.println(arr==copy);//flase,,,,地址不同，证明是新的对象

    }
}
