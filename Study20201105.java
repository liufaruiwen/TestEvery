package Study11;

import org.w3c.dom.NodeList;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Study20201105 {

    static class Node {
        char val;        // 数据域
        Node left;      // 左孩子的引用，常常代表左孩子为根的整棵左子树
        Node right;     // 右孩子的引用，常常代表右孩子为根的整棵右子树

        public Node(char val) {
            this.val = val;
        }
    }

    static class BinaryTree {


        public Node createTree() {
            Node A = new Node('A');
            Node B = new Node('B');
            Node C = new Node('C');
            Node D = new Node('D');
            Node E = new Node('E');
            Node F = new Node('F');
            Node G = new Node('G');
            Node H = new Node('H');
            A.left = B;
            A.right = C;
            B.left = D;
            B.right = E;
            E.right = H;
            C.left = F;
            C.right = G;
            return A;
        }

        // 前序遍历
        void preOrderTraversal(Node root) {

            if(root==null) {
                return;
            }

            //根会一直动，
            System.out.println(root.val);
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
        }

        // 中序遍历
        void inOrderTraversal(Node root) {

            if(root==null) {
                return;
            }

            //根会一直动，
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);


        }

        // 后序遍历
        void postOrderTraversal(Node root) {

            if(root==null) {
                return;
            }

            //根会一直动，
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val+" ");



        }

        int getSize2(Node root) {

            if(root==null) {
                return 0;
            }
           return getSize2(root.left)+getSize2(root.right)+1;

        }

         static int count1=0;
        void getSize1(Node root) {
            if(root==null) {
                return ;
            }
            count++;
            getSize1(root.left);
            getSize1(root.right);


        }

        int getLeafSize2(Node root) {
            if(root==null) {
                return 0;
            }

            if(root.left==null && root.right==null){
                return 1;
            }

           return getLeafSize2(root.left)+getLeafSize2(root.right);

        }
        static int count=0;
        void getLeafSize1(Node root) {

            if(root==null) {
                return ;
            }

            if(root.left==null && root.right==null){
                count++;
            }
            getLeafSize2(root.left);
            getLeafSize2(root.right);
        }

        //层序遍历
        void levelOrderTraversal(Node root){

            if(root==null) {
                return;
            }

            Queue<Node> tree=new LinkedList<>();
            List<Character> num=new ArrayList<>();

            tree.offer(root);

            while (tree!=null) {
                Node tmp=tree.poll();
                num.add(tmp.val);
                tree.offer(tmp.left);
                tree.offer(tmp.left);
            }
        }

        boolean isCompleteTree(Node root) {

            //节点数是否和深度成相关趋势
            return false;
        }

        //二叉树最大深度
        int maxDepth(Node root) {

            //递归
            return root==null?  0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }

        // 检查两颗树是否相同
        boolean sameTree(Node root1,Node root2) {

            if(root1==null && root2!=null) {
                return false;
            }
            if(root1!=null && root2==null) {
                return false;
            }
            if(root1==null && root2==null) {
                return true;
            }

            if(root1.val ==root2.val) {
                return  sameTree(root1.left,root2.left) && sameTree(root1.right,root2.right);
            }else {
                return false;
            }

        }

        //对称二叉树
        //左树反过来是否等于右树
        public static boolean isSymmetric(Node root) {
            if(root==null) {
                return false;
            }
            return comRoot(root.left,root.right);
        }
        public static boolean comRoot(Node left, Node right) {

            if(left==null && right==null) {
                return true;
            }
            if(left==null || right==null) {
                return false;
            }

            return left.val!=right.val && comRoot(left.left,right.right) && comRoot(left.right,right.left);
        }
//        public static boolean isSymmetric(Node root) {
//            return check(root, root);
//        }
//
//        public static boolean check(Node p, Node q) {
//            if (p == null && q == null) {
//                return true;
//            }
//            if (p == null || q == null) {
//                return false;
//            }
//            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
//        }



        public static void main(String[] args) {
            Node root=null;
            System.out.println(isSymmetric(root));
        }












    }

    public static void main1(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        Node root=binaryTree.createTree();
            binaryTree.postOrderTraversal(root);

    }

    //二叉树的前序遍历
//    List<Integer> list=new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if(root==null) {
//            return ;
//        }
//        list.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//
//
//    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//            //首先是判断wordList里面是否有endWord，，
//            int i = 0;
//            for (; i < wordList.size(); i++) {
//                if(endWord.equals(wordList.get(i))) {
//                    break;
//                }
//            }
//            if(i==wordList.size()) {
//                return 0;
//            }
//            //进行反向判断
//
//    }

}
