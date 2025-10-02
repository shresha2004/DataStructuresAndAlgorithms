
//Problem:https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public ArrayList<Node> findPreSucBruteForce(Node root, int key) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        inorder(root, key, ans);
        Node predecessor = null;
        Node successor = null;
        int index = binarySearch(ans, key);
        if (index >= 0) {
            if (index > 0)
                predecessor = ans.get(index - 1);
            if (index < ans.size() - 1)
                successor = ans.get(index + 1);
            return new ArrayList<>(Arrays.asList(predecessor, successor));
        } else {
            index = -(index + 1);
            if (index > 0)
                predecessor = ans.get(index - 1);
            if (index < ans.size())
                successor = ans.get(index);
            return new ArrayList<>(Arrays.asList(predecessor, successor));
        }
    }

    private void inorder(Node root, int key, ArrayList<Node> ans) {
        if (root == null)
            return;
        inorder(root.left, key, ans);
        ans.add(root);
        inorder(root.right, key, ans);

    }

    private int binarySearch(ArrayList<Node> arr, int key) {
        int start = 0;
        int end = arr.size() - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr.get(mid).data == key)
                return mid;
            else if (arr.get(mid).data > key)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -(start + 1);
    }
    public ArrayList<Node> findPreSucOptimal(Node root, int key) {
        // code here

        Node[] pred = new Node[1];
        Node[] suc = new Node[1];
        pred[0] = null;
        suc[0] = null;
        findAns(root, key, pred, suc);

        return new ArrayList(Arrays.asList(pred[0], suc[0]));
    }

    private void findAns(Node root, int key, Node[] pred, Node[] suc) {

        if (root == null)
            return;

        if (root.data == key) {
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null)
                    temp = temp.right;
                pred[0] = temp;
            }
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                suc[0] = temp;
            }
        } else if (root.data > key) {
            suc[0] = root;
            findAns(root.left, key, pred, suc);
        } else {
            pred[0] = root;
            findAns(root.right, key, pred, suc);
        }
    }
}

public class Problem11 {
    public static Node createBST(int[] arr) {
        if (arr.length == 0)
            return null;
        Node root = null;
        for (int data : arr) {
            root = insertIntoBST(root, data);
        }
        return root;
    }

    private static Node insertIntoBST(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertIntoBST(root.left, data);
        } else {
            root.right = insertIntoBST(root.right, data);
        }
        return root;
    }

    


    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        Node root = createBST(arr);

        Solution s = new Solution();
        System.out.println("Brute Force:"+s.findPreSucBruteForce(root, 5));
        System.out.println("Optimal:"+s.findPreSucOptimal(root, 5));
    }
}
