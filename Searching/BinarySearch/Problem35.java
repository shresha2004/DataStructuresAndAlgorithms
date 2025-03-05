package BinarySearch;
 class Solution {
    public  double MinimiseMaxDistanceBruteForce(int []arr, int K){
        // Write your code here.
        int n = arr.length;
        int[] howMany = new int[n-1];

        for(int gasStations = 1; gasStations<=K;gasStations++){
            double maxSection = -1;
            int maxInd = -1;
            for(int i =0;i<n-1;i++){
                double diff = arr[i+1] - arr[i];
                double sectionLength = diff/(double)(howMany[i]+1);
                if(sectionLength > maxSection){
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
                    howMany[maxInd]++;

        }

        double maxAns = -1;
        for(int i =0;i<n-1;i++){
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff/(double) (howMany[i]+1);
            maxAns = Math.max(maxAns,sectionLength);
        }
        return maxAns;

    }
}

public class Problem35 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int  k=6;
        int[] arr = {1,2,3,4,5,6,7};
       System.out.println("Brute Force:"+s.MinimiseMaxDistanceBruteForce(arr, k));

    }
}
