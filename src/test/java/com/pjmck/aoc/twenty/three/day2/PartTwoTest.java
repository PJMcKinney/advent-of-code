package com.pjmck.aoc.twenty.three.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartTwoTest {

    @Test
    public void testGetSumOfValidGameIds() {

        int sumOfPowers = PartTwo.getSumOfValidGameIds("twenty/three/day2/test_input_1.txt");

        assertEquals(2286, sumOfPowers);
    }

}