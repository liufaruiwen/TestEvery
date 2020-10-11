import java.util.Arrays;

public class Test20201012 {
    public static void main(String[] args) {
      int[] arr={1,4,9,5,3,10,6,7,11,2,15};
//        int find=dichotomy(arr,15);
//        System.out.println("这个数是arr中下标第："+find+"的数");
//        bubbleSort(arr);   //冒泡排序使用
        Arrays.sort(arr);   //java内置排序
        print(arr);




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
