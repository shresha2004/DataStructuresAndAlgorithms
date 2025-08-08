class Solution {
    public int maximumPointsRecursive(int arr[][]) {
        // code here
        int day = arr.length-1;
        int task = arr[0].length;//Initially u can make any task
        return findMaximumPointsRecursive(day,task,arr);
    }
    
    private int findMaximumPointsRecursive(int day,int prevTask,int[][] arr){
        if(day == 0){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<arr[0].length;i++){
                if(i != prevTask){
                    max = Math.max(arr[0][i],max);
                }
            }
            return max;
        }
        int maxPoints= 0;
        for(int i=0;i<arr[0].length;i++){
            if(i != prevTask){
              int  points = arr[day][i]+findMaximumPointsRecursive(day-1,i,arr);
                maxPoints = Math.max(points,maxPoints);
            }
        }
        return maxPoints;
    }



    public int maximumPointsMemoization(int arr[][]) {
        // code here
        int day = arr.length-1;
        int task = arr[0].length;//Initially u can make any task
        return findMaximumPointsMemoization(day,task,arr);
    }
    
    private int findMaximumPointsMemoization(int day,int prevTask,int[][] arr){
        if(day == 0){
            int max = Integer.MIN_VALUE;
            for(int i=0;i<arr[0].length;i++){
                if(i != prevTask){
                    max = Math.max(arr[0][i],max);
                }
            }
            return max;
        }
        int maxPoints= 0;
        for(int i=0;i<arr[0].length;i++){
            if(i != prevTask){
              int  points = arr[day][i]+findMaximumPointsMemoization(day-1,i,arr);
                maxPoints = Math.max(points,maxPoints);
            }
        }
        return maxPoints;
    }
}

public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        System.out.println("Recursive:"+s.maximumPointsRecursive(arr));
        System.out.println("Memoization:"+s.maximumPointsMemoization(arr));
        
    }
}
