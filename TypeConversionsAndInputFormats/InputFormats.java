import java.util.*;
import java.io.*;

public class InputFormats {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // -----------------------------
        // 1️⃣ Simple Integer Input
        // -----------------------------
        int n = sc.nextInt(); 
        System.out.println("Integer: " + n);

        // -----------------------------
        // 2️⃣ Integer Array - Given Size
        // Example: n=5, arr=1 2 3 4 5
        // -----------------------------
        int size = sc.nextInt();
        int[] arr1 = new int[size];
        for (int i = 0; i < size; i++) arr1[i] = sc.nextInt();
        System.out.println("Array with given size: " + Arrays.toString(arr1));

        // -----------------------------
        // 3️⃣ Integer Array - No Size Given (till EOF)
        // Example Input: 10 20 30 40 50
        // -----------------------------
        List<Integer> arrList = new ArrayList<>();
        while (sc.hasNextInt()) arrList.add(sc.nextInt());
        int[] arr2 = arrList.stream().mapToInt(i -> i).toArray();
        System.out.println("Array without size (EOF): " + Arrays.toString(arr2));

        // -----------------------------
        // 4️⃣ Array Input as String
        // Example Input: "1,2,3,4,5" or "1 2 3 4 5"
        // -----------------------------
        sc = new Scanner(System.in); // reset scanner
        String line = sc.nextLine().trim();
        String[] parts = line.split("[ ,]+"); // splits by space or comma
        int[] arr3 = new int[parts.length];
        for (int i = 0; i < parts.length; i++) arr3[i] = Integer.parseInt(parts[i]);
        System.out.println("Array from string: " + Arrays.toString(arr3));

        // -----------------------------
        // 5️⃣ 2D Array Input
        // Example:
        // 3 3
        // 1 2 3
        // 4 5 6
        // 7 8 9
        // -----------------------------
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();
        System.out.println("2D Array Input:");
        for (int[] r : matrix) System.out.println(Arrays.toString(r));

        // -----------------------------
        // 6️⃣ String Array Input
        // Example: n=3, arr=apple banana cherry
        // -----------------------------
        int nStr = sc.nextInt();
        String[] strArr = new String[nStr];
        for (int i = 0; i < nStr; i++) strArr[i] = sc.next();
        System.out.println("String Array: " + Arrays.toString(strArr));

        // -----------------------------
        // 7️⃣ Single String (Full Line)
        // Example: "hello world"
        // -----------------------------
        sc = new Scanner(System.in);
        String fullLine = sc.nextLine();
        System.out.println("String Line: " + fullLine);

        // -----------------------------
        // 8️⃣ Linked List Input
        // Example: "1 2 3 4 5"
        // -----------------------------
        sc = new Scanner(System.in);
        String[] listInput = sc.nextLine().split(" ");
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (String s : listInput)
            cur = (cur.next = new ListNode(Integer.parseInt(s)));
        System.out.print("Linked List: ");
        printList(dummy.next);

        // -----------------------------
        // 9️⃣ Tree Input (Level Order)
        // Example: 1 2 3 N 4 N 5
        // -----------------------------
        sc = new Scanner(System.in);
        String[] treeInput = sc.nextLine().split(" ");
        TreeNode root = buildTree(treeInput);
        System.out.print("Tree Level Order: ");
        printTree(root);

        // -----------------------------
        // 🔟 Graph Input (Adjacency List)
        // Example:
        // n=5, m=6
        // 1 2
        // 1 3
        // 2 4
        // 3 4
        // 4 5
        // 2 5
        // -----------------------------
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // if undirected
        }
        System.out.println("Graph (Adjacency List): " + graph);
    }

    // Helper Classes and Methods
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static TreeNode buildTree(String[] arr) {
        if (arr[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();
            if (!arr[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;
            if (i >= arr.length) break;
            if (!arr[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        System.out.println();
    }
}
