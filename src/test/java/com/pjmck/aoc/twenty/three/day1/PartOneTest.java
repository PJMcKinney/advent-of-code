package com.pjmck.aoc.twenty.three.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartOneTest {

    @Test
    public void testGetSumOfCalibrationValues() {

        int sumOfCalibrationValues = PartOne.getSumOfCalibrationValues("twenty/three/day1/input1_1.txt");

        Assertions.assertEquals(142, sumOfCalibrationValues);
    }

}