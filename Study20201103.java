package Study11;

import java.util.*;

public class Study20201103 {

    public static void main(String[] args) {

        System.out.println(getResult(210));

    }

     static class Joseph {
        public static int getResult123(int n) {
            return ysf(n, 2);
        }
        public static int ysf(int n, int m) {
            int tmp = n%m==0 ? n/m : n/m+1;
            if(tmp <= m+1) {
                return (tmp-1)*m+1; //终止条件
            }
            int path = ysf(tmp, m+1); //m+1次时最后一人编号的位置
            return (path-2)*m + 1;
        }

        public static void main(String[] args) {

            System.out.println(getResult123(10));
        }
    }

    //约瑟夫问题II
    public static int getResult(int n) {
        // write code here
        //循环队列，永远滴神
        Queue<Integer> o=new LinkedList<>();
        List<Integer>  op=new ArrayList<>();
        //注入
        for (int i = 1; i <=n ; i++) {
            op.add(i);
        }
        //选择

        int count=1;
        do {
            count++;
            for (int i = 1; i <= op.size(); i++) {

                //符合条件，，也就是为1
                if (i % count == 1) {

                    o.add(op.get(i-1));
                }
            }
            //清空op
            op.clear();
            while (!o.isEmpty()){
                op.add(o.poll());
            }
            int index= op.size()-1;
            op.add(0,op.remove(index));

        }while (op.size()!=1);

        return op.get(0);
    }




    //最近请求次数
    //仔细想想，，在这个区间内，，移除掉不属于的，，从头开始递增的，，队列满足
    class RecentCounter {
        Queue<Integer> q;
        public RecentCounter() {
            q = new LinkedList();
        }

        public int ping(int t) {
            q.add(t);
            //移除掉不符合的
            while (q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();
        }
    }





    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */





//    public ArrayList<Integer> asylum(int[][] ope) {
//        // write code here
//
//
//
//
//    }






    //比较退格的字符串
    public  boolean backspaceCompare(String S, String T) {

        Stack<String> s=new Stack<>();
        Stack<String> t=new Stack<>();

        for (int i = 0; i <S.length() ; i++) {

            if((S.charAt(i)+"").equals("#")) {
                if(!s.isEmpty()) {
                    s.pop();
                }
            }else {
                s.push((S.charAt(i)+""));
            }

        }
        for (int i = 0; i <T.length() ; i++) {

            if((T.charAt(i)+"").equals("#")) {
                if(!t.isEmpty()) {
                    t.pop();
                }
            }else {
                t.push((T.charAt(i)+""));
            }

        }

        while (!t.isEmpty() && !s.isEmpty()) {
            if(!(t.pop().equals(s.pop()))) {

                return false;

            }
        }

        return t.isEmpty() && s.isEmpty();
    }













    //栈的弹出压入序列
//    public static boolean IsPopOrder(int [] pushA,int [] popA) {
//
//
//
//
//    }

    public int calPoints(String[] ops) {


        Stack<Integer> op=new Stack<>();

        for (int i = 0; i <ops.length ; i++) {

            if(ops[i].equals("C")) {

                int a =op.pop();
            }else if(ops[i].equals("D")) {

                int a =op.peek();
                op.push(a*2);
            }else if(ops[i].equals("+")) {

                int a =op.pop();
                int b =op.peek();
                op.push(a);
                op.push(a+b);
            }else {
                op.push(Integer.valueOf(ops[i]));
            }

        }
        int sum=0;
        while (!op.isEmpty()){
            sum+=op.pop();
        }
        return sum;
    }

    public static void main1(String[] args) {
        String[] tokens={"10","6","9","3","+","-11","/","17","+","5"};
        System.out.println(evalRPN(tokens));

//        char ccl='5';
//        System.out.println(Integer.valueOf(ccl+""));

    }

    //逆波兰表达式求值
    public static int evalRPN(String[] tokens) {
        Stack<Integer> num=new Stack<>();

        for (int i = 0; i <tokens.length ; i++) {
            String cc=tokens[i];
            if(!cc.equals("+") && !cc.equals("-") && !cc.equals("*") &&!cc.equals("/")) {
               num.push(Integer.valueOf(cc));
            }else {
                int aaa=num.pop();
                int bbb=num.pop();
                if(tokens[i].equals("+")){

                    num.push(aaa+bbb);
                }
                else if(tokens[i].equals("-")){

                    num.push(bbb-aaa);
                }else if(tokens[i].equals("*")){

                    num.push(aaa*bbb);
                }else if(tokens[i].equals("/")){

                    num.push(bbb/aaa);
                }
            }
        }
        return num.pop();
    }




    //用单调栈去解决这个
    class StockSpanner {

        public Stack<Integer> prices;
        public Stack<Integer> weights;

        public StockSpanner() {
            prices=new Stack<>();
            weights=new Stack<>();
        }

        public int next(int price) {

            int w=1;
            //第一次进来的也不怕，有个空的判断
            while(!prices.isEmpty() && prices.peek() <=price) {
                prices.pop();
                w+=weights.pop();
            }
            prices.push(price);
            weights.push(w);
            return w;
        }
    }








    class StockSpanner13 {
        //思路：记载2个ArrayList，一个是输入参数price；另一个是next的结果；这两个组合起来相当于一个跳表
        //每个都是结果对应的范围内的最大数，如果比上个数少，那就是1，如果比上个数大，分2种情况，比如前一个小，那就是+1，如果大，进一步纳入范围
        List<Integer> prices;
        List<Integer> results;

        public StockSpanner13() {
            prices = new ArrayList<>();
            results = new ArrayList<>();
        }

        public int next(int price) {
            int tail = prices.size()-1;
            int ret = 1;
            while (tail >= 0 && price >= prices.get(tail)) {
                int rt = results.get(tail);
                ret += rt;
                tail = tail - rt;
            }
            prices.add(price);
            results.add(ret);
            return ret;
        }
    }





    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    static class StockSpanner12 {

     public Node head;
     public Node tail;

    public StockSpanner12() {

    }

    public int next(int price) {
        //先插入元素
        Node node1=new Node(price);
        if(head==null){
            head=node1;
        }else {
            tail.next=node1;
        }
        tail=node1;
        //count
        int count=0;
        Node node2=head;
        while(node2!=null) {
            if(node2.val<=price) {
                count++;
            }
        }
        return count;
    }


        public static void main999(String[] args) {

//         StockSpanner obj = new StockSpanner();
//            int param_1 = obj.next(price);

        }
}











    //栈的实现
    class MyStack {
        public int[] elem;
        public int usedSize;//top

        public MyStack() {
            this.elem = new int[5];
        }
        public void push(int item) {
            if(this.usedSize==this.elem.length){
                System.out.println("空间已满！");
                return;
            }
            this.elem[usedSize++]=item;
        }
        public int pop() {
            if(this.usedSize==0) {
                System.out.println("没有数据可读出！");
                return 0;
            }
            return this.elem[--usedSize];
        }
        public int peek(){
            if(this.usedSize==0) {
                System.out.println("没有数据可读出！");
                return 0;
            }
            return this.elem[usedSize-1];
        }
        public boolean isEmpty() {
//            if(this.usedSize==0){
//                return true;
//            }
//            return false;
            return this.usedSize==0;
        }

        public boolean isFull() {
//            if(this.usedSize==this.elem.length){
//                System.out.println("空间已满！");
//                return false;
//            }
//            return true;
            return this.usedSize==this.elem.length;
        }
    }


//    static class Node {
//        public int val;
//        public Node next;
//
//        public Node(int val) {
//            this.val = val;
//        }
//    }

    class MyQueue {
        public Node head;
        public Node tail;

        public void offer(int val) {

           Node node=new Node(val);
            if(isEmpty()) {
                //第一次插入
                head = node;
            }else {
                //后续插入
                tail.next=node;
            }
            tail=node;
        }

        public int poll() {

            if(isEmpty()) {
//                return -1;
                throw new RuntimeException("队列为空");
            }

            int data=head.val;
            head=head.next;
            if(isEmpty()) {
                tail=null;
            }
            return data;

        }

        public int peek() {
            if(isEmpty()) {
//                return -1;
                throw new RuntimeException("队列为空");
            }
            return head.val;
        }

        public boolean isEmpty() {
            return head==null;
        }
    }

    class MyCircularQueue {


        public int[] elem;
        public int usedSize;
        public int front;
        public int rear;


        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            this.elem = new int[k];
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {

            //1.判断是否为满
            //2.rear--》

            if(isFull()) {
                return false;
            }
            elem[rear]=value;
            //不能做简单的++运算，，因为要取模了
            rear=(rear+1)%elem.length;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            //1.判断是否为空
            if(isEmpty()) {
                return false;
            }
//            int data=elem[front];
            front=(front+1)%elem.length;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if(isEmpty()){
                return -1;
            }
            return elem[front];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            //考虑欠周
            //rear的值是代表下一个插入的点
            //故求那个值，，得是rear-1的下标（正常情况下）
            //若是0的情况，得是elem。length-1的下标（循环情况下）
            int index;
            if(rear==0) {
                index=elem.length-1;
            }else {
                index=rear-1;
            }
            return elem[index];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return rear==front;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return (rear+1)%elem.length==front;
        }
    }


}
