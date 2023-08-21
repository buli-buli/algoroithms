package coding.tree;

/**
 * @ClassNAME RBTree
 * @Description 实现一颗红黑树
 *      一颗红黑树是满足下面红黑性质的二叉搜索树
 *          1、每个节点或是红色的，或是黑色的
 *          2、根节点是黑色的
 *          3、每个叶节点（NIL）是黑色的
 *          4、如果一个节点是红色的，则它的两个子节点都是黑色的
 *          5、对于每个节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点
 *      注：我们使用哨兵来简化边界条件的处理。
 *          哨兵 nil 是一个与树中普通节点有相同属性的对象。它的color属性为BLACK，
 *      而其他属性p、left、right和key可以设置为任意值。所有指向 NIL 的指针都用指向哨兵 nil的指针替换。
 * @Author yu
 * @Date 2023/8/11 16:30
 * @Version 1.0
 */
class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node {
        private int key;
        private boolean color;
        private Node p;
        private Node left;
        private Node right;

        public int getKey() {
            return key;
        }

        public boolean isColor() {
            return color;
        }

        public Node getP() {
            return p;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node(int key, boolean color, Node p, Node left, Node right) {
            this.key = key;
            this.color = color;
            this.p = p;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private final Node nil;

    public RedBlackTree() {
        nil = new Node(-1, BLACK, null, null, null);
        root = nil;
    }

    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();

        t.rbInsert(t, 11);
        t.rbInsert(t, 2);
        t.rbInsert(t, 14);
        t.rbInsert(t, 15);
        t.rbInsert(t, 1);
        t.rbInsert(t, 7);
        t.rbInsert(t, 5);
        t.rbInsert(t, 8);
        t.rbInsert(t, 4);

        TreeOperation.show(t.root);
    }

    //左旋操作
    private void leftRotate(RedBlackTree t, Node x){
        Node y = x.right;
        //y的左子树变为x的右子树
        x.right = y.left;
        //y的左子树的父节点指向x
        if (y.left != t.nil){
            y.left.p = x;
        }
        //y的父节点指向x的父节点
        y.p = x.p;

        if (x.p == t.nil){
            //x的父节点为空，说明x是根节点，那么直接将y设置为根节点
            t.root = y;
        }else if(x == x.p.left){
            //x是左孩子，y设置为x的父节点的左孩子。
            x.p.left = y;
        }else {
            //x是有孩子，y设置为x的父节点的右孩子
            x.p.right = y;
        }

        //把y的左孩子设置为x
        y.left = x;
        //x的父节点设置为y
        x.p = y;
    }

    //右旋操作
    private void rightRotate(RedBlackTree t, Node y){
        Node x = y.left;
        y.left = x.right;
        if (x.right != t.nil){
            x.right.p = y;
        }
        x.p = y.p;

        if (y.p == t.nil){
            t.root = x;
        }else if(y == y.p.right){
            y.p.right = x;
        }else {
            y.p.left = x;
        }

        x.right = y;
        y.p = x;
    }

    public void rbInsert(RedBlackTree t, int zKey){
        Node z = new Node(zKey, RED, t.nil, t.nil, t.nil);
        Node y = t.nil;
        Node x = t.root;

        while (x != t.nil){
            y = x;
            if (z.key < x.key){
                x = x.left;
            }else {
                x = x.right;
            }
        }

        z.p = y;

        if (y == t.nil){
            t.root = z;
        }else if (z.key < y.key){
            y.left = z;
        }else {
            y.right = z;
        }

        z.left = t.nil;
        z.right = t.nil;
        z.color = RED;

        //插入后可能会破坏性质2和性质4。因为我们将插入的新节点着为红色，所以性质1、3和5不会因为插入新节点而被破坏。
        //修改红黑树结构让他继续满足红黑树的五个性质
        rbInsertFixup(t, z);
    }

    private void rbInsertFixup(RedBlackTree t, Node z) {
        while (z.p.color == RED){
            //当z节点的父节点不是红色（即红黑树满足性质4）的时候退出循环
            if (z.p == z.p.p.left){
                //z节点的爸爸是他爷爷的左孩子
                Node y = z.p.p.right;
                if (y.color == RED){
                    //情况1 父节点和叔叔节点都是红色的

                    //父亲节点和叔叔节点都着为黑色
                    z.p.color = BLACK;
                    y.color = BLACK;

                    //爷爷节点着为红色
                    z.p.p.color = RED;

                    //z变为它的爷爷节点来重复while循环
                    z = z.p.p;
                }else if (z == z.p.right){
                    //情况2 叔叔节点是黑色的且父节点是爷爷节点的右孩子

                    z = z.p;
                    //左旋：z和z的父节点父子关系对调，儿子的左子树变成爸爸的右子树
                    leftRotate(t, z);
                }else {
                    //情况3：叔叔节点是黑色的且父节点是爷爷节点的左孩子

                    //父节点着为黑色
                    z.p.color = BLACK;
                    //爷爷节点着为红色
                    z.p.p.color = RED;

                    //右旋；z和z的父节点关系对调，儿子的右子树变成爸爸的左子树
                    rightRotate(t, z.p.p);
                }
            }else {
                //z节点的爸爸是他的爷爷节点的右孩子，和z节点的爸爸是他爷爷的左孩子时的处理时一样都有三种情况。
                //而且是对称的，将上面的代码copy一份下来，把left换成right，right换成left就可以了
                Node y = z.p.p.left;
                if (y.color == RED){
                    //情况1
                    z.p.color = BLACK;
                    y.color = BLACK;
                    z.p.p.color = RED;
                    z = z.p.p;
                }else if (z == z.p.left){
                    //情况2
                    z = z.p;
                    rightRotate(t, z);
                }else {
                    z.p.color = BLACK;
                    z.p.p.color = RED;
                    leftRotate(t, z.p.p);
                }
            }

        }
        t.root.color = BLACK;
    }

    private Node treeMinimum(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    //在红黑树t中用v节点覆盖u节点
    private void rbTransplant(RedBlackTree t, Node u, Node v){
        if (u.p == t.nil){
            t.root = v;
        }else if (u == u.p.left){
            u.p.left = v;
        }else {
            u.p.right = v;
        }
        v.p = u.p;
    }
}


