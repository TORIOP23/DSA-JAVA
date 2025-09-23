package com.toriop.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * URL: <a href="https://leetcode.com/problems/two-sum/description/">Leetcode URL</a>
 */
public class TwoSum {

    public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }

            map.put(nums[i], i);
        }
        return null;
    }
}
