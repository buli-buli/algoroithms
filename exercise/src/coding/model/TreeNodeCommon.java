package coding.model;

public class TreeNodeCommon {
    public int val;
    public TreeNodeCommon left;
    public TreeNodeCommon right;
    public TreeNodeCommon() {}
    public TreeNodeCommon(int val) { this.val = val; }
    TreeNodeCommon(int val, TreeNodeCommon left, TreeNodeCommon right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
