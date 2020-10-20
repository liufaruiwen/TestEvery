package study;

import javax.swing.*;
import java.util.Collection;
import java.util.LinkedList;

public class Study20201020 {


    //节点定义；；数据域，地址域（本类的地址），分别命名为data，next，，定义完成员变量后，定义一个或多个，，构造函数，，方便构造节点
    static class Node {
        public int data;
        public Node next;//存储对象引用

        public Node(int data) {
            this.data = data;
            //这里没有初始化next的引用是，不知道next当前指向那个
            //节点
        }
    }
    //链表定义，，首先定义了头节点，然后定义链表的功能，，这边定义的是无头单向不循环链表
    public static class MySingleList {
        public Node head;//作用是，定位头节点的引用
        //头插法
        public void addFirst(int data){
            //1.用data构造一个node节点
            Node node=new Node(data);
            //2.把这个节点插入到头节点
            //判断head是否为空，，后面优化，有无头节点，这个程序都能正常运行，且结果正确
            node.next = this.head;
            this.head=node;
        }
        //尾插法
        public void addLast(int data){
            //1.用data构造一个node节点
            Node node=new Node(data);
            //2.把这个节点插入到尾节点
            //检测是否没头节点
            if(head==null) {
                head=node;
                return;
            }
            Node tmp=head;
            while (tmp.next!=null){
                tmp=tmp.next;
            }
            tmp.next=node;
        }

        //任意位置插入,第一个数据节点为0号下标
        public void addIndex(int index,int data) {
            //判断合法性
            if(index<0 ||index>size()){
                System.out.println("节点不规范！");
                return;
            }
            //判断是否加到头部
            if(index==0){
                addFirst(data);
                return;
            }
            //判断是否是加到尾部，，其实尾部加入，通过下面程序也能正常进行，，此处进行（可能）达到优化
            if(index==size()){
                addLast(data);
                return;
            }
            Node node=new Node(data);
            Node tmp=head;
            int indexO=0;
            //找到下标为index-1的那个节点
            while (indexO!=index-1) {
                tmp=tmp.next;
                indexO++;
            }
            //进行连接
            node.next=tmp.next;
            tmp.next=node;
        }
        //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key) {
            Node node=head;
            if(head!=null) {
                while (node!=null) {
                    if(node.data==key) {
                        return true;
                    }
                    node=node.next;
                }
            }
            return false;
        }

        //找到需要删除的前驱节点
        public Node searchPrevNode(int key) {

            Node node=this.head;
            if(node==null){
                return null;
            }
            //如果用 node！=null去测试，，可能下面的node.next.data会运行报错，因为如果它的下一个节点为空，这里会空指针异常
             while (node.next!=null){
                if(node.next.data==key) {
                    return node;
                }
                node=node.next;
            }
            return node;
        }
        //删除第一次出现关键字为key的节点
        public void remove(int key){
//            if(head==null){
//                return;
//            }
//            Node p=head;
//            Node q=head.next;
//            if(p.data==key) {
//                this.head=this.head.next;
//                return;
//            }
//            //首先不能为空，防止溢出
//            while (q!=null && q.data!=key) {
//                p=p.next;
//                q=q.next;
//            }
//            //判断是否是因为q=null而退出
//            if(q==null){
//                System.out.println("未能找到该节点！");
//                return;
//            }
//            p.next=q.next;
//            q=null;

            //仍要判断头节点
            if(this.head.data==key) {
                this.head=this.head.next;
                return;
            }
            //找前驱
            Node node=searchPrevNode(key);
            if(node==null){
                System.out.println("没有找到这个节点");
                return;
            }
            node.next=node.next.next;
        }
        //删除所有值为key的节点
        public void removeAllKey(int key) {
            //方法一：
//            if(!contains(key)){
//                return;
//            }
//            while (contains(key)) {
//                remove(key);
//            }
            //方法二：
            int count=0;
            Node node=head;
            while(node!=null) {
                if(node.data==key){
                    count++;
                }
                node=node.next;
            }
            while (count!=0) {
                remove(key);
                count--;
            }

        }
        //得到单链表的长度
        public int size() {
            Node cur=this.head;
            if(cur==null) {
                return -1;
            }
            int count=0;
            //判断这个指针指向的是否为空
            while (cur!=null) {
                cur=cur.next;
                count++;
            }
            return count;
        }

        public void display() {
            Node cur=this.head;
            //判断这个指针指向的是否为空
            while (cur!=null){
                System.out.print(cur.data+" ");
                cur=cur.next;
            }
            System.out.println();
        }
        public void clear() {

        }

    }

    public static void main(String[] args) {
        MySingleList mySingleL=new MySingleList();
        mySingleL.addLast(1);
        mySingleL.addLast(3);
        mySingleL.addLast(5);
        mySingleL.addLast(7);
        mySingleL.display();
        MySingleList mySingleL1=new MySingleList();
        mySingleL1.addLast(2);
        mySingleL1.addLast(4);
        mySingleL1.addLast(6);
        mySingleL1.addLast(8);
        mySingleL1.display();
//        System.out.println(mySingleL.head.data);//1
//        System.out.println(mySingleL1.head.data);//2
//        if((mySingleL.head.next.data)>mySingleL1.head.data){
//            System.out.println("111");
//        }else {
//            System.out.println("222");
//        }

        mySingleL.head=mergeTwoLists(mySingleL.head,mySingleL1.head);
        mySingleL.display();

    }
    /*
1.ok

*/
    //2.反转一个链表
    //力扣上题意大概是通过反转,,是真正意义上的反转,,通过一定的手段,让整个链表方向变换
    public static Node reversalList(Node head) {
        Node node=head;
        MySingleList cur=new MySingleList();
        while (node!=null) {
            cur.addFirst(node.data);
            node=node.next;
        }
        return cur.head;
    }
    //3.返回中间节点,,,利用快慢指针
    //4.输入一个链表,输出该链表中倒数第k个节点.先用size,然后算出第k个节点是正数第几个

    //5.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    /*
    1 2 4       1  3  4       1 1 2 3 4 4
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        //定义两个量,赋值l1,l2
        MySingleList l11 = new MySingleList();
        MySingleList l22 = new MySingleList();
        MySingleList cur = new MySingleList();
        l11.head = l1;
        l22.head = l2;
        cur.head = null;
        //
        while (l11.head != null || (l22.head != null)) {

            if((l11.head.data)<(l22.head.data)) {
                cur.addLast(l11.head.data);
                l11.head = l11.head.next;
                if (l11.head == null) {
                    while (l22.head != null) {
                        cur.addLast(l22.head.data);
                        l22.head = l22.head.next;
                    }
                }
            } else {
                cur.addLast(l22.head.data);
                l22.head = l22.head.next;
                if (l22.head == null) {
                    while (l11.head != null) {
                        cur.addLast(l11.head.data);
                        l11.head = l11.head.next;
                    }
                }
            }
        }
        return cur.head;
    }







//    public Node removeElements(Node head, int val) {
//
//
//
//    }
    public static void main2(String[] args) {
        MySingleList mySingleL=new MySingleList();
        mySingleL.addLast(1);
        mySingleL.addLast(2);
        mySingleL.addLast(3);
        mySingleL.addLast(4);
//        mySingleL.addLast(5);
//        mySingleL.addLast(6);
//        mySingleL.addLast(7);
//        mySingleL.addLast(8);
//        mySingleL.addLast(9);
//        mySingleL.addLast(10);
        mySingleL.display();
        mySingleL.head=reorderList(mySingleL.head);
        mySingleL.display();

        //系统自带的链表
        LinkedList<Node> queue=new LinkedList<>();

    }
    public static Node reorderList(Node head) {
    MySingleList front = new MySingleList();
    MySingleList back = new MySingleList();
    MySingleList my = new MySingleList();
    MySingleList newNode = new MySingleList();

    my.head=head;
    Node myhode=my.head;
    Node myfront=front.head;
    Node myback=back.head;

    //因为这个是带有头节点的，，，暂时不用带头节点的，因为情况不允许
    int size=my.size();
    int tmp=size/2;
    //之前没注意到size一直在变，，，所以要用常量，，，
//    while (size!=(size/2)){
     while (size!=tmp){
        front.addLast(myhode.data);
        myhode=myhode.next;
        size--;
    }
    while (size!=0){
        back.addFirst(myhode.data);
        myhode=myhode.next;
        size--;
    }
    size=my.size();
        for (int i = 1; i <=size ; i++) {
            //如果为奇数
            if(i%2!=0) {
                newNode.addLast(front.head.data);
                front.head=front.head.next;
            }else {
                newNode.addLast(back.head.data);
                back.head=back.head.next;
            }

        }
     return newNode.head;

    }

    public static void main1(String[] args) {
        MySingleList myAr=new MySingleList();
//        myAr.addFirst(1);
//        myAr.addFirst(2);
//        myAr.addFirst(3);
//        myAr.addFirst(4);
//        myAr.addFirst(5);
//        myAr.addFirst(6);
//        myAr.display();
//        myAr.remove(3);
//        myAr.display();
//        myAr.remove(6);
//        myAr.display();
//        myAr.remove(7);
//        myAr.display();
        myAr.addLast(1);
        myAr.addLast(2);
        myAr.addLast(3);
        myAr.addLast(4);
        myAr.addLast(7);
        myAr.addLast(6);
        myAr.addLast(7);
        myAr.addLast(7);
        myAr.addLast(8);
        myAr.display();
        myAr.removeAllKey(7);
        myAr.display();



    }


}
