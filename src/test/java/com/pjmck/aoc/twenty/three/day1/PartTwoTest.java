package com.pjmck.aoc.twenty.three.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartTwoTest {

    @Test
    public void testGetSumOfCalibrationValues() {

        int sumOfCalibrationValues = PartTwo.getSumOfCalibrationValues("twenty/three/day1/input1_2.txt");

        Assertions.assertEquals(313, sumOfCalibrationValues);
    }

}