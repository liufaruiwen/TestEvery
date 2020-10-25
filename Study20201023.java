package study;

public class Study20201023 {


    static  class ListNode {
        public int data;
        public ListNode prev;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    static class DoubleList {
        public ListNode head;
        public ListNode last;//始终指向最后的那个节点

        //头插法
        public void addfirst(int data) {

            ListNode node = new ListNode(data);
            if (head == null) {
                this.head = node;
                this.last = node;
            } else {
                node.next = this.head;
                head.prev = node;
                this.head = node;
            }
        }

        //尾插法
        public void addlast(int data) {
            ListNode node = new ListNode(data);
            if (head == null) {
                this.head = node;
                this.last = node;
            } else {
                last.next = node;
                node.prev = this.last;
                this.last = node;
            }
        }

        //大小
        public int size() {
            if (head == null) {
                return -1;
            }
            ListNode tmp = this.head;
            int count = 0;
            while (tmp != null) {
                tmp = tmp.next;
                count++;
            }
            return count;
        }

        //打印
        public void display() {
            if (head == null) {
                return;
            }
            ListNode tmp = this.head;
            while (tmp != null) {

                System.out.print(tmp.data + " ");
                tmp=tmp.next;
            }
            System.out.println();
        }

        //找到key
        public boolean contains(int key) {
            if (head == null) {
                return false;
            }
            //要展现双地址域的特点吗
            ListNode first = this.head;
            ListNode end = this.last;

            while (first != end) {

                if (first.data != key && end.data != key) {
                    if (first.next == end) {
                        return false;
                    }
                    first = first.next;
                    end = end.prev;
                } else {
                    return true;
                }
            }
            if (first.data == key) {
                return true;
            }
            return false;
        }

        //访问
        public ListNode searchIndex(int index) {
            if (index < 0 || index > size()) {
                return null;
            }

            ListNode node = this.head;
            while (index >= 0) {
                node = node.next;
                index--;
            }
            return node;

        }

        //随机插入
        //任意位置插入,第一个数据节点为0号下标
        public void addIndex(int index, int data) {
            if (index == 0) {
                addfirst(data);
                return;
            }
            if (index == size()) {
                addlast(data);
                return;
            }
            ListNode node = new ListNode(data);
            ListNode cur = searchIndex(index);
            if (cur == null) {
                return;
            }
            //转移
            node.next = cur;  //1    node的下一个为cur
            cur.prev.next = node;//2   cur的前驱的next指向node
            node.prev = cur.prev;//3   node前驱指向cur的前驱
            cur.prev = node;//4        cur的前驱指向node
        }

        //删除，，并返回该节点？
        public void remove(int key) {
            //先找到key的节点cur，，，
            if (this.head == null) {
                return;
            }
            ListNode node = this.head;
            while (node != null) {
                //如果找到，，，则先进行是否是头节点的判断，因为发现头节点是要特殊处理的，，然后在后续判断是否是尾节点，，，
                if (node.data == key) {
                    if (head.data == key) {

                        head = head.next;
                        head.prev = null;
                    } else {
                        node.prev.next = node.next;
                        if (node.next != null) {
                            node.next.prev = node.prev;
                        } else {
                            last = last.prev;
                        }
                    }
                    return;
                } else {
                    node = node.next;
                }
            }
        }

        public static void main(String[] args) {

            DoubleList doubleList=new DoubleList();
            doubleList.addlast(1);
            doubleList.addlast(2);
            doubleList.addlast(3);
            doubleList.addlast(4);
            doubleList.display();


        }


    }
}
