import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Summary_Ranges
 */
public class Summary_Ranges {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scan.nextInt();
        }   
        System.out.println(summaryRanges(nums));
        scan.close();
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if(start != nums[i]){
                list.add(start + "->" + nums[i]);
            } else {
                list.add(String.valueOf(start));
            }
        }
        return list;
    }
}