
//Problem:https://www.geeksforgeeks.org/problems/two-numbers-with-odd-occurrences5846/1
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int[] twoOddNumBruteForce(int Arr[], int N) {
        // code here
        int[] ans = new int[2];
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : Arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0)
                arr.add(entry.getKey());
        }

        if (arr.size() < 2)
            return new int[] { arr.get(0) };
        if (arr.get(0) > arr.get(1)) {
            ans[0] = arr.get(0);
            ans[1] = arr.get(1);
        } else {
            ans[0] = arr.get(1);
            ans[1] = arr.get(0);
        }
        return ans;

    }
    public int[] twoOddNumOptimal(int Arr[], int N) {
        // code here
        int xor =0;
        for(int i=0;i<N;i++){
            xor ^= Arr[i];
        }
    
        int bucket1 = 0;
        int bucket2 = 0;
        
        int rightmost = (xor & xor-1) ^ xor;
        for(int i=0;i<N;i++){
            if((Arr[i] & rightmost) > 0) bucket1 ^= Arr[i];
            else bucket2^=Arr[i];
        }
        if(bucket1 > bucket2) return new int[] {bucket1,bucket2};
       return new int[] {bucket2,bucket1};
    }
}

public class Problem13 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 8;
        int[] Arr = { 4, 2, 4, 5, 2, 3, 3, 1 };

        System.out.println("Brute Force:" +Arrays.toString(s.twoOddNumBruteForce(Arr, N)));
        System.out.println("Optimal:" +Arrays.toString(s.twoOddNumBruteForce(Arr, N)));
    }
}
