package study;

import java.util.ArrayList;
import java.util.List;

public class Study20201027 {


    public static void main(String[] args) {
        System.out.println("abcd".compareTo("abd"));
        System.out.println("abc".compareTo("abe"));
        System.out.println("abcde".compareTo("abc"));
        System.out.println("ab".compareTo("ab"));
        System.out.println(myCompareTo("abcd", "abd"));
        System.out.println(myCompareTo("abc", "abe"));
        System.out.println(myCompareTo("abcde", "abc"));
        System.out.println(myCompareTo("ab", "ab"));
        //除非是前面相同，然后多出来的算做直接数字
        //从第一个开始，如果不一样就直接报那个

    }

    public static void main2(String[] args) {

        String str="121 451 189";
        System.out.println(str);
//        str.split("1");
        str=myReplace('1',str,'6');
        System.out.println(str);

//        String[] abc=mySplit(str," ");
//        for (String i: str) {
//            System.out.println(i+" ");
//        }


    }
    public static String[] mySplit(String str,String flag) {

        //从哪开始截取，，或者是从哪截取到哪
        ArrayList<String> list = new ArrayList<>();
        while (str.contains(flag)) {
            int index = str.indexOf(flag);
            String tmp = str.substring(0, index);
            list.add(tmp);
            str = str.substring(index + flag.length());
        }

        list.add(str);
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    //把全部的old，替换成新的
    public static String myReplace(char old,String str,char news) {

        StringBuilder builder=new StringBuilder();

        for (int i = 0; i <str.length() ; i++) {

            if(str.charAt(i)==old) {
                builder.append(news);
            }else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

//    public static int myIndexOf(String str,String find) {
//
//        //暴力算法或者是kmp算法，，去判断字符串是否存在
//
//
//
//
//
//
//    }


    public static int myCompareTo(String str,String str1) {

        int a=str.length();
        int b=str1.length();
        int c;
        int d=Math.min(str.length(),str1.length());

        for (int i = 0; i <d; i++) {

            if(str.charAt(i)==str1.charAt(i)) {
                    i++;
            }else {
                c=str.charAt(i)-str1.charAt(i);
                return c;
            }
        }
       return str.length()-str1.length();
    }












     static class TestClass {

        private static void testMethod(){

            System.out.println("testMethod");

        }

        public static void main2(String[] args) {

            ((TestClass)null).testMethod();

        }

    }





     static class SystemUtil{
        public static boolean isAdmin(String userId){
            return userId.toLowerCase()=="admin";
        }
        public static void main2(String[] args){
            System.out.println(isAdmin("Admin"));
        }
    }


    public static void main1(String[] args) {

        String str1="hello";
        String str2=new String("hello");
        System.out.println(str1==str2);//flase

        String str3="hel"+"lo";
        System.out.println(str1==str3);//true


        //str4进行了后期的绑定， 前者是编译时就已经确定，，
        String str4="hel";
        String str5=str4+"lo";
        System.out.println(str1==str5);//flase

        String str6=new String("hel")+"lo";
        System.out.println(str6==str1);//flase


    }

}
