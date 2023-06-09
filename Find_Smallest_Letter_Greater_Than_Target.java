import java.util.Scanner;

/**
 * Find_Smallest_Letter_Greater_Than_Target
 */
public class Find_Smallest_Letter_Greater_Than_Target {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String target = scan.next();
        String letters = scan.nextLine();
        char c = target.charAt(0);
        
        char ans = nextGreaterElement(c, letters.toCharArray());
        System.out.println(ans);
        scan.close();
    }   
    private static char nextGreaterElement(char c, char[] letters) {
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(c < letters[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return letters[start % letters.length];
    }
}