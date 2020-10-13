public class Test20201013 {


    public static void main(String[] args) {
        System.out.println(maxNumThree(5,9,7));
        System.out.println(maxNumThree(9,5,6));
    }
    //求两个数中的最大值
    static int maxNumTwo(int a,int b) {
        return a>b? a:b;
    }

    //求三个书中的最大值
    static int maxNumThree(int a,int b,int c) {
        return a>maxNumTwo(b,c)? a:maxNumTwo(b,c);
    }


    public static void main4(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        oddEven(arr);
        for (int i:arr) {
            System.out.printf(i+" ");

        }
    }
    //让数组的顺序变为奇数位于偶数之前
    static void oddEven(int[] arr) {
        int left=0;
        int right=arr.length-1;
        int flag;
        int flag2=0;
        while (left<right){
            //指向的是偶数
            while (left<right && arr[left] % 2 != 0) {
                left++;
            }
            //指向的是奇数
            while (left<right && arr[right] % 2 == 0) {
                right--;
            }

            if (left<right) {
                //作用是进行数字的交换
                flag = arr[left];
                arr[left] = arr[right];
                arr[right] = flag;

            }
        }
    }




    public static void main3(String[] args) {
        System.out.println(recusiveSum(3));

    }
    //求阶乘和
    //求N的阶乘
       static int recusiveSum(int num) {
        int sum=0;
        for (int i = 1; i <=num ; i++) {
            sum+=recursive(i);
        }
        return sum;


    }
       static int recursive(int i) {
        if (0 == i)
            return 1;
        else
            return i * recursive(i-1);
    }

    public static void main2(String[] args) {
        System.out.println(Fibonacci(5));

    }
    //斐波那契数列,第多少项为几
    //此时的效率很不高
    static int Fibonacci(int num) {
//
//        if (num == 1 || num == 2) {
//            return 1;
//    }
//
//        return Fibonacci(num - 1) + Fibonacci(num - 2);
//
        //递归很容易溢出，且时间复杂度也不是很低，递归思想是空间换时间
        //方法二：

        if(num==1 ||num==2 ){
            return 1;
        }
        int f1 = 1,f2=1;
        int sum=0;
        for(int i=3;i<=num;i++){
            sum=f1+f2;
            f1=f2;
            f2=sum;
        }
        return  sum;

    }
    public static void main1(String[] args) {
        int[] arr={1,2,3,2,1};
        onlyOne(arr);

    }
    //找出出现一次的数字
    /*
    方法是利用了两个相同的数，它们的异或值为0，让数组中的每个数都异或起来，这样单独出现的那个数就会出现
     */
    static  void onlyOne(int[] arr){
        int only=0;
        for (int i = 0; i <arr.length; i++) {
            only^=arr[i];
        }
        System.out.println("只出现一次的数是："+only);

    }
}
