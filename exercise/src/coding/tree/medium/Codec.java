package coding.tree.medium;

/**
* @description: 序列化和反序列化二叉树
* @author: Yzw
* @date:
* @param:
* @return:
**/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root){
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        traverse(root, builder);
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");

        return builder.toString();
    }

    public void traverse(TreeNode root, StringBuilder builder){
        traverse(root.left, builder);
        traverse(root.right, builder);
        builder.append(root.val + ",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return new TreeNode(0);
    }
}