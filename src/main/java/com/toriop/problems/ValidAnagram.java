package com.toriop.problems;


/**
 * URL: <a href="https://leetcode.com/problems/valid-anagram/">Leetcode URL</a>
 */
public class ValidAnagram {

    public boolean solve(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if (alphabet[t.charAt(i) - 'a'] < 0) return false;
        }
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
