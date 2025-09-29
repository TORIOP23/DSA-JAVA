package com.toriop.problems;

/**
 * URL: https://leetcode.com/problems/product-of-array-except-self/description/
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {
    public int[] solution1(int[] nums) {
        long product = 1;
        int zero = 0;
        int[] res = new int[nums.length];
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else {
                product *= num;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[i] = Math.toIntExact(zero > 0 ? 0 : product / nums[i]);
            } else {
                res[i] = Math.toIntExact(zero > 1 ? 0 : product);
            }
        }
        return res;
    }

    public int[] solution2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}
