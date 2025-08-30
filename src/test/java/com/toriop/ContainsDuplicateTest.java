package com.toriop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainsDuplicateTest {

    private ContainsDuplicate solution;

    private static int[] parseIntArray(String str) {
        if (str.trim().isEmpty()) {
            return new int[0];
        }
        return Arrays.stream(str.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    @BeforeEach
    void setUp() {
        solution = new ContainsDuplicate();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/contains-duplicate.csv", numLinesToSkip = 1)
    void testFromCsv(String input, boolean expected, String description) {
        int[] nums = parseIntArray(input);
        boolean result = solution.containsDuplicate(nums);
        assertEquals(expected, result, description);
    }
}