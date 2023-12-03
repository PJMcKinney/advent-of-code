package com.pjmck.aoc.twenty.three.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartOneTest {

    @Test
    public void testGetSumOfValidGameIds() {

        int sumOfValidGameIds = PartOne.getSumOfValidGameIds("twenty/three/day2/test_input_1.txt");

        assertEquals(8, sumOfValidGameIds);
    }

}