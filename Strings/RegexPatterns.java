public class RegexPatterns {
    public static void main(String[] args) {
        printRegexPatterns();
    }

    public static void printRegexPatterns() {
        String regexPatterns =
            "Regex Pattern Reference:\n\n" +
            "1. \\d     -> Matches any digit (0-9)\n" +
            "2. \\w     -> Matches any word character (a-z, A-Z, 0-9, _)\n" +
            "3. \\s     -> Matches any whitespace (space, tab, newline)\n" +
            "4. .       -> Matches any character except newline\n" +
            "5. ^       -> Matches the start of the string\n" +
            "6. $       -> Matches the end of the string\n" +
            "7. *       -> Matches zero or more occurrences\n" +
            "8. +       -> Matches one or more occurrences\n" +
            "9. ?       -> Matches zero or one occurrence\n" +
            "10. {n}    -> Matches exactly n occurrences\n" +
            "11. [a-z]  -> Matches any character from 'a' to 'z'\n" +
            "12. [^a-z] -> Matches any character except 'a' to 'z'\n";

        System.out.println(regexPatterns);
    }
}
