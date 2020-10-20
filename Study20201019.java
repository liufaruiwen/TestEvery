package study;

import java.util.Arrays;

public class Study20201019{


    public static void main(String[] args) {


        int[] arr={10,6,3,8,33,27,66,9,7,88};
        quicksort1(arr,0,arr.length-1);
//        quick_sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quicksort1(int[] arr,int start,int end) {
        //递归结束条件
        if(start<end){
            int left=start;
            int right=end;
            int tmp=arr[start];

            while(left<right){
                //右边值比基值小时
                while (left<right && arr[right]>=tmp){
                    right--;
                }
                if(left<right) {
                    arr[left++] = arr[right];
                }
                while (left<right && arr[left]<tmp){
                    left++;
                }
                if(left<right) {
                    arr[right--] = arr[left];
                }

            }
            arr[left]=tmp;
            System.out.println(Arrays.toString(arr));
            quicksort1(arr,start,left);
            quicksort1(arr,left+1,end);
        }
    }
//public static void f(int[] arr,int start,int end){
//    //直到start=end时结束递归
//    if(start<end){
//        int left = start;
//        int right = end;
//        int temp = arr[start];
//
//        while(left<right){
//
//            //右面的数字大于标准数时，右边的数的位置不变，指针向左移一个位置
//            while(left<right && arr[right]>temp){
//                right--;
//            }
//
//            //右边的数字小于或等于基本数，将右边的数放到左边
//            arr[left] = arr[right];
//            left++;
//            ////左边的数字小于或等于标准数时，左边的数的位置不变，指针向右移一个位置
//            while(left<right && arr[left]<=temp){
//                left++;
//            }
//
//            //左边的数字大于基本数，将左边的数放到右边
//            arr[right] = arr[left];
//        }
//
//        //一趟循环结束，此时left=right，将基数放到这个重合的位置，
//        arr[left] = temp;
//        System.out.println(Arrays.toString(arr));
//        //将数组从left位置分为两半，继续递归下去进行排序
//        f(arr,start,left);
//        f(arr,left+1,end);
//    }else {return;}
//}
//private static void quickSort(int[] arr, int low, int high) {
//
//    if (low < high) {
//        // 找寻基准数据的正确索引
//        int left=low;
//        int right=high;
//        int tmp=arr[low];
//        while (low < right) {
//            // 当队尾的元素大于等于基准数据时,向前挪动high指针
//            while (left < right && arr[right] >= tmp) {
//                right--;
//            }
//            // 如果队尾元素小于tmp了,需要将其赋值给low
//            arr[left] = arr[right];
//            // 当队首元素小于等于tmp时,向前挪动low指针
//            while (left < right && arr[left] <= tmp) {
//                left++;
//            }
//            // 当队首元素大于tmp时,需要将其赋值给high
//            arr[high] = arr[left];
//        }
//        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
//        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
//        arr[left] = tmp;
//        int index=left;
//
//        // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
//        //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
//        quickSort(arr, low, index - 1);
//        quickSort(arr, index + 1, high);
//    }
//
//}
//快速排序
public static void quick_sort(int s[], int l, int r)
{
    if (l < r)
    {
        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
        int i = l, j = r, x = s[l];
        while (i < j)
        {
            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                j--;
            if(i < j)
                s[i++] = s[j];

            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                i++;
            if(i < j)
                s[j--] = s[i];
        }
        s[i] = x;
        System.out.println(Arrays.toString(s));
        quick_sort(s, l, i - 1); // 递归调用
        quick_sort(s, i + 1, r);
    }
}

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    public static void main4(String[] args) {

        System.out.println(arrangeCoins(3));
    }

    public static int arrangeCoins(int n) {
        int i=0;
        if(n==1||n==0){
            return n;
        }
        while (n>0){
            i++;
            n-=i;
        }
        if(n==0){
            return i;
        }
        return i-1;
    }

    public static void main3(String[] args) {
        System.out.println(addStrings("6913259244","71103343"));

    }

    //太大就越界了，，，，还不让用big，，所以这个方案暂时有问题
    public static int addStrings(String num1, String num2) {
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
        for (int i = 0; i <str1.length ; i++) {

            sum1+=str1[i]*tmp1;
            tmp1/=10;
        }
        return sum+sum1;

    }


    public static void main2(String[] args) {
        String s="a##c";
        String t="#a#c";

//        StringBuffer ss=new StringBuffer(s);
//        ss.deleteCharAt(2);
//        System.out.println(ss);
//        ss.deleteCharAt(2);
//        System.out.println(ss);

//        System.out.println(backspaceCompare(s,t));

    }

    public static boolean backspaceCompare(String S, String T) {
        StringBuffer s=new StringBuffer();
        StringBuffer t=new StringBuffer();
        char[] ss=S.toCharArray();
        char[] tt=T.toCharArray();
        int sss=0;
        int ttt=0;
        for (int i = 0; i <ss.length ; i++) {

            s.append(ss[i]);
            sss++;
            if(ss[i]=='#'){
                    s.deleteCharAt(--sss);

                if(i!=0 && sss!=0){
                    s.deleteCharAt(--sss);
                }

            }

        }
        for (int i = 0; i <tt.length ; i++) {

            t.append(tt[i]);
            ttt++;

            if(tt[i]=='#'){
                t.deleteCharAt(--ttt);

                if(i!=0 && ttt!=0){
                    t.deleteCharAt(--ttt);
                }
            }

        }
        return s.toString().equals(t.toString());
    }
//    public  boolean backspaceCompare1(String S, String T) {
//        StringBuffer s=new StringBuffer(S);
//        StringBuffer t=new StringBuffer(T);
//
//    }



    public static void main1(String[] args) {
        MyArrayList myArrayList=new MyArrayList(10);
//        myArrayList.add(0,1);
//        myArrayList.add(0,1);
//        myArrayList.add(0,1);
//        myArrayList.add(0,4);
//        myArrayList.add(0,19);
//        myArrayList.display();
//        System.out.println(myArrayList.search(3));
//        //判断是否有这个数
//        System.out.println(myArrayList.contains(6));
//        System.out.println(myArrayList.contains(2));
//        //获得这个下标的数
//        System.out.println(myArrayList.getPos(4));
//        //更改这个位置的数
//        myArrayList.setPos(0,999);
//        myArrayList.display();
//        //删除这个数字
//        myArrayList.remove(999);
//        myArrayList.display();
//        //获取长度
//        System.out.println(myArrayList.size());
//        myArrayList.removeall(1);
//        myArrayList.display();
//        System.out.println(myArrayList.size());
        myArrayList.add(0,1);
        myArrayList.add(0,1);
        myArrayList.add(0,1);
        myArrayList.add(0,1);
        myArrayList.add(0,1);
        myArrayList.add(0,1);
        myArrayList.add(6,19);
        myArrayList.add(7,19);
        myArrayList.add(8,1);
        myArrayList.display();
        myArrayList.removeAll(1);
        myArrayList.display();


    }



}
