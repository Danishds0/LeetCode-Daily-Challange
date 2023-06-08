import java.util.Scanner;

/**
 * Count_Negative_Numbers_in_a_Sorted_Matrix
 */
public class Count_Negative_Numbers_in_a_Sorted_Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = scan.nextInt();
            }
        }
        int ans =  bruteForceCountNegatives(grid);
        int ans2 = binarySearchCountNegatives(grid);
        int ans3 = countNegatives(grid);
        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);
        scan.close();
    }

    //Brute Force: This approch is having O(n^2) Time Complexity because we iterating each element of row and column.
    private static int bruteForceCountNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int element : row) {
                if(element < 0) count++;
            }
        }
        return count;
    }

    //Better Approach : This approach is having O(mlogn) Time complexity because we iterating each row and applying binary search.
    private static int binarySearchCountNegatives(int[][] grid) {
        int count = 0;
        int n = grid.length;
        for (int[] row : grid) {
            int start = 0, end = n - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if(row[mid] < 0) end = mid - 1;
                else start = mid + 1;
            }
            count += n - (start);
        }

        return count;
    }
    //Optimal Approach : This approach is having O(m + n) Time complexity 
    // because we iterating each row and finding last postive number index and then count the negative number from there.
    private static int countNegatives(int[][] grid) {
        int count = 0, negativeIndex = grid[0].length - 1;
        for (int[] row : grid) {
            while (negativeIndex >= 0 && row[negativeIndex] < 0) {
                negativeIndex--;
            }
            count += grid[0].length - (negativeIndex + 1);
        }
        return count;
    }
}