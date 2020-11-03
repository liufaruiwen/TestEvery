package Study11;

import java.util.*;

public class Study20201102 {


    public static void main(String[] args) {

        Queue1 queue1=new Queue1();
        queue1.addlast(1);
        queue1.addlast(2);
        queue1.addlast(3);
        queue1.addlast(4);
        queue1.display();
        queue1.outnum();
        queue1.display();
        queue1.outnum();
        queue1.display();
        queue1.outnum();
        queue1.display();
        queue1.outnum();
        queue1.display();
        queue1.outnum();
        queue1.display();

    }

    static class Node {
        public int val;
        public Node next;


        public Node(int val) {
            this.val = val;
        }
    }

    static class Queue1 {

        public Node front;
        public Node rear;
        public int size;

        //尾部插入
        public void addlast(int val) {

            Node node=new Node(val);
            if(front==null) {
                //第一次插入
                front = node;
            }else {
                //后续插入
                rear.next=node;
            }
            rear=node;
            size++;
        }

        //头部取数
        public int outnum() {

//            if(front==null) {
//                System.out.println("队列为空!");
//                return 0;
//            }
            if(size==0) {
                System.out.println("队列为空!");
                return 0;
            }
            int data=front.val;
            front=front.next;
            if(front==null) {
                rear=null;
            }
            size--;
            return data;

        }

        //show
        public void display() {

            if(front==null) {

                return;
            }
            Node node=this.front;
            while(node!=null) {
                System.out.print(node.val+" ");
                node=node.next;
            }
            System.out.println();

        }

        //size
        public int sizeof() {
            return size;
        }

    }






    public static void main7(String[] args) {


        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(4);
        System.out.println(list);


        //插入
        list.add(0,8);
        System.out.println(list);

        //删除第一个遇见的数
        list.remove(3);
        System.out.println(list);

        int b=list.remove(3);
        System.out.println(b+" abcd");

        //获取下标指定元素
        //返回值为E
        System.out.println(list.get(0));

        //判断 o 是否在线性表中
        System.out.println(list.contains(8));

        //[)  前闭后开的区间,,截取部分
        List<Integer> list1=list.subList(0,3);
        System.out.println(list1);

        //将下标为这个的元素设置为,,
        list.set(0,888);
        System.out.println(list);

        //获取这个下标的位置元素
        System.out.println(list.get(0));

        //


    }






    public static void main6(String[] args) {

        System.out.println(generate(5));
    }


    //杨辉三角自己实现
    public static List<List<Integer>> generate(int numRows) {


        List<List<Integer>> list1=new ArrayList<>();
        if(numRows==0 ){
            return list1;
        }
        //第一层
        List<Integer>  cur=new ArrayList<>();
        cur.add(1);
        list1.add(cur);

        for (int i = 1; i < numRows; i++) {

            //一层
            //第一部分
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);

            //中间部分
            //可以在前面提前一行放入一个里面
            List<Integer> preRow = list1.get(i-1);
            for (int j = 1; j < i; j++) {
                int tmp=preRow.get(j)+preRow.get(j-1);
                list2.add(tmp);
            }
            //最后部分
            list2.add(1);
            //进入二维
            list1.add(list2);
        }
        return list1;
    }









    public static void main5(String[] args) {

        int[][] grid={{1}};
        List<List<Integer>> list=shiftGrid(grid,1);
        System.out.println(list);
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {


        List<List<Integer>> list=new ArrayList<>();

        if(grid==null){
            return list;
        }
        int m=grid.length;
        int n=grid[0].length;

        for (int i = 0; i <m; i++) {
            List<Integer>  list1=new ArrayList<>();
            for (int j = 0; j <n; j++) {
                list1.add(grid[i][j]);
            }
            list.add(list1);
        }

        //m行  grid.length   n行  grid[i].length
        // k为偏移量,,,先弄k=1的,然后循环k次

        //循环一次的量

        for (int j = 0; j <k ; j++) {

            int end = list.get(m - 1).get(n - 1);
            if(m>=2) {
                list.get(1).add(0, list.get(0).get(n - 1));
            }

            for (int i = 2; i < m; i++) {
                int tmp = list.get(i - 1).get(n);
                list.get(i).add(0, tmp);
            }
            list.get(0).add(0, end);
            for (int i = 0; i < m; i++) {
                list.get(i).remove(n);
            }
        }
        return list;
    }

    public boolean canThreePartsEqualSum(int[] A) {






        return false;
    }



    public static void main4(String[] args) {

//        int[][] trust={{1,3},{1,4},{2,3},{2,4},{4,3}};
        int[][] trust={{2,1}};
        System.out.println(findJudge(2, trust));


    }
    public static int findJudge(int N, int[][] trust) {

        List<Integer> list=new ArrayList<>();
        //思路先找到那个不相信任何人的人
        for (int i = 0; i <trust.length ; i++) {
            list.add(trust[i][0]);
        }

        int tmp=-1;
        Integer i = 1;
        for (; i <=N ; i++) {
            if(!list.contains(i)) {
                tmp=i;
                break;
            }
        }
        //再看看除了他之外,是否是全部人都相信他
        list.clear();

        for (int j = 0; j <trust.length ; j++) {
            list.add(trust[j][1]);
        }
        int count =0;
        for (int k = 0; k <list.size() ; k++) {
            if(list.get(k)==tmp) {
                count++;
            }
        }
        if(count==N-1){
            return tmp;
        }
        return -1;
    }



    static class A<T> {
        T value;

        A(T value) {
            this.value=value;
        }

        T get() {
            return value;
        }
    }


// Definition for Employee.
static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};


    public static int getImportance(List<Employee> employees, int id) {

        //对ID进行寻找
        int IDD=0;
        for (int i = 0; i <employees.size() ; i++) {
            if(employees.get(i).id==id){
                IDD=i;
                break;
            }
        }
        //先找到当前ID的重要度
        int sum=employees.get(IDD).importance;
        //记录当前ID的下属有几个
        int count=employees.get(IDD).subordinates.size();
        for (int i = 0; i <count ; i++) {
            //记录当前ID下属的ID号
            int num=employees.get(IDD).subordinates.get(i);
            int cc=0;
            for (int j = 0; j <employees.size() ; j++) {
                if(employees.get(j).id==num){
                    cc=j;
                    break;
                }
            }
            sum+=employees.get(cc).importance;
        }
        return sum;
    }

    public static void main3(String[] args) {

        List<Employee> list=new ArrayList<>();

        List<Integer> bbc=new ArrayList<>();
        bbc.add(2);
        bbc.add(3);
        List<Integer> bbc1=new ArrayList<>();
        List<Integer> bbc2=new ArrayList<>();
        List<Integer> bbc3=new ArrayList<>();
        bbc1.add(4);
        list.add(new Employee(1,5,bbc));
        list.add(new Employee(2,3,bbc1));
        list.add(new Employee(3,4,bbc2));
        list.add(new Employee(4,1,bbc2));

        System.out.println(getImportance(list, 1));

    }





    public static void main2(String[] args) {

        A<String> a=new A<>("abc");
        System.out.println(a.get());

    }


    static class Student {
        private String name;
        private String classroom;
        private double score;

        public Student(String name, String classroom, double score) {
            this.name = name;
            this.classroom = classroom;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", classroom='" + classroom + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main1(String[] args) {
        ArrayList<Student> student=new ArrayList<>();

        student.add(new Student("葛二蛋","5班",95));
        student.add(new Student("段小龙","5班",80));
        student.add(new Student("李志辉","5班",75));

//        System.out.println(student);

//        for(Student stu:student) {
//            System.out.println(stu);
//        }

//        List<Integer> list= new ArrayList<>();
//        list.add(1);
//        list.add(5);
//        list.add(4);
//        list.add(3);
//        list.add(2);
//        Collections.sort(list);
//        System.out.println(list);

        String str1="welcome to bit";
        String str2="come";
        System.out.println(notchar(str1, str2));

//        List<String> list=new ArrayList();
//        notchar1(Collections.singletonList(list));
//        notchar1(Collections.singletonList(list));





    }


    public static String notchar(String s1,String s2) {
        //常用办法
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <s1.length() ; i++) {
//            int count=0;
//            for (int j = 0; j <s2.length() ; j++) {
//                if(s1.charAt(i)!=s2.charAt(j)) {
//                    count++;
//                }
//                if(count==s2.length()) {
//                    builder.append(s1.charAt(i));
//                }
            //熟练掌握String的方法
            char tmp=s1.charAt(i);
            if(!s2.contains(tmp+"")) {
                builder.append(tmp);
            }
        }
        return builder.toString();

        //本节内容

    }
    public static void notchar1(List<Object> list) {

    }




}
