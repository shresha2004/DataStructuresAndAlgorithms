package BinarySearch;
import java.util.PriorityQueue;
//Problem:https://www.naukri.com/code360/problems/minimise-max-distance_7541449?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTabValue=PROBLEM
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

    public  class Pair{
        double first;
        int second;

        Pair(double first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public  double MinimiseMaxDistanceBetter(int []arr, int K){
        // Write your code here.
        int n = arr.length;
        int[] howMany = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.first,a.first));

        for(int i =0;i<n-1;i++){
            pq.add(new Pair(arr[i+1]-arr[i],i));
        }

        for(int gasStations = 1; gasStations<=K;gasStations++){
            Pair tp = pq.poll();
            int secInd = tp.second;

            howMany[secInd]++;

            double inidiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = inidiff / (double) (howMany[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));

        }

       return pq.peek().first;

    }
}

public class Problem35 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int  k=6;
        int[] arr = {1,2,3,4,5,6,7};
       System.out.println("Brute Force:"+s.MinimiseMaxDistanceBruteForce(arr, k));
       System.out.println("Brute Force:"+s.MinimiseMaxDistanceBetter(arr, k));

    }
}
