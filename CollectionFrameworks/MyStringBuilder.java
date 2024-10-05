public class MyStringBuilder {
    public static void main(String[] args) {
        //Creating the instance
            StringBuilder sb= new StringBuilder();

        //Adding elements
            sb.append("How are you?");
            System.out.println("Append:"+sb.toString());

        //Inserting at specific index
            sb.insert(+0,"Hello java,");
            System.out.println("Insert:"+sb);

        //Deleting
            sb.delete(0, 11);
            System.out.println("Delete:"+sb.toString());

        //Replacing substring
            sb.replace(4, 7, "about");
            System.out.println("Replace:"+sb);
        
        //Reversing
            sb.reverse();
            System.out.println("Reversing:"+sb);
            sb.reverse();//Corrected
        
        //Length
            int x= sb.length();
            System.out.println("Length:"+x);

        //Setting length
            sb.setLength(9);
            System.out.println("Setting length:"+sb);
    }
    
}
