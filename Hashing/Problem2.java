//Storing small letter alphabets in hash arrays


public class Problem2 {
    public static void Solution(StringBuilder s) {
        int[] hash=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLowerCase(ch))
            hash[ch-'a']=hash[ch-'a']+1;//ex ascii value of a=97 if ch=c then 100(ascii value of c)- 97=3 so hash[3]


        }
        for(int i=0;i<hash.length;i++){
            if(hash[i]>0){
               char c= (char) ('a' + i);
                System.out.println(c+" -> "+hash[i]);
            }

        }
    }
    public static void main(String[] args) {
        
        Solution(new StringBuilder("java"));
    }
    
}
