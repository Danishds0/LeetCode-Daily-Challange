import java.util.Arrays;
import java.util.Scanner;

/**
 * K_Radius_Subarray_Averages
 */
public class K_Radius_Subarray_Averages {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        int[] ans = kRadiusSubarrayAverages(arr, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        scan.close();
    }
    private static int[] kRadiusSubarrayAverages(int[] arr, int k) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        if(k == 0) return ans;
        int avgLength = (2 * k) + 1;
        if(avgLength > arr.length) return ans;

        long sum = 0;
        for (int i = 0; i < avgLength; i++) {
            sum += arr[i];
        }
        ans[k] = (int)(sum / avgLength);
        for (int i = avgLength; i < ans.length; i++) {
            sum = sum - arr[i - avgLength] + arr[i];
            ans[i - k] = (int) (sum / avgLength);
        }
        return ans;
    }
}