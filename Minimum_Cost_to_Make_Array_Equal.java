import java.util.Arrays;
import java.util.Scanner;

/**
 * Minimum_Cost_to_Make_Array_Equal
 */
public class Minimum_Cost_to_Make_Array_Equal {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        int[] cost = new int[n];
        for (int i = 0; i < cost.length; i++) {
            nums[i] = scan.nextInt();
        }
        for (int i = 0; i < cost.length; i++) {
            cost[i] = scan.nextInt();
        }
        long ans = minCostToMakeArrayEqual(nums, cost);
        System.out.println(ans);
        scan.close();   
    }

    private static long minCostToMakeArrayEqual(int[] nums, int[] cost) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();

        long ans = getCost(nums, cost, nums[0]);
        while(left < right){
            int mid = (left + right) >> 1;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);
            ans = Math.min(cost1, cost2);
            if(cost1 < cost2) right = mid;
            else right = mid;
        }
        return ans;
    }

    private static long getCost(int[] nums, int[] cost, int target) {
        long sum = 0;
        for (int j = 0; j < cost.length; j++) {
            sum += Math.abs(nums[j] - target) * cost[j];
        }
        return sum;
    }
    
}