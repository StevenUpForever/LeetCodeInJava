package math;

public class Q268MissingNumber {

    //Difficulty: Easy
    //TAG: Apple
    //TAG: Math

    /**
     * 268. Missing Number
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     *
     * Example 1:
     *
     * Input: [3,0,1]
     * Output: 2
     * Example 2:
     *
     * Input: [9,6,4,2,3,5,7,0,1]
     * Output: 8
     * Note:
     * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */

    /*
    Solution:
    We can use formula sum = n * (n + 1) / 2 get the sum it should be , and realSum by add numbers in nums
    sum - realSum is the result

    Time: O(n)
    Space: O(1)
     */

    public int missingNumber(int[] nums) {
        if (nums == null) return 0;
        int sum = 0;
        for (int num: nums) sum += num;
        return nums.length * (nums.length + 1) / 2 - sum;
    }

}
