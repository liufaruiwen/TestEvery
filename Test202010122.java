import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test20201012 {
    public static void main(String[] args) {
        multiplicationTable();
    }
    //输出乘法口诀表
    static void multiplicationTable() {
        System.out.println("     乘法口诀表：   ");

        for(int i=1;i<10;i++) {

            for (int j = 1; j <=i ; j++) {
                int num=i*j;

                System.out.print(j+"*"+i+"="+num+"  ");
            }
            System.out.println("");
        }
        //可以改进部分：把答案改成统一位，这样外观好看一些

    }
    public static void main16(String[] args) {
        everyNum(123);
    }
    //输出一个整数的每一位
    static void everyNum(int num){
        //如果num条件设置为： num!=0则最后结果带0，设置为num>9，最后结果是不带0开头的
        // 原因是num！=0
        if(num!=0){
            everyNum(num/10);
            System.out.printf("%d  ",num%10);
        }
    }

    public static void main15(String[] args) {
        keypadDoor();
    }
    //密码门系统
    static void keypadDoor() {
        int key= (int) (Math.random()*10);
        int num=0;
        System.out.println("请输入一位数密码：");
        while(num!=3) {
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (key == answer) {
                System.out.println("登陆成功！！");
                scanner.close();
                break;
            } else {
                System.out.println("密码错误,请重修输入：");
                num++;
            }
        }
        if(num==3){
            System.out.println("错误次数过多，程序退出！");
        }
    }

    public static void main14(String[] args) {
        oddEven(43);
    }
    //12.获取一个数二进制序列中的所有偶数位和奇数位，分别输出二进制序列
    static  void oddEven(int num) {
        int num1=num;
        int num2=0;
        //创建一个偶数队列
        ArrayList<Integer> even=new ArrayList();
        //创建一个奇数队列
        ArrayList<Integer> odd=new ArrayList();
        //先把第一位即奇数位取出
        odd.add((num&1));
        //判断该数有多少位
        while(num1!=0){

            num1>>>=1;
            num2++;

        }
        //因为这里已经取了一位了，所以还需要取num2 -1次
        for(int i=1;i<num2;i++){
            num>>>=1;
            if(i%2==0){//此偶为奇,把这一位加到队列里面
                odd.add(num&1);
            }else{//此奇为偶,把这一位加到队列里面
                even.add(num&1);
            }

        }
        System.out.print("奇数序列为：");
        for(int i=odd.size()-1;i>=0;i--){
            System.out.print(odd.get(i));
        }
        System.out.print("\n偶数队列为：");
        for(int i=even.size()-1;i>=0;i--){
            System.out.print(even.get(i));
        }

    }
    public static void main13(String[] args) {
        returnOne(15);
        returnOne(5);

    }
    //写一个函数返回参数二进制中1的个数，比如：15  0000 1111  4个1
    static void returnOne(int num) {
        //先找到这个数二进制最左边的1在哪一位
        int num1=num;
        int num2=0;
        //计算器
        int num3=0;
        //判断这个数最高位的1在哪一位
        while(num1!=0){

            num1>>>=1;
            num2++;
        }
        //判断这个数最低位是否为1
        if((num&1)==1){

            num3++;
        }
        //判断这个数从倒数第二位起到最高位1中出现多少次1
        for(int i=1;i<num2;i++){
            num>>>=1;
            if((num&1)==1){
                num3++;
            }

        }
        System.out.println("一共出现了："+num3+"个1");


    }
    public static void main12(String[] args) {
    commonNum(8,8);
    commonNum(8,4);
    commonNum(4,8);
    commonNum(-1,2);
    }

    //求两个正整数最大公约数
    static void  commonNum(int num1,int num2) {
        if(num1>0 && num2>0) {
            int big;
            int small;
            int ssr;
            if (num1 >= num2) {
                big = num1;
                small = num2;
            } else {
                big = num1;
                small = num2;
            }
            while (big % small != 0) {
                ssr = big % small;
                big = small;
                small = ssr;
            }
            System.out.println(num1 + "和" + num2 + "的最大公约数是：" + small);

        }else {
            System.out.println("请输入正确的数字！");
        }
    }

    public static void main11(String[] args) {
        sumNum();

    }
//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
    static void sumNum() {
        double sum=0;
        double sum1=0;
        for(double i=1;i<=100;i++){
            //方法一，利用（-1）的次方来改变符号位
//            sum1+=(-Math.pow(-1.0,i)*(1/i));
            //方法二，利用奇数为+，偶数为-
            if(i%2!=0){
                sum+=1/i;
            }else {
                sum-=1/i;
            }

        }
        System.out.println(sum);
//        System.out.println(sum1);

    }
    public static void main10(String[] args) {
        daffodil();
    }
    static  void daffodil() {
        int hundreds = 0;       //百位
        int decade = 0;         //十位
        int unit=0;           //个位
        double num = 0;
        for(int i=1;i<1000;i++){
            //算出个位数字
            unit=i%100%10/1;

            if(i>=10) {
                //算出十位数字
                decade = i % 100 / 10;

                if (i >= 100) {
                    //算出百位数字
                    hundreds=i/100;

                }

            }
            //算出这三个数的立方和是多少
            num=Math.pow(unit,3)+Math.pow(decade,3)+Math.pow(hundreds,3);
            //判断是否满足要求
            if(i==num){
                System.out.println("水仙花数有："+i);
            }


        }


    }
    public static void main9(String[] args) {
    guessNum();
    }
    static void guessNum() {
        //生成随机数
        //如果不加括号会先随机数转成int类型，随机数是0-1之间，所以就会为0
        int a=(int) (Math.random()*10)+1;
        boolean flag=true;
        //用户输入
        System.out.println("猜猜看：  ");
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            int guess = scanner.nextInt();
            if (guess > a) {
                System.out.println("大了！！");

            } else if (guess < a) {
                System.out.println("小了！！");
            } else {
                System.out.println("猜对了！！");
                flag=false;

            }
        }
    }

    public static void main8(String[] args) {
        year(17);
        year(20);
        year(30);
        year(57);

    }
// 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
    static  void year(int age) {
        if(age>18){

            if(age>28){

                if(age>55){
                    System.out.println("老年！");
                }else {
                    System.out.println("中年!");
                }

            }else {
                System.out.println("青年!");
            }
        }else {
            System.out.println("少年！");
        }

    }
    public static void main7(String[] args) {
        primeNumber(1);
        primeNumber(2);
        primeNumber(3);
        primeNumber(4);

    }
    //判断一个数是否是素数
    static  void  primeNumber(int num) {
        boolean flag=true;
        if(num>1) {
            for (int i = 2; i <= Math.sqrt(num); i++) {

                if (num % i == 0) {
                    System.out.println("这个数不是素数：" + num);
                    flag=false;
                    break;

                }

            }
            if(flag){
                System.out.println("这个数是素数："+num);
            }


        }else {
            System.out.println("不符合规则！！");
        }

    }

    public static void main6(String[] args) {
        isPrimeNumber();

    }
    //打印 1 - 100 之间所有的素数
    static void isPrimeNumber() {
        int num=2;
        while(num>1 && num<=100){
            boolean flag=true;
            for (int i = 2; i *i<=num; i++) {
                //判断是否能被除了它本身和1之外的数整除
                if (num % i == 0) {
                    flag=false;
                    break;

                }

            }
            if(flag){
                System.out.println("这个数是素数："+num);
            }
            num++;

        }

    }


    public static void main5(String[] args) {
        for(int i=1000;i<=2000;i++){
            if(leapYear(i)!=1){
                continue;
            }
            System.out.println("闰年有："+i);

        }


    }
    static   int leapYear(int year){

        int flag=0;
        //判断是否是闰年，如果是flag变为1
        if((year%100!=0&&year%4==0)||(year%400 == 0)){
            flag=1;
        }
        return  flag;
    }
    public static void main4(String[] args) {
        int flagg=0;
        for(int i=0;i<=100;i++){
            if(goNine(i)==1){
                flagg++;
                System.out.println(i);
            }
        }
        System.out.println("这里面包含："+flagg+"   9");
//        int a=19;
////        everyNum(a);
//        int b= goNine(a);
//        System.out.println(b);


    }
    //判断数字里面是否包含9
    static  int goNine(int num) {

        int flag = 0;
        int flag2=0;

        if (num != 0) {
            flag2=goNine(num / 10);
            if (9 == num % 10) {
                flag = 1;
            }

        }
        return flag | flag2;
    }
    //输出一个整数的每一位（测试）
    static void everyNumer(int num) {
        //如果num条件设置为： num!=0则最后结果带0，设置为num>9，最后结果是不带0开头的
        // 原因是num！=0
        if (num != 0) {

            everyNumer(num/10);
//            System.out.printf("%d\n", num % 10);
            if(num%10==9){
                System.out.println("这个数字中含有9！！");
            }
        }
    }
    public static void main3(String[] args) {
        int i=1;
        while (i<=100) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("能被3又能被5整除的数有："+i);
            }
            i++;

        }
        //如皋要使用continue，判断条件要改，改成如果不符合，就直接进行下一次

    }

    public static void main2(String[] args) {
        //计算1--5的阶乘的和
        int i=1;
        int sum=0;
        while(i<=5){
            sum+=factorial(i);
            i++;
        }
        System.out.println("1到5的阶乘的和为："+sum);
    }
    //计算数字num的阶乘
    static int factorial(int num) {
        int i=1;
        int sum=1;
        while (i<=num){
            sum*=i;
            i++;
        }
        return sum;
    }

    public static void main1(String[] args) {
      int[] arr={1,4,9,5,3,10,6,7,11,2,15};
        int find=dichotomy(arr,15);
        System.out.println("这个数是arr中下标第："+find+"的数");
        bubbleSort(arr);   //冒泡排序使用
        Arrays.sort(arr);   //java内置排序
        print(arr);


        Scanner scanner =new Scanner(System.in);
        //可以按 Ctrl+D结束这个循环
        while(scanner.hasNextInt()) {
            System.out.println("请输入数字：");
            //最好是加一个判断，用来判断输入的是否是整型
            int num = scanner.nextInt();
            //输入字符的话会报 InputMismatchException（Java中捕获异常一种，检测是否为数字）
            if(num%2==0){
                System.out.println("这个数是偶数："+num);
            }else {
                System.out.println("这个数是奇数："+num);
            }

        }
        //1+2+...+100
        int i=1;
        int sum=0;
        while (i<=100){
            sum+=i;
            i++;
        }
        System.out.println("1+...+100="+sum);
        //1到100偶数的和
        int i1=1;
        int sum1=0;    //偶数和
        int sum3=0;   //奇数和
        //1+2+...+100
        while (i1<=100){
            //判断是否为偶数
            if(i1%2==0){
            sum1+=i1;
            }else{
            sum3+=i1;
            }

            i1++;
        }
        System.out.println("1到100偶数的和是："+sum1);
        System.out.println("1到100奇数的和是："+sum3);
        //1到100奇数的和
        int i2=1;
        int sum2=0;
        //1+2+...+100
        while (i2<=100){
            //判断是否为奇数
            if(i2%2!=0){
                sum2+=i2;
            }
            i2++;
        }
        System.out.println("1到100奇数的和是："+sum2);







    }

    //输出数组
    static void print(int[] arr) {
        //这里第二个判定条件非常重要，一定要想好，加不加 =
        for(int i=0;i<arr.length;i++){
            //","判定，是否是最后一个数字
            if(i!=arr.length-1){
                System.out.print(arr[i]+",");
            }else {
                System.out.println(arr[i]);
            }
        }

    }


    //数组的二分查找
    /*
    二分法效率要很高于遍历搜索
    二分的时间复杂度是O(logn)，遍历搜索的复杂度是O(n);遍历搜索主要就是遍历的时候占时间长
     */

   static int dichotomy(int[]a,int num){
        //定义左右两个节点
        int left=0;
        int right=a.length-1;
        while (left<=right){
            //定义中间节点
            int mid=(left+right)/2;
            //找的数字与中间数字比较
            if(num>a[mid]){
                left=mid+1;
            }else if(num<a[mid]){
                right=mid-1;
            }else {
                if(num==a[mid]){
                    return mid;
                }
            }
        }
        return -1;
    }

    //冒泡排序
    //理解还不是很透彻
    static void bubbleSort(int[] arr) {
            int tem;

       for(int i=0;i<arr.length-1;i++)
           for(int j=arr.length-1;j>i;j--){
                if(arr[j-1]>arr[j]){
                    tem=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tem;

                }

           }

    }

}
