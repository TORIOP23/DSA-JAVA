package com.toriop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * URL: <a href="https://leetcode.com/problems/group-anagrams/description/">Leetcode URL</a>
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}
