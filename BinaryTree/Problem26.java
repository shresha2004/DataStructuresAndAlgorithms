//Problem:https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
import java.util.*;
 class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curNode = q.poll();
            if(curNode == null){
            sb.append("null,");
            continue;
            }

            sb.append(curNode.val).append(",");
            q.offer(curNode.left);
            q.offer(curNode.right);
            
        }
          sb.setLength(sb.length() - 1);
       return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if (data == null || data.isEmpty()) return null;

        String[] strArr = data.split(",");
       if(strArr[0].equals("null")|| strArr[0].isEmpty()) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i=1;i<strArr.length;i++){
            if (strArr[i].isEmpty()) break;
            TreeNode curNode = q.poll();
            if(!strArr[i].equals("null"))
                {
                    TreeNode newNode = new TreeNode(Integer.parseInt(strArr[i]));
                    q.offer(newNode);
                    curNode.left=newNode;
                }
            if(!strArr[++i].equals("null")){
                TreeNode newNode = new TreeNode(Integer.parseInt(strArr[i]));
                q.offer(newNode);
                curNode.right=newNode;
            }
        }
        return root;
    }
}
public class Problem26 {
    public static void main(String[] args) {
    String str = "1,2,3,null,null,4,5";
    Codec s = new Codec();
    TreeNode root = s.deserialize(str);
    System.out.println("Solution:"+s.serialize(root));
    }
}
