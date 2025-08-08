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

     public int maximumPointsTabulation(int arr[][]) {
        // code here

        int[][] tabu = new int[arr.length][4];
        tabu[0][0] = Math.max(arr[0][1],arr[0][2]);
        tabu[0][1] = Math.max(arr[0][0],arr[0][2]);
        tabu[0][2] = Math.max(arr[0][0],arr[0][1]);
        tabu[0][3] = Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        
        for(int day=1;day<arr.length;day++){
            for(int last=0;last<4;last++){
                tabu[day][last] =0;
                for(int task = 0;task<3;task++){
                    if(task != last){
                        int pts = arr[day][task]+tabu[day-1][task];
                        tabu[day][last]=Math.max(tabu[day][last],pts);
                    }
                }
            }
        }
        return tabu[arr.length-1][3];
    }
}

public class Problem8 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        System.out.println("Recursive:"+s.maximumPointsRecursive(arr));
        System.out.println("Memoization:"+s.maximumPointsMemoization(arr));
        System.out.println("Tabulation:"+s.maximumPointsTabulation(arr));

    }
}
