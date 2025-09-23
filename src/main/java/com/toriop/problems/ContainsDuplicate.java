package com.toriop.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * URL: <a href="https://leetcode.com/problems/contains-duplicate/">Leetcode URL</a>
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
