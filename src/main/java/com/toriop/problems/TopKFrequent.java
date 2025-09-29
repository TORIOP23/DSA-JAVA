package com.toriop.problems;

import java.util.*;

/**
 * URL: https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] result = solution1(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution1(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : numMap.keySet()) {
            int fre = numMap.get(key);
            if (buckets[fre] == null) {
                buckets[fre] = new ArrayList<>();
            }
            buckets[fre].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            for (int n : buckets[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * Using Priority Queue
     */
    public static int[] solution2(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1[0] != o2[0]) {
                        return Integer.compare(o2[0], o1[0]); // max heap by first element
                    } else {
                        return Integer.compare(o2[1], o1[1]); // if equal, compare by second element
                    }
                }
        );

        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        for (int key : numMap.keySet()) {
            queue.add(new int[]{numMap.get(key), key});
        }

        int[] result = new int[k];
        int idx = 0;

        while (idx < k) {
            result[idx++] = queue.poll()[1];
        }
        return result;
    }

    /**
     * Using TreeMap
     */
    public static int[] solution3(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>(Comparator.reverseOrder());

        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        for (int key : numMap.keySet()) {
            freqMap.computeIfAbsent(numMap.get(key), t -> new ArrayList<>()).add(key);
        }

        int[] result = new int[k];
        int idx = 0;

        for (List<Integer> value : freqMap.values()) {
            for (int num : value) {
                if (idx < k) {
                    result[idx++] = num;
                } else {
                    break;
                }
            }
            if (idx >= k) {
                break;
            }
        }
        return result;
    }
}
