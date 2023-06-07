import java.util.Scanner;

/**
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 * Minimum_Flips_to_Make_a_OR_b_Equal_to_c
 */
public class Minimum_Flips_to_Make_a_OR_b_Equal_to_c {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        int ans = minFlips(a, b, c);
        System.out.println("Method 1 :" + "Number of Bits that we need to change - " + ans);
        int ans2 = bitCountMethod(a, b, c);
        System.out.println("Method 2 :" + "Number of Bits that we need to change - " + ans2);   
        scan.close();
    }
    private static int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int lastBitA = a & 1;
            int lastBitB = b & 1;
            int lastBitC = c & 1;

            if (lastBitC == 0) {
                flips += (lastBitA + lastBitB);
            } else {
                if(lastBitA == 0 && lastBitB == 0){
                    flips += 1;
                }
            }
        }
        a >>= 1;
        b >>= 1;
        c >>= 1;

        return flips;
    }
    //One more Approach through which we can solve easily.
    
    public static int bitCountMethod(int a, int b, int c) {
        return Integer.bitCount((a | b) ^ c) + Integer.bitCount((a & b) & ((a | b) ^ c));
    }
}